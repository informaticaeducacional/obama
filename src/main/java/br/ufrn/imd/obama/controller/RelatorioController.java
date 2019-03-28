package br.ufrn.imd.obama.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.jasperreports.Report;
import br.com.caelum.vraptor.jasperreports.download.ReportDownload;
import br.com.caelum.vraptor.jasperreports.formats.ExportFormats;
import br.com.caelum.vraptor.observer.download.Download;
import br.ufrn.imd.obama.dao.PlanoDeAulaDao;
import br.ufrn.imd.obama.dominio.PlanoDeAula;
import br.ufrn.imd.obama.dominio.relatorios.OldRelatorioPlanoDeAula;
import br.ufrn.imd.obama.dominio.relatorios.RelatorioPlanoDeAula;
import br.ufrn.imd.obama.dominio.relatorios.ReportFactory;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RelatorioController extends Controlador {

    @Inject
    private ServletContext context;

    private PlanoDeAulaDao planoDeAulaDao;

    @Deprecated
    protected RelatorioController(){
        this(null,null);
    }

    @Inject
    public RelatorioController(Result resultado, PlanoDeAulaDao planoDeAulaDao) {
        super(resultado);
        this.planoDeAulaDao = planoDeAulaDao;

    }

    /**
     * Gera plano de aula de acordo com a data de submissão, pois o modo como ele é gerado foi alterado
     * e por isso foi necessário diferenciar os formulários
     * @param idPlano
     * @return
     */
    @Get
    @Path("/relatorios/{idPlano}")
    public Download imprimirPlanoDeAula(int idPlano) {
        PlanoDeAula planoDeAula = planoDeAulaDao.buscarPlanoPorId(idPlano);
        Report report = null;

        int ano = planoDeAula.getDataCadastro().toLocalDateTime().getYear();
        if(ano < 2018) {
            OldRelatorioPlanoDeAula oldrelatorioPlanoDeAula = new OldRelatorioPlanoDeAula(planoDeAula.getTitulo(),planoDeAula.getAutor().getNome(),
                    planoDeAula.getDescricaoAnoEnsino(),planoDeAula.getNivelEnsino().getDenominacao(), Integer.toString(planoDeAula.getDuracaoEmMinutos())
                    ,planoDeAula.getObjetosAprendizagem(),planoDeAula.getEscola(),planoDeAula.getResumo(),planoDeAula.getObjetivoGeral(),
                    planoDeAula.getObjetivosEspecificos(),planoDeAula.getMetodologia(),planoDeAula.getAvaliacao(),planoDeAula.getReferencias());

            List<OldRelatorioPlanoDeAula> relatorios = new ArrayList<>();
            relatorios.add(oldrelatorioPlanoDeAula);
            report = new ReportFactory<>(relatorios, "OldPlanoDeAulaReport.jasper", context);

        } else {
            RelatorioPlanoDeAula relatorioPlanoDeAula = new RelatorioPlanoDeAula(planoDeAula.getTitulo(),planoDeAula.getAutor().getNome(), planoDeAula.getCoautores(),
                    planoDeAula.getDescricaoAnoEnsino(),"", Integer.toString(planoDeAula.getDuracaoEmMinutos())
                    ,planoDeAula.getObjetosAprendizagem(),planoDeAula.getMetodologia(),planoDeAula.getEscola());
            List<RelatorioPlanoDeAula> relatorios = new ArrayList<>();
            relatorios.add(relatorioPlanoDeAula);
            report = new ReportFactory<>(relatorios, "PlanoDeAulaReport.jasper", context);
        }

        ReportDownload download = new ReportDownload(report, ExportFormats.pdf(), false);
        return download;
    }

}

package br.ufrn.imd.obama.dominio;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


/**
 * Classe que repressenta os objetos de aprendizagem
 * 
 * @author nelson
 *
 */
@Entity
public class ObjetoAprendizagem extends Entidade implements Serializable{

	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descricao", columnDefinition="text")
	private String descricao;
	
	@Column(name="qtd_acessos")
	private int qtdAcessos;
	
	@Column(name="link", columnDefinition="text")
	private String link;
	
	@Column(name="path_arquivo")
	private String pathArquivo;
	
	@Column(name="data_lancamento")
	private Date dataLancamento;
	
	@JoinColumn(name="id_tipo_objeto")
	@ManyToOne
	private TipoObjeto tipoObjeto;

	@Column(name="versao")
	private String versao;
	
	@Column(name="ativo")
	private boolean ativo;
	
	@Column(name="tipo_visualizacao")
	private int tipoVisualizacao;
	
	@ManyToMany
	private List<Idioma> idioma;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<AutorMantenedor> autoresMantenedores;	
	
	@JoinColumn(name="id_plataforma")
	@ManyToOne
	private Plataforma plataforma;
	
	@JoinColumn(name="id_tipo_licenca_uso")
	@ManyToOne
	private TipoLicencaUso licencaDeUso;
	
	@OneToMany
	private List<Comentario> comentarios;
	
	@OneToMany
	private List<PlanoDeAula> planosDeAula;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="objetoaprendizagem_descritor",joinColumns = @JoinColumn(name="objetoaprendizagem", referencedColumnName="id"),
	    inverseJoinColumns=@JoinColumn(name="descritor_id", referencedColumnName="id")
	)
	private Set<Descritor> descritores;
	
	@Transient
	private HashMap<NivelEnsino, Set<TemaConteudo>> conteudosPorNivel;
	
	@Transient
	private boolean oaSelecionado;
	
	public ObjetoAprendizagem() {
		super();

	}

	public ObjetoAprendizagem(int id, String nome, String descricao, int qtdAcessos, String link, String pathArquivo,
			Date dataLancamento, TipoObjeto tipoObjeto, String versao, List<Idioma> idioma,
			List<AutorMantenedor> autoresMantenedores, Plataforma plataforma, TipoLicencaUso licencaDeUso,
			List<Comentario> comentarios, List<PlanoDeAula> planosDeAula, Set<Descritor> descritores,
			HashMap<NivelEnsino, Set<TemaConteudo>> conteudosPorNivel, int tipoVisualizacao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdAcessos = qtdAcessos;
		this.link = link;
		this.pathArquivo = pathArquivo;
		this.dataLancamento = dataLancamento;
		this.tipoObjeto = tipoObjeto;
		this.versao = versao;
		this.idioma = idioma;
		this.autoresMantenedores = autoresMantenedores;
		this.plataforma = plataforma;
		this.licencaDeUso = licencaDeUso;
		this.comentarios = comentarios;
		this.planosDeAula = planosDeAula;
		this.descritores = descritores;
		this.conteudosPorNivel = conteudosPorNivel;
		this.ativo = true;
		this.tipoVisualizacao = tipoVisualizacao;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoObjeto getTipoObjeto() {
		return tipoObjeto;
	}

	public void setTipoObjeto(TipoObjeto tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}

	public int getQtdAcessos() {
		return qtdAcessos;
	}

	public void setQtdAcessos(int qtdAcessos) {
		this.qtdAcessos = qtdAcessos;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPathArquivo() {
		return pathArquivo;
	}

	public void setPathArquivo(String pathArquivo) {
		this.pathArquivo = pathArquivo;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}	

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getTipoVisualizacao() {
		return tipoVisualizacao;
	}

	public void setTipoVisualizacao(int tipoVisualizacao) {
		this.tipoVisualizacao = tipoVisualizacao;
	}

	public List<Idioma> getIdioma() {
		return idioma;
	}

	public void setIdioma(List<Idioma> idioma) {
		this.idioma = idioma;
	}

	public List<AutorMantenedor> getAutoresMantenedores() {
		return autoresMantenedores;
	}

	public void setAutoresMantenedores(List<AutorMantenedor> autoresMantenedores) {
		this.autoresMantenedores = autoresMantenedores;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public TipoLicencaUso getLicencaDeUso() {
		return licencaDeUso;
	}

	public void setLicencaDeUso(TipoLicencaUso licencaDeUso) {
		this.licencaDeUso = licencaDeUso;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<PlanoDeAula> getPlanosDeAula() {
		return planosDeAula;
	}

	public void setPlanosDeAula(List<PlanoDeAula> planosDeAula) {
		this.planosDeAula = planosDeAula;
	}
	
	public List<Descritor> getDescritores() {
		List<Descritor> descritoresList = new ArrayList<>();
		descritoresList.addAll(descritores);
		return descritoresList;
	}

	public void setDescritores(Set<Descritor> descritores) {
		this.descritores = descritores;
	}

	public HashMap<NivelEnsino, Set<TemaConteudo>> getConteudosPorNivel() {
		return conteudosPorNivel;
	}

	public void setConteudosPorNivel(HashMap<NivelEnsino, Set<TemaConteudo>> conteudosPorNivel) {
		this.conteudosPorNivel = conteudosPorNivel;
	}
	
	@Transient
	public String getTextoBotaoTipoVisualizacao() {
		return TipoVisualizacao.getTextoBotaoPorId(this.tipoVisualizacao);
	}
	
	public boolean isOaSelecionado() {
		return oaSelecionado;
	}
	
	public void setOaSelecionado(boolean oaSelecionado) {
		this.oaSelecionado = oaSelecionado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjetoAprendizagem other = (ObjetoAprendizagem) obj;
		if (id != other.id)
			return false;
		return true;
	}

}

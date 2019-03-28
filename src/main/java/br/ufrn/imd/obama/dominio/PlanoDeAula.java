package br.ufrn.imd.obama.dominio;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

@Entity
public class PlanoDeAula extends Entidade implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	// Dados do plano de aula.
	@Column(name="data_cadastro")
	private Timestamp dataCadastro;
	
	@Column(name="qtd_downloads")
	private Integer qtdDownload;
	
	@Column(name="escola")
	private String escola;

	@ManyToOne
	private Usuario autor;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private NivelEnsino nivelEnsino;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Disciplina> disciplinasEnvolvidas;
	
	@Column(name="ano_ensino")
	private Integer anoEnsino;
	
	@Column(name="duracao_em_minutos")
	private Integer duracaoEmMinutos;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(columnDefinition="text")
	private String resumo;
	
	@Column(columnDefinition="text", name="objetivo_geral")
	private String objetivoGeral;
	
	@Column(columnDefinition="text", name="objetivos_especificos")
	private String objetivosEspecificos;
	
	@Column(columnDefinition="text")
	private String metodologia;	

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="planodeaula_objetoaprendizagem",joinColumns = @JoinColumn(name="planodeaula_id", referencedColumnName="id"),
	    inverseJoinColumns=@JoinColumn(name="objetosaprendizagem_id", referencedColumnName="id")
	)
	private Set<ObjetoAprendizagem> objetosAprendizagem;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="planodeaula_coautor",joinColumns = @JoinColumn(name="planodeaula_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="usuario_id", referencedColumnName="id")
	)
	private Set<Usuario> coautores;

	@Column(columnDefinition="text")
	private String avaliacao;
	
	@Column(columnDefinition="text")
	private String referencias;

	@Column(columnDefinition="text", unique = true, nullable = false)
	private String token;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="planoDeAula")
//	@JoinColumn(name="planodeaula_id", referencedColumnName="id")
	private Set<Comentario> comentarios;
	
	@Column(name="status_id")
	private int status;

	@Transient
	private List<Comentario> comentariosFeedback;

	@Transient
	private List<Comentario> comentariosPublicos;


	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public Timestamp getDataCadastro() {

		return dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {

		this.dataCadastro = dataCadastro;
	}

	public int getQtdDownload() {

		return qtdDownload;
	}

	public void setQtdDownload(int qtdDownload) {

		this.qtdDownload = qtdDownload;
	}

	public String getEscola() {

		return escola;
	}

	public void setEscola(String escola) {

		this.escola = escola;
	}

	public Usuario getAutor() {

		return autor;
	}

	public void setAutor(Usuario autor) {

		this.autor = autor;
	}

	public NivelEnsino getNivelEnsino() {

		return nivelEnsino;
	}

	public void setNivelEnsino(NivelEnsino nivelEnsino) {

		this.nivelEnsino = nivelEnsino;
	}

	public List<Disciplina> getDisciplinasEnvolvidas() {

		return disciplinasEnvolvidas;
	}

	public void setDisciplinasEnvolvidas(List<Disciplina> disciplinasEnvolvidas) {
		this.disciplinasEnvolvidas = disciplinasEnvolvidas;
	}

	public int getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public void setDuracaoEmMinutos(int duracaoEmMinutos) {

		this.duracaoEmMinutos = duracaoEmMinutos;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {

		this.token = token;
	}

	public String getObjetivoGeral() {

		return objetivoGeral;
	}

	public void setObjetivoGeral(String objetivoGeral) {

		this.objetivoGeral = objetivoGeral;
	}

	public String getObjetivosEspecificos() {

		return objetivosEspecificos;
	}

	public void setObjetivosEspecificos(String objetivosEspecificos) {

		this.objetivosEspecificos = objetivosEspecificos;
	}

	public String getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(String metodologia) {

		this.metodologia = metodologia;
	}

	public String getAvaliacao() {

		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {

		this.avaliacao = avaliacao;
	}

	public String getReferencias() {

		return referencias;
	}

	public void setReferencias(String referencias) {

		this.referencias = referencias;
	}
	
	public Set<Comentario> getComentarios() {

		return this.comentarios;
	}

	public List<Comentario> getComentariosList() {
		List<Comentario> comentariosList =  new ArrayList<>();
		comentariosList.addAll(this.comentarios);

		comentariosList.sort((c1,c2) -> c2.getDataComentario().compareTo(c1.getDataComentario()));
		return comentariosList;
	}

	public void setComentarios(Set<Comentario> comentarios) {

		this.comentarios = comentarios;
	}
	
	public String getTitulo() {

		return titulo;
	}

	public List<Comentario> getComentariosFeedback() {
		for(Comentario comentario : comentarios){
			if(comentario.isComentarioDeFeedback()){
				comentariosFeedback.add(comentario);
			}
		}
		return comentariosFeedback;
	}

	public void setComentariosFeedback(List<Comentario> comentariosFeedback) {
		this.comentariosFeedback = comentariosFeedback;
	}

	public List<Comentario> getComentariosPublicos() {
		for(Comentario comentario : comentarios){
			if(!(comentario.isComentarioDeFeedback())){
				comentariosPublicos.add(comentario);
			}
		}
		return comentariosPublicos;
	}

	public void setComentariosPublicos(List<Comentario> comentariosPublicos) {
		this.comentariosPublicos = comentariosPublicos;
	}

	public void setTitulo(String titulo) {

		this.titulo = titulo;
	}

	public String getResumo() {

		return resumo;
	}

	public void setResumo(String resumo) {

		this.resumo = resumo;
	}

	public int getAnoEnsino() {
		if(anoEnsino == null){
			anoEnsino = 0;
		}
		return anoEnsino;
	}
	
	@Transient
	public String getDescricaoAnoEnsino() {

		return AnoEnsino.getDenominacaoPorId(this.anoEnsino);
	}

	public void setAnoEnsino(int anoEnsino) {

		this.anoEnsino = anoEnsino;
	}

	public List<ObjetoAprendizagem> getObjetosAprendizagem() {
		List<ObjetoAprendizagem> objetosAprendizagemList = new ArrayList<>();
		objetosAprendizagemList.addAll(objetosAprendizagem);
		return objetosAprendizagemList;
	}

	public void setObjetosAprendizagem(Set<ObjetoAprendizagem> objetosAprendizagem) {
		this.objetosAprendizagem = objetosAprendizagem;
	}
	
	public void setObjetosAprendizagem(List<ObjetoAprendizagem> objetosAprendizagem) {
		this.objetosAprendizagem = new HashSet<>(objetosAprendizagem);
	}

	public int getStatus() {

		return status;
	}

	public void setStatus(int status) {

		this.status = status;
	}

	public void setStatusPlanoDeAula(StatusSubmissao status) {

		this.status = status.getId();
	}
	
	@Transient
	public StatusSubmissao getStatusPlanoDeAula(){

		return StatusSubmissao.getStatusPorId(status);
	}

	public Set<Usuario> getCoautores() {
		return coautores;
	}

	public void setCoautores(Set<Usuario> coautores) {
		this.coautores = coautores;
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
		PlanoDeAula other = (PlanoDeAula) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlanoDeAula [id=" + id + ", dataCadastro=" + dataCadastro + ", qtdDownload=" + qtdDownload + ", escola="
				+ escola + ", autor=" + autor + ", nivelEnsino=" + nivelEnsino + ", disciplinasEnvolvidas="
				+ disciplinasEnvolvidas + ", duracaoEmMinutos=" + duracaoEmMinutos + ", anoEnsino=" + anoEnsino
				+ ", objetivoGeral=" + objetivoGeral + ", objetivosEspecificos=" + objetivosEspecificos
				+ ", metodologia=" + metodologia + ", avaliacao=" + avaliacao
				+ ", referencias=" + referencias + ", comentarios=" + comentarios + "]";
	}	
}

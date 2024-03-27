package educa.ead.modelos;

import java.io.Serializable;
import java.time.Duration;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_id_curso", sequenceName = "seq_id_curso", initialValue = 100, allocationSize = 1)
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "seq_id_curso", strategy = GenerationType.SEQUENCE)
	private Long id;

	
	@Column(length = 200, name = "nome_curso", nullable = false)
	private String nome;
	

	@Column(length = 200, name = "descricao_curso", nullable = false)
	private String descricao;
	

	@Column(length = 400, name = "sobre_curso", nullable = false)
	private String sobre;
	

	@Column(name = "duracao_curso", nullable = false)
	private Duration duracao;
	

	@Column(columnDefinition = "text", name = "banner_curso")
	private String banner;

	@Column(name = "curso_liberado")
	private Boolean cursoLiberado;
	

	@OneToMany(orphanRemoval = true, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "curso")
	private Set<Aula> aulas = new HashSet<>();
	
	

	
	
	@OneToMany(orphanRemoval = true , cascade = CascadeType.REMOVE , fetch = FetchType.LAZY , mappedBy = "curso")
	private Set<CertificadoCurso> certificado= new HashSet<>();
 
	
	

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "professor_id", unique = true, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "professor_id_fk"))
	private Professor professor;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id", unique = true, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "categoria_id_fk"))
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public Duration getDuracao() {
		return duracao;
	}

	public void setDuracao(Duration duracao) {
		this.duracao = duracao;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public Boolean getCursoLiberado() {
		return cursoLiberado;
	}

	public void setCursoLiberado(Boolean cursoLiberado) {
		this.cursoLiberado = cursoLiberado;
	}

	public Set<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(Set<Aula> aulas) {
		this.aulas = aulas;
	}

	public Set<CertificadoCurso> getCertificado() {
		return certificado;
	}

	public void setCertificado(Set<CertificadoCurso> certificado) {
		this.certificado = certificado;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", sobre=" + sobre + ", duracao="
				+ duracao + ", banner=" + banner + ", cursoLiberado=" + cursoLiberado + ", aulas=" + aulas
				+ ", certificado=" + certificado + ", professor=" + professor + ", categoria=" + categoria + "]";
	}


	

	
	

	
	
	
}

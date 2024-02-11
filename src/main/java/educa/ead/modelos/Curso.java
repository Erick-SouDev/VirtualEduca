package educa.ead.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Long duracao;

	@Column(columnDefinition = "text", name = "banner_curso")
	private String banner;

	@Column(name = "curso_liberado")
	private Boolean cursoLiberado;


	@OneToMany(orphanRemoval = true, cascade = CascadeType.REFRESH,  fetch = FetchType.LAZY , mappedBy = "curso")
	private List<Aula> aulas =new ArrayList<>() ;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
				+ duracao + ", banner=" + banner + ", cursoLiberado=" + cursoLiberado + ", aulas=" + aulas + ", alunos="
				 + "]";
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

	public Long getDuracao() {
		return duracao;
	}

	public void setDuracao(Long duracao) {
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

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}


	
	

	

}

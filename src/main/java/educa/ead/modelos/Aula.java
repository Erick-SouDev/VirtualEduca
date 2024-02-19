package educa.ead.modelos;

import java.util.Objects;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_id_aula", sequenceName = "seq_id_aula", initialValue = 1, allocationSize = 1)

public class Aula {

	@Id
	@GeneratedValue(generator = "seq_id_aula", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_aula")
	private Long id;

	@Column(name = "nome_aula")
	private String nome;

	@Column(name = "descricao_aula")
	private String descricao;
	
	@Column(name = "url_video")
	private String url_video;
	

	@Column(name = "duracao_aula")
	private Long duracao;
	
	
	@ManyToOne(cascade = CascadeType.ALL  , fetch = FetchType.LAZY )
	@JoinColumn(name = "curso_id" , unique = true , foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT  , name="curso_id_fk")  )
	private Curso curso;

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


	public String getUrl_video() {
		return url_video;
	}


	public void setUrl_video(String url_video) {
		this.url_video = url_video;
	}


	public Long getDuracao() {
		return duracao;
	}


	public void setDuracao(Long duracao) {
		this.duracao = duracao;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
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
		Aula other = (Aula) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Aula [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", url_video=" + url_video
				+ ", duracao=" + duracao + ", curso=" + curso + "]";
	}


	


}

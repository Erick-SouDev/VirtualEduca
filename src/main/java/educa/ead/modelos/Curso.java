package educa.ead.modelos;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

@Entity(name = "tbl_curso")
@SequenceGenerator(name = "seq_id_curso", sequenceName = "seq_id_curso", initialValue = 100, allocationSize = 1)

public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(generator = "seq_id_curso" , strategy = GenerationType.SEQUENCE)
	
	private Long id;
	private String nome;
	private String descricao;
	private String sobre;
	private Long duracao;
	private String banner;
	
	private Boolean liberado;

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

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", sobre=" + sobre + ", duracao="
				+ duracao + ", banner=" + banner + ", liberado=" + liberado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(banner, descricao, duracao, id, liberado, nome, sobre);
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
		return Objects.equals(banner, other.banner) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(duracao, other.duracao) && Objects.equals(id, other.id)
				&& Objects.equals(liberado, other.liberado) && Objects.equals(nome, other.nome)
				&& Objects.equals(sobre, other.sobre);
	}
	
	
	
	
	
	
}

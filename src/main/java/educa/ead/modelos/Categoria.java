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
@SequenceGenerator(initialValue = 100 , allocationSize = 1 , name = "categoria_seq" , sequenceName = "categoria_seq")
public class Categoria implements Serializable {

	


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator ="categoria_seq"  , strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(unique = true , updatable = false ,name = "nome")
	private String nome;
	
	
	@OneToMany(mappedBy = "categoria"  , orphanRemoval = true , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Curso>cursos = new ArrayList<>();

	
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
	
	
	public List<Curso> getCursos() {
		return cursos;
	}
	
	
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
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
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", cursos=" + cursos + "]";
	}
	
	
	
	
}

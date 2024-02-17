package educa.ead.modelos;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("instrutor")
public class Instrutor  extends Usuario{

	private static final long serialVersionUID = 1L;

 
	@Column(name = "formacao", length = 300)
	private String formacao;

	@Column(name = "sobre", length = 300)
	private String sobre;
	
	@OneToMany(mappedBy = "instrutor" , orphanRemoval = true , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private Set<Curso> cursos = new HashSet<>();

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	@Override
	public String toString() {
		return "Instrutor [formacao=" + formacao + ", sobre=" + sobre + "]";
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	
	
	
}

package educa.ead.modelos;

import java.util.ArrayList;
import java.util.List;

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
	private List<Curso> cursos = new ArrayList<>();

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

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Instrutor [formacao=" + formacao + ", sobre=" + sobre + ", cursos=" + cursos + "]";
	}

	
	
	
}

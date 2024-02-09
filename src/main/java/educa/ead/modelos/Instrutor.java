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
@DiscriminatorValue(value = "instrutor")
public class Instrutor {
	@Column(name = "formacao" , length = 300  )
	private String formacao;
	
	
	@Column(name = "sobre" , length = 300)
	private String sobre;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "Instrutor" , fetch = FetchType.LAZY , orphanRemoval = true)
	private List<Curso> cursoInstrutor = new ArrayList<>();
	
	
	public void setCursoInstrutor(List<Curso> cursoInstrutor) {
		this.cursoInstrutor = cursoInstrutor;
	}
	
	public List<Curso> getCursoInstrutor() {
		return cursoInstrutor;
	}
	
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

	
	
}

package educa.ead.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "instrutor")
@DiscriminatorValue(value = "instrutor")
public class Instrutor {
	@Column(name = "formacao" , length = 300  )
	private String formacao;
	
	
	@Column(name = "sobre" , length = 300)
	private String sobre;
	
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

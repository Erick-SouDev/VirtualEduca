package educa.ead.modelos;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "aluno")
@DiscriminatorValue(value = "aluno")
public class Aluno extends Usuario {
	
	private String  matricula;
	
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMatricula() {
		return matricula;
	}
}

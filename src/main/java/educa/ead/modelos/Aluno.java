package educa.ead.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity()
@DiscriminatorValue(value = "aluno")
public class Aluno extends Usuario {
	
	@Column(name = "matricula_aluno" , length = 300)
	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + "]";
	}
	
	
	
	
	
}

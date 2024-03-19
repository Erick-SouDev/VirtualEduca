package educa.ead.modelos;

import java.util.HashSet;
import java.util.Set;

import org.apache.catalina.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("aluno")
public class Aluno extends Usuario {

	private static final long serialVersionUID = 1L;

	@Column(name = "matricula", length = 300)
	private String matricula;
	
	@OneToMany(mappedBy = "aluno" ,orphanRemoval = true , cascade = CascadeType.REFRESH , fetch = FetchType.LAZY)
	private Set<AlunoCurso> alunoCursos = new HashSet<>();

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setAlunoCursos(Set<AlunoCurso> alunoCursos) {
		this.alunoCursos = alunoCursos;
	}
	public Set<AlunoCurso> getAlunoCursos() {
		return alunoCursos;
	}


}

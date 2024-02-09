package educa.ead.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class AlunoInscritoCurso {

	@Temporal(TemporalType.DATE )
	private Date quandoFoiMatriculado;
	
	@Embedded
	private AlunoCurso alunoCurso;


	
	
	
	
	
}

package educa.ead.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Table(name = "certificado_curso")
@Entity
public class CertificadoCurso  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.DATE )
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE )

	private Date dataFinal;

	@Embedded
	private DadosAlunoCurso dadosAlunoCursoDto;
	
	
	@ManyToOne(cascade = CascadeType.ALL , optional = false , fetch = FetchType.LAZY )
	@JoinColumn(unique = true , name = "id_curso" )
	private Curso curso;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	public Date getDataFinal() {
		return dataFinal;
	}


	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}


	public DadosAlunoCurso getDadosAlunoCursoDto() {
		return dadosAlunoCursoDto;
	}


	public void setDadosAlunoCursoDto(DadosAlunoCurso dadosAlunoCursoDto) {
		this.dadosAlunoCursoDto = dadosAlunoCursoDto;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
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
		CertificadoCurso other = (CertificadoCurso) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "CertificadoCurso [id=" + id + ", dataInicio=" + dataInicio + ", dataFinal=" + dataFinal
				+ ", dadosAlunoCursoDto=" + dadosAlunoCursoDto + ", curso=" + curso + "]";
	}
    
	
	
	
	
}

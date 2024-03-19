package educa.ead.modelos;

import jakarta.persistence.Embeddable;

@Embeddable
public class DadosAlunoCurso  {

	public String nomeAluno;
	
	public String emailAluno;
	
	public String nomeCurso;
	
	public String informacao;
	
	
	
	
	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getInformacao() {
		return informacao;
	}

	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}
	
	
	
	
}

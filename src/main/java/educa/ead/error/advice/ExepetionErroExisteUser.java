package educa.ead.error.advice;

public class ExepetionErroExisteUser {

private String menssagem;
	
	private int codigo;

	public ExepetionErroExisteUser(String menssagem, int codigo) {
		this.menssagem = menssagem;
	}

	public ExepetionErroExisteUser() {
		super();
	}

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}

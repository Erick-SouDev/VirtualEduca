package educa.ead.modelos;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;

@MappedSuperclass
@SequenceGenerator(allocationSize = 1 , initialValue = 1000 , name = "seq_id" , sequenceName = "seq_id")
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 3474763985167895841L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_id")
	protected Long id;


	@Column(length = 300, name = "nome")
	protected String nome;

	@Column(length = 80, name = "email", unique = true)
	protected String email;

	@Column(length = 80, name = "senha", unique = true)
	protected String senha;

	@Column(name = "foto", columnDefinition = "text")
	protected String foto;



	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", foto=" + foto
				+ "]";
	}
	
	
}

package educa.ead.modelos;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.servlet.ServletContext;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@MappedSuperclass
@SequenceGenerator(allocationSize = 1 , initialValue = 1000 , name = "seq_id" , sequenceName = "seq_id")

public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 3474763985167895841L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_id")
	protected Long id;


	@Column(length = 300, name = "nome")
	@NotBlank(message = "campo obrigatorio")
	protected String nome;
	@NotBlank(message = "Campo obrigatorio")
	@Email(message = "Email  invalido" , regexp ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	@Column(length = 80, name = "email", unique = true)
	protected String email;

	@NotBlank(message = "Campo obrigatorio")
	@Column(length = 80, name = "senha", unique = true)
	protected String senha;


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




	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Column(name = "foto", columnDefinition = "text")
	protected String foto;


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

package educa.ead.modelos;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import educa.ead.enumerator.TyperUser;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@Table(name = "usuario" , uniqueConstraints = @UniqueConstraint(columnNames = {"email" , "senha"}))
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	@Column(length = 300, name = "nome")
	private String nome;

	
	@Column(length = 80, name = "email" , unique = true )
	private String email;
	
	@Column(length = 80, name = "senha" , unique =  true)
	private String senha;
	
	@Column(name = "foto", columnDefinition = "text")
	private String foto;

	@Enumerated(EnumType.STRING)
	private TyperUser typerUser;
	
	
	
	

	public TyperUser getTyperUser() {
		return typerUser;
	}

	public void setTyperUser(TyperUser typerUser) {
		this.typerUser = typerUser;
	}

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
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", foto=" + foto
				+ "]";
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

}

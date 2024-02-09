package educa.ead.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Id;

import educa.ead.enumerator.TipoUsuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class Instrutor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 300, name = "nome")
	private String nome;

	@Column(length = 80, name = "email", unique = true)
	private String email;

	@Column(length = 80, name = "senha", unique = true)
	private String senha;

	@Column(name = "foto", columnDefinition = "text")
	private String foto;

	@Enumerated(EnumType.STRING)
	private TipoUsuario typerUser;

	@Column(name = "formacao", length = 300)
	private String formacao;

	@Column(name = "sobre", length = 300)
	private String sobre;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Curso> cursoInstrutor = new ArrayList<>();

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

	public TipoUsuario getTyperUser() {
		return typerUser;
	}

	public void setTyperUser(TipoUsuario typerUser) {
		this.typerUser = typerUser;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public List<Curso> getCursoInstrutor() {
		return cursoInstrutor;
	}

	public void setCursoInstrutor(List<Curso> cursoInstrutor) {
		this.cursoInstrutor = cursoInstrutor;
	}

	@Override
	public String toString() {
		return "Instrutor [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", foto=" + foto
				+ ", typerUser=" + typerUser + ", formacao=" + formacao + ", sobre=" + sobre + ", cursoInstrutor="
				+ cursoInstrutor + "]";
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
		Instrutor other = (Instrutor) obj;
		return Objects.equals(id, other.id);
	}
	
	

}

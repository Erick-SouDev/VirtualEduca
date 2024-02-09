package educa.ead.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



import jakarta.persistence.Id;

import educa.ead.enumerator.TipoUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 300, name = "nome")
	private String nome;

	@Column(name = "matricula_aluno", length = 300)
	private String matricula;

	@OneToMany(fetch = FetchType.EAGER,  orphanRemoval = true)
	private List<Curso> cursos = new ArrayList<>();

	@Column(length = 80, name = "email", unique = true)
	private String email;

	@Column(length = 80, name = "senha", unique = true)
	private String senha;

	@Column(name = "foto", columnDefinition = "text")
	private String foto;

	@Enumerated(EnumType.STRING)
	private TipoUsuario typerUser;

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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", cursos=" + cursos + ", email="
				+ email + ", senha=" + senha + ", foto=" + foto + ", typerUser=" + typerUser + "]";
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
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id);
	}

}

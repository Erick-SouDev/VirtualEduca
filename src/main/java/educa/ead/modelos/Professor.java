



package educa.ead.modelos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import educa.ead.enumerator.disciplina.DisciplinaEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;

@Entity
@DiscriminatorValue("professor")
public class Professor  extends Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;

 
	@Column(name = "formacao", length = 300)
	private String formacao;

	@Column(name = "sobre", length = 300)
	private String sobre;
	
	@OneToMany(mappedBy = "professor" , orphanRemoval = true , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Curso> cursos = new ArrayList<>();
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "disciplina")
	private DisciplinaEnum displina;
	
	

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinTable(name = "professor_role", uniqueConstraints = @UniqueConstraint(columnNames = { "professor_id",
			"role_id" }, name = "constraint_professor_role"), joinColumns = @JoinColumn(name = "professor_id", referencedColumnName = "id", table = "Professor", foreignKey = @ForeignKey(name = "professor_fk")), 
			  inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", table = "role", foreignKey = @ForeignKey(name = "role_fk")))
	private Set<Role> roles = new HashSet<>();

	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Set<Role> getRoles() {
		return roles;
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


	public List<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}


	public DisciplinaEnum getDisplina() {
		return displina;
	}


	public void setDisplina(DisciplinaEnum displina) {
		this.displina = displina;
	}


	@Override
	public String toString() {
		return "Professor [formacao=" + formacao + ", sobre=" + sobre + ", cursos=" + cursos + ", displina=" + displina
				+ "]";
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.getSenha();
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getEmail();
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	} 

	
	
	
	
}

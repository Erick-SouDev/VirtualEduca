package educa.ead.modelos;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.UniqueConstraint;

@Entity
@DiscriminatorValue("aluno")
public class Aluno extends Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Column(name = "matricula", length = 300)
	private String matricula;

	

	@ManyToMany(cascade = CascadeType.REMOVE,  fetch = FetchType.EAGER )
	@JoinTable(name = "aluno_role", uniqueConstraints = @UniqueConstraint(columnNames = { "aluno_id",
			"role_id" }, name = "constraint_aluno_role"), joinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "id", table = "Aluno", foreignKey = @ForeignKey(name = "aluno_fk")), 
			  inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", table = "role", foreignKey = @ForeignKey(name = "role_fk")))
	private Set<Role> roles = new HashSet<>();

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

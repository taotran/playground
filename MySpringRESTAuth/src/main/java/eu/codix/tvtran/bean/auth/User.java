package eu.codix.tvtran.bean.auth;

import eu.codix.tvtran.bean.AbstractEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
@Entity
@Table(name = "user")
public class User
    extends AbstractEntity
//    implements UserDetails
{

  @Length(min = 5, max = 20)
  @Column(name = "username", unique = true, nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
  @JoinTable(
      name                = "UserRole",
      joinColumns         = @JoinColumn(name = "userId", referencedColumnName = "id"),
      inverseJoinColumns  = @JoinColumn(name = "roleId", referencedColumnName = "id")
  )
  private Set<Role> roles = new HashSet<Role>();

  @Column
  private boolean accountNonExpired = Boolean.TRUE;

  @Column
  private boolean accountNonLocked = Boolean.TRUE;

  @Column
  private boolean credentialsNonExpired = Boolean.TRUE;

  @Column
  private boolean enabled = Boolean.TRUE;

//  private Set<? extends GrantedAuthority> authorities;

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

//  public Collection<? extends GrantedAuthority> getAuthorities()
//  {
//    return authorities;
//  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public boolean isAccountNonExpired()
  {
    return accountNonExpired;
  }

  public boolean isAccountNonLocked()
  {
    return accountNonLocked;
  }

  public boolean isCredentialsNonExpired()
  {
    return credentialsNonExpired;
  }

  public boolean isEnabled()
  {
    return enabled;
  }

  public void setAccountNonExpired(boolean accountNonExpired)
  {
    this.accountNonExpired = accountNonExpired;
  }

  public void setAccountNonLocked(boolean accountNonLocked)
  {
    this.accountNonLocked = accountNonLocked;
  }

  public void setCredentialsNonExpired(boolean credentialsNonExpired)
  {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  public void setEnabled(boolean enabled)
  {
    this.enabled = enabled;
  }

  public Set<Role> getRoles()
  {
    return roles;
  }

  public void setRoles(Set<Role> roles)
  {
    this.roles = roles;
  }

//  public void setAuthorities(Set<? extends GrantedAuthority> authorities)
//  {
//    this.authorities = authorities;
//  }
}

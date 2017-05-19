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
@Table(name = "permission")
public class Permission extends AbstractEntity
{
  @Length(min = 4, max = 20)
  @Column(name = "name", unique = true, nullable = false)
  private String name;

  @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
  @JoinTable(
      name                = "RolePermission",
      joinColumns         = @JoinColumn(name = "permissionId", nullable = false, referencedColumnName = "id"),
      inverseJoinColumns  = @JoinColumn(name = "roleId", nullable = false, referencedColumnName = "id")
  )
  private Set<Role> roles = new HashSet<Role>();

  public Permission() {

  }

  public Permission(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Set<Role> getRoles()
  {
    return roles;
  }

  public void setRoles(Set<Role> roles)
  {
    this.roles = roles;
  }
}

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
@Table(name = "role")
public class Role extends AbstractEntity
{
  @Length(min = 4, max = 20)
  @Column(name = "name", unique = true, nullable = false)
  private String name;

  @ManyToMany(targetEntity = User.class, cascade = CascadeType.ALL)
  @JoinTable(
      name                = "UserRole",
      joinColumns         = @JoinColumn(name = "roleId", nullable = false, referencedColumnName = "id"),
      inverseJoinColumns  = @JoinColumn(name = "userId", nullable = false, referencedColumnName = "id")
  )
  private Set<User> users = new HashSet<User>();

  @ManyToMany(targetEntity = Permission.class, cascade = CascadeType.ALL)
  @JoinTable(
      name                = "RolePermission",
      joinColumns         = @JoinColumn(name = "roleId", nullable = false, referencedColumnName = "id"),
      inverseJoinColumns  = @JoinColumn(name = "permissionId", nullable = false, referencedColumnName = "id")
  )
  private Set<Permission> permissions = new HashSet<Permission>();

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Set<User> getUsers()
  {
    return users;
  }

  public void setUsers(Set<User> users)
  {
    this.users = users;
  }

  public Set<Permission> getPermissions()
  {
    return permissions;
  }

  public void setPermissions(Set<Permission> permissions)
  {
    this.permissions = permissions;
  }
}

package eu.codix.tvtran.config.auth;

import eu.codix.tvtran.service.permission.PermissionService;
import eu.codix.tvtran.service.role.RoleService;
import eu.codix.tvtran.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
@Service(value = "authenticationService")
public class MyUserDetailsService implements UserDetailsService
{

  @Autowired
  private PermissionService permissionService;

  @Autowired
  private RoleService roleService;

  @Autowired
  private UserService userService;

  /*  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
      final List<Permission> permissionsByUser = permissionService.findUserPermission("admin");
      return new User("admin", "1234", getMyAuthoritiesFromPermissions(permissionsByUser));
    }

    private Set<GrantedAuthority> getMyAuthoritiesFromPermissions(List<Permission> permissions)
    {
      final Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
      for (Permission permission : permissions) {
        authorities.add(new SimpleGrantedAuthority(permission.getName()));
      }
      return authorities;
    }
  */
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
  {
    final eu.codix.tvtran.bean.auth.User user = userService.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User: '" + username + "' not found !");
    }

    final List<String> authoritiesByUser = permissionService.findAllAuthorities(username);
    return new User
        (
            user.getUsername()
            , user.getPassword()
            , user.isEnabled()
            , user.isAccountNonExpired()
            , user.isCredentialsNonExpired()
            , user.isAccountNonLocked()
            , getMyAuthoritiesFromPermissions(authoritiesByUser)
        );
  }

  private Set<GrantedAuthority> getMyAuthoritiesFromPermissions(List<String> allAuthorities)
  {
    final Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
    for (String auth : allAuthorities) {
      grantedAuthorities.add(new SimpleGrantedAuthority(auth));
    }
    return grantedAuthorities;
  }
}

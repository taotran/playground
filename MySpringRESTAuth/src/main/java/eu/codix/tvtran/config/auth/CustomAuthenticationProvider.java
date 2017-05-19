package eu.codix.tvtran.config.auth;

import eu.codix.tvtran.bean.auth.User;
import eu.codix.tvtran.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/10/2017
 */
//@Component("authenticationProvider")
public class CustomAuthenticationProvider extends DaoAuthenticationProvider
{
  @Autowired
  private UserService userService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException
  {
    final User user = userService.findByUsername(authentication.getName());
    if (user == null) {
      throw new UsernameNotFoundException("User: '" + authentication.getName() + "' not found !");
    }
    final Authentication auth = super.authenticate(authentication);

    return new UsernamePasswordAuthenticationToken(user, auth.getCredentials(), auth.getAuthorities());
  }
}

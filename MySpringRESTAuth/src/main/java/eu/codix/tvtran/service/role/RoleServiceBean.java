package eu.codix.tvtran.service.role;

import eu.codix.tvtran.bean.auth.Role;
import eu.codix.tvtran.bean.auth.User;
import eu.codix.tvtran.repository.RoleRepository;
import eu.codix.tvtran.service.EntityServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
@Service
public class RoleServiceBean extends EntityServiceBean<Role> implements RoleService
{
  @Autowired
  private RoleRepository roleRepository;

  public List<Role> findByUsers(List<User> users)
  {
    return roleRepository.findByUsers(users);
  }

  public Role findByName(String name)
  {
    return roleRepository.findByName(name);
  }

  public List<Role> findByUser(User user)
  {
    return findByUsers(Arrays.asList(user));
  }
}

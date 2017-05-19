package eu.codix.tvtran.service.role;

import eu.codix.tvtran.bean.auth.Role;
import eu.codix.tvtran.bean.auth.User;
import eu.codix.tvtran.service.EntityService;

import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
public interface RoleService extends EntityService<Role>
{
  List<Role> findByUser(User user);

  List<Role> findByUsers(List<User> users);

  Role findByName(String name);

}

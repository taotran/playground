package eu.codix.tvtran.repository;

import eu.codix.tvtran.bean.auth.Role;
import eu.codix.tvtran.bean.auth.User;

import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
public interface RoleRepository extends EntityRepository<Role>
{

  List<Role> findByUsers(List<User> users);

  Role findByName(String name);
}

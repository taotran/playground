package eu.codix.tvtran.repository;

import eu.codix.tvtran.bean.auth.User;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
public interface UserRepository extends EntityRepository<User>
{

  User findByUsername(String userName);
  
}

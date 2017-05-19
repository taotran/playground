package eu.codix.tvtran.service.user;

import eu.codix.tvtran.bean.auth.User;
import eu.codix.tvtran.service.EntityService;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
public interface UserService extends EntityService<User>
{

  User findByUsername(String username);
}

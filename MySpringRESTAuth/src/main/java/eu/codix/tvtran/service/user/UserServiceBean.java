package eu.codix.tvtran.service.user;

import eu.codix.tvtran.bean.auth.User;
import eu.codix.tvtran.repository.UserRepository;
import eu.codix.tvtran.service.EntityServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
@Service
@Transactional
public class UserServiceBean extends EntityServiceBean<User> implements UserService
{
  @Autowired
  private UserRepository userRepository;

  public User findByUsername(String username)
  {
    return userRepository.findByUsername(username);
  }
}

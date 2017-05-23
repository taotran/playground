package eu.codix.tvtran.rest;

import eu.codix.tvtran.bean.auth.User;
import eu.codix.tvtran.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  5/23/2017
 */
@RestController
@RequestMapping("/svc")
public class UserResource
{
  private final UserService userService;

  @Autowired
  public UserResource(UserService userService)
  {
    Assert.notNull(userService);
    this.userService = userService;
  }

  @GetMapping(path = "/userList")
  public List<User> getUsers(@RequestParam(value = "page", required = false) Integer page)
  {
    return userService.findAll(new PageRequest(page, 30));

  }
}

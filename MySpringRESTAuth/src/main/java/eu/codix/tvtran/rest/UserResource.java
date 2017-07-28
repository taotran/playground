package eu.codix.tvtran.rest;

import eu.codix.tvtran.bean.auth.User;
import eu.codix.tvtran.config.MyLang;
import eu.codix.tvtran.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

  @GetMapping(path = "/user")
  public List<User> getUsers(@RequestParam(value = "page", required = false) Integer page, @MyLang String lang)
  {
    try {
      System.out.println("lang = " + lang);
      return userService.findAll(new PageRequest(page, 30));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ArrayList<User>();

  }

  @PostMapping(path = "/user")
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasAuthority('CREATE_USER')")
  public void addUser(@RequestBody User user) {
    userService.save(user);
  }
}

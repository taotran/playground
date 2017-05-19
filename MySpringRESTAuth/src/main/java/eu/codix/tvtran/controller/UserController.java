package eu.codix.tvtran.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  5/18/2017
 */
@Controller
public class UserController
{

  @PreAuthorize("hasAnyRole('USER','ADMIN')")
  @RequestMapping(path = "/ul", method = RequestMethod.GET)
  public String getUserList()
  {
    System.out.println("Inside user controller");
    return "userList";
  }
}

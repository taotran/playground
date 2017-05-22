package eu.codix.tvtran.controller;

import eu.codix.tvtran.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  5/18/2017
 */
@Controller
public class UserController
{

  @Autowired
  private UserService userService;

//  @PreAuthorize("hasAuthority('UPDATE_USER')")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @RequestMapping(path = "/user/list", method = RequestMethod.GET)
  public String getUserList(ModelMap model, @RequestParam(required = false) Integer page)
  {

    if (page == null) {
      page = 0;
    }

    final long count = userService.countAll();

    model.addAttribute("count", count);
    model.addAttribute("noOfPages", count / 20);
    model.addAttribute("users", userService.findAll(new PageRequest(page, 20)));

    System.out.println("Inside user controller");
    return "userList";
  }
}

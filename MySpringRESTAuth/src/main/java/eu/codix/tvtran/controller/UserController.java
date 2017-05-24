package eu.codix.tvtran.controller;

import eu.codix.tvtran.bean.auth.User;
import eu.codix.tvtran.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    model.addAttribute("noOfPages", count / 30);
    model.addAttribute("users", userService.findAll(new PageRequest(page, 30)));

    System.out.println("Inside user controller");
    return "userList";
  }

  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @GetMapping(path = "/user/getUsers", headers = "Accept=application/json")
  public @ResponseBody
  List<User> getUsers(HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    Integer page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 0;
    return userService.findAll(new PageRequest(page, 30));
  }
}

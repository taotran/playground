package eu.codix.tvtran.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/6/2017
 */

@Controller
public class HomeController
{
  private static final Logger logger = LogManager.getLogger(HomeController.class);

  @RequestMapping(path = {"/index", "/"})
  public String home()
  {
    logger.info("test log");
    return "index";
  }

  @RequestMapping(path = "/success")
  public String login()
  {
    logger.info("inside success controller");
    return "success";
  }
}

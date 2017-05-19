package eu.codix.tvtran.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/6/2017
 */
@RestController
@RequestMapping("/svc")
public class HomeResource
{

//  @PreAuthorize("hasPermission()")
  @PreAuthorize("hasAuthority('READ_USER')")
  @GetMapping(path = "/testList")
  public List<String> getTestList() {
    return Arrays.asList("test", "test1", "test2");
  }
}

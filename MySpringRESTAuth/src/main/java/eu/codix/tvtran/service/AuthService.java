package eu.codix.tvtran.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.codix.tvtran.bean.Credentials;
import eu.codix.tvtran.util.TestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.PrintWriter;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  5/15/2017
 */
//@Service("authService1")
public class AuthService implements IAuthService
{
  private static final Logger logger = LogManager.getLogger(AuthService.class);

  private String token;

//  @Autowired
//  public AuthService(WebApplicationContext wac) throws Exception {
//
//    final PrintWriter printWriter = IoBuilder.forLogger(logger).buildPrintWriter();
//
//    final MockMvc mockMvc = MockMvcBuilders
//        .webAppContextSetup(wac)
//        .apply(springSecurity())
//        .alwaysDo(print(printWriter))
//        .build();
//
//    token = TestUtils.performLogin(mockMvc, "admin1", "1234");
//
//  }

  @Autowired
  public AuthService(WebApplicationContext wac) throws Exception {

    final Credentials credentials = new Credentials("admin", "1234");

    final PrintWriter printWriter = IoBuilder.forLogger(logger).buildPrintWriter();
    final MockMvc mockMvc = MockMvcBuilders
        .webAppContextSetup(wac)
        .apply(springSecurity())
        .alwaysDo(print(printWriter))
        .build();
    MvcResult result = mockMvc.perform(post("/performLogin")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(credentials))
    ).andReturn();

    System.out.println(result);

  }



  public String getToken()
  {
    return token;
  }
}

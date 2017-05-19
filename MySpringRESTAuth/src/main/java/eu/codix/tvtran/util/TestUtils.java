package eu.codix.tvtran.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.codix.tvtran.bean.Credentials;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  5/15/2017
 */
public class TestUtils
{

  public static String performLogin(MockMvc mockMvc, String username, String password) throws Exception
  {

    final Credentials credentials = new Credentials(username, password);

    return mockMvc.perform(post("/performLogin")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(credentials))
    )
        .andExpect(status().is(200))
        .andReturn()
        .getResponse()
        .getHeader("Authorization");
  }

}

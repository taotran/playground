import eu.codix.tvtran.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/6/2017
 */

public class HomeResourceTest extends MyTestBase
{
//  @Autowired
//  @Qualifier("authService1") IAuthService authService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void test() {
    Assert.assertEquals(1, 1);
  }

  @Test
  public void testGetTestList() throws Exception {
//    String token = authService.getToken();
//    System.out.println(token);

    mockMvc.perform(get("/svc/testList")).andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());

  }
}

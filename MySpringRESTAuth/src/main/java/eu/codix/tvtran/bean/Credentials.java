package eu.codix.tvtran.bean;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  5/15/2017
 */
public class Credentials
{
  private String username;
  private String password;

  public Credentials(String username, String password)
  {
    this.username = username;
    this.password = password;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }
}

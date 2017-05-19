package eu.codix.tvtran.config.setup;

import eu.codix.tvtran.bean.auth.Permission;
import eu.codix.tvtran.bean.auth.Role;
import eu.codix.tvtran.bean.auth.User;
import eu.codix.tvtran.service.permission.PermissionService;
import eu.codix.tvtran.service.role.RoleService;
import eu.codix.tvtran.service.user.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
@Component
public class SetupData implements ApplicationListener<ContextRefreshedEvent>
{
  private static final Logger LOGGER = LogManager.getLogger(SetupData.class);

  static int count = 0;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private UserService userService;

  @Autowired
  private RoleService roleService;

  @Autowired
  private PermissionService permissionService;

  private boolean runInitializeData = false;

  public void onApplicationEvent(ContextRefreshedEvent event)
  {
    jdbcTemplate.execute("SELECT * FROM User");

    Pageable pageable = new PageRequest(1, 10);

    List<User> users = userService.findAll(pageable);

    for (User user : users) {
      System.out.println(user.getUsername());
    }

    if (event.getApplicationContext().getParent() != null) {
      LOGGER.info("================Initialization test data==================");
      LOGGER.info(count);
      count++;
      if (runInitializeData) {
        for (int i = 1; i < 1000; i++) {
          final String username = getSampleUsername(i);
          User user = userService.findByUsername(username);
          if (user == null) {
            user = new User();
            user.setUsername(username);
            user.setPassword("12345");
          }
          Role userRole = roleService.findByName("ROLE_USER");
          if (userRole == null) {
            userRole = new Role();
            userRole.setName("ROLE_USER");
          }
          Permission userEntityRPermission = permissionService.findByName("READ_USER");
          if (userEntityRPermission == null) {
            userEntityRPermission = new Permission("READ_USER");
          }
          final Set<Permission> permissions = new HashSet<Permission>();
          permissions.add(userEntityRPermission);

          userRole.setPermissions(permissions);

          Set<Role> roles = new HashSet<Role>();
          roles.add(userRole);

          user.setRoles(roles);


          userService.save(user);
          LOGGER.info("User '" + user.getUsername() + "' has been saved");


        }
      }
    }
//    jdbcTemplate.execute("INSERT INTO test(name) VALUES ('Test')");

//    User toBeValidatedUser = new User();
//    toBeValidatedUser.setUsername("a");
//    toBeValidatedUser.setPassword("abcd");
//    userService.save(toBeValidatedUser);
//    createATestUser();


    if (runInitializeData) {
      List<Permission> adminPermissions = permissionService.findUserPermission("admin");

      for (Permission permission : adminPermissions) {
        System.out.println(permission.getName());
      }
      User admin = userService.findByUsername("admin");
      if (admin != null) {
        userService.delete(admin);
      }

      admin = new User();
      admin.setUsername("admin");
      admin.setPassword("1234");

      Role adminRole = new Role();
      adminRole.setName("ROLE_ADMIN");

      Role userRole = new Role();
      userRole.setName("ROLE_USER");

      Permission userEntityCPermission = new Permission("CREATE_USER");

      Permission userEntityRPermission = new Permission("READ_USER");

      Permission userEntityUPermission = new Permission("UPDATE_USER");

      Permission userEntityDPermission = new Permission("DELETE_USER");

      final Set<Permission> permissions = new HashSet<Permission>();
      permissions.add(userEntityCPermission);
      permissions.add(userEntityRPermission);
      permissions.add(userEntityUPermission);
      permissions.add(userEntityDPermission);

      adminRole.setPermissions(permissions);

      final Set<Role> roles = new HashSet<Role>();
      roles.add(adminRole);
      roles.add(userRole);

      admin.setRoles(roles);

      //save admin with full roles and permissions
      userService.save(admin);

      LOGGER.info(userService.findAll().size());
    }
  }

  private void createATestUser()
  {
    final User user = new User();
    user.setUsername("testUser");
    user.setPassword("123");

    final Set<Role> roles = new HashSet<Role>();
    final Role role = new Role();
    role.setName("ROLE_USER");

    Permission userEntityRPermission = permissionService.findByName("READ_USER");
    if (userEntityRPermission == null) {
      userEntityRPermission = new Permission("READ_USER");
    }
    final Set<Permission> permissions = new HashSet<Permission>();
    permissions.add(userEntityRPermission);


    role.setPermissions(permissions);
    roles.add(role);

    user.setRoles(roles);
    userService.save(user);

  }

  private String getSampleUsername(int no)
  {
    String prefix = "user";
    String suffix;
    if (no < 10) {
      suffix = "00" + no;
    }
    else if (no >= 10 && no < 100) {
      suffix = "0" + no;
    }
    else {
      suffix = String.valueOf(no);
    }
    return prefix + suffix;
  }


}

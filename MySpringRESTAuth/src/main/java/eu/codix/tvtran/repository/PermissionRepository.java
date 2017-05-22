package eu.codix.tvtran.repository;

import eu.codix.tvtran.bean.auth.Permission;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
public interface PermissionRepository extends EntityRepository<Permission>
{

  //@formatter:off
  @Query(value =    "SELECT p FROM Permission   p   "
                  + " INNER  JOIN p.roles       r   "
                  + " INNER  JOIN r.users       u   "
                  + "WHERE  u.username = ?1         "
  ) //@formatter:on
  List<Permission> findUserPermission(String username);

  //@formatter:off
  @Query(value =    "SELECT p.name                                            "
                  + "  FROM permission p                                      "
                  + " INNER JOIN rolepermission rp ON rp.permissionId = p.id  "
                  + " INNER JOIN role r ON rp.roleId = r.id                   "
                  + " INNER JOIN userrole ur ON ur.roleId = r.id              "
                  + " INNER JOIN USER u ON ur.userId = u.id                   "
                  + " WHERE u.username = ?1                                   "
                  + "UNION                                                    "
                  + "SELECT r.name                                            "
                  + "  FROM role r                                            "
                  + "  JOIN userrole ur ON ur.roleid = r.id                   "
                  + "  JOIN USER u ON ur.userId = u.id                        "
                  + " WHERE u.username = ?1                                   "
  , nativeQuery = true)
  //@formatter:on
  List<String> findAuthorities(String username);

  Permission findByName(String name);
}

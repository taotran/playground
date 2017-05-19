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

  Permission findByName(String name);
}

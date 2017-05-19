package eu.codix.tvtran.service.permission;

import eu.codix.tvtran.bean.auth.Permission;
import eu.codix.tvtran.service.EntityService;

import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
public interface PermissionService extends EntityService<Permission>
{
  List<Permission> findUserPermission(String username);

  Permission findByName(String name);

}

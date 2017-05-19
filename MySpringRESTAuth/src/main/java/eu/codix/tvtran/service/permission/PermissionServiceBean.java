package eu.codix.tvtran.service.permission;

import eu.codix.tvtran.bean.auth.Permission;
import eu.codix.tvtran.repository.PermissionRepository;
import eu.codix.tvtran.service.EntityServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
@Service
public class PermissionServiceBean extends EntityServiceBean<Permission> implements PermissionService
{
  @Autowired
  private PermissionRepository permissionRepository;

  public List<Permission> findUserPermission(String username)
  {
    return permissionRepository.findUserPermission(username);
  }

  public Permission findByName(String name)
  {
    return permissionRepository.findByName(name);
  }
}

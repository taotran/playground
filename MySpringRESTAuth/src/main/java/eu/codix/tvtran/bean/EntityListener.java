package eu.codix.tvtran.bean;

import javax.persistence.PrePersist;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/20/2017
 */
public class EntityListener<T extends AbstractEntity>
{

  @PrePersist
  public void entityPrePersist() {

  }
}

package eu.codix.tvtran.bean;

import javax.persistence.Column;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  5/16/2017
 */
public class AbstractIndexableEntity extends AbstractEntity implements Indexable
{
  @Column(name = "index")
  private Integer index;

  public Integer getIndex()
  {
    return index;
  }

  public void setIndex(Integer index)
  {
    this.index = index;
  }
}

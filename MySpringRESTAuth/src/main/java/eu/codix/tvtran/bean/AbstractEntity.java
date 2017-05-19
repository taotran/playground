package eu.codix.tvtran.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
@MappedSuperclass
public class AbstractEntity implements Identifiable, Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "insertDate")
  private Date insertDate;

  @Column(name = "updateDate")
  private Date updateDate;

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  @PrePersist
  public void setPrePersist()
  {
    System.out.println("on pre-inserting...");
    if (this.insertDate == null) {
      this.insertDate = new Date();
    }
  }

  @PreUpdate
  public void setPreUpdate()
  {
    System.out.println("on pre-updating...");
    if (this.updateDate == null) {
      this.updateDate = new Date();
    }
  }


  public Date getInsertDate()
  {
    return insertDate;
  }

  public void setInsertDate(Date insertDate)
  {
    this.insertDate = insertDate;
  }

  public Date getUpdateDate()
  {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate)
  {
    this.updateDate = updateDate;
  }
}

package eu.codix.tvtran.bean.category;

import eu.codix.tvtran.bean.AbstractEntity;
import eu.codix.tvtran.bean.Indexable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/21/2017
 */
@Entity
@Table(name = "category")
public class Category extends AbstractEntity
{

  @NotNull
  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", length = 300)
  private String description;

//  @Column(name = "index")
//  private Integer index;

  @ManyToOne(targetEntity = Category.class)
  @JoinColumn(name = "fk_parent", referencedColumnName = "id")
  private Category parent;


  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Category getParent()
  {
    return parent;
  }

  public void setParent(Category parent)
  {
    this.parent = parent;
  }

//  public Integer getIndex()
//  {
//    return index;
//  }
//
//  public void setIndex(Integer index)
//  {
//    this.index = index;
//  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }
}

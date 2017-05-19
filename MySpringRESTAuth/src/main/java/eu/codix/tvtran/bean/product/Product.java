package eu.codix.tvtran.bean.product;

import eu.codix.tvtran.bean.AbstractEntity;
import eu.codix.tvtran.bean.category.Category;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/21/2017
 */
@Entity
@Table(name = "product")
public class Product extends AbstractEntity
{

  @NotNull
  @Column(name = "name", nullable = false)
  private String name;

  @Min(0)
  @Max(9999999)
  @Column(name = "price")
  private double price;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "fk_category", referencedColumnName = "id")
  private Category category;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public Category getCategory()
  {
    return category;
  }

  public void setCategory(Category category)
  {
    this.category = category;
  }
}

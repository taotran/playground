package eu.codix.tvtran.service.product;

import eu.codix.tvtran.bean.category.Category;
import eu.codix.tvtran.bean.product.Product;
import eu.codix.tvtran.repository.ProductRepository;
import eu.codix.tvtran.service.EntityServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/21/2017
 */
@Service
public class ProductServiceBean extends EntityServiceBean<Product> implements ProductService
{
  private final ProductRepository productRepository;

  @Autowired
  public ProductServiceBean(ProductRepository productRepository)
  {
    Assert.notNull(productRepository);
    this.productRepository = productRepository;
  }

  public List<Product> findByCategory(Category category)
  {
    return productRepository.findByCategory(category);
  }
}

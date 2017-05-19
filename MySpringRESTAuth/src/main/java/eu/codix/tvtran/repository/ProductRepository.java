package eu.codix.tvtran.repository;

import eu.codix.tvtran.bean.category.Category;
import eu.codix.tvtran.bean.product.Product;

import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/21/2017
 */
public interface ProductRepository extends EntityRepository<Product>
{

  List<Product> findByCategory(Category category);
}

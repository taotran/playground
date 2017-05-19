package eu.codix.tvtran.service.product;

import eu.codix.tvtran.bean.category.Category;
import eu.codix.tvtran.bean.product.Product;
import eu.codix.tvtran.service.EntityService;

import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/21/2017
 */
public interface ProductService extends EntityService<Product>
{

  List<Product> findByCategory(Category category);
}

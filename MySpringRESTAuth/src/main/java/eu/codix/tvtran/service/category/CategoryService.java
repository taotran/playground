package eu.codix.tvtran.service.category;

import eu.codix.tvtran.bean.category.Category;
import eu.codix.tvtran.service.EntityService;

import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/21/2017
 */
public interface CategoryService extends EntityService<Category>
{

  List<Category> findChildren(Category parent);
}

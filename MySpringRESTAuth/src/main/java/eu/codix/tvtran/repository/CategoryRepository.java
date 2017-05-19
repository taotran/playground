package eu.codix.tvtran.repository;

import eu.codix.tvtran.bean.category.Category;

import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/21/2017
 */
public interface CategoryRepository extends EntityRepository<Category>
{
  List<Category> findByParent(Category parent);
}

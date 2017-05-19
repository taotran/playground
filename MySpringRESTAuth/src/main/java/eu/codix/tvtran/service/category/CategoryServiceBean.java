package eu.codix.tvtran.service.category;

import eu.codix.tvtran.bean.category.Category;
import eu.codix.tvtran.repository.CategoryRepository;
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
public class CategoryServiceBean extends EntityServiceBean<Category> implements CategoryService
{
  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryServiceBean(CategoryRepository categoryRepository)
  {
    Assert.notNull(categoryRepository);
    this.categoryRepository = categoryRepository;
  }

  public List<Category> findChildren(Category parent)
  {
    return categoryRepository.findByParent(parent);
  }
}

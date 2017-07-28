package eu.codix.tvtran.service;

import eu.codix.tvtran.bean.AbstractEntity;
import eu.codix.tvtran.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//import org.springframework.data.domain.Slice;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
@Service
public class EntityServiceBean<T extends AbstractEntity> implements EntityService<T>
{
  @PersistenceContext
  private EntityManager em;

  @Autowired
  private EntityRepository<T> entityRepository;

  public List<T> findAll()
  {
    return entityRepository.findAll();
  }

  public List<T> findAll(Pageable pageable)
  {
    return entityRepository.findAll(pageable).getContent();
  }

  public T findOne(Long id)
  {
    return entityRepository.findOne(id);
  }

  @Transactional
  public T save(@Validated T t)
  {
    if (t.getId() == 0 || findOne(t.getId()) == null) {
      em.persist(t);
    }
    else {
      em.merge(t);
    }
    em.flush();
    return t;
  }

  @Transactional
  public void delete(T t)
  {
    entityRepository.delete(t);
  }

  public long countAll() {
    return entityRepository.count();
  }
}

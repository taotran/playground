package eu.codix.tvtran.service;

import eu.codix.tvtran.bean.AbstractEntity;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Slice;

import java.util.List;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
public interface EntityService<T extends AbstractEntity>
{
  List<T> findAll();

  List<T> findAll(Pageable pageable);

  T findOne(Long id);

  T save(T t);

  void delete(T t);

  long countAll();
}

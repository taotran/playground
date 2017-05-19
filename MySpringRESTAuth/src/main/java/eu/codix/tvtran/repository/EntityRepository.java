package eu.codix.tvtran.repository;

import eu.codix.tvtran.bean.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
public interface EntityRepository<T extends AbstractEntity> extends JpaRepository<T, Long>
{
}

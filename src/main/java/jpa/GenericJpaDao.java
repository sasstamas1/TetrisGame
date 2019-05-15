package jpa;

import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Jpa Dao.
 *
 * @param <T>
 */
public abstract class GenericJpaDao<T> {

    protected Class<T> entityClass;
    protected EntityManager entityManager;

    /**
     * Jpa dao konstruktora.
     * @param entityClass egy entity class.
     */
    public GenericJpaDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Mentés az adatbázisba.
     * @param entity entity.
     */
    @Transactional
    public void persist(T entity) {
        entityManager.persist(entity);
    }

}

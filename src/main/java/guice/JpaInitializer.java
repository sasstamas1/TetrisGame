package guice;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Jpa inicializálás.
 */
@Singleton
public class JpaInitializer {

    /**
     * Inicializalja a persist szervert.
     *
     * @param persistService - a persist szerver.
     */
    @Inject
    public JpaInitializer (PersistService persistService) {
        persistService.start();
    }

}
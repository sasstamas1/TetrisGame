package guice;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JpaInitializer {

    /**
     * Inicializálja a persist szervert.
     *
     * @param persistService - a persist szerver.
     */
    @Inject
    public JpaInitializer (PersistService persistService) {
        persistService.start();
    }

}

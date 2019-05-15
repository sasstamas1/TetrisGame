package guice;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * PesrsistenceModule class.
 */
public class PersistenceModule extends AbstractModule {

    private String jpaUnit;

    /**
     * a PersistenceModule konstruktora.
     *
     * @param jpaUnit adott jpaUnit.
     */
    public PersistenceModule(String jpaUnit) {
        this.jpaUnit = jpaUnit;
    }

    /**
     * Beallitja a fuggosegek befecskendezeset elosegito keretrendszert.
     */
    @Override
    protected void configure() {
        install(new JpaPersistModule(jpaUnit));
        bind(JpaInitializer.class).asEagerSingleton();
    }

}
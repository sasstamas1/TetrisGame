package guice;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

public class PersistenceModule extends AbstractModule {

    private String jpaUnit;

    public PersistenceModule(String jpaUnit) {
        this.jpaUnit = jpaUnit;
    }

    /**
     * Beállítja a függ?ségek befecskendezését el?segít? keretrendszert.
     */
    @Override
    protected void configure() {
        install(new JpaPersistModule(jpaUnit));
        bind(JpaInitializer.class).asEagerSingleton();
    }

}

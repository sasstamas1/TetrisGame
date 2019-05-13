package guice;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

public class PersistenceModule extends AbstractModule {

    private String jpaUnit;

    public PersistenceModule(String jpaUnit) {
        this.jpaUnit = jpaUnit;
    }

    /**
     * Be�ll�tja a f�gg?s�gek befecskendez�s�t el?seg�t? keretrendszert.
     */
    @Override
    protected void configure() {
        install(new JpaPersistModule(jpaUnit));
        bind(JpaInitializer.class).asEagerSingleton();
    }

}

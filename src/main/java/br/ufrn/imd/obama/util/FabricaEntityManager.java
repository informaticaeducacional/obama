package br.ufrn.imd.obama.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by samue on 08/09/2017.
 */
public class FabricaEntityManager {

    @ApplicationScoped
    @Produces
    public EntityManagerFactory criarFactory() {
        return Persistence.createEntityManagerFactory("ObamaPersistenceUnit");
    }

    public void fecharFactory(@Disposes EntityManagerFactory factory) {
        factory.close();
    }

    @Produces
    @RequestScoped
    public EntityManager criarManager(EntityManagerFactory factory) {
        return factory.createEntityManager();
    }

    public void fecharManager(@Disposes EntityManager manager) {
        manager.close();
    }
}

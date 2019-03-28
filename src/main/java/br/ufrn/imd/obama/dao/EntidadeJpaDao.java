package br.ufrn.imd.obama.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufrn.imd.obama.dominio.Entidade;

public abstract class EntidadeJpaDao<T extends Entidade> implements EntidadeDao<T> {

    protected EntityManager manager;
    protected Class<T> tClass;

    public EntidadeJpaDao(EntityManager entityManager, Class<T> tClass) {
        this.manager = entityManager;
        this.tClass = tClass;
    }

    @Override
    public T buscarPorId(int id) {
        return manager.find(tClass, id);
    }

    @Override
    public T salvar(T entidade) {
        if(entidade.getId() > 0) {
            this.manager.merge(entidade);
        } else {
            this.manager.persist(entidade);
        }
        return entidade;
    }

    @Override
    public void remover(T entidade) {
        manager.remove(entidade);
    }

    /**
     * A função listar() deve ser utilizada para todas as entidades que possuem delete lógico
     * @return Collection
     */
    @SuppressWarnings("unchecked")
	@Override
    public List<T> listar() {
        return manager.createQuery("SELECT t FROM "+tClass.getSimpleName()+" t").getResultList();
    }

}

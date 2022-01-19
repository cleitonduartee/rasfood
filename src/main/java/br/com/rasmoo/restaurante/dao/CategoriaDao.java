package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public void cadastrar(final Categoria categoria){

        this.entityManager.persist(categoria);
    }

    public Categoria consultarPorId(Integer id){

        return entityManager.find(Categoria.class, id);
    }
    public void atualizar(final Categoria categoria){

        this.entityManager.merge(categoria);
    }
    public void deletar(Categoria categoria){

        this.entityManager.remove(categoria);
    }
}

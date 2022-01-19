package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.util.List;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio cardapio){
        this.entityManager.persist(cardapio);
    }

    public List<Cardapio> consultarTodos(){
        String query = "SELECT c FROM Cardapio c";
        return this.entityManager.createQuery(query, Cardapio.class).getResultList();
    }
    public Cardapio consultarPorId(Integer id){
        return entityManager.find(Cardapio.class, id);
    }
    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }
    public void deletar(Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}

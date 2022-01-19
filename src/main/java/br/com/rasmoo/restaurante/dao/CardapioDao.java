package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
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
        try{
            String jpql = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(jpql, Cardapio.class).getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public List<Cardapio> consultaPorValor(final BigDecimal filtro){
       try{
           String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
           return this.entityManager.createQuery(jpql, Cardapio.class)
                   .setParameter("valor",filtro)
                   .getResultList();
       }catch (Exception e){
           return null;
       }
    }
    public Cardapio consultarPorNome(final String filtro){
        try{
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:nome)";
            return entityManager.createQuery(jpql,Cardapio.class).setParameter("nome",filtro).getSingleResult();
        }catch (Exception e){
            return null;
        }
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

package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.entity.Prato;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {
        Prato risoto = new Prato();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado lula, polvo e marisco");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));
        /*
        Nesse momento o ciclo de vida da entidade é TRANSIENT (Não está sendo gerenciado pelo JPA)
         */

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rasFood");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(risoto);
        entityManager.getTransaction().commit();
        /*
        Nesse momento o ciclo de vida da entidade é MANAGED(JPA está monitorando a entidade, podendo ser invocado
        os métodos commit() e flush() para sincronizar a entidade.
         */
        entityManager.close();
        /*
        Nesse momento o ciclo de vida da entidade é DETACHED.
         */

    }
}

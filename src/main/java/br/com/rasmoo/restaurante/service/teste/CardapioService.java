package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado lula, polvo e marisco");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmao ao molho de maracuja");
        salmao.setDescricao("Salmao grelhado ao molho");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(88.50));
        /*
        Nesse momento o ciclo de vida da entidade é TRANSIENT (Não está sendo gerenciado pelo JPA)
         */
        EntityManager entityManager = JPAUtil.getEntityManagerRasFod();
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        cardapioDao.cadastrar(salmao);
        System.out.println("Prato consultado foi: "+ cardapioDao.consultar(2));

        cardapioDao.deletar(salmao);
        System.out.println("Prato consultado foi: "+ cardapioDao.consultar(2));
        risoto.setValor(BigDecimal.valueOf(10));
        cardapioDao.atualizar(risoto);
        System.out.println("Prato Atualizado foi: "+ cardapioDao.consultar(1));
        entityManager.getTransaction().commit();

        entityManager.close();
        /*
        Nesse momento o ciclo de vida da entidade é DETACHED.
         */

    }
}

package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.PratoDao;
import br.com.rasmoo.restaurante.entity.Prato;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {
        Prato risoto = new Prato();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado lula, polvo e marisco");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Prato salmao = new Prato();
        salmao.setNome("Salmao ao molho de maracuja");
        salmao.setDescricao("Salmao grelhado ao molho");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(88.50));
        /*
        Nesse momento o ciclo de vida da entidade é TRANSIENT (Não está sendo gerenciado pelo JPA)
         */
        EntityManager entityManager = JPAUtil.getEntityManagerRasFod();
        PratoDao pratoDao = new PratoDao(entityManager);
        entityManager.getTransaction().begin();
        pratoDao.cadastrar(risoto);
        pratoDao.cadastrar(salmao);
        System.out.println("Prato consultado foi: "+pratoDao.consultar(2));

        pratoDao.deletar(salmao);
        System.out.println("Prato consultado foi: "+pratoDao.consultar(2));
        risoto.setValor(BigDecimal.valueOf(10));
        pratoDao.atualizar(risoto);
        System.out.println("Prato Atualizado foi: "+pratoDao.consultar(1));
        entityManager.getTransaction().commit();

        entityManager.close();
        /*
        Nesse momento o ciclo de vida da entidade é DETACHED.
         */

    }
}

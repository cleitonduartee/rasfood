package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFod();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarCardapio(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("Lista produtos por valor: "+ cardapioDao.consultaPorValor(BigDecimal.valueOf(88.50)));
        System.out.println("Consulta por nome: "+ cardapioDao.consultarPorNome("Risoto de frutos do mar"));
        entityManager.close();

    }
}


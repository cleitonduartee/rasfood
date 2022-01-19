package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
       EntityManager entityManager = JPAUtil.getEntityManagerRasFod();
       cadastrarProdutoCardapio(entityManager, cadastrarCategoria(entityManager));

    }
    private static Categoria cadastrarCategoria(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria categoria = new Categoria("Prato principal");

        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(categoria);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return categoria;
    }
    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria){
        Cardapio risoto = new Cardapio("Risoto de frutos do mar","Risoto acompanhado lula, polvo e marisco",true,
                BigDecimal.valueOf(88.50),categoria);

        Cardapio salmao = new Cardapio("Salmao ao molho de maracuja","Salmao grelhado ao molho",true,
                BigDecimal.valueOf(88.50),categoria);
        /*
        Nesse momento o ciclo de vida da entidade é TRANSIENT (Não está sendo gerenciado pelo JPA)
         */
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        cardapioDao.cadastrar(salmao);
   //     System.out.println("Prato consultado foi: "+ cardapioDao.consultarPorId(2));
   //     System.out.println("Prato Atualizado foi: "+ cardapioDao.consultarPorId(1));
        cardapioDao.consultarTodos().forEach(el->System.out.println("O prato consultado foi : "+ el));
        entityManager.getTransaction().commit();

        entityManager.close();
        /*
        Nesse momento o ciclo de vida da entidade é DETACHED.
         */
    }
}

package br.com.rasmoo.restaurante.util;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CargaDeDadosUtil {

    public CargaDeDadosUtil() {
    }

    public static void cadastrarCategoria(EntityManager entityManager){

        Categoria categoria1 = new Categoria("Entrada");
        Categoria categoria2 = new Categoria("Saida");
        Categoria categoria3 = new Categoria("Prato principal");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrar(categoria1);
        entityManager.flush();
        categoriaDao.cadastrar(categoria2);
        entityManager.flush();
        categoriaDao.cadastrar(categoria3);
        entityManager.flush();
        entityManager.clear();

    }
    public static void cadastrarCardapio(EntityManager entityManager){

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        Cardapio risoto = new Cardapio("Risoto de frutos do mar","Risoto acompanhado lula, polvo e marisco",true,
                BigDecimal.valueOf(88.50),categoriaDao.consultarPorId(3));

        Cardapio salmao = new Cardapio("Salmao ao molho de maracuja","Salmao grelhado ao molho",true,
                BigDecimal.valueOf(88.50),categoriaDao.consultarPorId(3));
        Cardapio entrada1 = new Cardapio("Entrada 1","Descrição entrada 1",true,
                BigDecimal.valueOf(88.50),categoriaDao.consultarPorId(1));

        Cardapio entrada2 = new Cardapio("Entrada 2","Descrição entrada 2",true,
                BigDecimal.valueOf(88.50),categoriaDao.consultarPorId(1));
        Cardapio entrada3 = new Cardapio("Entrada 3","Descrição entrada 3",true,
                BigDecimal.valueOf(88.50),categoriaDao.consultarPorId(1));

        Cardapio entrada4 = new Cardapio("Entrada 4","Descrição entrada 4",true,
                BigDecimal.valueOf(88.50),categoriaDao.consultarPorId(1));

        Cardapio saida1 = new Cardapio("Saida 1","Descrição saida 1",true,
                BigDecimal.valueOf(88.50),categoriaDao.consultarPorId(2));

        Cardapio saida2 = new Cardapio("Saida 2","Descrição saida 2",true,
                BigDecimal.valueOf(88.50),categoriaDao.consultarPorId(2));
        Cardapio saida3 = new Cardapio("Saida 3","Descrição saida 3",true,
                BigDecimal.valueOf(88.50),categoriaDao.consultarPorId(2));

        Cardapio saida4 = new Cardapio("Saida 4","Descrição saida 4",true,
                BigDecimal.valueOf(88.50),categoriaDao.consultarPorId(2));

        cardapioDao.cadastrar(risoto);
        cardapioDao.cadastrar(salmao);
        cardapioDao.cadastrar(entrada1);
        cardapioDao.cadastrar(entrada2);
        cardapioDao.cadastrar(entrada3);
        cardapioDao.cadastrar(entrada4);
        cardapioDao.cadastrar(saida1);
        cardapioDao.cadastrar(saida2);
        cardapioDao.cadastrar(saida3);
        cardapioDao.cadastrar(saida4);
        entityManager.getTransaction().commit();
    }


}

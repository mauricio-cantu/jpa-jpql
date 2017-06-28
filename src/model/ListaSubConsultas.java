package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ListaSubConsultas {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compubras");
		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();
		
//		1) Mostre o nome dos Clientes e seu endereço completo, dos clientes que realizaram um pedido
//		   no ano de 2015. ordene pela ordem alfabética. 
//		Query q = em.createQuery(
//				"SELECT c.nome, c.endereco "
//				+ "FROM Cliente c "
//				+ "WHERE c.codCliente in "
//					+ "(SELECT c.codCliente "
//					+ "FROM Cliente c "
//					+ "JOIN Pedido p on p.cliente = c.codCliente "
//					+ "WHERE FUNCTION('YEAR', p.dataPedido) = 2015)"
//				+ "ORDER BY c.nome");
//		List<Object[]> res = q.getResultList();
//		for(Object[] o : res){
//			System.out.println("Nome: " + o[0] + ", Endereço: " + o[1]);
//		}
		
		
//		2) Mostre o nome do produto e seu valor unitário. Somente devem ser exibidos os produtos que
//		tiveram pelo menos 5 e no máximo 7 itens em um único pedido. Ordene em ordem
//		decrescente pelo valor unitário dos produtos.
//		Query q = em.createQuery(
//				"SELECT DISTINCT pr.descricao, pr.valorUnitario "
//				+ "FROM Produto pr "
//				+ "WHERE pr.codProduto in "
//					+ "(SELECT pr.codProduto "
//					+ "FROM Produto pr "
//					+ "JOIN Itempedido i on i.produto = pr.codProduto "
//					+ "WHERE i.quantidade BETWEEN 5 AND 7) "
//				+ "ORDER BY pr.valorUnitario desc");
//		List<Object[]> res = q.getResultList();
//		for(Object[] o : res){
//			System.out.println("Descrição: " + o[0] + ", Valor unitario: " + o[1]);
//		}
		
		
		
		
		em.getTransaction().commit();

		em.close();
		entityManagerFactory.close();

	}

}

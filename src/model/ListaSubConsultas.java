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
		
		
//		3) Mostre a quantidade de pedidos dos clientes que moram no RS ou em SC.
//		Query q = em.createQuery("SELECT COUNT(c.codCliente), c.uf "
//				+ "FROM Cliente c "
//				+ "WHERE c.codCliente in "
//					+ "(SELECT c.codCliente "
//					+ "FROM Cliente c "
//					+ "WHERE c.uf in ('RS', 'SC'))"
//				+ "GROUP BY c.uf");
//		List<Object[]> res = q.getResultList();
//		for(Object[] o : res){
//			System.out.println("UF: " + o[1] + ", Total: " + o[0]);
//		}
		
		
//		4) Mostre o código do produto, o nome e o valor unitário dos produtos que possuam pedidos para
//		serem entregues entre os dias 01/12/2014 e 31/01/2015. Ordene a lista pelo valor unitário
//		decrescente dos produtos
//		Query q = em.createQuery("SELECT pr.codProduto, pr.descricao, pr.valorUnitario "
//				+ "FROM Produto pr "
//				+ "WHERE pr.codProduto in "
//					+ "(SELECT pr.codProduto "
//					+ "FROM Produto pr "
//					+ "JOIN Itempedido i on i.produto = pr.codProduto "
//					+ "JOIN Pedido p on p.codPedido = i.pedido "
//					+ "WHERE p.dataPedido BETWEEN '2014-12-01' AND '2015-01-31')"
//				+ "ORDER BY pr.valorUnitario desc");
//		List<Object[]> res = q.getResultList();
//		for(Object[] o : res){
//			System.out.println("Código: " + o[0] + ", Descrição: " + o[1] + ", Valor Unitario: " + o[2]);
//		}
		
		
//		5) Exiba os dados dos clientes que fizeram pedidos com mais de 60 itens, observe que esta é a
//		quantidade total de itens, independentemente de serem produtos iguais ou diferentes.
		Query q = em.createQuery("SELECT c "
				+ "FROM Cliente c "
				+ "WHERE c.codCliente in "
					+ "(SELECT c.codCliente "
					+ "FROM Cliente c "
					+ "JOIN Pedido p on p.cliente = c.codCliente "
					+ "JOIN Itempedido i on i.pedido = p.codPedido "
					+ "GROUP BY i.pedido "
					+ "HAVING sum(i.quantidade) > 60)");
		List<Cliente> res = q.getResultList();
		for(Cliente c : res){
			System.out.println("Código: " + c.getCodCliente() + ", Nome: " + c.getNome() + ", Cidade: " + c.getCidade());
		}
		
		
		em.getTransaction().commit();

		em.close();
		entityManagerFactory.close();

	}

}

package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Executavel {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compubras");
		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();
		
//		Ex 1 - Mostrar a quantidade pedida para um determinado produto com um determinado
//			   código a partir da tabela item de pedido.
//		Query select = em.createNamedQuery("Itempedido.findAll");
//		List<Itempedido> resultado = select.getResultList();
//		for(Itempedido i : resultado){
//			System.out.println("Quantidade: " + i.getQuantidade() 
//			+ ", Descrição: " + i.getProduto().getDescricao() 
//					+ ", Cod Produto: " + i.getProduto().getCodProduto());
//		}
	
		
//		Ex 2 - Listar a quantidade de produtos que cada pedido contém
//		Query select = em.createQuery("SELECT sum(i.quantidade), p.codPedido FROM Itempedido i "
//				+ "JOIN Pedido p on i.pedido = p.codPedido GROUP BY p.codPedido");
//		List<Object[]> resultados = select.getResultList();
//		for(Object[] ob : resultados){
//			System.out.println("Quantidade: " + ob[0] + ", Pedido: " + ob[1]);
//		}
		

//		Ex 3 - Ver os pedidos de cada cliente, listando nome do cliente e número do pedido.
//		Query select = em.createQuery("SELECT c.nome, p.codPedido FROM Pedido p"
//				+ " JOIN Cliente c on p.cliente = c.codCliente");
//		List<Object[]> resultados = select.getResultList();
//		for(Object[] ob : resultados){
//			System.out.println("Nome: " + ob[0] + ", Pedido: " + ob[1]);
//		}
		
		
//		Ex 4 - Listar todos os clientes com seus respectivos pedidos. Os clientes que não têm
//			   pedidos também devem ser apresentados
//		Query select = em.createQuery("SELECT c.nome, p.codPedido FROM Cliente c"
//				+ " LEFT JOIN Pedido p on p.cliente = c.codCliente");
//		List<Object[]> resultados = select.getResultList();
//		for(Object[] ob : resultados){
//			System.out.println("Nome: " + ob[0] + ", Cod Pedido: " + ob[1]);
//		}

		
//		Ex 5 - Clientes com prazo de entrega superior a 10 dias e que pertençam aos estados do
//			Rio Grande do Sul ou Santa Catarina.
//		Query select = em.createQuery("SELECT DISTINCT c.nome FROM Cliente c "
//				+ "JOIN Pedido p ON p.cliente = c.codCliente "
//				+ "WHERE function('datediff', p.prazoEntrega, p.dataPedido) > 10") AND c.uf in ('RS', 'SC');
//		List<String> resultado = select.getResultList();
//		for(String s : resultado){
//			System.out.println(s);
//		}
		
		
//		Ex 6 - Mostrar os clientes e seus respectivos prazos de entrega, ordenando do maior para
//		o menor.
//		Query select = em.createQuery("SELECT c.nome, p.prazoEntrega FROM Cliente c "
//				+ "JOIN Pedido p on p.cliente = c.codCliente ORDER BY p.prazoEntrega desc");
//		List<Object[]> resultados = select.getResultList();
//		for(Object[] ob : resultados){
//			System.out.println("Nome: " + ob[0] + ", Prazo entrega: " + ob[1]);
//		}
		
		
//		Ex 7 - Apresentar os vendedores, em ordem alfabética, que emitiram pedidos com prazos
//		de entrega superiores a 15 dias e que tenham salários fixos iguais ou superiores a
//		R$ 1.000,00
//		Query select = em.createQuery("SELECT DISTINCT v.nome FROM Vendedor v "
//				+ "JOIN Pedido p on p.vendedor = v.codVendedor "
//				+ "WHERE p.prazoEntrega > 15 AND v.salarioFixo >= 1000.00 "
//				+ "ORDER BY v.nome");
//		List<String> resultados = select.getResultList();
//		for(String s : resultados){
//			System.out.println(s);
//		}
		
		
//		Ex 8 - Os vendedores têm seu salário fixo acrescido de 20% da soma dos valores dos
//		pedidos. Faça uma consulta que retorne o nome dos funcionários e o total de
//		comissão, desses funcionários.
//		Query select = em.createQuery("SELECT v.nome, v.salarioFixo + 0,2 * (sum(i.quantidade * pr.valorUnitario)) "
//				+ "FROM Vendedor v "
//				+ "JOIN Pedido p on p.vendedor = v.codVendedor "
//				+ "JOIN Itempedido i on i.pedido = p.codPedido "
//				+ "JOIN Produto pr on pr.codProduto = i.produto "
//				+ "GROUP BY v.codVendedor");
//		List<Object[]> resultados = select.getResultList();
//		for(Object[] ob: resultados){
//			System.out.println("Nome: " + ob[0] + ", Comissao: " + ob[1]);
//		}
		
		
//		Ex 9 - Os clientes e os respectivos vendedores que fizeram algum pedido para esse
//		cliente, juntamente com a data do pedido.
//		Query select = em.createQuery("SELECT c.nome, v.nome, p.dataPedido "
//				+ "FROM Cliente c "
//				+ "JOIN Pedido p on p.cliente = c.codCliente "
//				+ "JOIN Vendedor v on p.vendedor = v.codVendedor");
//		List<Object[]> res = select.getResultList();
//		for(Object[] ob : res){
//			System.out.println("Cliente: " + ob[0] + ", Vendedor: " + ob[1] + ", Data: " + ob[2]);
//		}
		
		
//		Ex 10 - Liste o nome do cliente e a quantidade de pedidos de cada cliente
//		Query q = em.createQuery("SELECT c.nome, COUNT(c.codCliente) "
//				+ "FROM Cliente c "
//				+ "JOIN Pedido p on p.cliente = c.codCliente "
//				+ "GROUP BY c.codCliente");
//		List<Object[]> res = q.getResultList();
//		for(Object[] ob : res){
//			System.out.println("Cliente: " + ob[0] + ", Pedidos: " + ob[1]);
//		}
		
		
//		Ex 11 - Liste o nome do cliente, o código do pedido e a quantidade total de produtos por
//		pedido.
//		Query q = em.createQuery("SELECT c.nome, p.codPedido, sum(i.quantidade) "
//				+ "FROM Cliente c "
//				+ "JOIN Pedido p on p.cliente = c.codCliente "
//				+ "JOIN Itempedido i on i.pedido = p.codPedido "
//				+ "GROUP BY i.codPedido "
//				+ "ORDER BY p.codPedido desc");
//		List<Object[]> res = q.getResultList();
//		for(Object[] ob : res){
//			System.out.println("Cliente: " + ob[0] + ", Pedido: " + ob[1] + ", Qnt. total pedido: " + ob[2]);
//		}
		
		
//		Ex 12 - Liste o nome do cliente, o código do pedido e o valor total do pedido
//		Query q = em.createQuery("SELECT c.nome, p.codPedido, sum(i.quantidade * pr.valorUnitario) "
//				+ "FROM Cliente c "
//				+ "JOIN Pedido p on p.cliente = c.codCliente "
//				+ "JOIN Itempedido i on i.pedido = p.codPedido "
//				+ "JOIN Produto pr on pr.codProduto = i.produto "
//				+ "GROUP BY p.codPedido");
//		List<Object[]> res = q.getResultList();
//		for(Object[] ob : res){
//			System.out.println("Cliente: " + ob[0] + ", Pedido: " + ob[1] + ", Valor total: " + ob[2]);
//		}
		
		
//		Ex 13 - Liste os produtos, a quantidade vendida e a data dos pedidos realizados no mês de
//		maio de 2015, começando pelos mais vendidos.
//		Query q = em.createQuery("SELECT pr.descricao, i.quantidade, p.dataPedido "
//				+ "FROM Produto pr "
//				+ "JOIN Itempedido i on i.produto = pr.codProduto "
//				+ "JOIN Pedido p on p.codPedido = i.pedido "
//				+ "WHERE FUNCTION('MONTH', p.dataPedido) = 05 "
//				+ "AND FUNCTION('YEAR', p.dataPedido) = 2015 "
//				+ "ORDER BY i.quantidade desc");
//		List<Object[]> res = q.getResultList();
//		for(Object[] ob : res){
//			System.out.println("Produto: " + ob[0] + ", Quantidade: " + ob[1] + ", Data pedido: " + ob[2]);
//		}
		
		
//		Ex 14 - Liste os produtos, do mais caro para o mais barato, dos pedidos no mês de junho
//		(considerando todos os anos)
//		Query q = em.createQuery("SELECT DISTINCT pr.descricao "
//				+ "FROM Produto pr "
//				+ "JOIN Itempedido i on i.produto = pr.codProduto "
//				+ "JOIN Pedido p on i.pedido = p.codPedido "
//				+ "WHERE FUNCTION('MONTH', p.dataPedido) = 06 "
//				+ "ORDER BY pr.valorUnitario DESC");
//		List<String> res = q.getResultList();
//		for(String s : res){
//			System.out.println(s);
//		}
		
		
//		Ex 15 - Exiba a relação dos pedidos mais caros de todos os tempos. Esta relação deve
//		conter o nome do cliente, do vendedor, o código do pedido e o valor total do pedido.
//		Query q = em.createQuery("SELECT c.nome, v.nome, p.codPedido, sum(i.quantidade * pr.valorUnitario) as Total "
//				+ "FROM Pedido p "
//				+ "JOIN Itempedido i on i.pedido = p.codPedido "
//				+ "JOIN Produto pr on i.produto = pr.codProduto "
//				+ "JOIN Cliente c on p.cliente = c.codCliente "
//				+ "JOIN Vendedor v on p.vendedor = v.codVendedor "
//				+ "GROUP BY p.codPedido "
//				+ "ORDER BY Total DESC");
//		List<Object[]> res = q.getResultList();
//		for(Object[] ob : res){
//			System.out.println("Cliente : " + ob[0] + ", Vendedor: " + ob[1] + ", Pedido: " + ob[2] + ", Valor total: " + ob[3]);
//		}
		
		
//		Ex 16 -  Exiba a relação com os melhores vendedores (considerando apenas a quantidade de pedidos) 
//		para o mês de setembro (incluindo todos os anos). Exiba o nome do vendedor, o ano e o número total de pedidos daquele ano
//		Query q = em.createQuery("SELECT v.nome, FUNCTION('YEAR', p.dataPedido), COUNT(p.codPedido) "
//				+ "FROM Vendedor v "
//				+ "JOIN Pedido p on p.vendedor = v.codVendedor "
//				+ "WHERE FUNCTION('MONTH', p.dataPedido) = 9 "
//				+ "GROUP BY v.codVendedor, FUNCTION('YEAR', p.dataPedido) "
//				+ "ORDER BY COUNT(p.codPedido) desc");
//		List<Object[]> res = q.getResultList();
//		for(Object[] ob : res){
//			System.out.println("Vendedor : " + ob[0] + ", Ano: " + ob[1] + ", Total pedidos: " + ob[2]);
//		}
<<<<<<< HEAD


//		Ex 17 - Liste o nome dos clientes e o total de pedidos de cada cliente, em ordem crescente
//		de pedidos. Os clientes sem pedidos também devem ser listados.
//		Query q = em.createQuery("SELECT c.nome, COUNT(p.codPedido) as Pedidos "
//				+ "FROM Cliente c "
//				+ "LEFT JOIN Pedido p on p.cliente = c.codCliente "
//				+ "GROUP BY c.codCliente "
//				+ "ORDER BY Pedidos asc");
//		List<Object[]> res = q.getResultList();
//		for(Object[] ob : res){
//			System.out.println("Nome: " + ob[0] + ", pedidos: " + ob[1]);
//		}
		
		
//		Ex 18 - Exiba uma relação em ordem alfabética do código do cliente e nome dos clientes
//		que nunca fizeram nenhum pedido
//		Query q = em.createQuery("SELECT c.codCliente, c.nome "
//				+ "FROM Cliente c "
//				+ "LEFT JOIN Pedido p on p.cliente = c.codCliente "
//				+ "WHERE p.cliente is null");
//		List<Object[]> res = q.getResultList();
//		for(Object[] ob : res){
//			System.out.println("Código: " + ob[0] + ", Nome: " + ob[1]);
//		}
		
		
//		Ex 19 - Mostre o código do produto, a descrição e o valor total obtido por cada produto ao
//		longo da história da loja. Ordene a lista pelo valor total dos produtos. Observe que
//		mesmo os produtos que nunca foram vendidos devem ser exibidos.
//		Query q = em.createQuery("SELECT pr.codProduto, pr.descricao, sum(i.quantidade * pr.valorUnitario) as ValorTotal "
//				+ "FROM Produto pr "
//				+ "LEFT JOIN Itempedido i on i.produto = pr.codProduto "
//				+ "GROUP BY pr.codProduto "
//				+ "ORDER BY ValorTotal asc ");
//		List<Object[]> res = q.getResultList();
//		for(Object[] ob : res){
//			System.out.println("Código: " + ob[0] + ", Descrição: " + ob[1] + ", Valor Total: " + ob[2]);
//		}
		
		
//		Ex 20 -  Mostre todos os dados dos vendedores e a quantidade total de pedidos efetuados
//		por cada vendedor. A relação deve contar apenas os vendedores de faixa de
//		comissão “A” e ordenados pela quantidade total de pedidos. Mesmo os vendedores
//		sem pedidos devem ser listados.
//		Query q = em.createQuery("SELECT v, COUNT(p.codPedido) as Pedidos "
//				+ "FROM Vendedor v "
//				+ "LEFT JOIN Pedido p on p.vendedor = v.codVendedor "
//				+ "WHERE v.faixaComissao = 'A' "
//				+ "GROUP BY v.codVendedor "
//				+ "ORDER BY Pedidos desc");
//		List<Object[]> res = q.getResultList();
//		for(Object[] ob : res){//
//			System.out.println(ob[0] + ", Pedidos: " + ob[1]);
//			// ob[0] retorna o objeto Vendedor inteiro, porém sobrescrevi o método toString da classe Vendedor para retonar
//			// todos os dados, conforme pede o exercício
//		}
		
=======
	
>>>>>>> 5a02f57df2cec7f53679f0aa577d48cbdf2a34f9
		
		em.getTransaction().commit();

		em.close();
		entityManagerFactory.close();

	}
}

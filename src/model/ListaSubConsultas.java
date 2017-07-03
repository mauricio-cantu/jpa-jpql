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
//		Query q = em.createQuery("SELECT c "
//				+ "FROM Cliente c "
//				+ "WHERE c.codCliente in "
//					+ "(SELECT c.codCliente "
//					+ "FROM Cliente c "
//					+ "JOIN Pedido p on p.cliente = c.codCliente "
//					+ "JOIN Itempedido i on i.pedido = p.codPedido "
//					+ "GROUP BY i.pedido "
//					+ "HAVING sum(i.quantidade) > 60)");
//		List<Cliente> res = q.getResultList();
//		for(Cliente c : res){
//			System.out.println("Código: " + c.getCodCliente() + ", Nome: " + c.getNome() + ", Cidade: " + c.getCidade());
//		}
		
		
//		6) Crie uma consulta que exiba o código do cliente, o nome do cliente e o número dos seus
//		pedidos ordenados pelo nome e posteriormente pelo código do pedido. Somente devem ser
//		exibidos os pedidos dos vendedores que possuem a faixa de comissão “A”.
//		Query q = em.createQuery("SELECT c.codCliente, c.nome, count(p.codPedido) as Pedidos "
//				+ "FROM Cliente c "
//				+ "JOIN Pedido p on p.cliente = c.codCliente "
//				+ "WHERE c.codCliente in "
//					+ "(SELECT p.cliente "
//					+ "FROM Pedido p "
//					+ "JOIN Vendedor v on v.codVendedor = p.vendedor "
//					+ "WHERE v.faixaComissao='A') "
//					+ "GROUP BY c.codCliente "
//					+ "ORDER BY c.nome, Pedidos asc");
//		List<Object[]> res = q.getResultList();
//		for(Object[] o : res){
//			System.out.println("Cod cliente: " + o[0] + ", Nome: " + o[1] + ", Total pedidos: " + o[2]);
//		}
		
		
//		7) Crie uma consulta que exiba o nome do cliente, endereço, cidade, UF, CEP, código do pedido
//		e prazo de entrega dos pedidos que NÃO sejam de vendedores que ganham menos de R$
//		1500,00.
//		Query q = em.createQuery("SELECT c.nome, c.endereco, c.cidade, c.uf, c.cep, p.codPedido, p.prazoEntrega "
//				+ "FROM Cliente c "
//				+ "JOIN Pedido p on p.cliente = c.codCliente "
//				+ "WHERE p.codPedido NOT IN "
//					+ "(SELECT p.codPedido "
//					+ "FROM Pedido p "
//					+ "JOIN Vendedor v on v.codVendedor = p.vendedor "
//					+ "WHERE v.salarioFixo < 1500)");
//		List<Object[]> res = q.getResultList();
//		for(Object[] o : res){
//			System.out.println("Nome: " + o[0] + ", Endereço: " + o[1] + ", Cidade: " + o[2] + ", UF: " + o[3] + ", CEP: " + o[4]
//					+ ", Cod Pedido: " + o[5] + ", Entrega: " + o[6]);
//		}
		
		
//		8) Crie uma consulta que exiba o nome do cliente, cidade e estado, dos clientes que fizeram
//		algum pedido no ano de 2015. Ordene os resultados pelos nomes dos clientes em ordem
//		alfabética.
//		Query q = em.createQuery("SELECT c "
//				+ "FROM Cliente c "
//				+ "WHERE c.codCliente in "
//					+ "(SELECT p.cliente "
//					+ "FROM Pedido p "
//					+ "WHERE FUNCTION('YEAR', p.dataPedido)=2015) "
//				+ "ORDER BY c.nome asc");
//		List<Cliente> res = q.getResultList();
//		for(Cliente c : res){
//			System.out.println("Nome: " + c.getNome() + ", Cidade: " + c.getCidade() + ", Estado: " + c.getUf());
//		}
		
		
//		9) Crie uma consulta que exiba o código do pedido e o somatório da quantidade de itens desse
//		pedido. Devem ser exibidos somente os pedidos em que o somatório das quantidades de itens
//		de um pedido seja maior que a média da quantidade de itens de todos os pedidos.
//		Query q = em.createQuery("SELECT p.codPedido, sum(i.quantidade) "
//				+ "FROM Pedido p "
//				+ "JOIN Itempedido i on i.pedido = p.codPedido "
//				+ "GROUP BY p.codPedido "
//				+ "HAVING SUM(i.quantidade) > (SELECT AVG(quantidade) FROM Itempedido)");
//		List<Object[]> res = q.getResultList();
//		for(Object[] o : res){
//			System.out.println("Cod pedido: " + o[0] + ", Quant: " + o[1]);
//		}
		
		
//		10) Crie uma consulta que exiba o nome do cliente, o nome do vendedor de seu último pedido e o
//		estado do cliente. Devem ser exibidos apenas os clientes do Rio Grande do Sul e apenas o
//		último vendedor. 
//		Query q = em.createQuery("SELECT c.nome, (SELECT ), c.uf "
//				+ "FROM Cliente c ");
//		CONTINUAR
		
		
//		11) Selecione o nome do produto e o valor unitário dos produtos que possuem o valor unitário
//		maior que todos os produtos que comecem com a letra L. A lista deve ser ordenada em ordem
//		alfabética. 
//		Query q = em.createQuery("SELECT pr.descricao, pr.valorUnitario "
//				+ "FROM Produto pr "
//				+ "WHERE pr.valorUnitario > "
//					+ "(SELECT sum(valorUnitario) FROM Produto WHERE descricao like '%L') "
//				+ "ORDER BY pr.codProduto");
//		List<Object[]> res = q.getResultList();
//		for(Object[] o : res){
//			System.out.println("Descrição: " + o[0] + ", Valor unit: " + o[1]);
//		}
//		System.out.println(q.getResultList().size());
		
		
//		12) Selecione o código do produto, o nome do produto e o valor unitário dos produtos que
//			possuam pelo menos um pedido com mais de 9 itens em sua quantidade. A lista deve ser
//			ordenada pelo valor unitário em ordem decrescente.
//		Query q = em.createQuery("SELECT pr.codProduto, pr.descricao, pr.valorUnitario "
//				+ "FROM Produto pr "
//				+ "WHERE pr.codProduto in "
//					+ "(SELECT produto "
//					+ "FROM Itempedido "
//					+ "WHERE quantidade > 9) "
//				+ "ORDER BY pr.valorUnitario desc");
//		List<Object[]> res = q.getResultList();
//		for(Object[] o : res){
//			System.out.println("Produto: " + o[0] + ", Descrição: " + o[1] + ", Valor Unit: " + o[2]);
//		}
		
		
//		13) Selecione o código do vendedor e o nome dos vendedores que não tenham vendido nenhum
//			pedido com prazo de entrega em Agosto de 2015. A lista deve ser ordenada pelo nome dos
//			vendedores em ordem alfabética. 
//		Query q = em.createQuery("SELECT v.codVendedor, v.nome "
//				+ "FROM Vendedor v "
//				+ "WHERE v.codVendedor not in "
//					+ "(SELECT p.vendedor "
//					+ "FROM Pedido p "
//					+ "WHERE FUNCTION('MONTH', p.prazoEntrega) = 8 AND FUNCTION('YEAR', p.prazoEntrega) = 2015) "
//				+ "ORDER BY v.nome asc");
//		List<Object[]> res = q.getResultList();
//		for(Object[] o : res){
//			System.out.println("Cod: " + o[0] + ", Nome: " + o[1]);
//		}
		
		
//		14) Selecione o código do cliente e o nome dos clientes que tenham feitos pedidos em Abril de
//			2014. A lista deve ser ordenada pelo nome dos clientes em ordem alfabética
//		Query q = em.createQuery("SELECT c.codCliente, c.nome "
//				+ "FROM Cliente c "
//				+ "WHERE c.codCliente in "
//					+ "(SELECT p.cliente "
//					+ "FROM Pedido p "
//					+ "WHERE FUNCTION('MONTH', p.dataPedido) = 4 AND FUNCTION('YEAR', p.prazoEntrega) = 2014 )"
//				+ "ORDER BY c.nome asc");
//		List<Object[]> res = q.getResultList();
//		for(Object[] o : res){
//			System.out.println("Cod: " + o[0] + ", Nome: " + o[1]);
//		}
		
		
		
		em.getTransaction().commit();

		em.close();
		entityManagerFactory.close();

	}

}

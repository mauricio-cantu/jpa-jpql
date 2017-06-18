package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itempedido database table.
 * 
 */
@Entity
@Table(name="itempedido")
@NamedQuery(name="Itempedido.findAll", query="SELECT i FROM Itempedido i")
public class Itempedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CodItemPedido")
	private int codItemPedido;

	@Column(name="Quantidade")
	private int quantidade;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="CodPedido")
	private Pedido pedido;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="CodProduto")
	private Produto produto;

	public Itempedido() {
	}

	public int getCodItemPedido() {
		return this.codItemPedido;
	}

	public void setCodItemPedido(int codItemPedido) {
		this.codItemPedido = codItemPedido;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
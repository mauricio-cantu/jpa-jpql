package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the vendedor database table.
 * 
 */
@Entity
@Table(name="vendedor")
@NamedQuery(name="Vendedor.findAll", query="SELECT v FROM Vendedor v")
public class Vendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CodVendedor")
	private int codVendedor;

	@Column(name="FaixaComissao")
	private String faixaComissao;

	@Column(name="Nome")
	private String nome;

	@Column(name="SalarioFixo")
	private BigDecimal salarioFixo;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="vendedor")
	private List<Pedido> pedidos;

	public Vendedor() {
	}

	public int getCodVendedor() {
		return this.codVendedor;
	}

	public void setCodVendedor(int codVendedor) {
		this.codVendedor = codVendedor;
	}

	public String getFaixaComissao() {
		return this.faixaComissao;
	}

	public void setFaixaComissao(String faixaComissao) {
		this.faixaComissao = faixaComissao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalarioFixo() {
		return this.salarioFixo;
	}

	public void setSalarioFixo(BigDecimal salarioFixo) {
		this.salarioFixo = salarioFixo;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setVendedor(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setVendedor(null);

		return pedido;
	}

}
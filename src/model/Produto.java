package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@Table(name="produto")
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CodProduto")
	private int codProduto;

	@Column(name="Descricao")
	private String descricao;

	@Column(name="ValorUnitario")
	private BigDecimal valorUnitario;

	//bi-directional many-to-one association to Itempedido
	@OneToMany(mappedBy="produto")
	private List<Itempedido> itempedidos;

	public Produto() {
	}

	public int getCodProduto() {
		return this.codProduto;
	}

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public List<Itempedido> getItempedidos() {
		return this.itempedidos;
	}

	public void setItempedidos(List<Itempedido> itempedidos) {
		this.itempedidos = itempedidos;
	}

	public Itempedido addItempedido(Itempedido itempedido) {
		getItempedidos().add(itempedido);
		itempedido.setProduto(this);

		return itempedido;
	}

	public Itempedido removeItempedido(Itempedido itempedido) {
		getItempedidos().remove(itempedido);
		itempedido.setProduto(null);

		return itempedido;
	}

}
package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name="pedido")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CodPedido")
	private int codPedido;

	@Temporal(TemporalType.DATE)
	@Column(name="DataPedido")
	private Date dataPedido;

	@Temporal(TemporalType.DATE)
	@Column(name="PrazoEntrega")
	private Date prazoEntrega;

	//bi-directional many-to-one association to Itempedido
	@OneToMany(mappedBy="pedido")
	private List<Itempedido> itempedidos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="CodCliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Vendedor
	@ManyToOne
	@JoinColumn(name="CodVendedor")
	private Vendedor vendedor;

	public Pedido() {
	}

	public int getCodPedido() {
		return this.codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public Date getDataPedido() {
		return this.dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getPrazoEntrega() {
		return this.prazoEntrega;
	}

	public void setPrazoEntrega(Date prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public List<Itempedido> getItempedidos() {
		return this.itempedidos;
	}

	public void setItempedidos(List<Itempedido> itempedidos) {
		this.itempedidos = itempedidos;
	}

	public Itempedido addItempedido(Itempedido itempedido) {
		getItempedidos().add(itempedido);
		itempedido.setPedido(this);

		return itempedido;
	}

	public Itempedido removeItempedido(Itempedido itempedido) {
		getItempedidos().remove(itempedido);
		itempedido.setPedido(null);

		return itempedido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
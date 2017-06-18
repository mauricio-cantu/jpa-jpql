package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CodCliente")
	private int codCliente;

	@Column(name="Cep")
	private String cep;

	@Column(name="Cidade")
	private String cidade;

	@Column(name="Endereco")
	private String endereco;

	@Column(name="Ie")
	private String ie;

	@Column(name="Nome")
	private String nome;

	@Column(name="Uf")
	private String uf;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;

	public Cliente() {
	}

	public int getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getIe() {
		return this.ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setCliente(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setCliente(null);

		return pedido;
	}

}
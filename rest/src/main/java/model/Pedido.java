package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Pedido implements Model{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private BigDecimal valortotal = new BigDecimal(0);
	
	@Column
	private Date data;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany (cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "venda_id")
	private Set<ItemPedido> itemVendas;
	
	public Pedido(){
		itemVendas = new HashSet<ItemPedido>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ItemPedido> getItemVendas() {
		return itemVendas;
	}

	public void addItemVendas(ItemPedido itens) {
		itemVendas.add(itens);
		for (ItemPedido itemVenda : itemVendas) {
			setValortotal(getValortotal().add(itemVenda.getProduto().getValor().multiply(itemVenda.getQuantidade())));
		}
	}
	
	public void removeItemVendas(ItemPedido itens) {
		itemVendas.remove(itens);
		for (ItemPedido itemVenda : itemVendas) {
			setValortotal(getValortotal().add(itemVenda.getProduto().getValor().multiply(itemVenda.getQuantidade())));
		}
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", valortotal=" + valortotal + ", data=" + data + ", cliente=" + cliente
				+ ", itemVendas=" + itemVendas + ", getCliente()=" + getCliente() + ", getItemVendas()="
				+ getItemVendas() + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

package model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Produto implements Model{
	@Id
	private Integer id;
	private String nome;
	private BigDecimal valor;

	public Produto() {

	}

	public Integer getId() {
		return this.id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public static Builder builder() {
		return new Builder();
	}

	private Produto(Builder b) {
		this.id = b.id;
		this.nome = b.nome;
		this.valor = b.valor;
	}

	public static class Builder {

		private Integer id;
		private String nome;
		private BigDecimal valor;

		private Builder() {
		}

		public Builder id(Integer id) {
			this.id = id;
			return this;
		}

		public Builder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public Builder valor(BigDecimal valor) {
			this.valor = valor;
			return this;
		}

		public Produto build() {
			return new Produto(this);
		}

	}

	

}

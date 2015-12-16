package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Permisao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private byte codigo;
	@Column
	private String descricao;
	
	public byte getCodigo() {
		return codigo;
	}
	public void setCodigo(byte codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

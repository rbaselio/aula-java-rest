package DAO;

import model.Produto;

public class ProdutoDAO extends BaseDAO<Produto> {
	
	public ProdutoDAO() {
		this.entityClass = Produto.class;
	}


}
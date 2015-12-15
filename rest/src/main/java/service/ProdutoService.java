package service;

import model.Produto;

public class ProdutoService extends BaseService<Long, Produto> {
	
	public ProdutoService() {
		this.entityClass = Produto.class;
	}


}
package DAO;

import model.Categoria;

public class CategoriaDAO extends BaseDAO<Categoria> {
	
	public CategoriaDAO() {
		this.entityClass = Categoria.class;
	}


}
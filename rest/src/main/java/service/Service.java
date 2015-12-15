package service;


import exception.InvalidModelException;
import model.Model;
import validator.Validator;

public class Service<D, T extends Model> {

	private Validator<T> validator;
	private D dao;
	
	public D getDao() {
		return dao;
	}
	
	public D getDao(T entity) throws InvalidModelException {
		if(validator.validate(entity)) {
			return dao;
		} else {
			throw new InvalidModelException();
		}
	}
	
}

package service;


import exception.InvalidModelException;
import model.Model;
import validator.Validator;

public class Service<D, T extends Model> {

	private Validator<T> validator;
	private D dao ;
	
	private final Class<D> type;
    public Service(Class<D> class1) {
    	this.type = (Class<D>) class1;
    }
	
		
	public D getDao() {		
		if (dao == null){	
			
			try {
				dao = type.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return dao;
	}
	

	public D getDao(T entity) throws InvalidModelException {
		return dao;
//		if(validator.validate(entity)) {
//			return dao;
//		} else {
//			throw new InvalidModelException();
//		}
	}
	
}

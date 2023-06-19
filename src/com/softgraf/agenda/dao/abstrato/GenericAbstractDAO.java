package com.softgraf.agenda.dao.abstrato;

import java.util.List;

/*
 * Design Pattern DAO = Data Access Object
 * DAO é genérico (interface ou classe abstrata)
 * DAO é um padrão de projeto, não uma tecnologia
 * DAO é uma interface de operação CRUD
 */

public interface GenericAbstractDAO<T, ID> {

	boolean save(T entity);
	
	T findById(ID primaryKey);
	
	Iterable<T> findAll();
	
	void delete(ID primaryKey);
	
	boolean existsById(ID primaryKey);
	
	void update(ID primaryKey, T entity);
	
	long count();
	
}

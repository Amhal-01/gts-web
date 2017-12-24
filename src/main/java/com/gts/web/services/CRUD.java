package com.gts.web.services;

import java.util.List;

public interface CRUD <T>{
	public void create(T o);
	public void update(T o);
	public void delete(T o);
	public T getById(int id);
	public List<T> getAll();
}

package com.mocito.examples;

public class MyService {
	
	private MyDao myDao;
	
	public MyService(MyDao myDao) {
		this.myDao = myDao;
	}
	
	public MyEntity findById(long id) {
		return myDao.findById(id);
	}

}

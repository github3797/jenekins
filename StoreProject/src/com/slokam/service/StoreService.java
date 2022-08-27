package com.slokam.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.slokam.dao.StoreDao;

import com.slokam.pojo.StorePojo;
import com.slokam.pojo.loginpojo;

@Service
public class StoreService 
{
	private StoreDao dao;

	public void setDao(StoreDao dao) {
		this.dao = dao;
	}
	public boolean loginservice(loginpojo login) 
	{
	boolean flag=	dao.logindao(login);
	return flag;
	}
 public void registerService(StorePojo p)
  {
		dao.registerdao(p);
}

public void updateService(StorePojo p)
{
	dao.updatedao(p);
}

public void deleteService(StorePojo p) {
	dao.deleteDao(p);
}
public List<StorePojo> getAllService()
{
	List<StorePojo> list=dao.getallDao();
	return list;
	
}



public StorePojo registerService1(Integer id) 
{
	StorePojo rpojo=dao.byid(id);
	return rpojo;
	
}


}

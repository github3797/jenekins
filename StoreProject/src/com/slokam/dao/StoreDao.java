package com.slokam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.slokam.pojo.StorePojo;
import com.slokam.pojo.loginpojo;


public class StoreDao 
{
private JdbcTemplate temp;
	public JdbcTemplate getTemp() {
	return temp;
}
public void setTemp(JdbcTemplate temp) {
	this.temp = temp;
}
	
	public boolean logindao(loginpojo login) 
	{
		String sql="select count(*) from login where username=? and password=?"; 
	int count=	temp.queryForInt(sql,login.getUsername(),login.getPassword());
	if(count>0)
	{
		return true;
	}
	else
	{
		return false;
	}
	}
	public void registerdao(StorePojo p) 
	{
		String sql="insert  into store values(?,?,?,?)";
		temp.update(sql, p.getStoreid(),p.getStorename(),p.getAddress(),p.getStoreowener());
		System.out.println("Data inserted");
		
	}
	public void updatedao(StorePojo p) 
	{
		

		String sql="update store set storename=?,address=?,storeowener=? where storeid=?";
		temp.update(sql,p.getStorename(),p.getAddress(),p.getStoreowener(),p.getStoreid());
		System.out.println("Data updated");
	}
	public void deleteDao(StorePojo p) 
	{
		
		String sql="delete from store where storeid=?";
		temp.update(sql, p.getStoreid());
		System.out.println("Data Deleted");
	}
	
	
	
	public List<StorePojo> getallDao() 
	{
		String sql="select * from store";
		@SuppressWarnings("unchecked")
		List<StorePojo> per=	temp.query(sql, new RowMapper() {

			public Object mapRow(ResultSet x, int arg1) throws SQLException 
			{
				StorePojo p=new StorePojo();
				
			int storeid=	x.getInt("storeid");
			String storename=x.getString("storename");
		      String storeaddress=	x.getString("address");
		       String storeowener=x.getString("storeowener");
		       p.setStoreid(storeid);
		       p.setStorename(storename);
		       p.setAddress(storeaddress);
		       p.setStoreowener(storeowener);
			   return p;
				
			}
		});
		return per;
	
		
	}
	public StorePojo byid(Integer id) 
	{
		String sql="select * from store where storeid=?";
		
		StorePojo rpojo=(StorePojo)temp.queryForObject(sql, new RowMapper(){

			public Object mapRow(ResultSet x, int arg1) throws SQLException 
			{
				StorePojo p=new StorePojo();
				
				int storeid=	x.getInt("storeid");
				String storename=x.getString("storename");
			      String storeaddress=	x.getString("address");
			       String storeowener=x.getString("storeowener");
			       p.setStoreid(storeid);
			       p.setStorename(storename);
			       p.setAddress(storeaddress);
			       p.setStoreowener(storeowener);
				   return p;
			}
		}
			,id);
		return rpojo;
		}
}


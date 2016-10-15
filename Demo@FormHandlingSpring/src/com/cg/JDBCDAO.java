package com.cg;

import java.sql.Connection;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class JDBCDAO implements ApplicationContextAware{

	@Autowired
	private  DataSource dataSource;
	private Connection con;
	private ApplicationContext appcontext;
/*public JDBCDAO() {
	// TODO Auto-generated constructor stub
}*/
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	void establish(){	
		try {
			con= this.dataSource.getConnection();
			System.out.println(con!=null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		appcontext= arg0;
		
	}
}
	
	
	
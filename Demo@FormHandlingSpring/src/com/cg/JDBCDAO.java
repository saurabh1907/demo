package com.cg;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class JDBCDAO implements ApplicationContextAware{

	
	private DataSource dataSource;
	private Connection con;
	private ApplicationContext appcontext;
	
	void establish(){	
		dataSource = (DataSource) appcontext.getBean("VIMDataSource");
		try {
			con= dataSource.getConnection();
			System.out.println(con!=null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		appcontext= arg0;
		
	}
}
	
	
	
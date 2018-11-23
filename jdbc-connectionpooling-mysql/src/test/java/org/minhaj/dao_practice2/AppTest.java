package org.minhaj.dao_practice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class AppTest {
 
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		//Default 20 connection object will be created
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/mytestdb");
		ds.setUsername("root");
		ds.setPassword("password");
		ds.setMaxIdle(5);
		
		Connection con = null;
		try {
			
			for(int i=0; i<20 ; i++){
				con = ds.getConnection(); // pooled connection object
				System.out.println(con + " - "+ i);
				con.close(); // if you do not close the connection then you wont see
				//20 con obj becuase java takes little time to create con object 
				//and you will see it stuck at 7 or 8th obj .
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

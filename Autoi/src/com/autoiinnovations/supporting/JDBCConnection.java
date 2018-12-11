package com.autoiinnovations.supporting;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.JSONException;
import org.json.JSONObject;







public class JDBCConnection {
	private static Connection connection = null;
	static String  url="jdbc:mysql://localhost:3306/autoiinno_autoi_db?noAccessToProcedureBodies=true";
	static String  userName="autoiinno_autoi1";
	static String  password="Autoi@12345";
	public static Connection getOracleConnection()
			throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");  
		  
		/*Connection con=DriverManager.getConnection(  
				url,userName,password);    */
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/autoiinno_autoi_db?noAccessToProcedureBodies=true","autoiinno_autoi1","Autoi@12345");    
   

		return con;

	}
	
	
	/*public static void main(String args[]) throws ClassNotFoundException, SQLException, NamingException
	{
		
		Connection con=getOracleConnection();
		System.out.println(con);
		
	}*/
	
	public static Connection getConnection() throws NamingException, SQLException{
		/*Context ctx = InitialContext();
		Object obj = ctx.lookup("skfalkjfds");
		Connection conn = (Connection)obj;*/
		Connection conn=null;
		try
		{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
		 conn= ds.getConnection();
		return conn;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	

	
}

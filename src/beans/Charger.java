package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Charger {
	public static final String path ="jdbc:mysql://127.0.0.1:3306/";
	public Connection con;
	
	public Charger(Connection con){
		this.con=con;
	}
	
	public static  void chargerDriver(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public static Charger getConnection(String baseName,String user,String motdepass){
		try {
		return new Charger( DriverManager.getConnection(path+baseName,user, motdepass));
		} catch (SQLException e) {
	   
		}
		return null;
	}
	
	public  PreparedStatement CreateStatement(String str){
		try {
			return con.prepareStatement(str);
		} catch (SQLException e) {
		e.printStackTrace();
		return null;
		}
	}
	
	public  Statement CreateStatement(){
		try {
			return con.createStatement();
		} catch (SQLException e) {
		e.printStackTrace();
		return null;
		}
	}
	
	public  ResultSet Requet(String str,Statement stat){
		try {
			return stat.executeQuery(str);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public  ResultSet Requet(PreparedStatement prep ){
        try {
			return prep.executeQuery();
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	public  void Requetup(PreparedStatement prep ) throws Exception{
        try {
			 prep.executeUpdate();
		} catch (SQLException e) {
        throw new Exception();
		}
		
	}
	public void fermeture(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

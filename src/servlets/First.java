package servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import form.form;
import beans.Charger;
import beans.auteur;

public class First extends HttpServlet{
	 
	    
		 public void init(){
		 }
		protected void doGet(HttpServletRequest req ,HttpServletResponse res) throws ServletException, IOException{
			this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(req, res);
		}
	    protected void doPost(HttpServletRequest req ,HttpServletResponse res) throws ServletException, IOException{
	    	Map<Integer,auteur> hs =form.DO(req);
	    	Map<String, String> err =form.getmap();
	    	if(err.size()>0)
	    	{
	        req.setAttribute("erreur",err);	
	    	}else
	        req.setAttribute("Selection",hs);
	  
			this.getServletContext().getRequestDispatcher("/WEB-INF/intercation.jsp").forward(req, res);
		}
}

package form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import servlets.First;
import beans.Charger;
import beans.Interaction;
import beans.auteur;

public class form {
	static Map<String,String> erreur= new HashMap<String, String>();
	public  static Map<String,String> getmap(){
		return erreur;
	}
	public static Map<Integer,auteur> DO(HttpServletRequest req){
		erreur = new HashMap<String, String>();
    	String str =(String) req.getParameter("nom");
    	String str1 =(String) req.getParameter("prenom");
    	String str2 =(String) req.getParameter("anneeNai");
    	String str3 =(String) req.getParameter("Nnom");
    	String str4 =(String) req.getParameter("Nprenom");
    	String show =(String) req.getParameter("SHOW");
    	String delete =(String) req.getParameter("Delete");
    	String modifie =(String) req.getParameter("MODIFIE");
		 Charger.chargerDriver();
        Interaction inter = new Interaction( Charger.getConnection("auteur", "ikbal", "ikol1945")
);
        Map<Integer,auteur> hs=null;
    	if(show!=null){
    		try {
			     hs = inter.Show_(str, str1);
			    erreur.put("showS","SUCCES");
			}  catch (Exception e) {
			   erreur.put("showF","ERREUR SIR U MUST VERIFIE YOUR arguments");
			}
    		
    	}else{
    		if(delete!=null){
    			try {
					inter.DELETE(Integer.valueOf(str2));
				    erreur.put("DeleteS","SUCCES");
				}  catch (Exception e) {
			   erreur.put("DeleteF","ERREUR SIR U MUST VERIFIE YOUR arguments");
				}
    		}else{
    			if(modifie!=null){
    				try {
						inter.remplacerPseado(str, str1, str3, str4);
					    erreur.put("modifieS","SUCCES");
					} catch (Exception e) {
			   erreur.put("modifieF","ERREUR SIR U MUST VERIFIE YOUR arguments");
					}
    			}
    		}
    	}
    	return hs;
	}
}

package beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Interaction {
	Charger charge;
	PreparedStatement prep;
	PreparedStatement prep1;
	PreparedStatement prep2;
	PreparedStatement prep3;
	PreparedStatement prep4;
	PreparedStatement prep5;
	PreparedStatement prep6;
	public Interaction(Charger charge){
    	 this.charge=charge;
    	 prep1 =charge.CreateStatement("select *from tabauteur");
    	 prep2 =charge.CreateStatement("select *from tabauteur where nomauteur =? ,prenomauteur =?  ");
         prep3 = charge.CreateStatement("select *from tabauteur where anneenaissance>? ");
         prep4 = charge.CreateStatement("update tabauteur set nomauteur =? ,prenomauteur =? where nomauteur=? and prenomauteur=? ");
         prep5 = charge.CreateStatement("delete from tabauteur where anneenaissance<?");
       /* 
        * prep6 = charge.CreateStatement("delete (count) *from tabauteur where anneenaissance>?");
        * ResultSet r = executeQuery();
        * int n =0;
        * while(r.next()){
        * n=r.getInt(1);
        *}
        * System.out.println(n);
         */
    }
    
	public void AjouterP(auteur aut) throws Exception{
		try {
			prep.setInt(1,aut.getId());
			prep.setString(2,aut.getSexe());
			prep.setString(3,aut.getNom());
			prep.setString(4,aut.getPrenom());
			prep.setString(5,String.valueOf(aut.getAnnéeNaissance()));
			prep.setString(6,String.valueOf(aut.getAnnéedécés()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  charge.Requetup(prep);
	}
	
	public ResultSet AjouterS(auteur aut){
		Statement stat =charge.CreateStatement();
		return charge.Requet("Insert into tabauteur values ("+aut.getId()+","+aut.getSexe()+","+aut.getPrenom()
				+","+aut.getAnnéeNaissance()+","+aut.getAnnéedécés(),stat);
	}
	
	public ResultSet SHOW_ALL(){
		return charge.Requet(prep1);
	}
	
    public Map<Integer,auteur> Show_(String name,String prenom) throws NumberFormatException, SQLException{
    	try {
			prep2.setString(1, name);
			prep2.setString(2, prenom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet r = charge.Requet(prep2);
		Map<Integer,auteur> hs = new HashMap<Integer, auteur>();
		while (r.next()) {
			auteur a = new auteur(r.getInt("id"), r.getString("sexe"), r.getString("nomauteur"), r.getString("prenomauteur"),
					Integer.valueOf(r.getString("anneenaissance")),Integer.valueOf(r.getString("anneedeces")) );
			hs.put(a.getId(), a);
		}
		 return hs;
    }
   
    
	public ResultSet who_born_after(int date){
		try {
			prep3.setInt(1, date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return charge.Requet(prep3);
	}
    
    public void remplacerPseado(String nnom,String nprenom,String onom,String oprenom) throws Exception{	
    	try {
    		prep4.setString(3, nnom);
			prep4.setString(4, nprenom);
			prep4.setString(1, onom);
	    	prep4.setString(2, oprenom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        charge.Requetup(prep4);
    }
    
    public void DELETE(int year) throws Exception{
    	try {
			prep5.setInt(1, year);
		} catch (SQLException e) {
         throw new Exception();
		}
    	charge.Requetup(prep5);
    }
    
    public void Afficher(ResultSet rest){
    	try {
			while(rest.next()){
				System.out.println(rest.getInt("n_auteur")+" * "+rest.getString("sexe")+" * "+rest.getString("nomauteur")
				+" * "+rest.getString("prenomauteur")+" * "+rest.getInt("anneenaissance")+" * "+rest.getInt("anneedeces"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public int numdeselement(){
    	ResultSet rest =charge.Requet(prep1);
    	int i =0;
    	try {
			while (rest.next()) {
				i++;
			}
		} catch (SQLException e) {
		   e.printStackTrace();
		}
    	return i;
    }
}

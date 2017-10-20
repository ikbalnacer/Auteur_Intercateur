<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/newnew/Connexion" method="Post">

<fieldset>
<p>NAME :<input  width="150" height="30" name="name" /> 
<p>PRENOM :<input  width="150" height="30" name="prenom" /> 
<p>annee naissance :<input  width="150" height="30"  name="anneeNai"/>
<p><input type="submit"  value="SHOW ALL" name="SHOW" /> 
<label>${err.showF}</label><label>${err.showS}</label>
 
</fieldset>
<fieldset>
<p>annee naissance :<input  width="150" height="30" name="anneeNai"/>
<p><input type="submit"  value="Delete" name="Delete"/>
<label>${err.DeleteF}</label><label>${err.DeleteS}</label>
</fieldset>

<fieldset>
<p>ONAME :<input  width="150" height="30" name="Nname"/> 
<p>OPRENOM :<input  width="150" height="30" name="Nprenom"/> 
<p>NNAME :<input  width="150" height="30" name="name"/> 
<p>NPRENOM :<input  width="150" height="30" name="prenom"/> 
<p><input type="submit"  value="MODIFIE"  name="MODIFIE"/>
<label>${err.modifieF}</label><label>${err.modifieS}</label>
</fieldset>
</form>
</body>
</html>
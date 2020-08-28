<%-- 
    Document   : index.jsp
    Created on : 27-ago-2020, 17:51:57
    Author     : Tito
--%>

<%@page import="modelo.Productor"%>
<%@page import="design.IProductorDAO"%>
<%@page import="Factory.IFactoryDAO"%>
<%@page import="design.IAccesoFactory"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
    <section id="examen">
        
    <%
        HttpSession sesion= request.getSession(false);
        
        IAccesoFactory accesoFactory = IFactoryDAO.getInstance().getAccesoFactory("MySQL");
        IProductorDAO productorDAO = accesoFactory.getProductorService();
        List<Productor> tabla = productorDAO.obtenerProductoresSinNombreSinProduccion();
  
        int num_filas = tabla.size();// conseguimos el numero de filas de la tablaReporteResumen para validar que exista
        if(num_filas>0){
        
    %>
	
            <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido</th>
                        </tr>	
                    </thead>
                    <tbody>
                        <%
                        for(int i=0 ; i < num_filas ; i++ ){
                        %>
                        <tr>
                            <th scope="row"><%=i+1%></th>
                            <td><%=tabla.get(i).getNombre()%></td>
                            <td><%=tabla.get(i).getApellido()%></td>
                        </tr>
                        <%
                        }
                        %>
                    </tbody>
                </table>
       <%           
    }else{
    %>
	
	<table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                </tr>	
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>---</td>
                    <td>---</td>
                </tr>
            </tbody>
        </table>

    <%
        }
%>
	</section>


	<footer>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
        
        </footer>
</body>
</html>
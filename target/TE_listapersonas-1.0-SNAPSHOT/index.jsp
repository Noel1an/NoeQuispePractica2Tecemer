<%@page import="com.emergentes.modelo.Tarea"%>
<%@page import="java.util.ArrayList"%>
<% 
  if(session.getAttribute("listatar")==null){
       ArrayList<Tarea> listaux = new ArrayList<Tarea>();
       session.setAttribute("listatar", listaux);
  }
  ArrayList<Tarea> lista = (ArrayList<Tarea>)session.getAttribute("listatar");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emergentes II</title>
    </head>
    <body>
        <h1>Gestor de Tareas</h1>
        <h3>Noe Elmer Quispe Lipa</h3>
        
        <a href="MainServlet?op=nuevo">Agregar una Nueva Tarea</a>
       <br>
        <table border="1" cellpadding="0">
                <tr>
                    <th>ID</th>
                    <th>TAREA</th>
                    <th>COMPLETADO</th>
                    <th></th>
                </tr><br>
                    <%
                        if(lista !=null){
                            for(Tarea item:lista){
                     %>
                     <td><%= item.getId() %></td>
                    <td><%=item.getTitulo() %></td>
                    <td>
                        <input type="checkbox" >
                    </td>
                    <td>
                        <a href="MainServlet?op=editar&id=<%= item.getId() %>
                           ">Editar</a>
                        <a href="MainServlet?op=eliminar&id=<%= item.getId() %>"
                           onclick="return(confirm('esta seguro de eliminar??..')
                                       )">Eliminar</a>
                    </td>  
                    <tr>
                    <% 
                            }
                        }
                     %>
                  </tr>     
        </table>    
    </body>
</html>

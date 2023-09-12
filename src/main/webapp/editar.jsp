<%@page import="com.emergentes.modelo.Tarea"%>
<% 
    Tarea tar=(Tarea)request.getAttribute("miobjtar");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Añade una Nueva Tarea</h1>
         <h3>Noe Elmer Quispe Lipa</h3>
         <form action="MainServlet" method="post">
             <table border="0">
                 <thead>
                     <tr>
                         <th>ID</th>
                         <th><input type="text" name="id" 
                          value="<%= tar.getId() %>" size="2" readonly=""></th>
                     </tr>
                 </thead>
                 <tbody>
                     <tr>
                         <td>Tarea</td>
                         <td><input type="text" name="titulo" 
                                    value="<%= tar.getTitulo() %>"></td>
                     </tr>
                     <tr>
                         <td></td>
                         <td><input type="submit" value="Actualizar"></td>
                     </tr>
                 </tbody>
             </table>
         </form>
    </body>
</html>

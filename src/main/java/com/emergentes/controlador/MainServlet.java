
package com.emergentes.controlador;

import com.emergentes.modelo.Tarea;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String op=request.getParameter("op");
        Tarea objtar =new Tarea();
        int id,pos;
        
        HttpSession ses=request.getSession();
        ArrayList<Tarea> lista =(ArrayList<Tarea>)ses.getAttribute("listatar");
        switch (op) {
            case "nuevo":
                //enviar un objeto vacio a editar dato
                request.setAttribute("miobjtar", objtar);
                request.getRequestDispatcher("editar.jsp").
                        forward(request,response);
                break;
            case "editar":
                //envia un objeto a editar pero con contenido
                id=Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request,id);
                //obtener el objeto
                objtar = lista.get(pos);
                request.setAttribute("miobjtar", objtar);
                request.getRequestDispatcher("editar.jsp").forward(request,
                        response);
                break;
            case "eliminar":
                //enviar el registro de laa eliminar
                id=Integer.parseInt(request.getParameter("id"));
                //averiguar el objeto
                
                pos = buscarIndice(request,id);
                if(pos  >=0){
                    lista.remove(pos);
                }
                //actualizar la lista
                request.setAttribute("listatar", lista);
                //enviamos al index
                response.sendRedirect("index.jsp");
                break;
            default:
       
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses=request.getSession();
        ArrayList<Tarea> lista =(ArrayList<Tarea>)ses.getAttribute("listatar");
        Tarea objtar = new Tarea();
        objtar.setId(id);
        objtar.setTitulo(request.getParameter("titulo"));
        if(id==0){
            //nuevo
            int idNuevo = obtenerId(request);
            objtar.setId(idNuevo);
            lista.add(objtar);
        }else{
            //edicion
            int pos = buscarIndice(request,id);
            lista.set(pos, objtar);
        }
        request.setAttribute("listatar", lista);//actualisa la lista
        response.sendRedirect("index.jsp");//redireccion el control aindex
    }

   public int buscarIndice(HttpServletRequest request,int id){
       HttpSession ses=request.getSession();
       ArrayList<Tarea> lista=(ArrayList<Tarea>)ses.getAttribute("listatar");
       
       int pos =-1;
       if(lista != null){
           for(Tarea ele : lista){
               ++pos;
               if(ele.getId()==id){
                   break;
               }
           }
       }
       return pos;
   }
   
   public int obtenerId(HttpServletRequest request){
       HttpSession ses = request.getSession();
       ArrayList<Tarea> lista=(ArrayList<Tarea>)ses.getAttribute("listatar");
       //busca el ultimo id
       int idn=0;
       for(Tarea ele : lista){
           idn = ele.getId();
       }
       return idn + 1;
   }
}
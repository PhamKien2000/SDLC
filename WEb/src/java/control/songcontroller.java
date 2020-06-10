/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Song;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dataprosess;

/**
 *
 * @author kienv
 */
@WebServlet(name = "songcontroller", urlPatterns = {"/songcontroller"})
public class songcontroller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          String action=request.getParameter("ac");
        if("add".equals(action))
        {
            String id=request.getParameter("txtID");
            String name=request.getParameter("txtName");
            String temp=request.getParameter("txtPrice");
            float price=Float.parseFloat(temp);
            String sampleURL=request.getParameter("txtSample");
            String fulURL=request.getParameter("txtFull");
            String idC=request.getParameter("txtC");
            String idSinger=request.getParameter("txtSg");
            Dataprosess dt=new Dataprosess();
            if(dt.addSong(id, name, price, sampleURL, fulURL, idC, idSinger))
            {
                ArrayList<Song> list=dt.getSong();
                request.setAttribute("list", list);
                RequestDispatcher rd=request.getRequestDispatcher("ViewSong1.jsp");
                rd.forward(request, response);
                
            }
            else
            {
                response.sendRedirect("Erorr.jsp?code=1");
            }
        }
        if("view".equals(action))
        {
            Dataprosess dt=new Dataprosess();
            ArrayList<Song> list=dt.getSong();
            request.setAttribute("list", list);
            RequestDispatcher rd=request.getRequestDispatcher("ViewSong1.jsp");
            rd.forward(request, response);
        }
         if("del".equals(action)){
            String id=request.getParameter("id");
            
            Dataprosess dt=new Dataprosess();
            if(dt.delSong(id)){ 
                ArrayList<Song> list=dt.getSong();
                request.setAttribute("list", list);
                RequestDispatcher rd=request.getRequestDispatcher("ViewSong1.jsp");
                rd.forward(request, response);
            }
            else{
                response.sendRedirect("Error.jsp?code=1");
            }
        }
         if("edit".equals(action)){
            String id=request.getParameter("id");
            Dataprosess dt = new Dataprosess();
            Song s=dt.getSongID(id);
            request.setAttribute("sDetail", s);
            RequestDispatcher rd=request.getRequestDispatcher("EditSong.jsp");
            rd.forward(request, response);
        }
        if("update".equals(action))
        {
            String id=request.getParameter("txtID");
            String name=request.getParameter("txtName");
            String temp=request.getParameter("txtPrice");
            float price=Float.parseFloat(temp);
            String sampleURL=request.getParameter("txtSample");
            String fulURL=request.getParameter("txtFull");
            String idC=request.getParameter("txtC");
            String idSinger=request.getParameter("txtSg");
            Dataprosess dt=new Dataprosess();
            if(dt.updateSong(id, name, price, sampleURL, fulURL, idC, idSinger))
            {
                ArrayList<Song> list=dt.getSong();
                request.setAttribute("list", list);
                RequestDispatcher rd=request.getRequestDispatcher("ViewSong1.jsp");
                rd.forward(request, response);
                
            }
            else
            {
                response.sendRedirect("Erorr.jsp?code=1");
            }
        }
        if("detail".equals(action))
        {
            Dataprosess dt=new Dataprosess();
            ArrayList<Song> list=dt.getSong();
            request.setAttribute("list", list);
            RequestDispatcher rd=request.getRequestDispatcher("Cart.jsp");
            rd.forward(request, response);
        }
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

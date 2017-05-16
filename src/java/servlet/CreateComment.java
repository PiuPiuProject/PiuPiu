/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.SesBean;
import entities.Comment;
import entities.Piu;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateComment extends HttpServlet {

    @EJB
    SesBean miEjb;
    public static final String STATUS_OK = "teamOk";
    public static final String STATUS_ERROR = "teamError";

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

        int id = Integer.parseInt((String) request.getParameter("idpiu"));
        String user = (String) request.getParameter("user");
        String text = request.getParameter("text");
        Piu p = miEjb.existPiu(id);
        System.out.println(user);
        if (p != null) {
        User u = miEjb.existName(user);
        if (user != null) {
            System.out.println(u);
            Comment c = new Comment(0, text, new Date(), p, u);
            System.out.println(c);

            if (miEjb.insertComment(c)) {
                request.setAttribute("status", STATUS_OK);
            } else {
                request.setAttribute("status", STATUS_ERROR);
            }
            request.getRequestDispatcher("/CreateCommentFinal.jsp").forward(request, response);
        } else {
            System.out.println("NOOOO");
        }
        } else {
            System.out.println("AAAAaAaaaaaaaaa");
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

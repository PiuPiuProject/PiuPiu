/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.SesBean;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CreateAccount extends HttpServlet {

    @EJB
    SesBean miEjb;

    public static final String STATUS_OK = "userOK";
    public static final String STATUS_ERROR = "userERROR";
    
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
            if("Create".equals(request.getParameter("usuario"))){
                String username = request.getParameter("username");
                String surname = request.getParameter("surname");
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                System.out.println("tumejor");
                
                if(miEjb.existUser(username) == false){
                    User u = new User(username, surname, name, email, password);
                    if (miEjb.insertUser(u)) {
                        request.setAttribute("status", STATUS_OK);
                    }
                }else if(miEjb.existUser(username) == true){
                    request.setAttribute("status", STATUS_ERROR);
                }
                request.getRequestDispatcher("/CreateAccountFinal.jsp").forward(request, response);
            }else{
                System.out.println("no entro. tu mejor");
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
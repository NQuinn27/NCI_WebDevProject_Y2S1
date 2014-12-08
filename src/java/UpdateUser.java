/*
 * Copyright 2014 niallquinn
 * UpdateUser.java created Dec 8, 2014
 * WebDevProject
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import webApp.ApplicationController;
import webApp.Sex;
import webApp.Style;
import webApp.User;

/**
 *
 * @author niallquinn
 */
@WebServlet(urlPatterns =
{
    "/UpdateUser"
})
public class UpdateUser extends HttpServlet
{

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
            throws ServletException, IOException
    {
        
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        int id = -1;
        id = Integer.parseInt(request.getParameter("id"));
        if (id == -1) {
            return;
        }
        ApplicationController controller;
        try
        {
            controller = ApplicationController.getShared();
        } catch (JAXBException ex)
        {
            Logger.getLogger(UsersServlet.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        User u = controller.getUserById(id);
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        int sex = Integer.parseInt(request.getParameter("sexRadio"));
        int style = Integer.parseInt(request.getParameter("styleRadio"));
        
        Sex _sex = sex == 0 ? Sex.MALE : Sex.FEMALE;
        Style _style = style == 0 ? Style.FORMAL : Style.TEEN;
        
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setSex(_sex);
        u.setDob(dob);
        u.setStyle(_style);
        
        request.setAttribute("user", u);
        request.getRequestDispatcher("/user.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}

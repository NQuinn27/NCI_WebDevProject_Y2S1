/*
 * Copyright 2014 niallquinn
 * APIGetUser.java created Dec 4, 2014
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
import webApp.User;

/**
 *
 * @author niallquinn
 */
@WebServlet(urlPatterns =
{
    "/API/User"
})
public class APIGetUser extends HttpServlet
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
        int userId = -1;
        userId = Integer.parseInt(request.getParameter("id"));
        
        if (userId == -1) {
            //404
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
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Ahem, API, user ID = " + request.getParameter("id"));
        int userId=-1;
        if (request.getParameter("id") != null){
            userId = Integer.parseInt(request.getParameter("id"));
        }
        if (userId == -1) {
            request.setAttribute("error","500");
            return;
        }
        ApplicationController controller = null;
        try
        {
            controller = ApplicationController.getShared();
        } catch (JAXBException ex)
        {
            Logger.getLogger(APIGetUser.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        User u = controller.getUserList().get(userId);
        
        PrintWriter out = response.getWriter();
        out.println(u.JSONRepresentation());
        //We can make a JSON object here
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
        processRequest(request, response);
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

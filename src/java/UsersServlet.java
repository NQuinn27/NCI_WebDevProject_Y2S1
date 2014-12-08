/*
 * Copyright 2014 niallquinn
 * UsersServlet.java created Nov 29, 2014
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
    "/Users"
})
public class UsersServlet extends HttpServlet
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
        response.setContentType("text/html;charset=UTF-8");
        
        int userId=-1;
        if (request.getParameter("id") != null){
            userId = Integer.parseInt(request.getParameter("id"));
        }
        String name = request.getParameter("name");
        
        System.out.println("Id = " + userId);
        
        ApplicationController controller;
        try {
            controller = ApplicationController.getShared();
        } catch (Exception e) {
            return;
        }
        
        
        User u = null;
        if (userId < controller.getUserList().size()) {
            u = controller.getUserList().get(userId);
        }
        
                
        System.out.println("User Id = " + u.getIdentifier());
        if (userId == -1 || u == null) {
            //404
        } else {
            request.setAttribute("user", u);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        }
    }
      
    private String nice404(int userId) {
        String output = "<!DOCTYPE html>\n";
        output += "<html>\n";
        output += "<head>\n";
        output += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n";
        output += "<title>Clothes Club!</title>";
        output += "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">";
        output += "</head>\n";
        output += "<body>";
        output += "<h2>404</h2>";
        output += "<h3>We are sorry, there is no user with id " + userId + "</h3>";
        output += "</body>";
        output += "</html>\n";
        return output;
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

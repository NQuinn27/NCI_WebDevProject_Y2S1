/*
 * Copyright 2014 niallquinn
 * AllUsers.java created Dec 4, 2014
 * WebDevProject
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author niallquinn
 */
@WebServlet(urlPatterns =
{
    "/AllUsers"
})
public class AllUsers extends HttpServlet
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        System.out.print("======1=========");
        try (PrintWriter out = response.getWriter())
        {
            
            //!!!!! NOT IDEAL !!!!!!
            String XMLFilename = "/Users/niallquinn/Developer/Java/clothesclub/clothesclub/Assets/Users.xml";
          
            System.out.print("======1=========");
            
            StreamSource streamSource = new StreamSource(XMLFilename);
            System.out.print("======2=========");
            
            StringWriter writer = new StringWriter();
            
            System.out.print("======3=========");
            //Creating the result
            StreamResult result = new StreamResult(writer);
            
            System.out.print("======4=========");
            //Create transform factory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
        
            //Taking the stylesheet from inside the xml document
            Source stylesheet = transformerFactory.getAssociatedStylesheet(streamSource, null, null, null);
        
            //Get the new transformer
            Transformer transformer = transformerFactory.newTransformer(stylesheet);
        
            //Create the result
            transformer.transform(streamSource, result);
            System.out.print(result);
            
            out.print(writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
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

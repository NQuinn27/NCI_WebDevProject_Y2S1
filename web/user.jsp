<%-- 
    Document   : index
    Created on : Nov 22, 2014, 2:16:35 PM
    Author     : niallquinn
--%>

<%@page import="webApp.Style"%>
<%@page import="webApp.Sex"%>
<%@ page import="webApp.User" %>

<%
    /*Adding Dummy Data
        Here we will either do the XML transformation to populate arrays
        or delegate to a java class. (Probably the latter to keep this page
        clean).
    */
    User u = (User)request.getAttribute("user");
    if (u == null) {
        //Deal with it!
        System.out.println("No user");
    }
    
    System.out.println(u.getFirstName());
//    int id = u.getIdentifier();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clothes Club!</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles.css">
        <style type="text/css">
            .red{
                background-color: red;
            }
        </style>
    </head>
    <body>
        
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Clothing Club</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                    <li><a href="http://localhost:8080/clothesclub">Home <span class="sr-only">(current)</span></a></li>
                    <li><a href="http://localhost:8080/clothesclub/usersList.jsp">Users</a></li>
                    <li><a href="http://localhost:8080/clothesclub/packagesList.jsp">Packages</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div>
        </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1>Welcome to the Clothing Club!</h1>
            <p>Are you a lover of fashion? Sign up now to avail of a new bespoke package each month. <a href="#">Signup is easy</a></p>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
        </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
        <div class="row">
            <div class="centerBox">
                <h5><b>First Name:</b> <%out.print(u.getFirstName());%></h5>
                <h5><b>Last Name:</b> <%out.print(u.getLastName());%></h5>
                <h5><b>Date of Birth: </b> <%out.print(u.getDob());%></h5>
                <h5><b>Sex: </b>
                <%if (u.getSex() == Sex.MALE) {
                    out.print("Male");
                } else {
                    out.print("Female");
                }%></h5>
                <h5><b>Prefferred Style </b>
                <%if (u.getStyle() == Style.FORMAL) {
                    out.print("Formal");
                } else {
                    out.print("Teen");
                }%></h5>
            </div>
            
        </div>
        <hr>
        <footer>
            <p>&copy; Company 2014</p>
        </footer>
    </div> <!-- /container -->

        
        
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </body>
</html>


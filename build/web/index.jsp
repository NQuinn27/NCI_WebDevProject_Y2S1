<%-- 
    Document   : index
    Created on : Nov 22, 2014, 2:16:35 PM
    Author     : niallquinn
--%>

<%@page import="webApp.ApplicationController"%>
<%@page import="webApp.Sex"%>
<%@ page import="webApp.User" %>

<%
    //Get app controller singleton
    ApplicationController controller = ApplicationController.getShared();
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
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script>
        </script>
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
                    <li class="active"><a href="http://localhost:8080/clothesclub">Home <span class="sr-only">(current)</span></a></li>
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
            <p><a class="btn btn-primary btn-lg" href="http://localhost:8080/clothesclub/NewUser" role="button">Sign Up Now &raquo;</a></p>
        </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-6">
                <p><a class="btn btn-primary btn-lg" href="http://localhost:8080/clothesclub/usersList.jsp" role="button">View All Users &raquo;</a></p>
            </div>
            <div class="col-md-6">
                <p><a class="btn btn-primary btn-lg" href="http://localhost:8080/clothesclub/packagesList.jsp" role="button">View All Packages &raquo;</a></p>
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

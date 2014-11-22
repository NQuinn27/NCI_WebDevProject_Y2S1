<%-- 
    Document   : index
    Created on : Nov 22, 2014, 2:16:35 PM
    Author     : niallquinn
--%>

<%@page import="webApp.Sex"%>
<%@ page import="webApp.User" %>

<%
    /*Adding Dummy Data
        Here we will either do the XML transformation to populate arrays
        or delegate to a java class. (Probably the latter to keep this page
        clean).
    */
    User userOne = new User("Niall", "Quinn", "22/08/1988", Sex.MALE);
    User userTwo = new User("John", "O'Shea", "dd/mm/yyyy", Sex.MALE);
    User userThree = new User("Joe", "Bloggs", "dd/mm/yyyy", Sex.MALE);
    User userFour = new User("Jane", "Bloggs", "dd/mm/yyyy", Sex.FEMALE);
    User userFive = new User("John", "O'Shea", "dd/mm/yyyy", Sex.MALE);
    
    User[] users = {userOne,userTwo,userThree,userFour,userFive};
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clothes Club!</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles.css">
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
            <!--<div class="col-md-6">-->
                <h2>Users</h2>
                <table class="table table-striped">
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Sex</th>
                    <th>DOB</th>
                    <th>Signup Date</th>
                    <th>Edit</th>
                    <th>Delete</th>
                <!-- For loop to iterate through the users and print the data -->
                    <% for (int x=0 ; x < 5 ; x++) { %>
                        <tr>
                            <td><%out.print(x);%></td>
                            <td><%out.print(users[x].getFirstName());%></td>
                            <td><%out.print(users[x].getLastName());%></td>
                            <td><%String sex = (users[x].getSex() == Sex.MALE) ? "Male" : "Female"; out.print(sex);%></td>
                            <td><%out.print(users[x].getDob());%></td>
                            <td><%out.print("dd/mm/yyyy");%></td>
                            <td><a href="#">Edit</a></td>
                            <td><a href="#">Delete</a></td>
                        </tr>
                    <% } %>
                <table>
                <p><a class="btn btn-default" href="#" role="button">Add New User &raquo;</a></p>
        </div>
        <hr>
        <footer>
            <p>&copy; Company 2014</p>
        </footer>
    </div> <!-- /container -->

        
        
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </body>
</html>

<%-- 
    Document   : usersList
    Created on : Nov 22, 2014, 2:16:35 PM
    Author     : niallquinn
--%>

<%@page import="webApp.Style"%>
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
    </head>
    <body>
        
        <div id="userDetails">
            <h1 id="boxUserTitle"></h1>
            <h1 id="boxUsername"></h1>
            <h2 id="boxUserDob"></h2>
        </div>
        
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
                    <li><a href="http://localhost:8080/clothesclub">Home</a></li>
                    <li class="active"><a href="http://localhost:8080/clothesclub/usersList.jsp">Users <span class="sr-only">(current)</span></a></li>
                    <li><a href="http://localhost:8080/clothesclub/packagesList.jsp">Packages</a></li>
                    <li><a href="http://localhost:8080/clothesclub/AllUsers">All Users from XSLT</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div>
        </nav>
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1>Welcome to the Clothing Club!</h1>
            <p>Are you a lover of fashion? Sign up now to avail of a new bespoke package each month. <a href="http://localhost:8080/clothesclub/NewUser">Signup is easy</a></p>
            <p><a class="btn btn-primary btn-lg" href="http://localhost:8080/clothesclub/NewUser" role="button">Sign Up Now &raquo;</a></p>
        </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
        <div class="row">
            <!--<div class="col-md-6">-->
                <h2>Users!</h2>
                <table class="table table-striped">
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Sex</th>
                    <th>DOB</th>
                    <th>Style</th>
                    <th>Edit</th>
                    <th>Delete</th>
                <!-- For loop to iterate through the users and print the data -->
                    <% for (int x=0 ; x < controller.getUserList().size() ; x++) { %>
                        <tr id="tableRow">
                            <%String link = "http://localhost:8080/clothesclub/Users?id=" + x ;%>
                            <td>
                                <a id="ident" href="<%out.print(link);%>"><%out.print(x);%></a>
                            </td>
                            <td><%out.print(controller.getUserList().get(x).getFirstName());%></td>
                            <td><%out.print(controller.getUserList().get(x).getLastName());%></td>
                            <td><%String sex = (controller.getUserList().get(x).getSex() == Sex.MALE) ? "Male" : "Female"; out.print(sex);%></td>
                            <td><%out.print(controller.getUserList().get(x).getDob());%></td>
                            <td><%String style = (controller.getUserList().get(x).getStyle() == Style.FORMAL) ? "Formal" : "Teen"; out.print(style); %></td>
                            <%String editLink = "http://localhost:8080/clothesclub/edit.jsp?id=" + x ;%>
                            <td><a href="<%out.print(editLink);%>">Edit</a></td>
                            <%String deleteLink = "http://localhost:8080/clothesclub/DeleteUser?id=" + x ;%>
                            <td><a href="<%out.print(deleteLink);%>">Delete</a></td>
                        </tr>
                    <% } %>
                <table>
                <p><a class="btn btn-default" href="#" role="button">Add New User &raquo;</a></p>
            <!--</div>-->
        </div>
        <hr>
        <footer>
            <p>&copy; Company 2014</p>
        </footer>
    </div> <!-- /container -->

    <script>
        //<!-- AJAX IMPLEMENTATION -->
        $( "tr" ).hover(
            function() {
                var identifier = $(this).find("#ident").html();
                $(document).find("#userDetails").css("display","inline-block");
                var identifier = $(this).find("#ident").text();
                var link = "http://localhost:8080/clothesclub/API/User?id=" + identifier;
                $.ajax({url:link,success:function(result){
                    var uo = jQuery.parseJSON(result);
                    $(document).find("#userDetails").find("#boxUserTitle").text("User Details");
                    $(document).find("#userDetails").find("#boxUsername").text(uo.firstName + " " + uo.lastName);
                    $(document).find("#userDetails").find("#boxUserDob").text(uo.dob);
                }});
            }, function() {
                $( document ).find( "#userDetails" ).css("display","none");
            }
        );
    </script> 
        
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </body>
</html>

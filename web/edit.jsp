<%@page import="webApp.Style"%>
<%@page import="webApp.ApplicationController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="webApp.Sex"%>
<%@ page import="webApp.User" %>

<%
    ApplicationController controller = ApplicationController.getShared();
    int id = -1;
    id = Integer.parseInt(request.getParameter("id"));
    if (id == -1) {
        return;
    }
    User u = null;
    if (id < controller.getUserList().size()) {
        u = controller.getUserById(id);
    }
    if (u == null) {
        return;
    }
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
        
        <form class="form-horizontal" action="http://localhost:8080/clothesclub/UpdateUser" method="POST">
                <fieldset>

                <!-- Form Name -->
                <legend>Update User Details</legend>

                <!-- Text input-->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="id">ID</label>  
                  <div class="col-md-4">
                  <input id="firstName" name="id" type="text" placeholder="" value="<%out.print(id);%>" class="form-control input-md uneditable-input">

                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="firstName">First Name</label>  
                  <div class="col-md-4">
                  <input id="firstName" name="firstName" type="text" placeholder="" value="<%out.print(u.getFirstName());%>" class="form-control input-md">

                  </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="lastName">Last Name</label>  
                  <div class="col-md-4">
                  <input id="lastName" name="lastName" type="text" placeholder="" value="<%out.print(u.getLastName());%>" class="form-control input-md">

                  </div>
                </div>
                
                <!-- Text input-->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="dob">DOB</label>  
                  <div class="col-md-4">
                  <input id="dob" name="dob" type="text" placeholder="dd/mm/yyyy" value="<%out.print(u.getDob());%>" class="form-control input-md">

                  </div>
                </div>

                <!-- Multiple Radios (inline) -->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="sexRadio">Sex</label>
                  <div class="col-md-4"> 
                     <%boolean isMale = (u.getSex()==Sex.MALE) ? true:false;%>
                    <label class="radio-inline" for="sexRadio-0">
                      <input type="radio" name="sexRadio" id="sexRadio-0" value="0" <%if(isMale){out.print("checked=\"checked\"");}%>>
                      Male
                    </label> 
                    <label class="radio-inline" for="sexRadio-1">
                      <input type="radio" name="sexRadio" id="sexRadio-1" value="1" <%if(!isMale){out.print("checked=\"checked\"");}%>>
                      Female
                    </label>
                  </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="styleRadio">Style</label>
                  <div class="col-md-4"> 
                      <%boolean isFormal = (u.getStyle()==Style.FORMAL) ? true:false;%>
                    <label class="radio-inline" for="styleRadio-0">
                      <input type="radio" name="styleRadio" id="sexRadio-0" value="0" <%if(isFormal){out.print("checked=\"checked\"");}%>>
                      Formal
                    </label> 
                    <label class="radio-inline" for="styleRadio-1">
                      <input type="radio" name="styleRadio" id="sexRadio-1" value="1" <%if(!isFormal){out.print("checked=\"checked\"");}%>>
                      Teen
                    </label>
                  </div>
                </div>
                <!-- Button -->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="go"></label>
                  <div class="col-md-4">
                    <button type="submit" id="go" name="go" class="btn btn-success">Update!</button>
                  </div>
                </div>
                </fieldset>
            </form>
        <hr>
        <footer>
            <p>&copy; Company 2014</p>
        </footer>
    </div> <!-- /container -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </body>
</html>

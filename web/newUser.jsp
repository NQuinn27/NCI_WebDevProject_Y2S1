<%-- 
    Document   : newUser
    Created on : Dec 6, 2014, 10:58:49 AM
    Author     : niallquinn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clothes Club!</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles.css">
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
        </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
        <div class="centerBox">
            <form class="form-horizontal" action="http://localhost:8080/clothesclub/NewUser" method="POST">
                <fieldset>

                <!-- Form Name -->
                <legend>Insert Your Details</legend>

                <!-- Text input-->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="firstName">First Name</label>  
                  <div class="col-md-4">
                  <input id="firstName" name="firstName" type="text" placeholder="" class="form-control input-md">

                  </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="lastName">Last Name</label>  
                  <div class="col-md-4">
                  <input id="lastName" name="lastName" type="text" placeholder="" class="form-control input-md">

                  </div>
                </div>
                
                <!-- Text input-->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="dob">DOB</label>  
                  <div class="col-md-4">
                  <input id="dob" name="dob" type="text" placeholder="dd/mm/yyyy" class="form-control input-md">

                  </div>
                </div>

                <!-- Multiple Radios (inline) -->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="sexRadio">Sex</label>
                  <div class="col-md-4"> 
                    <label class="radio-inline" for="sexRadio-0">
                      <input type="radio" name="sexRadio" id="sexRadio-0" value="0" checked="checked">
                      Male
                    </label> 
                    <label class="radio-inline" for="sexRadio-1">
                      <input type="radio" name="sexRadio" id="sexRadio-1" value="1">
                      Female
                    </label>
                  </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="styleRadio">Style</label>
                  <div class="col-md-4"> 
                    <label class="radio-inline" for="styleRadio-0">
                      <input type="radio" name="styleRadio" id="sexRadio-0" value="0" checked="checked">
                      Formal
                    </label> 
                    <label class="radio-inline" for="styleRadio-1">
                      <input type="radio" name="styleRadio" id="sexRadio-1" value="1">
                      Teen
                    </label>
                  </div>
                </div>
                <!-- Button -->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="go"></label>
                  <div class="col-md-4">
                    <button type="submit" id="go" name="go" class="btn btn-success">Go!</button>
                  </div>
                </div>
                </fieldset>
            </form>
        </div>
        <hr>
        <footer>
            <p>&copy; Company 2014</p>
        </footer>
    </div> <!-- /container -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </body>
</html>

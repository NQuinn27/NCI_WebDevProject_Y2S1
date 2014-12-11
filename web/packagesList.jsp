<%-- 
    Document   : packagesList
    Created on : Nov 22, 2014, 2:16:35 PM
    Author     : niallquinn
--%>

<%@page import="webApp.Month"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="webApp.ClothingPackage"%>
<%@page import="webApp.Style"%>
<%@page import="webApp.ApplicationController"%>
<%@page import="webApp.Sex"%>
<%@ page import="webApp.User" %>

<%
    //Get app controller singleton
    ApplicationController controller = ApplicationController.getShared();
    ArrayList<ClothingPackage> packagesList = controller.getPackagesList();
    
    ArrayList<ClothingPackage> formalList = new ArrayList<ClothingPackage>();
    ArrayList<ClothingPackage> teenList = new ArrayList<ClothingPackage>();
    
    //Seperate by style
    for (ClothingPackage p : packagesList) {
        Style st = p.getStyle();
        if (p.getStyle() == Style.FORMAL) {
            formalList.add(p);
        } else {
            teenList.add(p);
        }
    }
    
    //Sort by month
    Collections.sort(formalList);
    Collections.sort(teenList);
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
                    <li><a href="http://localhost:8080/clothesclub">Home</a></li>
                    <li><a href="http://localhost:8080/clothesclub/usersList.jsp">Users <span class="sr-only">(current)</span></a></li>
                    <li class="active"><a href="http://localhost:8080/clothesclub/packagesList.jsp">Packages</a></li>
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
            <div class="col-md-6">
                <h2>Formal Packages</h2>
                    <% for (int x=0 ; x < formalList.size() ; x++) { %>
                        <% ClothingPackage p = formalList.get(x); %>
                        <% int m = p.getMonth();
                            String monthString = "";
                            switch (m) {
                                case 1:
                                    monthString = "January";
                                    break;
                                case 2:
                                    monthString = "February";
                                    break;
                                case 3:
                                    monthString = "March";
                                    break;
                                case 4:
                                    monthString = "April";
                                    break;
                                case 5:
                                    monthString = "May";
                                    break;
                                case 6:
                                    monthString = "June";
                                    break;
                                case 7:
                                    monthString = "July";
                                    break;
                                case 8:
                                    monthString = "August";
                                    break;
                                case 9:
                                    monthString = "September";
                                    break;
                                case 10:
                                    monthString = "October";
                                    break;
                                case 11:
                                    monthString = "November";
                                    break;
                                case 12:
                                    monthString = "December";
                                    break;
                            }
                        %>
                        <div class="panel panel-default">
                            <div class="panel-heading"><h2><%out.print(monthString);%></h2></div>
                            <div class="panel-body">
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <span class="label label-default">Style</span> 
                                        <% String style = (p.getStyle() == Style.FORMAL) ? "Formal" : "Teen"; out.print(style);%>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="label label-default">Top Item</span> 
                                        <% String topItem = p.getTopItem().getDescription(); out.print(topItem);%>
                                        <hr>
                                        <% String imageURI = "http://localhost:8080/clothesclub" + p.getTopItem().getImageUri();%>
                                        <img class="centerImage" src="<%out.print(imageURI);%>"/>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="label label-default">Shirt Item</span> 
                                        <% out.print(p.getShirtItem().getDescription());%>
                                        <hr>
                                        <img class="centerImage" src="<%out.print("http://localhost:8080/clothesclub" + p.getShirtItem().getImageUri());%>"/>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="label label-default">Bottom Item</span> 
                                        <% String trouserItem = p.getTrousersItem().getDescription(); out.print(trouserItem);%>
                                        <hr>
                                        <img class="centerImage" src="<%out.print("http://localhost:8080/clothesclub" + p.getTrousersItem().getImageUri());%>"/>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="label label-default">Accessory Item</span> 
                                        <% out.print(p.getAccessoryItem().getDescription());%>
                                        <hr>
                                        <img class="centerImage" src="<%out.print("http://localhost:8080/clothesclub" + p.getAccessoryItem().getImageUri());%>"/>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="label label-default">Shoes</span> 
                                        <% out.print(p.getShoes().getDescription());%>
                                        <hr>
                                        <img class="centerImage" src="<%out.print("http://localhost:8080/clothesclub" + p.getShoes().getImageUri());%>"/>
                                    </li>
                                  </ul>
                            </div>
                        </div>
                    <% } %> 
            </div>
            <div class="col-md-6">
                <h2>Teen Packages</h2>
                    <% for (int x=0 ; x < teenList.size() ; x++) { %>
                        <% ClothingPackage p = teenList.get(x); %>
                        <% int m = p.getMonth();
                            String monthString = "";
                            switch (m) {
                                case 1:
                                    monthString = "January";
                                    break;
                                case 2:
                                    monthString = "February";
                                    break;
                                case 3:
                                    monthString = "March";
                                    break;
                                case 4:
                                    monthString = "April";
                                    break;
                                case 5:
                                    monthString = "May";
                                    break;
                                case 6:
                                    monthString = "June";
                                    break;
                                case 7:
                                    monthString = "July";
                                    break;
                                case 8:
                                    monthString = "August";
                                    break;
                                case 9:
                                    monthString = "September";
                                    break;
                                case 10:
                                    monthString = "October";
                                    break;
                                case 11:
                                    monthString = "November";
                                    break;
                                case 12:
                                    monthString = "December";
                                    break;
                            }
                        %>
                        <div class="panel panel-default">
                            <div class="panel-heading"><h2><%out.print(monthString);%></h2></div>
                            <div class="panel-body">
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <span class="label label-default">Style</span> 
                                        <% String style = (p.getStyle() == Style.FORMAL) ? "Formal" : "Teen"; out.print(style);%>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="label label-default">Top Item</span> 
                                        <% String topItem = p.getTopItem().getDescription(); out.print(topItem);%>
                                        <hr>
                                        <% String imageURI = "http://localhost:8080/clothesclub" + p.getTopItem().getImageUri();%>
                                        <img class="centerImage" src="<%out.print(imageURI);%>"/>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="label label-default">Shirt Item</span> 
                                        <% out.print(p.getShirtItem().getDescription());%>
                                        <hr>
                                        <img class="centerImage" src="<%out.print("http://localhost:8080/clothesclub" + p.getShirtItem().getImageUri());%>"/>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="label label-default">Bottom Item</span> 
                                        <% String trouserItem = p.getTrousersItem().getDescription(); out.print(trouserItem);%>
                                        <hr>
                                        <img class="centerImage" src="<%out.print("http://localhost:8080/clothesclub" + p.getTrousersItem().getImageUri());%>"/>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="label label-default">Accessory Item</span> 
                                        <% out.print(p.getAccessoryItem().getDescription());%>
                                        <hr>
                                        <img class="centerImage" src="<%out.print("http://localhost:8080/clothesclub" + p.getAccessoryItem().getImageUri());%>"/>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="label label-default">Shoes</span> 
                                        <% out.print(p.getShoes().getDescription());%>
                                        <hr>
                                        <img class="centerImage" src="<%out.print("http://localhost:8080/clothesclub" + p.getShoes().getImageUri());%>"/>
                                    </li>
                                  </ul>
                            </div>
                        </div>
                    <% } %> 
            </div> 
            <!--</div>-->
        </div>
        <hr>
        <footer>
            <p>&copy; Company 2014</p>
        </footer>
    </div> <!-- /container -->

        
        
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </body>
</html>

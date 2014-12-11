<?xml version="1.0" encoding="UTF-8" ?>
<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Clothes Club || All Users</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="styles.css"/>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
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
              <li><a href="http://localhost:8080/clothesclub/AllUsers">All Users from XSLT</a></li>
            </ul>
          </div><!-- /.navbar-collapse -->
        </div>
      </nav>
        <div class="container">
        <div class="row">
                <h2>All Users!</h2>
                <h4>This page was generated using XSLT Transformation in a Servlet</h4>
                <table class="table table-striped">
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Sex</th>
                    <th>DOB</th>
                    <th>Style</th>
                    <xsl:for-each select="//user">
                        <tr>
                            <td> <xsl:value-of select="./id"/></td>
                            <td> <xsl:value-of select="./firstName"/></td>
                            <td> <xsl:value-of select="./lastName"/></td>
                            <td> <xsl:value-of select="./dob"/></td>
                            <td> <xsl:value-of select="./sex"/></td>
                            <td> <xsl:value-of select="./style"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
        </div>
        </div>
    </body>
    </html>
    </xsl:template>
</xsl:transform>

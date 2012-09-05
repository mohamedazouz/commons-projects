<%-- 
    Document   : index
    Created on : 14/08/2012, 12:59:32 م
    Author     : 221388
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/converterPage.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h1>Upload input File</h1>
        </center>
        <form action="convert2"  method="post" id="converterForm"
              enctype="multipart/form-data">
            <div id="inDiv">
                <div>
                    <label>Input File</label>
                    <input type="file" name="inputFile" />
                </div>
            </div>
            <input type="submit" value="next">
        </form>
    </body>
</html>

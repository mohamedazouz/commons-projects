<%-- 
    Document   : upload
    Created on : 27/08/2012, 09:00:42 ص
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
        <style type="text/css">
            .box{
                border-bottom: solid 1px #000
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="convert"  method="post" id="converterForm">
            <div id="inDiv" class="box">
                <center>
                    <h1>Input File details</h1>
                </center>
                <div>
                    <label>if the file has delimter ?</label>
                    <p>
                        <label>Yes</label>
                        <input type="radio" name="isInDel" value="1" class="isInDel" checked/>
                        <input type="text" name="inDelimter"  />
                    </p>
                    <p>
                        <label>No</label>
                        <input type="radio" name="isInDel" value="2" class="isInDel" />
                    </p>
                </div>
                <div id="inFldLenDiv" style="display: none;">
                    <p>
                        <label>what is number of input feilds ?</label>
                        <input type="text" name="inFldlen" />
                    </p>
                    <button id="updateinput">update</button>
                    <div id="inFldsQuslenDiv">

                    </div>
                </div>
            </div>
            <div id="outDiv">
                <center>
                    <h1>Output File details</h1>
                </center>
                <div>
                    <label>if the file has delimeter?</label>
                    <p>
                        <label>Yes</label>
                        <input type="radio" name="isOutDel" value="1" class="isOutDel" checked/>
                        <input type="text" name="outDelimter"  />
                    </p>
                    <p>
                        <label>No</label>
                        <input type="radio" name="isOutDel" value="2" class="isOutDel" />
                    </p>
                </div>
                <p>
                    <label>what is number of output fields ?</label>
                    <input type="text" name="outFldlen" />
                </p>
                <button id="updateOutput">update</button>
                <div id="OutFldsQuslenDiv">

                </div>
            </div>
            <input type="submit">
        </form>
    </body>
</html>

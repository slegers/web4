<%--
  Created by IntelliJ IDEA.
  User: yanice
  Date: 24/02/2018
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Simple Ajax Example (using text)</title>
  <script type="text/javascript" src="quote.js"></script>
</head>

<body>
<h1>Quote of the moment ...</h1>
<div id="quote"></div>
<input type="button" id="quotebutton" value="New Quote" onclick="getNewQuote();"/>
</body>
</html>
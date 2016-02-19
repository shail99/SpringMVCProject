<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="jsp/jqtree.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://d3js.org/d3.v3.min.js">
</script>
<title>JqTreee</title>
</head>
<body>

<h1>
	First Spring MVC Application
</h1>

<script>

	d3.select("h1").text("Spring MVC Application written with D3");
	d3.select("body").append("h2").text("Adding new element within d3");

</script>

<script src="<c:url value="resources/jqtree/jquery-1.12.0.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="resources/jqtree/tree.jquery.js" />" type="text/javascript"></script>
<script src="<c:url value="resources/jqtree/jquery.cookie.js" />" type="text/javascript"></script>

<div id="tree1">
	<script>
		var data = [
    	{
        	label: 'node1',
        	children: [
            	{ label: 'child1' },
            	{ label: 'child2' }
        	]
    	},
    	{
        	label: 'node2',
        	children: [
            	{ label: 'child3' }
        	]
    	}
	];
		
	$(function() {
		    $('#tree1').tree({
		        data: data
		    });
		});
</script>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width-device-width, initial-scale=1">
    <meta name="description: content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/facivon.ico">
    <title>Book management demo</title>
    <link rel='stylesheet' href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css'>

    <link rel="stylesheet" href="/resources/css/main.css">

</head>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Spring Web MVC demo</a>
        </div>

         <div class="navbar-header">
                   <a href="newBook">Add book</a>
                </div>


    </div>
</nav>
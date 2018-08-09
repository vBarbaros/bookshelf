<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Books</title>
  </head>
  <body>
    <section>
      <div class="jumbotron">
        <div class="container">
          <h1>Books</h1>
        </div>
      </div>
    </section>
    <section class="container">
      <div class="row">
        <div class="col-md-5">
		  <img src="<c:url value="/resource/images/${book.bookId}.png"></c:url>" alt="image"  style = "width:100%"/>
		</div>
        <div class="col-md-5">
          <h3>${book.bookTitle}</h3>
          <p>${book.review}</p>
          <p><strong>Item Code : </strong><span class="label label-warning">${book.bookId}</span></p> 
          <p><strong>Editor</strong> : ${book.editor}</p> 
          <p><strong>Genre</strong> : ${book.genre}</p>
          <p><strong>Available units in stock </strong> : ${book.unitsInStock}</p>
          <h4>${book.pricePerUnit} USD</h4>
          
          <a href="<spring:url value="/books" />" class="btn btn- default">
          	<span class="glyphicon-hand-left glyphicon"></span> 
          	  Back to Main
       	  </a>
          
          <p>
          	<a href="#" class="btn btn-warning btn-large"><span class="glyphicon-shopping-cart glyphicon"></span>Order Now</a>
          </p> 
        </div>
      </div>
    </section>
  </body>
</html>
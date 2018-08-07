<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
      href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Books</title>
  </head>
  <body>
    <section>
      <div class="jumbotron">
        <div class="container">
          <h1>Books</h1>
          <p>All the available books on my Bookshelf</p>
        </div>
   	  </div>
	</section>
	<section class="container">
      <div class="row">
      	<c:forEach items="${books}" var="book">
      	
        <div class="col-sm-6 col-md-6" style="padding-bottom: 15px">
          <div class="thumbnail">
            <div class="caption">
              <h3>${book.bookTitle}</h3>
              <p>${book.genre}</p>
              <p>${book.review}</p>
         	  <p>${book.pricePerUnit} USD</p>
          	  <p>Available ${book.unitsInStock} hard copies in stock</p>
            </div>
          </div>
        </div>
        
        </c:forEach>
      </div>
    </section>
  </body>
</html>
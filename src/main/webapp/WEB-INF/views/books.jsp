<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
    <title>Books</title>
  </head>
  <body>
	<section class="container">
      <div class="row">
      	<c:forEach items="${books}" var="book">
      	
        <div class="col-sm-4 col-md-4" style="padding-bottom: 15px">
          <div class="thumbnail">
	            <c:choose>
	    		<c:when test="${book.bookId == 'B0001' || book.bookId == 'B0002' || book.bookId == 'B0003'}">
	       			<div class="col-md-6">
			  			<img src="<c:url value="/bookshelf/resource/images/${book.bookId}.png"></c:url>" alt="image"  style = "width:100%"/>
					</div>
	    		</c:when>
	   		    <c:otherwise>
	   		    	<div class="col-md-6">
			  			<img src="<c:url value="/bookshelf/resource/images/default_bookcover.png"></c:url>" alt="image"  style = "width:100%"/>
					</div>
	            </c:otherwise>
			</c:choose>
            <div class="caption">
              <h3>${book.bookTitle}</h3>
              <p>${book.genre}</p>
              <p>${book.review}</p>
         	  <p>${book.pricePerUnit} USD</p>
          	  <p>Available ${book.unitsInStock} hard copies in stock</p>
          	  
          	  <p>
				<a href="<spring:url value="/books/book?id=${book.bookId}"/>" class="btn btn-primary">
       			  <span class="glyphicon-info-sign glyphicon"/></span> 
       			  	Details
       			</a>
              </p>
            </div>
          </div>
        </div>
        
        </c:forEach>
      </div>
    </section>
  </body>
</html>
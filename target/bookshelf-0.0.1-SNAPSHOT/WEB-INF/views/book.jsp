<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
    <title>Books</title>
  </head>
  <body>
    <section class="container" ng-app="cartApp" >
      <div class="row">
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
        
        <div class="col-md-6">
          <h3>${book.bookTitle}</h3>
          <p>${book.review}</p>
          <p><strong>Item Code : </strong><span class="label label-warning">${book.bookId}</span></p> 
          <p><strong>Editor</strong> : ${book.editor}</p> 
          <p><strong>Genre</strong> : ${book.genre}</p>
          <p><strong>Available units in stock </strong> : ${book.unitsInStock}</p>
          <h4>${book.pricePerUnit} USD</h4>
          
          <p ng-controller="cartCtrl">
					<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${book.bookId}')"> 
						<span class="glyphicon-shopping-cart glyphicon"></span> Order Now
					</a>
					
					<a href="<spring:url value="/cart" />" class="btn btn-default">
						<span class="glyphicon-hand-right glyphicon"></span> View Cart
					</a>
					
					<a href=" <spring:url value="/books" />" class="btn btn-default">
					   <span class="glyphicon-hand-left glyphicon"></span>Back to Main
					</a>
				</p> 
        </div>
      </div>
    </section>
  </body>
</html>
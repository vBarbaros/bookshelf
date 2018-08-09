<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Books</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Books</h1>
				<p>Add Books</p>
			</div>
			<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">
				Logout
			</a>
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newBook" class="form-horizontal" enctype="multipart/form-data">
			<fieldset>
				<legend>Add new book</legend>

				<div class="form-group">
					<label class="control-label col-sm-6 col-md-6 col-lg-6" for="bookId">
						<spring:message code="addBook.form.bookId.label" />
					</label>
					<div class="col-lg-12">
						<form:input id="bookId" path="bookId" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-6 col-md-6 col-lg-6" for="bookTitle">Book Title</label>
					<div class="col-lg-12">
						<form:input id="bookTitle" path="bookTitle" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-6 col-md-6 col-lg-6" for="pricePerUnit">Price Per Unit</label>
					<div class="col-lg-12">
						<div class="form:input-prepend">
							<form:input id="pricePerUnit" path="pricePerUnit" type="text" class="form:input-large"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-6 col-md-6 col-lg-6" for="review">Review</label>
					<div class="col-lg-12">
						<form:textarea id="review" path="review" rows = "2"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-6 col-md-6 col-lg-6" for="editor">Editor</label>
					<div class="col-lg-12">
						<form:input id="editor" path="editor" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-6 col-md-6 col-lg-6" for="genre">Genre</label>
					<div class="col-lg-12">
						<form:input id="genre" path="genre" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-6 col-md-6 col-lg-6" for="unitsInStock">Units In
						Stock</label>
					<div class="col-lg-12">
						<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-6 col-md-6 col-lg-6" for="condition">Condition</label>
					<div class="col-lg-12">
						<form:radiobutton path="condition" value="New" />New 
						<form:radiobutton path="condition" value="Old" />Used
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="bookImage">
						<spring:message code="addBook.form.bookImage.label"/>
					</label>
					<div class="col-lg-12">
						<form:input id="bookImage" 
									path="bookImage"
									type="file" 
									class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-sm-6 col-md-6 col-lg-6">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
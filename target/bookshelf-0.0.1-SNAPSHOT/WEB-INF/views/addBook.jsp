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

	<section class="container">
		<form:form  modelAttribute="newBook" class="form-horizontal" enctype="multipart/form-data">
			<fieldset>
				<legend>Add new book</legend>
				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2" for="bookId">
						<spring:message code="addBook.form.bookId.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="bookId" path="bookId" type="text" class="form:input-large"/>
						<form:errors path="bookId" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="bookTitle">Book Title</label>
					<div class="col-lg-10">
						<form:input id="bookTitle" path="bookTitle" type="text" class="form:input-large"/>
						<form:errors path="bookTitle" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="pricePerUnit">Price Per Unit</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="pricePerUnit" path="pricePerUnit" type="text" class="form:input-large"/>
							<form:errors path="pricePerUnit" cssClass="text-danger"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="review">Review</label>
					<div class="col-lg-10">
						<form:textarea id="review" path="review" rows = "2"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="editor">Editor</label>
					<div class="col-lg-10">
						<form:input id="editor" path="editor" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="genre">Genre</label>
					<div class="col-lg-10">
						<form:input id="genre" path="genre" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="unitsInStock">Units In
						Stock</label>
					<div class="col-lg-10">
						<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="condition">Condition</label>
					<div class="col-lg-10">
						<form:radiobutton path="condition" value="New" />New 
						<form:radiobutton path="condition" value="Old" />Used
					</div>
				</div>
				
				<%-- <div class="form-group">
					<label class="control-label col-lg-2" for="bookImage">
						<spring:message code="addBook.form.bookImage.label"/>
					</label>
					<div class="col-lg-10">
						<form:input id="bookImage" 
									path="bookImage"
									type="file" 
									class="form:input-large"/>
					</div>
				</div> --%>
				
				<div class="form-group">
					<div class="col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
						
						<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">
							Logout
						</a>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
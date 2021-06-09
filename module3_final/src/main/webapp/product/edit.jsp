<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Editing product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<h1>Edit existing product</h1>
<c:if test="${requestScope['message']=='editSuccess'}"><span style="color: green">Product has been edited successfully</span><br></c:if>
<c:if test="${requestScope['message']=='editFail'}"><span style="color: red">Product has NOT been edited</span><br></c:if>
<form action="/products?action=edit" method="post">
    <input type="hidden" name="id" value="${requestScope['product'].id}">
    <lable>Name</lable><br>
    <input type="text" name="name" value="${requestScope['product'].name}"><br>
    <lable>Price</lable><br>
    <input type="text" name="price" required value="${requestScope['product'].price}"><br>
    <lable>Quantity</lable><br>
    <input type="number" name="count" required value="${requestScope['product'].count}"><br>
    <lable>Color</lable><br>
    <input type="text" name="color" value="${requestScope['product'].color}"><br>
    <lable>Description</lable><br>
    <input type="text" name="description" value="${requestScope['product'].description}"><br>
    <lable>Category</lable><br>
    <select name="categoryId">
        <c:forEach items="${requestScope['categories']}" var="category">
            <option value="${category.id}"
                    <c:if test="${product.categoryId == category.id}"> selected="selected" </c:if>
            >
                ${category.name}
            </option>
        </c:forEach>
    </select>
    <input type="submit" value="Update" class="btn btn-success">|<a href="/products" class="btn btn-secondary">Back</a><br>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</html>

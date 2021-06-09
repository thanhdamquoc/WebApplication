<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Adding new product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Add new product</h1>
    <c:if test="${requestScope['message']=='addSuccess'}"><span style="color: green">Product has been added successfully</span><br></c:if>
    <c:if test="${requestScope['message']=='addFail'}"><span style="color: red">Product has NOT been added</span><br></c:if>
    <form action="/products?action=add" method="post">
        <lable>Name</lable><br>
        <input type="text" name="name"><br>
        <lable>Price</lable><br>
        <input type="text" name="price" required><br>
        <lable>Quantity</lable><br>
        <input type="number" name="count" required><br>
        <lable>Color</lable><br>
        <input type="text" name="color"><br>
        <lable>Description</lable><br>
        <input type="text" name="description"><br>
        <lable>Category</lable><br>
        <select name="categoryId">
            <c:forEach items="${requestScope['categories']}" var="category">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select><br><br>
        <input type="submit" value="Create" class="btn btn-success"> | <a href="/products" class="btn btn-secondary">Back</a><br>
    </form>
</body>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</html>

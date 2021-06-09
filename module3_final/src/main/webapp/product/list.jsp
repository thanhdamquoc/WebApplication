<%@ page import="com.codegym.service.category.CategoryService" %>
<%@ page import="com.codegym.service.category.ICategoryService" %>
<%@ page import="com.codegym.model.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%ICategoryService categoryService = new CategoryService();%>

<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col" style="text-align: left"><a class="btn btn-primary" href="/products?action=add">+Add new product</a></div>
        <div class="col">
            <form action="/products" method="get">
                <input placeholder="Search" type="text" name="q">
                <input type="submit" value="Search">
            </form>
        </div>
    </div>
</div>


<c:if test="${requestScope['message']=='removeSuccess'}"><span style="color: green">Product has been removed successfully</span><br></c:if>
<c:if test="${requestScope['message']=='removeFail'}"><span style="color: red">Product has NOT been removed</span><br></c:if>

<table class="table">
    <tr>
        <th scope="col">Product List</th>
    </tr>
    <tr>
        <table class="table table-striped">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Product Name</th>
                <th scope="col">Price</th>
                <th scope="col">Quantity</th>
                <th scope="col">Color</th>
                <th scope="col">Category</th>
                <th scope="col">Action</th>
            </tr>
            <c:forEach items="${requestScope['products']}" var="product">
                <tr>
                    <td scope="row">${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.count}</td>
                    <td>${product.color}</td>
                    <td>
                        <c:set value="${product.categoryId}" var="categoryId"/>
                        <%
                            int categoryId = (Integer) pageContext.getAttribute("categoryId");
                            String categoryName = categoryService.findById(categoryId).getName();
                        %>
                        <%=categoryName%>
                    </td>
                    <td>
                        <a href="/products?action=edit&id=${product.id}" class="btn btn-primary">Edit</a>
                        |<a href="/products?action=remove&id=${product.id}" class="btn btn-danger">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </tr>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</html>

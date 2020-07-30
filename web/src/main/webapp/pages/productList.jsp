
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="row row-cols-1 row-cols-md-4">
    <c:forEach items="${requestScope.productList}" var="item" varStatus="infdex">
        <div class="col mb-3">
            <div class="card h-100 text-center">
                <a href="${pageContext.request.contextPath}/product?pId=${item.id}"
                   class="card-link"><img src="${pageContext.request.contextPath}/img/${item.img}" class="card-img-top" alt="${item.name}"></a>

                <div class="card-body">
                    <a href="${pageContext.request.contextPath}/product?pId=${item.id}"
                       class="card-link">${item.name} ${item.price}</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

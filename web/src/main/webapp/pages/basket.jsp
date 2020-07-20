<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${requestScope.error != null}">
    <h5>${requestScope.error}</h5>
</c:if>


<c:choose>
    <c:when test="${sessionScope.basket.orders.size()==0 || sessionScope.basket == null}">
        <c:if test="${requestScope.orderInProcess == null}">
            <h5>Ваша корзина пуста</h5>
        </c:if>
    </c:when>
    <c:otherwise>
        <form id="delFromBasket" method="post" action="${pageContext.request.contextPath}/delFromBasket"></form>
        <form id="setOrder" method="post" action="${pageContext.request.contextPath}/setOrder"></form>

        <table class="table table-hover">
            <caption>Товары в корзине</caption>
            <thead>
            <tr>
                <th scope="col"></th>
                <th scope="col"></th>
                <th scope="col">Наименование</th>
                <th scope="col">Цена</th>
                <th scope="col">Количество</th>

                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.basket}" var="item" varStatus="index">
                <tr>
                    <th scope="row"><c:out value="${index.count}"/></th>
                    <td>
                        <a href="${pageContext.request.contextPath}/product?pId=${item.id}">
                            <img src="${pageContext.request.contextPath}/img/${item.img}" alt="${item.name}" height="70">
                        </a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/product?pId=${item.id}">
                            <c:out value="${item.name}"/>
                        </a>
                    </td>
                    <td><c:out value="${item.price}"/></td>
                    <td>
                        <label>
                            <input form="setOrder" type="number" min="1" max="${item.quantity}" value="1"
                                   name="quantity">
                        </label>
                    </td>
                    <td>
                        <button class="btn btn-primary col-6" form="delFromBasket" type="submit" name="delProduct" value="${item.id}">
                            Удалить
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <input form="setOrder" type="submit" value="Заказать">
    </c:otherwise>
</c:choose>
<br>

<c:if test="${requestScope.orderInProcess != null}">
    <table>
        <caption>Заказанные товары</caption>
        <tr>
            <th>Номер</th>
            <th>ID заказа</th>
            <th>Название</th>
            <th>Цена</th>
            <th>Количество</th>
            <th>Статус</th>
            <th></th>
        </tr>
        <c:forEach items="${requestScope.orderInProcess}" var="item" varStatus="index">
            <tr>
                <th><c:out value="${index.count}"/></th>
                <th><c:out value="${item.id}"/></th>
                <th><c:out value="${item.productName}"/></th>
                <th><c:out value="${item.productPrice}"/></th>
                <th><c:out value="${item.quantity}"/></th>
                <th><c:out value="${item.status}"/></th>
            </tr>
        </c:forEach>
    </table>
</c:if>


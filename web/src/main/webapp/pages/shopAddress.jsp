<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.github.xrapalexandra.kr.model.Role" %>


<div class="card col-10">
    <h5 class="card-header">Адреса наших магазинов</h5>
    <div class="card-body">
        <div class="panel panel-default">
            <div class="panel-body">

                <c:if test="${sessionScope.user.role != Role.ADMIN}">
                    <c:forEach items="${requestScope.shop}" var="item">
                        <div>
                            <c:out value="${item}"/>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${sessionScope.user.role == Role.ADMIN}">
                <form method="post" action="${pageContext.request.contextPath}/delShopAddress">
                        <c:forEach items="${requestScope.shop}" var="item" varStatus="index">
                            <label>
                                <input type="checkbox" name="delShop[]" value="${item.id}">
                                <c:out value="${item}"/>
                            </label>
                            <br>
                        </c:forEach>
                    <button class="btn btn-primary col-2" type="submit">
                        Удалить
                    </button>
                </form>
                <form method="post" action="${pageContext.request.contextPath}/shopAddress">
                    <h5>Добавить адресс</h5>
                    <div class="form-row">
                        <label for="city" class="col-3">Город</label>
                        <div class="col-9">
                            <input type="text" class="form-control" id="city" name="city" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <label for="street" class="col-3">Улица</label>
                        <div class="col-9">
                            <input type="text" class="form-control" id="street" name="street" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <label for="building" class="col-3">Дом</label>
                        <div class="col-9">
                            <input type="text" class="form-control" id="building" name="building" required>
                        </div>
                    </div>
                    <br>
                    <button class="btn btn-primary col-2" type="submit">
                        Добавить
                    </button>
                </form>
                </c:if>
            </div>
        </div>
    </div>
</div>
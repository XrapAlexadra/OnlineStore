<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="card col-5">
    <h5 class="card-header">Редактирование товара</h5>
    <div class="card-body">
        <div class="panel panel-default">
            <div class="panel-body">
                <form method="post" action="${pageContext.request.contextPath}/change">
                    <div class="form-row">
                        <label for="name" class="col-3">Наименование</label>
                        <div class="col-9">
                            <input type="text" class="form-control" id="name" name="name"
                                   value="${requestScope.product.name}">
                        </div>
                    </div>
                    <div class="form-row">
                        <label for="price" class="col-3">Цена</label>
                        <div class="col-9">
                            <input type="text" class="form-control" id="price" pattern="[0-9\.]{1,10}$"
                                   name="price" required value="${requestScope.product.price}">
                        </div>
                    </div>
                    <div class="form-row">
                        <label for="quantity" class="col-3">Цена</label>
                        <div class="col-9">
                            <input type="text" class="form-control" id="quantity" pattern="[0-9]{1,10}$"
                                   name="quantity" required value="${requestScope.product.quantity}">
                        </div>
                    </div>
                    <div class="form-row">
                        <label for="description" class="col-3">Описание</label>
                        <div class="col-9">
                            <input type="text" class="form-control" id="description"
                                   name="description" value="${requestScope.product.description}">
                        </div>
                    </div>
                    
                    <br>
                    <button class="btn btn-primary col-5" type="submit">Изменить</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
    <div class="row">
        <div class="col-4">
            <div id="carousel" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="${pageContext.request.contextPath}/img/${requestScope.product.img}"
                             class="d-block w-100" alt="${requestScope.product.name}">
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath}/img/${requestScope.product.img}"
                             class="d-block w-100" alt="${requestScope.product.name}">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-8">
            <span>${requestScope.product.name}</span>
            <span>${requestScope.product.price}</span>
            <br>
            <form method="post" action=${pageContext.request.contextPath}/addOrder>
                <button type="submit" class="btn btn-primary" name="pId" value="${requestScope.product.id}">
                    В корзину
                </button>
            </form>
        </div>
    </div>
</div>

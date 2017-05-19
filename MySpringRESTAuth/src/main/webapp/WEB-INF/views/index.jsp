<%--
  Created by IntelliJ IDEA.
  User: tvtran
  Date: 4/6/2017
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HOMEPAGE</title>
    <%--<script src="<c:url value="/js/bootstrap.js" />" ></script>--%>
    <%--<link rel="stylesheet" href="<c:url value="/css/bootstrap.css" />" >--%>

    <script src="/js/bootstrap.js" ></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/test.css">
</head>
<body>
<%--<button type="button" class="btn btn-primary">Primary</button>--%>
<%--<nav class="navbar navbar-toggleable-md navbar-light bg-faded">--%>
    <%--<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">--%>
        <%--<span class="navbar-toggler-icon"></span>--%>
    <%--</button>--%>
    <%--<a class="navbar-brand" href="#">Navbar</a>--%>
    <%--<div class="collapse navbar-collapse" id="navbarNavDropdown">--%>
        <%--<ul class="navbar-nav">--%>
            <%--<li class="nav-item active">--%>
                <%--<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="#">Features</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="#">Pricing</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item dropdown">--%>
                <%--<a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                    <%--Dropdown link--%>
                <%--</a>--%>
                <%--<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">--%>
                    <%--<a class="dropdown-item" href="#">Action</a>--%>
                    <%--<a class="dropdown-item" href="#">Another action</a>--%>
                    <%--<a class="dropdown-item" href="#">Something else here</a>--%>
                <%--</div>--%>
            <%--</li>--%>
        <%--</ul>--%>
    <%--</div>--%>
<%--</nav>--%>
<div>
    <form>
        <a href="<c:url value="/user/list" />" >User List</a>
        |
        <a href="<c:url value="/logout" />" >LOGOUT</a>
        |
        <a href="<c:url value="/svc/testList" />" >TEST LIST</a>
    </form>
</div>
<div class="container" style="margin-top:50px;">
    <div class="row">

        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="post-img-content">
                    <img src="http://placehold.it/350x260" class="img-responsive" />
                    <span class="post-title">
                        <b>Perfumes</b><br>
                        <b>Clássico</b>
                    </span>
                    <span class="round-tag">-15%</span>
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">19.99€</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <h5 class="price-text-color">14.99€</h5>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="#" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="#" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="post-img-content">
                    <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                    <span class="post-title">
                        <b>Perfumes</b><br>
                        <b>Clássico</b>
                    </span>
                    <span class="round-tag">-15%</span>
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$199.99</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                        </i><i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="photo">
                    <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$199.99</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                        </i><i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="photo">
                    <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$199.99</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                        </i><i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"a</i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

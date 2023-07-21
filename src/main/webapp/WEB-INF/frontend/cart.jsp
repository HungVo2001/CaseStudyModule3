<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>Lugx Gaming Template - Contact Page</title>
  <link rel="shortcut icon" type="image/x-icon" href="\frontend\assets\img\favicon.png">

  <!-- all css here -->
  <link rel="stylesheet" href="\frontend\assets\css\bootstrap.min.css">
  <link rel="stylesheet" href="\frontend\assets\css\plugin.css">
  <link rel="stylesheet" href="\frontend\assets\css\bundle.css">
  <link rel="stylesheet" href="\frontend\assets\css\style.css">
  <link rel="stylesheet" href="\frontend\assets\css\responsive.css">

  <jsp:include page="/WEB-INF/layout/head_css.jsp"></jsp:include>
  <style>
    .cart{
      padding: 20px;
    }
    table{
      color: white;
    }
  </style>

</head>

<body>

  <!-- ***** Preloader Start ***** -->
<%--<jsp:include page="layout/preloader.jsp"></jsp:include>--%>
  <!-- ***** Preloader End ***** -->

  <!-- ***** Header Area Start ***** -->
  <jsp:include page="/WEB-INF/layout/header_js.jsp"></jsp:include>
  <!-- ***** Header Area End ***** -->

  <div class="page-heading header-text">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h3>CART</h3>
          <span class="breadcrumb"><a href="/homes">Home</a> > CART</span>
        </div>
      </div>
    </div>
  </div>

  <div class="cart-page section">
    <div id="cartpage-app" class="cartpage-container">
      <div class="cartpage-left">
        <div class="cartpage-section" data-select2-id="select2-data-13-9tyk">
          <h2>Cart</h2>
          <div class="shopping_cart_area">
            <form action="#">
              <div class="row">
                <div class="col-12">
                  <div class="table_desc">
                    <div class="cart_page table-responsive">
                      <table>
                        <thead>
                        <tr>
                          <th class="cart product_remove">Delete</th>
                          <th class="cart product_thumb">Image</th>
                          <th class="cart product_name">Product</th>
                          <th class="cart product-price">Price</th>
                          <th class="cart product_quantity">Quantity</th>
                          <th class="cart product_total">Total</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${requestScope.cart.getCartItems()}" var="cartItem">
                          <tr>
                            <td class="cart product_remove"><a href="/cart?action=delete&id=${cartItem.id}"><i class="fa fa-trash-o"></i>xoa</a></td>
                            <td class="cart product_thumb"><img style="width: 100px;height: 100px" src="${cartItem.product.img}"></td>
                            <td class="cart product_name">${cartItem.product.name}</td>
                            <td class="cart product-price">${cartItem.price}</td>
                            <td class="cart product_quantity"><input  onchange="handleQuantityChange(this, ${cartItem.product.id})" min="0" max="100" type="number" value="${cartItem.quantity}"></td>
                            <td class="cart product_total">${cartItem.price*cartItem.quantity} VND</td>
                          </tr>
                        </c:forEach>


                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
        <div class="separator"></div>
      </div>
      <div class="cartpage-right">
        <h2>Summary</h2>
        <div class="cart-summary">
          <div class="price_indiv d-flex justify-content-between" style="padding-bottom: 30px">
            <p>Total</p>
            <p><span id="product_total_amt">${String.format("%.0f",cartItem.total)}</span> VNĐ</p>
          </div>
          <a class="button gotopayment">Go to payment
            <div><i class="fa-solid fa-greater-than"></i></div>
          </a>
          <span class="choice">or</span>
          <a href="/shop" class="back">
            <div><i class="fa-solid fa-less-than"></i>Continue shopping</div>
          </a>
        </div>
      </div>
    </div>
  </div>

  <!-- <footer>
    <div class="container">
      <div class="col-lg-12">
        <p>Copyright © 2048 LUGX Gaming Company. All rights reserved. &nbsp;&nbsp; <a rel="nofollow" href="https://templatemo.com" target="_blank">Design: TemplateMo</a></p>
      </div>
    </div>
    
  </footer> -->

  <div class="separator wide"></div>

  <jsp:include page="/WEB-INF/layout/footer_container.jsp"></jsp:include>

  <jsp:include page="/WEB-INF/layout/java_script.jsp"></jsp:include>

  <script>
    function handleQuantityChange(eQuantity, idProduct){
      let url = `/cart?action=update&id=\${idProduct}&quantity=\${eQuantity.value}`;

      window.location.assign(url);
    }
    function formatPrice(price) {
      return price.toLocaleString('vi-VN', {style: 'currency', currency: 'VND'});
    }
    function deleteCartItemIfQuantityEqualZero(idProduct) {

    }
  </script>
  <script src="\frontend\assets\js\vendor\modernizr-2.8.3.min.js"></script>
  <script src="\frontend\assets\js\vendor\jquery-1.12.0.min.js"></script>
  <script src="\frontend\assets\js\popper.js"></script>
  <script src="\frontend\assets\js\bootstrap.min.js"></script>
  <script src="\frontend\assets\js\ajax-mail.js"></script>
  <script src="\frontend\assets\js\plugins.js"></script>
  <script src="\frontend\assets\js\main.js"></script>
</body>

</html>
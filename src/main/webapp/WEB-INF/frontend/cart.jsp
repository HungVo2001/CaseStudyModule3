<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>Lugx Gaming Template - Contact Page</title>

  <jsp:include page="/WEB-INF/layout/head_css.jsp"></jsp:include>


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
          <h3>Contact Us</h3>
          <span class="breadcrumb"><a href="#">Home</a> > Contact Us</span>
        </div>
      </div>
    </div>
  </div>

  <div class="cart-page section">
    <div id="cartpage-app" class="cartpage-container">
      <div class="cartpage-left">
        <div class="cartpage-section" data-select2-id="select2-data-13-9tyk">
          <h2>Cart</h2>
          <div class="cart-listing" data-select2-id="select2-data-12-kkm5">
            <div class="cart-item" data-select2-id="select2-data-11-d37n">
              <div class="item-container" data-select2-id="select2-data-10-xtlc">
                <a href="../../dashboard/asset/assets/images/single-game.jpg" class="cover">
                  <picture>
                    <img alt="Six Days in fallu" src="../../dashboard/asset/assets/images/single-game.jpg" loading="lazy">
                  </picture>
                </a>
                <div class="information">
                  <div class="name">
                    <div class="platform platform-steam">
                      <div> <img class="icon-steam" src="../../dashboard/asset/assets/images/steam.png" alt=""></div>
                    </div>
                    <span title="Six Days in Fallujah" class="title">Six Days in Fallujah</span>
                  </div>
                  <div class="type">Steam</div>
                  <div class="actions">
                    <a class="deleteItem">
                      <i class="delete fa-regular fa-trash-can"></i>
                    </a>
                    <a class="moveToWishlist">Move to Wishlist</a>
                  </div>
                </div>
                <div class="price-container" data-select2-id="select2-data-9-7f0z">
                  <div class="price">28.99€</div>
                  <select class="wide selectable2 manual select2-hidden-accessible"
                    data-select2-id="select2-data-1-mi7w" tabindex="-1" aria-hidden="true">
                    <option value="0" disabled="disabled">0</option>
                    <option value="1" data-select2-id="select2-data-3-bt80">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                  </select>
                  <span class="select2 select2-container select2-container--default" dir="ltr"
                    data-select2-id="select2-data-2-v91o">
                    <span class="selection">
                      <span class="select2-selection select2-selection--single" role="combobox" aria-haspopup="true"
                        aria-expanded="false" tabindex="0" aria-disabled="false"
                        aria-labelledby="select2-v6kx-container" aria-controls="select2-v6kx-container">
                        <span class="select2-selection__rendered" id="select2-v6kx-container" role="textbox"
                          aria-readonly="true" title="1">1</span>
                        <span class="select2-selection__arrow" role="presentation">
                          <b role="presentation"></b>
                        </span>
                      </span>
                    </span>
                    <span class="dropdown-wrapper" aria-hidden="true"></span>
                  </span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="separator"></div>
      </div>
      <div class="cartpage-right">
        <h2>Summary</h2>
        <div class="cart-summary">
          <div class="summary-row">
            <span>Official price</span>
            <span>38.99€</span>
          </div>
          <div class="summary-row">
            <span>Discount</span>
            <span>-10€</span>
          </div>
          <div class="summary-row">
            <span>Subtotal</span>
            <span>28.99€</span>
          </div>
          <a class="button gotopayment">Go to payment
            <div><i class="fa-solid fa-greater-than"></i></div>
          </a>
          <span class="choice">or</span>
          <a href="/" class="back">
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

</body>

</html>
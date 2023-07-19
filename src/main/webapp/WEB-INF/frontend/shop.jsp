<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Lugx Gaming - Shop Page</title>
    <jsp:include page="/WEB-INF/layout/head_css.jsp"></jsp:include>
  </head>

<body>

  <!-- ***** Preloader Start ***** -->
<%--  <jsp:include page="layout/preloader.jsp"></jsp:include>--%>
  <!-- ***** Preloader End ***** -->

  <!-- ***** Header Area Start ***** -->
  <jsp:include page="/WEB-INF/layout/header_js.jsp"></jsp:include>
  <!-- ***** Header Area End ***** -->

  <div class="page-heading header-text">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h3>Our Shop</h3>
          <span class="breadcrumb"><a href="#">Home</a> > Our Shop</span>
        </div>
      </div>
    </div>
  </div>

  <div class="section trending">
    <div class="container">
      <ul class="trending-filter">
        <li>
          <a class="is_active" href="#!" data-filter="*">Show All</a>
        </li>
        <li>
          <a href="#!" data-filter=".adv">Adventure</a>
        </li>
        <li>
          <a href="#!" data-filter=".str">Strategy</a>
        </li>
        <li>
          <a href="#!" data-filter=".rac">Racing</a>
        </li>
      </ul>
      <div class="row trending-box">
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 adv">
          <div class="item">
            <div class="thumb">
              <a href="/WEB-INF/frontend/product-details.jsp"><img src="/dashboard/asset/assets/images/trending-01.jpg" alt=""></a>
              <span class="price"><em>$36</em>$24</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="/WEB-INF/frontend/product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 str">
          <div class="item">
            <div class="thumb">
              <a href="/WEB-INF/frontend/product-details.jsp"><img src="/dashboard/asset/assets/images/trending-02.jpg" alt=""></a>
              <span class="price"><em>$32</em>$22</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="/WEB-INF/frontend/product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 adv rac">
          <div class="item">
            <div class="thumb">
              <a href="/WEB-INF/frontend/product-details.jsp"><img src="/dashboard/asset/assets/images/trending-03.jpg" alt=""></a>
              <span class="price"><em>$45</em>$30</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="/WEB-INF/frontend/product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 str">
          <div class="item">
            <div class="thumb">
              <a href="/WEB-INF/frontend/product-details.jsp"><img src="/dashboard/asset/assets/images/trending-04.jpg" alt=""></a>
              <span class="price"><em>$32</em>$22</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="/WEB-INF/frontend/product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 rac str">
          <div class="item">
            <div class="thumb">
              <a href="/WEB-INF/frontend/product-details.jsp"><img src="/dashboard/asset/assets/images/trending-03.jpg" alt=""></a>
              <span class="price"><em>$38</em>$26</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="/WEB-INF/frontend/product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 rac adv">
          <div class="item">
            <div class="thumb">
              <a href="/WEB-INF/frontend/product-details.jsp"><img src="/dashboard/asset/assets/images/trending-01.jpg" alt=""></a>
              <span class="price"><em>$30</em>$20</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="/WEB-INF/frontend/product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 rac str">
          <div class="item">
            <div class="thumb">
              <a href="/WEB-INF/frontend/product-details.jsp"><img src="/dashboard/asset/assets/images/trending-04.jpg" alt=""></a>
              <span class="price"><em>$32</em>$22</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="/WEB-INF/frontend/product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 rac adv">
          <div class="item">
            <div class="thumb">
              <a href="/WEB-INF/frontend/product-details.jsp"><img src="/dashboard/asset/assets/images/trending-02.jpg" alt=""></a>
              <span class="price"><em>$32</em>$22</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="/WEB-INF/frontend/product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 adv rac">
          <div class="item">
            <div class="thumb">
              <a href="/WEB-INF/frontend/product-details.jsp"><img src="/dashboard/asset/assets/images/trending-03.jpg" alt=""></a>
              <span class="price"><em>$28</em>$20</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="/WEB-INF/frontend/product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 str">
          <div class="item">
            <div class="thumb">
              <a href="/WEB-INF/frontend/product-details.jsp"><img src="/dashboard/asset/assets/images/trending-04.jpg" alt=""></a>
              <span class="price"><em>$26</em>$18</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="/WEB-INF/frontend/product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 adv">
          <div class="item">
            <div class="thumb">
              <a href="/WEB-INF/frontend/product-details.jsp"><img src="/dashboard/asset/assets/images/trending-01.jpg" alt=""></a>
              <span class="price"><em>$32</em>$24</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="/WEB-INF/frontend/product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 str">
          <div class="item">
            <div class="thumb">
              <a href="/WEB-INF/frontend/product-details.jsp"><img src="/dashboard/asset/assets/images/trending-02.jpg" alt=""></a>
              <span class="price"><em>$45</em>$30</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="/WEB-INF/frontend/product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <ul class="pagination">
          <li><a href="#"> &lt; </a></li>
            <li><a href="#">1</a></li>
            <li><a class="is_active" href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#"> &gt; </a></li>
          </ul>
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
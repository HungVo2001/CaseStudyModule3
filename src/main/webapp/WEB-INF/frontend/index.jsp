<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>Lugx Gaming Shop HTML5 Template</title>

  <jsp:include page="/WEB-INF/layout/head_css.jsp"></jsp:include>





</head>
<body>

  <!-- ***** Preloader Start ***** -->
<%-- <jsp:include page="layout/preloader.jsp"></jsp:include>--%>
  <!-- ***** Preloader End ***** -->

  <!-- ***** Header Area Start ***** -->
  <jsp:include page="/WEB-INF/layout/header_js.jsp"></jsp:include>
  <!-- ***** Header Area End ***** -->

  <div class="main-banner">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 align-self-center">
          <div class="caption header-text">
            <h6></h6>
            <h2></h2>
            <p></p>
            <div class="search-input">
              <form id="search" action="#">
                <input type="text" placeholder="Type Something" id='searchText' name="searchKeyword"
                  onkeypress="handle" />
                <!-- <button role="button">Search Now</button> -->
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>

  <div class="section trending">
    <div class="container">
      <div class="row">
        <div class="col-lg-6">
          <div class="section-heading">
            <h6>Trending</h6>
            <h2>Trending Games</h2>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="main-button">
            <a href="shop.jsp">View All</a>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="item">
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/trending-01.jpg" alt=""></a>
              <span class="price"><em>$28</em>$20</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="product-details.jsp"><i style="margin-top: 30%" class=" fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="item">
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/trending-02.jpg" alt=""></a>
              <span class="price">$44</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="item">
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/trending-03.jpg" alt=""></a>
              <span class="price"><em>$64</em>$44</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="product-details.jsp"><i style="margin-top: 30%" class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="item">
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/trending-04.jpg" alt=""></a>
              <span class="price">$32</span>
            </div>
            <div class="down-content">
              <span class="category">Action</span>
              <h4>Assasin Creed</h4>
              <a href="product-details.jsp"><i style="margin-top: 30%" class=" fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="section most-played">
    <div class="container">
      <div class="row">
        <div class="col-lg-6">
          <div class="section-heading">
            <h6>TOP GAMES</h6>
            <h2>Most Played</h2>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="main-button">
            <a href="shop.jsp">View All</a>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6">
          <div class="item">
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/top-game-01.jpg" alt=""></a>
            </div>
            <div class="down-content">
              <span class="category">Adventure</span>
              <h4>Assasin Creed</h4>
              <a href="product-details.jsp">Explore</a>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6">
          <div class="item">
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/top-game-02.jpg" alt=""></a>
            </div>
            <div class="down-content">
              <span class="category">Adventure</span>
              <h4>Assasin Creed</h4>
              <a href="product-details.jsp">Explore</a>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6">
          <div class="item">
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/top-game-03.jpg" alt=""></a>
            </div>
            <div class="down-content">
              <span class="category">Adventure</span>
              <h4>Assasin Creed</h4>
              <a href="product-details.jsp">Explore</a>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6">
          <div class="item">
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/top-game-04.jpg" alt=""></a>
            </div>
            <div class="down-content">
              <span class="category">Adventure</span>
              <h4>Assasin Creed</h4>
              <a href="product-details.jsp">Explore</a>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6">
          <div class="item">
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/top-game-05.jpg" alt=""></a>
            </div>
            <div class="down-content">
              <span class="category">Adventure</span>
              <h4>Assasin Creed</h4>
              <a href="product-details.jsp">Explore</a>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6">
          <div class="item">
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/top-game-06.jpg" alt=""></a>
            </div>
            <div class="down-content">
              <span class="category">Adventure</span>
              <h4>Assasin Creed</h4>
              <a href="product-details.jsp">Explore</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="section categories">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <div class="section-heading">
            <h6>Categories</h6>
            <h2>Top Categories</h2>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/categories-01.jpg" alt=""></a>
            </div>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/categories-05.jpg" alt=""></a>
            </div>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/categories-03.jpg" alt=""></a>
            </div>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/categories-04.jpg" alt=""></a>
            </div>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="product-details.jsp"><img src="../../dashboard/asset/assets/images/categories-05.jpg" alt=""></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>


  <div class="separator wide"></div>

  <div class="actions-footer ">
    <div class="subscribe subscription-div">
      <div class="text">
        <div class="fa fa-send-o"></div>
        <div class="lines">
          <h3>Don't miss any offers and promotions!</h3>
          <span>And be the first to receive our private offers, newsletters and deals of the week</span>
        </div>
      </div>
      <a class="button">
        Sign Up!
      </a>
    </div>
  </div>

  <jsp:include page="/WEB-INF/layout/footer_container.jsp"></jsp:include>

 <jsp:include page="/WEB-INF/layout/java_script.jsp"></jsp:include>

</body>

</html>
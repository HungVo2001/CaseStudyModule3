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
              <form id="search" action="">
<%--                <input type="text" placeholder="Type Something" id='searchText' name="searchKeyword"--%>
<%--                  onkeypress="handle" />--%>
                <input  type="text"  placeholder="Type Something" id='searchText' name="kw" value="${pageable.getKw()}" onkeypress="handle">

<%--                <select name="product-type" id="">--%>
<%--                  <option value="-1">Search</option>--%>
<%--                  <c:forEach items="${productTypes}" var="p">--%>
<%--                    <option ${pageable.getProductType() == p.getId() ? 'selected' : ''} value="${p.getId()}">--%>
<%--                        ${p.getName()}--%>
<%--                    </option>--%>
<%--                  </c:forEach>--%>
<%--                </select>--%>
                <button class="btn btn-primary">Search</button>
                <!-- <button role="button">Search Now</button> -->
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="section trending">

              <ul class="trending-filter">
                <li>
                  <a class="is_active" href="/homes?kw=&product-type=1" data-filter="*">ACTION</a>
                </li>
                <li>
                  <a class="is_active" href="/homes?kw=&product-type=2" data-filter=".adv">LOGIC</a>
                </li>
                <li>
                  <a class="is_active" href="/homes?kw=&product-type=3" data-filter=".str">RACING</a>
                </li>
              </ul>
        <c:forEach items="${requestScope.products}" var="p" >
          <div class="col-lg-3 col-md-6">
            <div class="item">
              <div class="thumb">
                <a href="/product"><img src="${p.getImg()}" alt=""></a>
                <span class="price">${p.getPrice()}</span>
              </div>
              <div class="down-content">
                <span class="category">Action</span>
                <h4>${p.getName()}</h4>
                <a href="/product"><i style="margin-top: 30%" class=" fa fa-shopping-bag"></i></a>
              </div>
            </div>
          </div>
        </c:forEach>
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
            <a href="/shop">View All</a>
          </div>
        </div>
<<<<<<< HEAD
        <div class="col-lg-2 col-md-6 col-sm-6">
          <div class="item">
            <div class="thumb">
              <a href="/product"><img src="../../dashboard/asset/assets/images/top-game-01.jpg" alt=""></a>
            </div>
            <div class="down-content">
              <span class="category">Adventure</span>
              <h4>Assasin Creed</h4>
              <a href="/product">Explore</a>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6">
          <div class="item">
            <div class="thumb">
              <a href="/product"><img src="../../dashboard/asset/assets/images/top-game-02.jpg" alt=""></a>
            </div>
            <div class="down-content">
              <span class="category">Adventure</span>
              <h4>Assasin Creed</h4>
              <a href="/product">Explore</a>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6">
          <div class="item">
            <div class="thumb">
              <a href="/product"><img src="../../dashboard/asset/assets/images/top-game-03.jpg" alt=""></a>
            </div>
            <div class="down-content">
              <span class="category">Adventure</span>
              <h4>Assasin Creed</h4>
              <a href="/product">Explore</a>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6">
          <div class="item">
            <div class="thumb">
              <a href="/product"><img src="../../dashboard/asset/assets/images/top-game-04.jpg" alt=""></a>
            </div>
            <div class="down-content">
              <span class="category">Adventure</span>
              <h4>Assasin Creed</h4>
              <a href="/product">Explore</a>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6">
          <div class="item">
            <div class="thumb">
              <a href="/product"><img src="../../dashboard/asset/assets/images/top-game-05.jpg" alt=""></a>
            </div>
            <div class="down-content">
              <span class="category">Adventure</span>
              <h4>Assasin Creed</h4>
              <a href="/product">Explore</a>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6">
          <div class="item">
            <div class="thumb">
              <a href="/product"><img src="../../dashboard/asset/assets/images/top-game-06.jpg" alt=""></a>
            </div>
            <div class="down-content">
              <span class="category">Adventure</span>
              <h4>Assasin Creed</h4>
              <a href="/product">Explore</a>
            </div>
          </div>
        </div>
=======
        <c:forEach items="${requestScope.productAction}" var="p">
          <div class="col-lg-2 col-md-6 col-sm-6">
            <div class="item">
              <div class="thumb">
                <a href="/product"><img src="${p.getImg()}" alt=""></a>
              </div>
              <div class="down-content">
                <span class="category">ACTION</span>
                <h4>${p.getName()}</h4>
                <a href="/product">Explore</a>
              </div>
            </div>
          </div>
        </c:forEach>

<%--        <div class="col-lg-2 col-md-6 col-sm-6">--%>
<%--          <div class="item">--%>
<%--            <div class="thumb">--%>
<%--              <a href="/product"><img src="../../dashboard/asset/assets/images/top-game-03.jpg" alt=""></a>--%>
<%--            </div>--%>
<%--            <div class="down-content">--%>
<%--              <span class="category">Adventure</span>--%>
<%--              <h4>Assasin Creed</h4>--%>
<%--              <a href="/product">Explore</a>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <div class="col-lg-2 col-md-6 col-sm-6">--%>
<%--          <div class="item">--%>
<%--            <div class="thumb">--%>
<%--              <a href="/product"><img src="../../dashboard/asset/assets/images/top-game-04.jpg" alt=""></a>--%>
<%--            </div>--%>
<%--            <div class="down-content">--%>
<%--              <span class="category">Adventure</span>--%>
<%--              <h4>Assasin Creed</h4>--%>
<%--              <a href="/product">Explore</a>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <div class="col-lg-2 col-md-6 col-sm-6">--%>
<%--          <div class="item">--%>
<%--            <div class="thumb">--%>
<%--              <a href="/product"><img src="../../dashboard/asset/assets/images/top-game-05.jpg" alt=""></a>--%>
<%--            </div>--%>
<%--            <div class="down-content">--%>
<%--              <span class="category">Adventure</span>--%>
<%--              <h4>Assasin Creed</h4>--%>
<%--              <a href="/product">Explore</a>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <div class="col-lg-2 col-md-6 col-sm-6">--%>
<%--          <div class="item">--%>
<%--            <div class="thumb">--%>
<%--              <a href="/product"><img src="../../dashboard/asset/assets/images/top-game-06.jpg" alt=""></a>--%>
<%--            </div>--%>
<%--            <div class="down-content">--%>
<%--              <span class="category">Adventure</span>--%>
<%--              <h4>Assasin Creed</h4>--%>
<%--              <a href="/product">Explore</a>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--        </div>--%>
>>>>>>> origin/hung_dev
      </div>
    </div>
  </div>
  <div class="section most-played">
    <div class="container">
      <div class="row">
        <div class="col-lg-6">
          <div class="section-heading">
            <h6>Racing GAMES</h6>
            <h2>Pro Played</h2>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="main-button">
            <a href="/shop">View All</a>
          </div>
        </div>
        <c:forEach items="${requestScope.productLogic}" var="p">
          <div class="col-lg-2 col-md-6 col-sm-6">
            <div class="item">
              <div class="thumb">
                <a href="/product"><img src="${p.getImg()}" alt=""></a>
              </div>
              <div class="down-content">
                <span class="category">LOGIC</span>
                <h4>${p.getName()}</h4>
                <a href="/product">Explore</a>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
<%--  <div class="indies-container">--%>
<%--    <div class="character"></div>--%>
<%--    <div class="games">--%>
<%--      <div class="headline">--%>
<%--        <h2>Top indie games</h2>--%>
<%--        <a class="button button-secondary" href="/en/search/?cat[]=32" title="Top indie games">View all</a>--%>
<%--      </div>--%>
<%--      <div class="listing-games listing-slider">--%>
<%--        <div class="item">--%>
<%--          <a class="cover video is-playable played" href="https://www.instant-gaming.com/en/13993-buy-assetto-corsa-competizione-2023-gt-world-challenge-pack-pc-game-steam/">--%>
<%--            <picture>--%>
<%--              <img class="picture" data-src="https://gaming-cdn.com/images/products/13993/380x218/assetto-corsa-competizione-2023-gt-world-challenge-pack-pc-game-steam-cover.jpg?v=1689850800" alt="Assetto Corsa Competizione - 2023 GT World Challenge Pack" src="https://gaming-cdn.com/images/products/13993/380x218/assetto-corsa-competizione-2023-gt-world-challenge-pack-pc-game-steam-cover.jpg?v=1689850800" loading="lazy" onload="lazyLoadImage(this)">--%>
<%--            </picture>--%>
<%--            <video preload="none" loop="" muted="" playsinline="">--%>
<%--              <source src="https://gaming-cdn.com/videos/products/13993/800x450/assetto-corsa-competizione-2023-gt-world-challenge-pack-pc-game-steam-preview.webm?v=1681977774" type="video/webm">--%>
<%--            </video>--%>
<%--            <div class="discount">-23%</div>--%>
<%--          </a>--%>
<%--          <div class="information">--%>
<%--            <div class="text">--%>
<%--              <div class="name">--%>
<%--                <span class="dlc">DLC</span>--%>
<%--                <span class="title">Assetto Corsa Competizione - 2023 GT World Challenge Pack</span>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--            <div class="price">9.99€</div>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <div class="item">--%>
<%--          <a class="cover video is-playable played" href="https://www.instant-gaming.com/en/8256-buy-smalland-survive-the-wilds-pc-game-steam/">--%>
<%--            <picture>--%>
<%--              <img class="picture" data-src="https://gaming-cdn.com/images/products/8256/380x218/smalland-survive-the-wilds-pc-game-steam-cover.jpg?v=1689850800" alt="Smalland: Survive the Wilds" src="https://gaming-cdn.com/images/products/8256/380x218/smalland-survive-the-wilds-pc-game-steam-cover.jpg?v=1689850800" loading="lazy" onload="lazyLoadImage(this)">--%>
<%--            </picture>--%>
<%--            <video preload="none" loop="" muted="" playsinline="">--%>
<%--              <source src="https://gaming-cdn.com/videos/products/8256/800x450/smalland-survive-the-wilds-pc-game-steam-preview.webm?v=1680105720" type="video/webm">--%>
<%--            </video>--%>
<%--            <div class="discount">-46%</div>--%>
<%--          </a>--%>
<%--          <div class="information">--%>
<%--            <div class="text">--%>
<%--              <div class="name">--%>
<%--                <span class="title">Smalland: Survive the Wilds</span>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--            <div class="price">13.56€</div>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <div class="item">--%>
<%--          <a class="cover video is-playable played" href="https://www.instant-gaming.com/en/13889-buy-cassette-beasts-pc-game-steam/">--%>
<%--            <picture>--%>
<%--              <img class="picture" data-src="https://gaming-cdn.com/images/products/13889/380x218/cassette-beasts-pc-game-steam-cover.jpg?v=1689850800" alt="Cassette Beasts" src="https://gaming-cdn.com/images/products/13889/380x218/cassette-beasts-pc-game-steam-cover.jpg?v=1689850800" loading="lazy" onload="lazyLoadImage(this)">--%>
<%--            </picture>--%>
<%--            <video preload="none" loop="" muted="" playsinline="">--%>
<%--              <source src="https://gaming-cdn.com/videos/products/13889/800x450/cassette-beasts-pc-game-steam-preview.webm?v=1683636041" type="video/webm">--%>
<%--            </video>--%>
<%--            <div class="discount">-27%</div>--%>
<%--          </a>--%>
<%--          <div class="information">--%>
<%--            <div class="text">--%>
<%--              <div class="name">--%>
<%--                <span class="title">Cassette Beasts</span>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--            <div class="price">14.67€</div>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <div class="item">--%>
<%--          <a class="cover video" href="https://www.instant-gaming.com/en/4793-buy-barotrauma-pc-mac-game-steam/" title="buy Barotrauma Steam 17.29€">--%>
<%--            <picture>--%>
<%--              <img class="picture" data-src="https://gaming-cdn.com/images/products/4793/380x218/barotrauma-pc-mac-game-steam-cover.jpg?v=1689850800" alt="Barotrauma" src="https://gaming-cdn.com/images/products/4793/380x218/barotrauma-pc-mac-game-steam-cover.jpg?v=1689850800" loading="lazy" onload="lazyLoadImage(this)">--%>
<%--            </picture>--%>
<%--            <video preload="none" loop="" muted="" playsinline="">--%>
<%--              <source src="https://gaming-cdn.com/videos/products/4793/800x450/barotrauma-pc-mac-game-steam-preview.webm?v=1678190707" type="video/webm">--%>
<%--            </video>--%>
<%--            <div class="discount">-51%</div>--%>
<%--          </a>--%>
<%--          <div class="information">--%>
<%--            <div class="text">--%>
<%--              <div class="name">--%>
<%--                <span class="title">Barotrauma</span>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--            <div class="price">17.29€</div>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <a href="/en/search/?cat[]=32" class="listing-dummy" title="Top indie games - View all"></a>--%>
<%--      </div>--%>
<%--    </div>--%>
<%--  </div>--%>

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
              <a href="/product"><img src="../../dashboard/asset/assets/images/categories-01.jpg" alt=""></a>
            </div>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="/product"><img src="../../dashboard/asset/assets/images/categories-05.jpg" alt=""></a>
            </div>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="/product"><img src="../../dashboard/asset/assets/images/categories-03.jpg" alt=""></a>
            </div>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="/product"><img src="../../dashboard/asset/assets/images/categories-04.jpg" alt=""></a>
            </div>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="/product"><img src="../../dashboard/asset/assets/images/categories-05.jpg" alt=""></a>
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
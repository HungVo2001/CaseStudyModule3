<header class="header-area header-sticky">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <nav class="main-nav">
                    <!-- ***** Logo Start ***** -->
                    <a href="/homes" class="logo-ig">
                        <!-- <img src="assets/images/logo.png" alt="" style="width: 158px;"> -->
                    </a>
                    <!-- ***** Logo End ***** -->
                    <!-- ***** Menu Start ***** -->
                    <ul class="nav">
                        <li><a href="/homes" class="active">Home</a></li>
                        <li><a href="/shop">Our Shop</a></li>
                        <li><a href="/product">Product Details</a></li>
                        <li><a style="background-color: #ee626b; font-size: 15px; " href="/cart"><i
                                style="margin-top: 12px" class="icona fa fa-shopping-bag"></i></a></li>
                        <%--            <li><a href="/login">Sign In</a></li>--%>

                        <form class="d-flex">

                            <% if (session.getAttribute("user") != null) { %>
                            <div class="right-items">
                                <li><a href="/user">${sessionScope.user.getUsername()}</a></li>
                            </div>
                            <div class="right-items">
                                <li><a href="/logout">Logout</a></li>
                            </div>
                            <% } else {%>
                            <div class="right-items">
                                <li><a href="/login">Login</a></li>
                            </div>
                            <% } %>
                        </form>
                    </ul>
                    <a class='menu-trigger'>
                        <span>Menu</span>
                    </a>
                    <!-- ***** Menu End ***** -->
                </nav>
            </div>
        </div>
    </div>
</header>
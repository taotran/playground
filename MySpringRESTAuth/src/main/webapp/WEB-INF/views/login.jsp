<html>
<head>
    <title>HOMEPAGE</title>

    <script src="/js/jquery-1.11.1.js" ></script>
	<script src="/js/login.js" ></script>
	<script src="/js/bootstrap.js" ></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>


<div class="container">
	<div class="row">
    	<div class="container" id="formContainer">

          <form name="f" class="form-signin" id="login" role="form" action="login" method="POST">
            <h3 class="form-signin-heading">Please sign in</h3>
            <a href="#" id="flipToRecover" class="flipLink">
              <div id="triangle-topright"></div>
            </a>
            <%--<input type="text" class="form-control" name="loginEmail" id="loginEmail" placeholder="Email address" required autofocus>--%>
            <input type="text" class="form-control" name="username" value="">
            <input type="password" class="form-control" name="password" id="loginPass" placeholder="Password" required>
            <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
              <input name="submit" type="submit" value="Login" />
          </form>
    
          <form class="form-signin" id="recover" role="form">
            <h3 class="form-signin-heading">Enter email address</h3>
            <a href="#" id="flipToLogin" class="flipLink">
              <div id="triangle-topleft"></div>
            </a>
            <input type="email" class="form-control" name="loginEmail" id="loginEmail" placeholder="Email address" required autofocus>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Recover password</button>
          </form>

        </div> <!-- /container -->
	</div>
</div>

</body>
</html>

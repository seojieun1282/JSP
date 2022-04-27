<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>로그인페이지</title>

    	<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

	    <!-- Bootstrap core CSS -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		

        <!-- jquery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

        <!-- SimpleLightbox plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>

        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap Icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <!-- SimpleLightbox plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/bootstrap.css" rel="stylesheet" />
        <!-- Custom styles for this template -->
	    <link href="css/signin.css" rel="stylesheet"/>
   

  </head>
  <body class="text-center">
    
<main class="form-signin">
  <form method="post" action="joinAction.jsp">
    <a href="index.jsp" style="font-size: 40px; font-weight: bold; color: indianred; text-shadow: 1px 1px 1.2px midnightblue; text-decoration: none;">TEST</a>
    <h2 class="h3 mb-3 fw-normal">Sign up</h2>

    <div class="form-group">
      <input type="text" class="form-control" placeholder="ID" name="userID" maxlength="20">
    </div>
    <div class="form-group">
      <input type="password" class="form-control" placeholder="Password" name="userPassword" maxlength="20">
    </div>
    <div class="form-group">
		<input type="text" class="form-control" placeholder="Name" name="userName" maxlength="20">
	</div>
    <div class="form-group">
      <input type="email" class="form-control" placeholder="name@example.com" name="userEmail" maxlength="50">
    </div>
    <div class="form-group" style="text-align: center;">
				<div class="btn-group" data-toggle="buttons">
					<label class="btn btn-primary active">
						<input type="radio" name="userGender" autocomplete="off" value="man" checked>man
					</label>
					<label class="btn btn-primary">
						<input type="radio" name="userGender" autocomplete="off" value="female" checked>female
					</label>
				</div>
	</div>
	
   
    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>
    <p class="mt-5 mb-3 text-muted"></p>
    <a class="mt-5 mb-3 text-muted" href="login.jsp" style="font-size: 20px; font-weight: bold; text-decoration: none;"><span style="border-bottom: 12px solid #dcf1fb; padding: 0 0 0 0.2em;">Sign in</span></a>
    <p class="mt-5 mb-3 text-muted">&copy; 2018-2021</p>
  </form>
</main>


    
  </body>
</html>

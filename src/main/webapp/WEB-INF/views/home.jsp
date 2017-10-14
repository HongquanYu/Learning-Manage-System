
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="<%=request.getContextPath()%>/resources/css/style_home.css"
  rel="stylesheet" type="text/css">
  </head>



  <body>
   
      <div class="container">
<!--navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><img src="<%=request.getContextPath()%>/resources/background/logo.png"></a>
 
    
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
     <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         Course
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Course1</a>
          <a class="dropdown-item" href="#">Course2</a>
          <a class="dropdown-item" href="#">Course3</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Messages</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="#">Grades</a>
      </li>
        <li class="nav-item">
        <a class="nav-link " href="#">Profile</a>
        </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
  </div>  
</nav>
 
    <div class="row">
           <div class="col-6 col-md-3">    
              <div class="list-group">
                  <span class=""></span>
  <div class="alert alert-danger" role="alert">
  New Assignment!!
</div>
  <a href="#" class="list-group-item list-group-item-action">Assignment2 <small class="text-muted">1 days later</small></a>
  <a href="#" class="list-group-item list-group-item-action">Assignment3<small class="text-muted">1 days later</small></a>
  <a href="#" class="list-group-item list-group-item-action">Assignment3<small class="text-muted">1 days later</small></a>
  <a href="#" class="list-group-item list-group-item-action">Assignment4<small class="text-muted">1 days later</small></a>
</div>


        </div>        
    
          <div class="col col-6 col-md-5">
              <div class="col">
                <div class="card" style="width: 26rem;">
                        <div class="card-body">
            <h4 class="card-title">ENPM613</h4>
            <p class="card-text">Software Design and implementation</p>
            <a href="#" class="btn btn-success">Enter the course</a>
                        </div>
                </div>
                </div>
          
            <div class="col">
              <div class="card" style="width: 26rem;">
                <div class="card-body">
                    <h4 class="card-title">ENPM613</h4>
                    <p class="card-text">Software Design and implementation</p>
                    <a href="#" class="btn btn-success">Enter the course</a>
                </div>
                </div>
            </div>
              
           <div class="col">
              <div class="card" style="width: 26rem;">
                <div class="card-body">
                    <h4 class="card-title">ENPM613</h4>
                    <p class="card-text">Software Design and implementation</p>
                    <a href="#" class="btn btn-success">Enter the course</a>
                </div>
                </div>
            </div>
        </div>
      
       <div class="col-6 col-md-4" >
           <a href="#"><span class="glyphicon glyphicon-envelope"></span></a>
                <div class="alert alert-warning" role="alert">
  New Messages!!
</div>
           
           
           <div class="list-group" >
  
               <a href="#" class="list-group-item 
               list-group-item-info list-group-item-action flex-column align-items-start active" >
    <div class="d-flex w-100 justify-content-between" >
      <h5 class="mb-2">From Ioana Rus</h5>
      <small>3 days ago</small>
    </div>
    <p class="mb-1">Hello Everyone,
Please remember to sign up for the Software development project teams, BEFORE submitting the first team assignment, so the team assignments will be .......</p>
  </a>
  
               
    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-2">From Emily</h5>
      <small class="text-mute">3 days ago</small>
    </div>
    <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
  </a>
                
               <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-2">From Emma</h5>
      <small class="text-mute">3 days ago</small>
    </div>
    <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
  </a>
                 
 
</div>
                </div>
                </div>
           

        </div>      
      
      <div class="row">
          
          
          
      </div> 
      <div class="panel-footer" align="center">
    <font size="1">Copyright @2017 <a>ezcomm.umd.com</a>,
      All Rights Reserved.
    </font>
  </div>

     <!--  <footer>
      <div class="footer" >
<p class="foot">© 2017 ezcomm.umd.com, All Rights Reserved.</p>

          </div> -->
      </footer>
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
      <script src="sty.jsp"></script>
  </body>
</html>
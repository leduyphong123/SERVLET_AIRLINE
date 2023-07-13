<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <!-- Font Awesome -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
  <!-- MDB -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet"/>
  <style>
    body {
      background-color: #fbfbfb;
    }

    @media (min-width: 991.98px) {
      main {
        padding-left: 240px;
      }
    }

    /* Sidebar */
    .sidebar {
      position: fixed;
      top: 0;
      bottom: 0;
      left: 0;
      padding: 58px 0 0;
      /* Height of navbar */
      box-shadow: 0 2px 5px 0 rgb(0 0 0 / 5%), 0 2px 10px 0 rgb(0 0 0 / 5%);
      width: 240px;
      z-index: 600;
    }

    @media (max-width: 991.98px) {
      .sidebar {
        width: 100%;
      }
    }

    .sidebar .active {
      border-radius: 5px;
      box-shadow: 0 2px 5px 0 rgb(0 0 0 / 16%), 0 2px 10px 0 rgb(0 0 0 / 12%);
    }

    .sidebar-sticky {
      position: relative;
      top: 0;
      height: calc(100vh - 48px);
      padding-top: 0.5rem;
      overflow-x: hidden;
      overflow-y: auto;
      /* Scrollable contents if viewport is shorter than content. */
    }
  </style>
</head>

<body>
<!--Main Navigation-->
<header>
  <!-- Sidebar -->
  <nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse bg-white">
    <div class="position-sticky">
      <div class="list-group list-group-flush mx-3 mt-4">
        <a href="#" class="list-group-item list-group-item-action py-2 ripple " aria-current="true">
          <i class="fas fa-tachometer-alt fa-fw me-3"></i><span>Main dashboard</span>
        </a>
        <a href="/city" class="list-group-item list-group-item-action py-2 ripple">
          <i class="fas fa-chart-area fa-fw me-3"></i><span>City</span>
        </a>
        <a href="/airline" class="list-group-item list-group-item-action py-2 ripple"><i
                class="fas fa-lock fa-fw me-3"></i><span>AirLine</span></a>
        <a href="/airplane" class="list-group-item list-group-item-action py-2 ripple"><i
                class="fas fa-chart-line fa-fw me-3"></i><span>AirPlane</span></a>
        <a href="/chair" class="list-group-item list-group-item-action py-2 ripple active"><i
                class="fas fa-chart-line fa-fw me-3"></i><span>Chair</span></a>
        <a href="/airplaneChair" class="list-group-item list-group-item-action py-2 ripple"><i
                class="fas fa-chart-line fa-fw me-3"></i><span>Airplane Chair</span></a>
        <a href="/flight" class="list-group-item list-group-item-action py-2 ripple"><i
                class="fas fa-chart-line fa-fw me-3"></i><span>Flight</span></a>

      </div>
    </div>
  </nav>
  <!-- Sidebar -->

  <!-- Navbar -->
  <nav id="main-navbar" class="navbar navbar-expand-lg navbar-light bg-white fixed-top">
    <!-- Container wrapper -->
    <div class="container-fluid">
      <!-- Toggle button -->
      <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#sidebarMenu"
              aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <i class="fas fa-bars"></i>
      </button>

      <!-- Brand -->
      <a class="navbar-brand" href="#">
        <img src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp" height="25"
             alt="MDB Logo" loading="lazy"/>
      </a>
      <!-- Search form -->
      <form class="d-none d-md-flex input-group w-auto my-auto">
        <input autocomplete="off" type="search" class="form-control rounded"
               placeholder='Search (ctrl + "/" to focus)' style="min-width: 225px;"/>
        <span class="input-group-text border-0"><i class="fas fa-search"></i></span>
      </form>

      <!-- Right links -->
      <ul class="navbar-nav ms-auto d-flex flex-row">

        <!-- Avatar -->
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle hidden-arrow d-flex align-items-center" href="#"
             id="navbarDropdownMenuLink" role="button" data-mdb-toggle="dropdown" aria-expanded="false">
            <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img (31).webp" class="rounded-circle"
                 height="22" alt="Avatar" loading="lazy"/>
          </a>
          <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownMenuLink">
            <li>
              <a class="dropdown-item" href="#">My profile</a>
            </li>
            <li>
              <a class="dropdown-item" href="#">Settings</a>
            </li>
            <li>
              <a class="dropdown-item" href="#">Logout</a>
            </li>
          </ul>
        </li>
      </ul>
    </div>
    <!-- Container wrapper -->
  </nav>
  <!-- Navbar -->
</header>
<!--Main Navigation-->

<!--Main layout-->
<main style="margin-top: 58px;">
  <div class="container pt-4 ">
    <div class="row justify-content-center">
      <h2 class="col-12 text-center py-4 bg-body rounded shadow-sm text-info">Chair manager</h2>
      <div class="col-12 my-4">
        <a class="btn btn-success" href="/city" role="button">List chair</a>

      </div>
      <div class="col-12 py-5 bg-body shadow-sm">
        <h3 class="my-3 text-center">Edit Chair</h3>

        <div class="row justify-content-center">


          <div class="col-8">
            <form action="/chair?aution=edit&id=${element.getId()}" method="post">
              <div class="form-outline mt-3">
                <input type="text" id="name" name="name" class="form-control" value="${element.getName()}"/>
                <label class="form-label" for="name">Name</label>
              </div>
              <div class="button-submit text-center mt-3">
                <button type="submit" class="btn btn-primary btn-rounded mt-3 ">Update</button>
              </div>
            </form>
          </div>

          <div class="col-6 p-2 m-0">
            <c:if test="${success}">
              <c:choose>
                <c:when test="${success == true}">
                  <div class="alert alert-success p-2 m-0" id="mesenger" role="alert">
                    Edit city success
                  </div>
                  <script>
                    var clearMesenger = setTimeout(()=>{
                      var mesenger = document.getElementById("mesenger");
                      mesenger.style.visibility = "hidden"
                    },1000)
                  </script>
                </c:when>
                <c:otherwise>
                  <div class="alert alert-warning p-2 m-0" id="mesenger" role="alert">
                    Name char 50, Quantity min 0
                  </div>
                  <script>
                    var clearMesenger = setTimeout(()=>{
                      var mesenger = document.getElementById("mesenger");
                      mesenger.style.visibility = "hidden"
                    },1000)
                  </script>
                </c:otherwise>
              </c:choose>
            </c:if>
          </div>

        </div>
      </div>
    </div>

  </div>

</main>
<!--Main layout-->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<!-- MDB -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>


</body>

</html>
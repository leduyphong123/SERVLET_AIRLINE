<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <!-- Font Awesome -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
  <!-- MDB -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet" />
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

    .hiddenDate {
      visibility: hidden;
    }

    .wrap-or {
      margin-bottom: 13px;
      margin-left: 10px;
      margin-right: 10px;
    }

    .wrap-hour {
      font-size: 10px;
      text-align: center;
    }

    .or {
      border-bottom: 1px dashed red;
      width: 40px;
      padding: 0 5px;

    }

    .wrap-or-hidden {
      width: 80px;
    }

    .wrap-cusor {
      cursor: pointer;
    }

    .wrap-height {
      margin-top: 20px;
      height: 190px;
      border-left: 1px dashed red;
    }

    .wrap-hover-color {
      border: 1px solid rgb(193, 189, 189);
      height: 190px;
    }

    .wrap-hover-color:hover {
      border: 1px solid red;
    }

    .wrap-hidden-detail {
      visibility: hidden;

    }
  </style>
</head>

<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <!-- Container wrapper -->
  <div class="container">
    <!-- Navbar brand -->
    <a class="navbar-brand me-2" href="https://mdbgo.com/">
      <img src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp" height="16" alt="MDB Logo"
           loading="lazy" style="margin-top: -1px;" />
    </a>

    <!-- Toggle button -->
    <button class="navbar-toggler" type="button" data-mdb-toggle="collapse"
            data-mdb-target="#navbarButtonsExample" aria-controls="navbarButtonsExample" aria-expanded="false"
            aria-label="Toggle navigation">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Collapsible wrapper -->
    <div class="collapse navbar-collapse" id="navbarButtonsExample">
      <!-- Left links -->
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="#">Ticket Booking</a>
        </li>
      </ul>
      <!-- Left links -->

      <div class="d-flex align-items-center">
        <a href="/login" type="button" class="btn btn-link px-3 me-2">
          Login
        </a>
        <a href="/register" type="button" class="btn btn-primary me-3">
          Sign up for free
        </a>

      </div>
    </div>
    <!-- Collapsible wrapper -->
  </div>
  <!-- Container wrapper -->
</nav>
<!-- Navbar -->
<div class="container mt-5 py-5">
  <div class="row justify-content-center p-5 bg-body shadow rounded border-info border">
    <div class="col-10 ">
      <form action="/booking?action=adminEdit&idBooking=${element.getId()}" method="post">
        <div class="d-flex justify-content-between mb-3">
          <div class="col-3">
            <div class="form-outline mt-3">
              <input type="text" id="firtName" name="firtName" class="form-control" />
              <label class="form-label" for="firtName">Firt name</label>
            </div>
          </div>
          <div class="col-3">
            <div class="form-outline mt-3">
              <input type="text" id="middleName" name="middleName" class="form-control" />
              <label class="form-label" for="middleName">Middle name</label>
            </div>
          </div>
          <div class="col-3">
            <div class="form-outline mt-3">
              <input type="text" id="lastName" name="lastName" class="form-control" />
              <label class="form-label" for="lastName">Last name</label>
            </div>
          </div>
        </div>
        <div class="d-flex justify-content-between mb-3">
          <div class="col-3">
            <div class="form-outline mt-3">
              <input type="text" id="email" name="email" class="form-control" />
              <label class="form-label" for="email">Email</label>
            </div>
          </div>
          <div class="col-3">
            <div class="form-outline mt-3">
              <input type="date" id="birthDate" name="birthDate" class="form-control" />
              <label class="form-label" for="birthDate">Birth day</label>
            </div>
          </div>
          <div class="col-3">
            <div class="form-outline mt-3">
              <input type="text" id="address" name="address" class="form-control" />
              <label class="form-label" for="address">Address</label>
            </div>
          </div>
        </div>

        <div class="button-submit text-center mt-3">
          <button type="submit" class="btn btn-primary btn-rounded mt-3 ">Edit</button>
        </div>
      </form>

    </div>
  </div>

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
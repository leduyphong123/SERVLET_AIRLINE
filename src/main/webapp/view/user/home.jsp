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
      <form action="/login" method="post">
        <div class="d-flex justify-content-between">
          <div class="col-3">
            <select class="form-select mt-3" aria-label="Default select example" name="formCity">
              <option value="${element.getId()}">${element.getName()}</option>
            </select>
          </div>
          <div class="col-3">
            <select class="form-select mt-3" aria-label="Default select example" name="toCity">
              <option value="${element.getId()}">${element.getName()}</option>
            </select>
          </div>
          <div class="col-3">
            <div class="form-outline mt-3">
              <input type="number" id="numberPeple" name="numberPeple" class="form-control" />
              <label class="form-label" for="numberPeple">No.of Passengers</label>
            </div>
          </div>
        </div>
        <div class="d-flex justify-content-center my-5">
          <div class="col-3">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="returnDateCheck" />
              <label class="form-check-label" for="returnDateCheck">Return Date</label>
            </div>

          </div>
        </div>
        <div class="d-flex justify-content-between">
          <div class="col-3">
            <div class="form-outline mt-3">
              <input type="date" id="formDate" name="formDate" class="form-control" />
              <label class="form-label" for="formDate">Departure Date</label>
            </div>
          </div>
          <div class="col-3">
            <div class="form-outline mt-3 hiddenDate" id="hiddenDate">
              <input type="date" id="returnDate" name="returnDate" class="form-control" />
              <label class="form-label" for="returnDate">Return Date</label>
            </div>
          </div>
          <div class="col-3">
            <select class="form-select mt-3" aria-label="Default select example" name="chairId">
              <option value="${element.getId()}">${element.getName()}</option>
            </select>
          </div>
        </div>
        <div class="button-submit text-center mt-3">
          <button type="submit" class="btn btn-primary btn-rounded mt-3 ">Search</button>
        </div>
      </form>
    </div>

  </div>
</div>
<script>
  var returnDateCheck = document.getElementById("returnDateCheck");
  returnDateCheck.addEventListener("change", () => {
    if (returnDateCheck.checked == true) {
      var hiddenDate = document.getElementById("hiddenDate");
      hiddenDate.style.visibility = "visible";
    } else {
      var hiddenDate = document.getElementById("hiddenDate");
      hiddenDate.style.visibility = "hidden";
    }
  })
</script>
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
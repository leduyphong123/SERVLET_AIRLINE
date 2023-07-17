
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
  <div class="row justify-content-center p-5 bg-body shadow rounded border-info border mb-3">
  <% int indes = 1;%>
    <c:forEach items="${searchFlightList}" var="element">
      <c:set var="formTime" scope="session" value="${element.getFlightFormDate().toString().split(' ')}"/>
      <c:set var="resultFormTime" scope="session" value="${formTime[1].substring(0,5)}"/>
      <c:set var="toTime" scope="session" value="${element.getFlightToDate().toString().split(' ')}"/>
      <c:set var="resultToTime" scope="session" value="${toTime[1].substring(0,5)}"/>
      <fmt:parseNumber var = "hourForm" type = "number" value = "${formTime[1].substring(0,2)}" />
      <fmt:parseNumber var = "minuteForm" type = "number" value = "${formTime[1].substring(3,5)}" />
      <fmt:parseNumber var = "hourTo" type = "number" value = "${toTime[1].substring(0,2)}" />
      <fmt:parseNumber var = "minuteTo" type = "number" value = "${toTime[1].substring(3,5)}" />
      <c:set  var="hour" scope="session" value="${hourTo - hourForm}" />
      <c:set  var="minute" scope="session" value="${minuteTo - minuteForm}" />
      <div class="col-10 p-4 rounded shadow mb-5 wrap-hover-color" id="wrapNewHidden-<%=indes%>">
        <div class="d-flex justify-content-between ">
          <div class="col-2">${element.getAirlineName()}</div>
          <div class="col-4">
            <div class="d-flex justify-content-center align-items-center">
              <div class="pr-2" id="formTime">${resultFormTime}</div>
              <div class="wrap-or">
                <div class="wrap-hour">${hour}h<c:choose>
                  <c:when test="${minute < 10 && minute >=0}">
                    <%=0%>${minute}
                  </c:when>
                  <c:otherwise>
                    ${minute}
                  </c:otherwise>
                </c:choose></div>
                <div class="or"></div>
              </div>
              <div class="pl-2">${resultToTime}</div>
            </div>
            <div class="d-flex justify-content-center align-items-center">
              <div class="pr-2 wrap-hour">${element.getFormCityShortName()}</div>
              <div class="wrap-or-hidden">
              </div>
              <div class="pl-2 wrap-hour">${element.getToCiTyShortName()}</div>
            </div>
          </div>
          <div class="col-2"><span class="text-danger">${element.getAirplaneChairPrice()}</span> vnd/guest</div>
        </div>
        <div class="d-flex justify-content-between mt-5">
          <div class="col-2 wrap-cusor" id="clickHidden" onclick="clickHidden(<%=indes%>)">
            Flight Details
          </div>
          <div class="col-2 wrap-cusor">
            Fare & Benefits
          </div>
          <div class="col-2 wrap-cusor">
            Refund
          </div>
          <a href="/flightDetail?id=${element.getFlighId()}" class="btn btn-primary col-2">Choose</a>
        </div>
        <div class="py-4 mt-5 d-flex justify-content-around bg-light border rounded wrap-hidden-detail"
             id="hiddenFlightDetails-<%=indes%>">
          <div class="col-1 text-center " style="font-size: 13px;">
            <div>${resultFormTime}</div>
            <div>${formTime[0].substring(5,10)}</div>
            <div style="height: 150px;"></div>
            <div>${resultToTime}</div>
            <div>${toTime[0].substring(5,10)}</div>
          </div>
          <div class="col-0 wrap-height"></div>
          <div class="col-9">
            <p class="text-uppercase">${element.getFormCityName()} ( ${element.getFormCityShortName()} )</p>
            <p>${element.getAirlineName()}</p>
            <p>${element.getAirlineShortName()}</p>
            <div class="d-flex justify-content-around">
              <div class="col-5" style="font-size: 13px;">
                <p> Baggage 0kg (buy at booking)</p>
                <p> Cabin baggage 7 kg</p>
              </div>
              <div class="col-5" style="font-size: 13px;">
                <p> ${element.getAirplaneName()}</p>
                <p> ${element.getAirplaneShortName()}</p>
              </div>
            </div>
            <p class="text-uppercase">${element.getToCityName()} ( ${element.getToCiTyShortName()} )</p>
          </div>
        </div>
      </div>
      <%indes+=1;%>
    </c:forEach>


  </div>

</div>
<script>
  var isHidden = true;
  function clickHidden(index){

    if (isHidden == true) {
      var hiddenFlightDetails = document.getElementById("hiddenFlightDetails-"+index)
      var wrapNewHidden = document.getElementById("wrapNewHidden-"+index);
      wrapNewHidden.style.height = "550px";
      hiddenFlightDetails.style.visibility = "visible";
    } else {
      var hiddenFlightDetails = document.getElementById("hiddenFlightDetails-"+index)
      var wrapNewHidden = document.getElementById("wrapNewHidden-"+index);
      wrapNewHidden.style.height = "190px";
      hiddenFlightDetails.style.visibility = "hidden";
    }
    isHidden = !isHidden;

  }

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
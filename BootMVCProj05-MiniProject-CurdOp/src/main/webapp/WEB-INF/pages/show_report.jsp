<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:red; text-align:center">Actors Report Page</h1>

<c:choose>
  <c:when test="${!empty listActors}">
    <table border="1" align="center" bgcolor="yellow">
      <tr bgcolor="green">
        <th>ActorId</th>
        <th>Actor Name</th>
        <th>Actor Address</th>
        <th>Actor Category</th>
        <th>Actor Fee</th>
      </tr>
      <c:forEach var="actor" items="${listActors}">
        <tr style="color:blue">
          <td>${actor.aid}</td>
          <td>${actor.aname}</td>
          <td>${actor.addrs}</td>
          <td>${actor.category}</td>
          <td>${actor.fee}</td>
          
          <td><a href="edit?no=${actor.aid}"><img src="images/edit.png" width="30px" height="30px">
          &nbsp; &nbsp;</a>
          <a href="delete?no=${actor.aid}" onclick="return confirm('R u sure u want to delete record?')"><img src="images/delete.png" width="30px" height="30px">
          &nbsp; &nbsp;</a></td>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <h1 style="color:red; text-align:center">No Record Found</h1>
  </c:otherwise>
</c:choose>

<br>


<c:if test="${!empty resultMsg}">
  <h1 style="color:green; text-align:center">${resultMsg}</h1>
  <br>
</c:if>

<h1 style="text-align:center">
  <a href="register">
    <img src="images/add.png" width="100" height="200"> Register Actor
  </a>
</h1>

<br><br>

<h1 style="text-align:center">
  <a href="./">
    <img src="images/home.png" width="100" height="200"> Home
  </a>
</h1>

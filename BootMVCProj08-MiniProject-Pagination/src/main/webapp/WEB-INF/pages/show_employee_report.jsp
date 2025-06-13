<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<c:choose>
  <c:when test="${!empty pageData}">
    <h1 style="color:red; text-align:center">Employees Report</h1>
    <table border="1" align="center" bgcolor="cyan">
      <tr style="color:red">
        <th>Emp No</th>
        <th>Emp Name</th>
        <th>Job</th>
        <th>Salary</th> 
        <th>Dept No</th>
       
      </tr>
      
      <c:forEach var="emp" items="${pageData.getContent()}">
        <tr style="color:blue">
          <td>${emp.empno}</td>
          <td>${emp.ename}</td>
          <td>${emp.job}</td>
          <td>${emp.sal}</td>
          <td>${emp.deptno}</td>
          
        </tr>
      </c:forEach>
    </table>
    <center> page no::${pageData.getNumber()+1}/${pageData.getTotalPages()}</center>
  <center> 
  <c:forEach var="i"  begin="1" end="${pageData.getTotalPages()}" step="1">
  
  [<a href="report?page=${i-1}">${i}</a>]&nbsp; &nbsp;
  
  </c:forEach>
  </center>
  </c:when>

  <c:otherwise>
    <h1 style="color:red; text-align:center">No Employees Found</h1>
  </c:otherwise>
</c:choose>
<h2 style="color:green; text-align:center">${resultMsg}</h2>
<center>
  <a href="emp_add">
    <img src="images/add.png" width="40" height="50" alt="Add"> Add Employee
  </a>
  &nbsp;&nbsp;
  <a href="./">
    <img src="images/home.png" width="40" height="40" alt="Home"> Home
  </a>
</center>

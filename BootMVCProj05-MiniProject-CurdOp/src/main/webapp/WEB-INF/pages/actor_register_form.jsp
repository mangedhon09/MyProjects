<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red; text-align:center">Actor Registration Page</h1>

<frm:form modelAttribute="actor">
  <table border="0" align="center" bgcolor="cyan">
    <tr>
      <td>Actor name:</td>
      <td><frm:input path="aname" /></td>
    </tr>
    <tr>
      <td>Actor Address:</td>
      <td><frm:input path="addrs" /></td>
    </tr>
    <tr>
      <td>Actor Category:</td>
      <td><frm:input path="category" /></td>
    </tr>
    <tr>
      <td>Actor Fee:</td>
      <td><frm:input path="fee" /></td>
    </tr>
    <tr>
      <td><input type="submit" value="Register" /></td>
      <td><input type="reset" value="Cancel" /></td>
    </tr>
  </table>
</frm:form>

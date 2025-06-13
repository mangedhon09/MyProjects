<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red; text-align:center">Actor Details Edit Page</h1>

<frm:form modelAttribute="actor">
  <table border="0" align="center" bgcolor="cyan">
    <tr>
      <td>Actor Id:</td>
      <td>
        <frm:input path="aid" disabled="true" />
      </td>
    </tr>
    <tr>
      <td>Actor Name:</td>
      <td>
        <frm:input path="aname" />
      </td>
    </tr>
    <tr>
      <td>Actor Address:</td>
      <td>
        <frm:input path="addrs" />
      </td>
    </tr>
    <tr>
      <td>Actor Category:</td>
      <td>
        <frm:input path="category" />
      </td>
    </tr>
    <tr>
      <td>Actor Fee:</td>
      <td>
        <frm:input path="fee" />
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="Edit Actor" />
        <input type="reset" value="Cancel" />
      </td>
    </tr>
  </table>
</frm:form>

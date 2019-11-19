<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.List"%>
<!DOCTYPE html>

<html>

<head>
    <title>User Activities</title>
    <link rel="stylesheet" href="mainpage.css">
    <script src="https://use.fontawesome.com/e54f0b343c.js"></script>

</head>

<body>
<div class="topmenu">
  <ul>
    <li><a>How Its Work ?</a></li>
    <li><a>Home</a></li>
    <li><a href="mainpage.jsp">Manage</a>
       <ul class="dropdown">
           <li><a href="basictable.jsp">Basic Table</a></li>
            <li><a href="emailservices.jsp">Email Services</a></li>
            <li><a href="socialmediaservices.jsp">Social Media Services</a></li>
            <li><a href="bankservices.jsp">Bank Services</a></li>
            <li><a href="telephonedirectory.jsp">Telephone Directory</a></li>
        </ul>  
      </li>
       <li><a>Profile</a>
        <ul class="dropdown">
            <li><a href="useractivities.jsp">User Activities</a></li>
            <li><a href="useractivities.jsp">User Settings</a></li>
        </ul>  
      </li>
    <li><a>Premium</a></li>
    <li id="exit"><a href="login.jsp">Exit</a></li>
  </ul>
</div>
    
<div class="butonAdd">
	<form action ="useractivities" method = "post" >
    <input type="submit" value="REFRESH" name="submit" class="butons">
    </form>
</div>
<div class="tables">
    <table>
        <tr>
            <th>id</th>
            <th id="#bankname">Type</th>
            <th id="ipadressbar">Operating System</th>
            <th id="ipadressbar">Browser</th>
            <th id="ipadressbar">İp Adress</th>
            <th id="datebar">Date</th>
            <th id="deletebar">DELETE</th>
            <th id="errorbar">!</th>
         </tr>
        <c:forEach items="${userLogsList}" var="UserLogs">
       		 <tr>
           	<td ><c:out value="${UserLogs.id}"/></td>
           	<td><c:out value="${UserLogs.userlogtype}"/></td>  
           	<td><c:out value="${UserLogs.userOs}"/></td>
            <td><c:out value="${UserLogs.userBrowser}"/></td> 
           	<td><c:out value="${UserLogs.userİpAdress}"/></td>  
           	<td><c:out value="${UserLogs.userLogDate}"/></td>  
           	<td><input type="button" name="submit" value="Edit"  class="myButtons"></td>
            <td><input type="button" name="submit" value = "Suspect" class="myButtons"></td>   	  
        </tr>
    	</c:forEach>
       
       
    </table>
</div>    
    
    

    
</body>

</html>
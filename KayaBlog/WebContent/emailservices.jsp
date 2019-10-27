<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.List"%>
<!DOCTYPE html>

<html>

<head>
    <title>Email Services</title>
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
            <li><a>Note Services</a></li>
            <li><a>To Do List</a></li>
            <li><a>Date Services</a></li>
        </ul>  
      </li>
       <li><a>Profile</a>
        <ul class="dropdown">
            <li><a href="useractivities.jsp">User Activities</a></li>
            <li><a href="useractivities.jsp">User Settings</a></li>
        </ul>  
      </li>
    <li><a>Premium</a></li>
    <li id="exit"><a>Exit</a></li>
  </ul>
</div>
    
<div class="butonAdd">
	<form action ="emailservices" method = "post" >
    <input type="submit" value="ADD" name="submit" class="butons">
    <input type="submit" value="REFRESH" name="submit" class="butons">
    </form>
</div>
<div class="tables">
    <table>
        <tr>
            <th id="idbar">id</th>
            <th id="typebar">Email Services</th>
            <th id="emailbar">Email Adress</th>
            <th id="passwordbar">Password</th>
            <th id="passwordbar">Explanation</th>
            <th id="editbar">EDİT</th>
            <th id="deletebar">DELETE</th>
         </tr>
         
         <c:forEach items="${emailList}" var="EmailTable">
       		<tr>
           	 	<td ><c:out value="${EmailTable.id}"/></td>
           	 	<td><c:out value="${EmailTable.userEmailType}"/></td>  
           	 	<td><c:out value="${EmailTable.userEmailServicesAdress}"/></td>
                <td><c:out value="${EmailTable.userEmailServicesPass}"/></td> 
           	 	<td><c:out value="${EmailTable.userEmailServicesExplana}"/></td>  
           	 	<td><input type="button" name="submit" value="Edit"  class="myButtons"></td>
          	  	<td><input type="button" name="submit" value = "Delete" class="myButtons"></td> 
          	  
        	</tr>
    	</c:forEach>
       
       
    </table>
</div>    
    
    
<footer class="footer">
   <p><i>Copyright © 2019 Kaya Web Services Company, All Right Reserved</i></p>
    
</footer>    
    
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.List"%>
<!DOCTYPE html>

<html>

<head>
    <title>Bank Services</title>
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
	<form action ="mainpage" method = "post" >
    <input type="submit" value="ADD" name="submit" class="butons">
    <input type="submit" value="REFRESH" name="submit" class="butons">
    </form>
</div>
<div class="tables">
    <table>
        <tr>
            <th id="idbar">id</th>
            <th id="emailbar">Phone Number Type</th>
            <th id="emailbar">Phone Owner Name</th>
            <th id="ipadressbar">Phone Number</th>
            <th id="ipadressbar">Explanations</th>   
            <th id="editbar">EDİT</th>
            <th id="deletebar">DELETE</th>
         </tr>
         <tr>
           	<td ><c:out value="${BasicTable.userid}"/></td>
           	<td><c:out value="${BasicTable.userShowEmail}"/></td>
            <td><c:out value="${BasicTable.userShowEmail}"/></td> 
            <td><c:out value="${BasicTable.userShowEmail}"/></td> 
           	<td><c:out value="${BasicTable.userShowpassword}"/></td>   
           	<td><input type="button" name="submit" value="Edit"  class="myButtons"></td>
            <td><input type="button" name="submit" value = "Delete" class="myButtons"></td>   	  
        </tr>
       
       
    </table>
</div>    
    
    
<footer class="footer">
   <p><i>Copyright © 2019 Kaya Web Services Company, All Right Reserved</i></p>
    
</footer>    
    
</body>

</html>
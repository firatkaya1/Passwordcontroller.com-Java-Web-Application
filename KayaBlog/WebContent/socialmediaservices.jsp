<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.List"%>
<!DOCTYPE html>

<html>

<head>
    <title>Social Media Services</title>
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
    <li id="exit"><a href="login.jsp">Exit</a></li>
  </ul>
</div>
    
<div class="butonAdd">
	<form action ="socialmediaservices" method = "post" >
    <input type="submit" value="ADD" name="submit" class="butons">
    <input type="submit" value="REFRESH" name="submit" class="butons">
    </form>
</div>
<div class="tables">
    <table>
        <tr>
            <th>id</th>
            <th id="socialmedia">Social Media</th>
            <th id="ipadressbar">Social Media's Email</th>
            <th id="ipadressbar">Social Media's Username</th>   
            <th id="ipadressbar">Social Media's Password</th>
            <th id="datebar">Explanations</th>
            <th id="editbar">EDİT</th>
            <th id="deletebar">DELETE</th>
         </tr>
         <c:forEach items="${socialMediaList}" var="SocialMediaTable">
       		 <tr>
           	<td ><c:out value="${SocialMediaTable.id}"/></td>
           	<td><c:out value="${SocialMediaTable.socialMediaType}"/></td>  
           	<td><c:out value="${SocialMediaTable.socialMediaEmail}"/></td>
            <td><c:out value="${SocialMediaTable.socialMediaUsername}"/></td> 
           	<td><c:out value="${SocialMediaTable.socialMediaPassword}"/></td>  
           	<td><c:out value="${SocialMediaTable.socialMediaExplanation}"/></td>  
           	<td><input type="button" name="submit" value="Edit"  class="myButtons"></td>
            <td><input type="button" name="submit" value = "Suspect" class="myButtons"></td>   	  
        </tr>
    	</c:forEach>
       
       
    </table>
</div>    
    
    
<footer class="footer">
   <p><i>Copyright © 2019 Kaya Web Services Company, All Right Reserved</i></p>
    
</footer>    
    
</body>

</html>
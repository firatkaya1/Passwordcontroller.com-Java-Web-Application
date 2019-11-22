<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.List"%>
<!DOCTYPE html>

<html>

<head>
    <title>Social Media Services</title>
    <link rel="stylesheet" href="mainpage.css">
    <link rel="shortcut icon" href="img/logo.png">
    <script src="https://use.fontawesome.com/e54f0b343c.js"></script>

</head>

<body>
<div class="topmenu">
        <ul>
            <li><a href="howitsworks.jsp" >How Its Work ?</a></li>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="mainpage.jsp">Manage</a>
                <ul class="dropdown">
                    <li><a href="basictable.jsp">Basic Table</a></li>
                    <li><a href="emailservices.jsp">Email Services</a></li>
                    <li><a href="socialmediaservices.jsp" id="here">Social Media Services</a></li>
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
            <li><a href="premium.jsp">Premium<div class="premiumicon"></div></a></li>
            <li id="exit"><a href="login.jsp">Exit</a></li>
        </ul>
    </div>
    
<div class="butonAdd">
	
    	<input type="submit" value="ADD" name="addbutton" class="butons" id="addbutton">
    <form action ="socialmediaservices" method = "post" >
    	<input type="submit" value="REFRESH" name="Submit" class="butons">
    </form>
</div>
<div class="tables">
    <table  id="myTable">
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
           	<td class="usershowpassword"><input type="password" readonly class="passwordfield" value="${SocialMediaTable.socialMediaPassword}">
           	<input type="submit" value="" class="seePass" id ="${SocialMediaTable.id}" >
           	
           	</td>  
           	<td><c:out value="${SocialMediaTable.socialMediaExplanation}"/></td>  
           	<td><input type="button" name="Submit" value="Edit"  class="myButtons" id="${SocialMediaTable.id}"></td>
            <td><form action ="socialmediaservices" method = "post" >
          	  		<input type="submit" name="Submit" value = "DELETE" class="myButtons1">
          	  		<input type="hidden" name="valueofid" value = "${SocialMediaTable.id}" class="myButtons1">
          	  	</form>
          	</td>   	  
        </tr>
    	</c:forEach>
    </table>
</div>    

<div id="modal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h2 class="addTitle">Social Media Services</h2>
    </div>
      
    <div class="modal-body">
       		<form action ="socialmediaservices" method = "post" >
       		<i style = "color:red;font-size: 14px;">*All field can not be blank.</i>
            <h4>İd</h4><input type="text" readonly id="userid">
            <h4>Social Media</h4><input type="text" id="socialmediaType" name = "socialmediaType">
            <h4>Social Media's Email</h4><input type="email" name ="socialmediaEmail" id="socialmediaEmail">
            <h4>Social Media's Username</h4><input type="text" name="socialmediausername" id="socialmediausername">
            <h4>Social Media's Password</h4><input type="password" name="socialmediapassword" id="socialmediapassword" class="password1" >
            <h4>Choose Your Encrypt Algorithms</h4>
                    <div>
                        <select id="typeofencrypt" onchange="mySelectBox()" class="selectedarea">
                    <option value="None">None</option>
                    <option value="MD-5">MD-5</option>
                    <option value="SHA-256">SHA-256</option>
                    <option value="Special-One">Special-One</option>
                    <option value="Special-Two">Special-Two</option>
                    <option value="God">God</option>
                    <option value="Hard">Hard</option>
                    <option value="Dont Choose Me!">Dont Choose Me!</option>
                </select>
                        <input type="text" name="typeofmyencrypt" id="typeofmyencrypttext" readonly>
                    </div>
            <h4>Explanations</h4><input type="text" name="socialmediaexp" id="socialmediaexp" >
            	<input type="Submit" name="Submit" value="SAVE" class="savebutton" > 
        	</form> 
    </div>      
</div>

<script src="js/popupsocialmedia.js"></script> 

</div>    
    
<div id="modalUpdate" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span  class="close">&times;</span>
      <h2 class="addTitle">Socail Media Services</h2>
    </div>
      
    <div class="modal-body">
       		<form action ="socialmediaservices" method = "post" >
            <h4>İd</h4><input type="text" readonly id="useridUpdate" name="useridUpdate">
            <h4>Social Media</h4><input type="text" name="socialmediaTypeUpdate" id="socialmediaTypeUpdate">
            <h4>Social Media's Email</h4><input type="email" name ="socialmediaEmailUpdate" id="socialmediaEmailUpdate">
            <h4>Social Media's Username</h4><input type="text" name ="socialmediausernameUpdate" id="socialmediausernameUpdate">
            <h4>Social Media's Password</h4><input type="password" name="socialmediapasswordUpdate" id="socialmediapasswordUpdate" class="password1" >
            <h4>Explanations</h4><input type="text" name="socialmediaexpUpdate" id="socialmediaexpUpdate" >
            	<input type="Submit" name="Submit" value="UPDATE" class="savebutton" > 
            	
        	</form> 
    </div>      
</div>
<script src="js/popupsocialmedia.js">
</script> 
</div>     
    
   
    
</body>

</html>
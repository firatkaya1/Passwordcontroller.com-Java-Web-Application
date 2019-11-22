<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.List"%>
<!DOCTYPE html>

<html>

<head>
    <title>Basic Table</title>
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
                    <li><a href="basictable.jsp" id="here">Basic Table</a></li>
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
            <li><a href="premium.jsp">Premium<div class="premiumicon"></div></a></li>
            <li id="exit"><a href="login.jsp">Exit</a></li>
        </ul>
    </div>
    
<div class="butonAdd">
        <input type="submit" value="ADD" name="addbutton" class="butons" id="addbutton">
        	<form action ="basictables" method = "post" >
            <input type="Submit"  name="Submit" value="REFRESH" class="butons" >
    		</form> 
    </div>



<div class="tables">
    <table id="myTable">
        <tr>
            <th id="idbar">id</th>
            <th id="typebar">type</th>
            <th id="emailbar">Email</th>
            <th id="userbar">Username</th>
            <th id="passwordbar">Password</th>
            <th>Explanation</th>
            <th id="editbar">EDİT</th>
            <th id="deletebar">DELETE</th>
         </tr>
        
        <c:forEach items="${tableBasicList}" var="BasicTable">
       		<tr>
       			
           	 	<td><c:out value="${BasicTable.userid}"/></td>
           	 	<td class="xxusershowtype"><c:out value="${BasicTable.userShowtype}" /></td>  
           	 	<td class="xxusershowemail"><c:out value="${BasicTable.userShowEmail}" /></td>
                <td class="usershowusername"><c:out value="${BasicTable.userShowUsername}" /></td> 
           	 	<td class="usershowpassword"><input type="password" readonly class="passwordfield" value="${BasicTable.userShowpassword}">
           	 	<input type="submit" value="" class="seePass" id ="${BasicTable.userid}" >
           	 	</td>  
           	 	<td class="usershowexpl"><c:out value="${BasicTable.userShowExplanation}" /></td>  
           	 	<td>          	 		
           	 		<input type="submit" name="Submit" value="EDİT" class="myButtons" id="${BasicTable.userid}">
           	 	</td>
          	  	<td>
          	  	<form action ="basictables" method = "post" >
          	  		<input type="submit" name="Submit" value = "DELETE" class="myButtons1">
          	  		<input type="hidden" name="userid" value = "${BasicTable.userid}" class="myButtons1">
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
      <h2 class="addTitle">Basic Table</h2>
    </div>
      
    <div class="modal-body">
       		<form action ="basictables" method = "post" >
       		<i style = "color:red;font-size: 14px;">*All field can not be blank.</i>
            <h4>İd</h4><input type="text" readonly id="userid">
            <h4>Type</h4><input type="text" name="typeEmail" id="emailType">
            <h4>Email</h4><input type="text" name ="email" id="emailAdress">
            <h4>Username</h4><input type="text" name="username" id="username">
            <h4>Password</h4><input type="text" name="password" id="password" >
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
                        <input type="text" name="typeofmyencrypt" id="typess" readonly>
                    </div>
            <h4>Explanations</h4><input type="text" name="explanations" id="explanations" >
            	<input type="Submit" name="Submit" value="SAVE" class="savebutton" > 
        	</form> 
    </div>      
</div>

<script src="js/popup.js"></script> 

</div>


<div id="modalUpdate" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span  class="close">&times;</span>
      <h2 class="addTitle">Basic Table</h2>
    </div>
      
    <div class="modal-body">
       		<form action ="basictables" method = "post" >
            <h4>İd</h4><input type="text" readonly id="userid1" name="userid1">
            <h4>Type</h4><input type="text" name="emailType1" id="emailType1">
            <h4>Email</h4><input type="email" name ="emailAdress1" id="emailAdress1">
            <h4>Username</h4><input type="text" name="username1" id="username1">
            <h4>Password</h4><input type="password" name="password1" id="password1" class="password1" >
            <h4>Explanations</h4><input type="text" name="explanations1" id="explanations1" >
            	<input type="Submit" name="Submit" value="UPDATE" class="savebutton" > 
            	
        	</form> 
    </div>      
</div>
<script src="js/popup.js">
</script> 
</div>



  
    
</body>

</html>
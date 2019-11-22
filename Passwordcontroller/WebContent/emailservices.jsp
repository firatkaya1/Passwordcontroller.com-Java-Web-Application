<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <li><a href="howitsworks.jsp" >How Its Work ?</a></li>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="mainpage.jsp">Manage</a>
                <ul class="dropdown">
                    <li><a href="basictable.jsp">Basic Table</a></li>
                    <li><a href="emailservices.jsp" id="here">Email Services</a></li>
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
			<input type="submit" value="ADD" name="addbutton" class="butons" id="addbutton">
	<form action ="emailservices" method = "post" >
    		<input type="submit" name="Submit" value="REFRESH"  class="butons">
    </form>
</div>
<div class="tables">
    <table id="myTable">
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
                <td class="usershowpassword"><input type="password" readonly class="passwordfield" value="${EmailTable.userEmailServicesPass}">
           	 	<input type="submit" value="" class="seePass" id ="${EmailTable.id}" >
           	 	</td> 
           	 	<td><c:out value="${EmailTable.userEmailServicesExplana}"/></td>  
           	 	<td><input type="submit" name="Submit" value="EDİT"  class="myButtons" id="${EmailTable.id}"></td>
          	  	<td>
          	  		<form action="emailservices" method="post">
          	  		<input type="submit" name="Submit" value = "DELETE" class="myButtons">
          	  		<input type="hidden" name="valueofid" value = "${EmailTable.id}">
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
      <h2 class="addTitle">Email Services</h2>
    </div>
      
    <div class="modal-body">
       		<form action ="emailservices" method = "post" >
       		<i style = "color:red;font-size: 14px;">*All field can not be blank.</i>
            <h4>İd</h4><input type="text" readonly id="userid">
            <h4>Email Services</h4><input type="text" name="emailServices" id="emailServices">
            <h4>Email Adress</h4><input type="text" name ="emailAdress" id="emailAdress">
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
                        <input type="text" name="typeofmyencrypttext" id="typeofmyencrypttext" readonly>
                    </div>
            <h4>Explanations</h4><input type="text" name="explanations" id="explanations" >
            	<input type="Submit" name="Submit" value="SAVE" class="savebutton" > 
        	</form> 
    </div>      
</div>

<script src="js/popupemailtable.js">
</script> 
</div>    
    
<div id="modalUpdate" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span  class="close">&times;</span>
      <h2 class="addTitle">Email Services</h2>
    </div>
      
    <div class="modal-body">
       		<form action ="emailservices" method = "post" >
            <h4>İd</h4><input type="text" readonly id="useridUpdate" name="useridUpdate">
            <h4>Email Services</h4><input type="text" name="emailServicesUpdate" id="emailServicesUpdate">
            <h4>Email Adress</h4><input type="email" name ="emailAdressUpdate" id="emailAdressUpdate">
            <h4>Password</h4><input type="password" name="passwordUpdate" id="passwordUpdate" class="password1" >
            <h4>Explanations</h4><input type="text" name="explanationsUpdate" id="explanationsUpdate" >
            	<input type="Submit" name="Submit" value="UPDATE" class="savebutton" > 
            	
        	</form> 
    </div>      
</div>
<script src="js/popupemailtable.js">
</script> 
</div>    
    
  
    
</body>

</html>
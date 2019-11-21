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
    <li><a href="home.jsp">Home</a></li>
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
		<input type="submit" value="ADD" name="addbutton" class="butons" id="addbutton">
	<form action ="telephonedirectory" method = "post" >
    	<input type="submit" value="REFRESH" name="Submit" class="butons">
    </form>
</div>
<div class="tables">
    <table id = "myTable">
        <tr>
            <th id="idbar">id</th>
            <th id="emailbar">Phone Number Type</th>
            <th id="emailbar">Phone Owner Name</th>
            <th id="ipadressbar">Phone Number</th>
            <th id="ipadressbar">Explanations</th>   
            <th id="editbar">EDİT</th>
            <th id="deletebar">DELETE</th>
         </tr>
         <c:forEach items="${tableTelephoneDirectoryList}" var="TelephoneDirectoryTable">
       		<tr>
           	 	<td><c:out value="${TelephoneDirectoryTable.id}"/></td>
           	 	<td class="xxusershowtype"><c:out value="${TelephoneDirectoryTable.phonenumbertype}" /></td>  
           	 	<td class="xxusershowemail"><c:out value="${TelephoneDirectoryTable.phoneownername}" /></td>
                <td class="usershowusername"><c:out value="${TelephoneDirectoryTable.phonenumber}" /></td> 
           	 	<td class="usershowpassword"><c:out value="${TelephoneDirectoryTable.phonexplain}"/></td> 
           	 	<td>          	 		
           	 		<input type="submit" name="Submit" value="EDİT" class="myButtons" id="${TelephoneDirectoryTable.id}">
           	 	</td>
          	  	<td>
          	  	<form action ="telephonedirectory" method = "post" >
          	  		<input type="submit" name="Submit" value = "DELETE" class="myButtons1">
          	  		<input type="hidden" name="userid" value = "${TelephoneDirectoryTable.id}" class="myButtons1">
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
      <h2 class="addTitle">Telephone Directory</h2>
    </div>
      
    <div class="modal-body">
       		<form action ="telephonedirectory" method = "post" >
       		<i style = "color:red;font-size: 14px;">*All field can not be blank.</i>
            <h4>İd</h4><input type="text" readonly id="userid">
            <h4>Phone Number Type</h4><input type="text" name="phonenumbertype" id="phonenumbertype" placeholder="Phone Number Type">
            <h4>Phone Owner Name</h4><input type="text" name ="phoneownername" id="phoneownername" placeholder="Phone Owner Name">
            <h4>Phone Number</h4><input type="text" name="phonenumber" id="phonenumber" placeholder="Phone Number">
            <h4>Explanations</h4><input type="text" name="phoneexplain" id="phoneexplain" placeholder="Explanations" >
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
            	<input type="Submit" name="Submit" value="SAVE" class="savebutton" > 
        	</form> 
    </div>      
</div>

<script src="js/popuptelephonedirectory.js"></script> 

</div>  

<div id="modalUpdate" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span  class="close">&times;</span>
      <h2 class="addTitle">Bank Table</h2>
    </div>
      
    <div class="modal-body">
       		<form action ="telephonedirectory" method = "post" >
            <h4>İd</h4><input type="text" readonly  name="useridUpdate" id="useridUpdate">
            <h4>Phone Number Type</h4><input type="text" name="phonenumbertypeUpdate" id="phonenumbertypeUpdate" placeholder="Phone Number Type">
            <h4>Phone Owner Name</h4><input type="text" name ="phoneownernameUpdate" id="phoneownernameUpdate" placeholder="Phone Owner Name">
            <h4>Phone Number</h4><input type="text" name="phonenumberUpdate" id="phonenumberUpdate" placeholder="Phone Number">
            <h4>Explanations</h4><input type="text" name="phoneexplainUpdate" id="phoneexplainUpdate" placeholder="Explanations" >
            	<input type="Submit" name="Submit" value="UPDATE" class="savebutton" > 
            	
        	</form> 
    </div>      
</div>
<script src="js/popuptelephonedirectory.js">
</script> 
</div>    
    
    
<footer class="footer">
   <p><i>Copyright © 2019 Kaya Web Services Company, All Right Reserved</i></p>
    
</footer>    
    
</body>

</html>
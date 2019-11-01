<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.List"%>
<!DOCTYPE html>

<html>

<head>
    <title>Basic Table</title>
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
            <th id="editbar">Edit</th>
            <th id="deletebar">DELETE</th>
         </tr>
        
        <c:forEach items="${tableBasicList}" var="BasicTable">
       		<tr>
       			
           	 	<td><c:out value="${BasicTable.userid}"/></td>
           	 	<td class="xxusershowtype"><c:out value="${BasicTable.userShowtype}" /></td>  
           	 	<td class="xxusershowemail"><c:out value="${BasicTable.userShowEmail}" /></td>
                <td class="usershowusername"><c:out value="${BasicTable.userShowUsername}" /></td> 
           	 	<td class="usershowpassword"><c:out value="${BasicTable.userShowpassword}" /></td>  
           	 	<td class="usershowexpl"><c:out value="${BasicTable.userShowExplanation}" /></td>  
           	 	<td>
           	 		
           	 		<input type="submit" name="Submit" value="EDİT" class="myButtons" id="${BasicTable.userid}">
           	 		<input type="hidden" name="Submit"  class="listToJs">
           	 		
           	 	</td>
          	  	<td><input type="submit" name="Submit" value = "Delete" class="myButtons1"></td> 
          	  	           	 	
        	</tr>
    	</c:forEach>  
    	    	
    </table>	
   
</div>    
<div id="modal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h2 id="addTitle">Basic Table</h2>
    </div>
      
    <div class="modal-body">
       		<form action ="basictables" method = "post" >
       		<i style = "color:red;font-size: 14px;">*All field can not be blank.</i>
            <h4>İd</h4><input type="text" readonly id="userid">
            <h4>Type</h4><input type="text" name="typeEmail" id="emailType">
            <h4>Email</h4><input type="text" name ="email" id="emailAdress">
            <h4>Username</h4><input type="text" name="username" id="username">
            <h4>Password</h4><input type="text" name="password" id="password" >
            <h4>Explanations</h4><input type="text" name="explanations" id="explanations" >
            	<input type="Submit" name="Submit" value="SAVE" class="savebutton" > 
        	</form> 
    </div>      
</div>

<script>
//Get the modal
//Get the modal
//Get the button that opens the modal
var btns = document.getElementsByClassName("myButtons");
var addbtn = document.getElementById("addbutton");
var table = document.getElementById("myTable");
//Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

//When the user clicks the button, open the modal 


for (var i = 0; i < btns.length; i++) {
	
btns[i].onclick = function() {
	 var currentRow = this.id;
	 document.getElementById("userid").value =table.rows[currentRow].cells[0].innerHTML;
	 document.getElementById("emailType").value =table.rows[currentRow].cells[1].innerHTML;
	 document.getElementById("emailAdress").value =table.rows[currentRow].cells[2].innerHTML;
	 document.getElementById("username").value =table.rows[currentRow].cells[3].innerHTML;
	 document.getElementById("password").value =table.rows[currentRow].cells[4].innerHTML;
	 document.getElementById("explanations").value =table.rows[currentRow].cells[5].innerHTML;
	 modal.style.display = "block";
	}
}

addbtn.onclick = function() {
	 document.getElementById("userid").value ="";
	 document.getElementById("emailType").value ="";
	 document.getElementById("emailAdress").value ="";
	 document.getElementById("username").value ="";
	 document.getElementById("password").value ="";
	 document.getElementById("explanations").value ="";
	 modal.style.display = "block";
}


//When the user clicks on <span> (x), close the modal
span.onclick = function() {
modal.style.display = "none";
}

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
if (event.target == modal) {
modal.style.display = "none";
}
}</script> 
</div>
<footer class="footer">
    <p><i>Copyright © 2019 Kaya Web Services Company, All Right Reserved</i></p>
    
</footer>    
    
</body>

</html>
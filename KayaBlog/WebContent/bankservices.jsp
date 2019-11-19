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
        <form action ="bankservices" method = "post" >
            <input type="submit" value="REFRESH" name="Submit" class="butons" >
        </form> 
    </div>
<div class="tables">
    <table id="myTable">
        <tr>
            <th>id</th>
            <th id="bankname">Bank Name</th>
            <th id="ipadressbar">Bank Card Number</th>
            <th id="ipadressbar">Bank Card Name</th>   
            <th id="ipadressbar">Bank Card Last Date</th>
            <th id="ipadressbar">Bank Card Expiration Date</th>
            <th id="datebar">Explanations</th>
            <th id="editbar">EDİT</th>
            <th id="deletebar">DELETE</th>
         </tr>
         <c:forEach items="${tableBankList}" var="BankTable">
       		<tr>
           	 	<td><c:out value="${BankTable.id}"/></td>
           	 	<td class="xxusershowtype"><c:out value="${BankTable.bankname}" /></td>  
           	 	<td class="xxusershowemail"><c:out value="${BankTable.bankcardnumber}" /></td>
                <td class="usershowusername"><c:out value="${BankTable.bankcardname}" /></td> 
           	 	<td class="usershowpassword"><c:out value="${BankTable.banklastdate}"/></td> 
           	 	<td class="usershowexpl"><c:out value="${BankTable.bankexpirationdate}" /></td>  
           	 	<td class="usershowexpl"><c:out value="${BankTable.bankexplain}" /></td>
           	 	<td>          	 		
           	 		<input type="submit" name="Submit" value="EDİT" class="myButtons" id="${BankTable.id}">
           	 	</td>
          	  	<td>
          	  	<form action ="bankservices" method = "post" >
          	  		<input type="submit" name="Submit" value = "DELETE" class="myButtons1">
          	  		<input type="hidden" name="userid" value = "${BankTable.id}" class="myButtons1">
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
      <h2 class="addTitle">Bank Table</h2>
    </div>
      
    <div class="modal-body">
       		<form action ="bankservices" method = "post" >
       		<i style = "color:red;font-size: 14px;">*All field can not be blank.</i>
            <h4>İd</h4><input type="text" readonly id="userid">
            <h4>Bank Name</h4><input type="text" name="bankName" id="bankName" placeholder="Bank Name">
            <h4>Bank Card Name</h4><input type="text" name ="bankcardname" id="bankcardname" placeholder="Bank Card Name">
            <h4>Bank Card Number</h4><input type="text" name="bankcardnumber" id="bankcardnumber" placeholder="Bank Card Number">
            <h4>Bank Card Last Date</h4><input type="text" name="bankcardlastdate" id="bankcardlastdate" placeholder="Bank Card Last Date" >
            <h4>Bank Card Expiration Date</h4><input type="text" name="bankcardexpirationdate" id="bankcardexpirationdate" placeholder ="Bank Card Expiration Date">
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
            <h4>Explanations</h4><input type="text" name="explain" id="explain" placeholder="Explanations">
            	<input type="Submit" name="Submit" value="SAVE" class="savebutton" > 
        	</form> 
    </div>      
</div>

<script src="js/popupbanktable.js"></script> 

</div>

<div id="modalUpdate" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span  class="close">&times;</span>
      <h2 class="addTitle">Bank Table</h2>
    </div>
      
    <div class="modal-body">
       		<form action ="bankservices" method = "post" >
            <h4>İd</h4><input type="text" readonly name="useridUpdate" id="useridUpdate"  placeholder="id" >
            <h4>Bank Name</h4><input type="text" name="bankNameUpdate" id="bankNameUpdate" placeholder="Bank Name">
            <h4>Bank Card Name</h4><input type="text" name ="bankcardnameUpdate" id="bankcardnameUpdate" placeholder="Bank Card Name">
            <h4>Bank Card Number</h4><input type="text" name="bankcardnumberUpdate" id="bankcardnumberUpdate" placeholder="Bank Card Number">
            <h4>Bank Card Last Date</h4><input type="text" name="bankcardlastdateUpdate" id="bankcardlastdateUpdate" placeholder="Bank Card Last Date" >
            <h4>Bank Card Expiration Date</h4><input type="text" name="bankcardexpirationdateUpdate" id="bankcardexpirationdateUpdate" placeholder ="Bank Card Expiration Date">
            <h4>Explanations</h4><input type="text" name="explainUpdate" id="explainUpdate" placeholder="Explanations">	
            	<input type="Submit" name="Submit" value="UPDATE" class="savebutton" > 
            	
        	</form> 
    </div>      
</div>
<script src="js/popupbanktable.js">
</script> 
</div>    

    
</body>

</html>
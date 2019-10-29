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
           <li><a href="basictables.jsp">Basic Table</a></li>
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
        <input type="submit" value="ADD" name="submit" class="butons" id="myBtn">
        <form action ="mainpage" method = "post" >
            <input type="submit" value="REFRESH" name="submit" class="butons" >
        </form> 
    </div>
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h2 id="addTitle">Bank Services</h2>
    </div>
      
    <div class="modal-body">
       <form action="mainpage" method="post">
            <h4>İd</h4><input type="text" readonly>
            <h4>Bank Name</h4><input type="text">
            <h4>Bank Card Number</h4><input type="text">
            <h4>Bank Card Name</h4><input type="text">
            <h4>Bank Card Last Date</h4><input type="text">
            <h4>Bank Card Expiration Date</h4><input type="text">
            <h4>Explanations</h4><input type="text">
            <input type="submit" value="SAVE" class="savebutton">
        </form>
    </div>      
</div>
<script src="popup.js"></script> 
</div>
<div class="tables">
    <table>
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
         <tr>
           	<td ><c:out value="${BasicTable.userid}"/></td>   
           	<td ><c:out value="${BasicTable.userid}"/></td>   
           	<td ><c:out value="${BasicTable.userid}"/></td>   
           	<td ><c:out value="${BasicTable.userid}"/></td>   
           	<td ><c:out value="${BasicTable.userid}"/></td>   
           	<td ><c:out value="${BasicTable.userid}"/></td>   
           	<td ><c:out value="${BasicTable.userid}"/></td>   
           	<td><input type="button" name="submit" value="Edit" class="myButtons"></td>
            <td><input type="button" name="submit" value = "Delete" class="myButtons"></td>   	  
        </tr>
       
       
    </table>
</div>    
    
    
<footer class="footer">
   <p><i>Copyright © 2019 Kaya Web Services Company, All Right Reserved</i></p>
    
</footer>    
    
</body>

</html>
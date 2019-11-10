/**
 * 
 */

var btns = document.getElementsByClassName("myButtons");
var addbtn = document.getElementById("addbutton");
var table = document.getElementById("myTable");
//Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
var spanUpdate = document.getElementsByClassName("close")[1];



for (var i = 0; i < btns.length; i++) {

    btns[i].onclick = function() {
    	var currentRow = this.id;
    	document.getElementById("useridUpdate").value =table.rows[currentRow].cells[0].innerHTML;
        document.getElementById("phonenumbertypeUpdate").value= table.rows[currentRow].cells[1].innerHTML;
        document.getElementById("phoneownernameUpdate").value =table.rows[currentRow].cells[2].innerHTML;
        document.getElementById("phonenumberUpdate").value = table.rows[currentRow].cells[3].innerHTML;
        document.getElementById("phoneexplainUpdate").value = table.rows[currentRow].cells[4].innerHTML;
        document.getElementById("typeofmyencrypttext").value = "None";
        modalUpdate.style.display = "block";
    }
}


function mySelectBox() {
    var tetrar = document.getElementById("typeofencrypt");
    document.getElementById("typeofmyencrypttext").value = tetrar.options[tetrar.selectedIndex].value;
}


addbtn.onclick = function() {
	document.getElementById("userid").value ="";
    document.getElementById("phonenumbertype").value= "";
    document.getElementById("phoneownername").value = "";
    document.getElementById("phonenumber").value = "";
    document.getElementById("phoneexplain").value = "";
    document.getElementById("typeofmyencrypttext").value = "None";
    modal.style.display = "block";
}


//When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}
spanUpdate.onclick = function() {
	modalUpdate.style.display = "none";
}

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
    if (event.target == modalUpdate) {
    	modalUpdate.style.display = "none";
    }
}
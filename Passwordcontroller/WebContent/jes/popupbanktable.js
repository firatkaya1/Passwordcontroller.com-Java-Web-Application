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
    	console.log("currentRow:"+currentRow);
    	document.getElementById("useridUpdate").value =table.rows[currentRow].cells[0].innerHTML;
        document.getElementById("bankNameUpdate").value= table.rows[currentRow].cells[1].innerHTML;
        document.getElementById("bankcardnameUpdate").value = table.rows[currentRow].cells[2].innerHTML;
        document.getElementById("bankcardnumberUpdate").value = table.rows[currentRow].cells[3].innerHTML;
        document.getElementById("bankcardlastdateUpdate").value = table.rows[currentRow].cells[4].innerHTML;
        document.getElementById("bankcardexpirationdateUpdate").value = table.rows[currentRow].cells[5].innerHTML;
        document.getElementById("explainUpdate").value = table.rows[currentRow].cells[6].innerHTML;
        modalUpdate.style.display = "block";
    }
}


function mySelectBox() {
    var tetrar = document.getElementById("typeofencrypt");
    document.getElementById("typeofmyencrypttext").value = tetrar.options[tetrar.selectedIndex].value;
}


addbtn.onclick = function() {
	document.getElementById("userid").value ="";
    document.getElementById("bankName").valuu= "";
    document.getElementById("bankcardname").value = "";
    document.getElementById("bankcardnumber").value = "";
    document.getElementById("bankcardlastdate").value = "";
    document.getElementById("bankcardexpirationdate").value = "";
    document.getElementById("explain").value = "";
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
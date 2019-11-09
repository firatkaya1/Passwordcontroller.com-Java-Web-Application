//Get the modal
//Get the modal
//Get the button that opens the modal
var modal1 = document.getElementById("myModal");
var btns = document.getElementsByClassName("myButtons");
var showPasswords = document.getElementsByClassName("seePass");
var addbtn = document.getElementById("addbutton");
var table = document.getElementById("myTable");
//Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
var spanUpdate = document.getElementsByClassName("close")[1];



for (var i = 0; i < btns.length; i++) {

    btns[i].onclick = function() {
    	var currentRow = this.id;
    	
        document.getElementById("userid1").value = table.rows[currentRow].cells[0].innerHTML;
        document.getElementById("emailType1").value = table.rows[currentRow].cells[1].innerHTML;
        document.getElementById("emailAdress1").value = table.rows[currentRow].cells[2].innerHTML;
        document.getElementById("username1").value = table.rows[currentRow].cells[3].innerHTML;
        document.getElementById("password1").value = document.getElementsByClassName("passwordfield")[currentRow - 1].value;
        document.getElementById("explanations1").value = table.rows[currentRow].cells[5].innerHTML;
        modalUpdate.style.display = "block";
    }
}
for(var i = 0 ;i<showPasswords.length;i++){
	
	showPasswords[i].onclick = function () {
		var currentRow = this.id;
		var currentPasswordrow = document.getElementsByClassName("passwordfield")[currentRow - 1];
		if (currentPasswordrow.type === "password") {
			currentPasswordrow.type = "text";
		  } else {
			  currentPasswordrow.type = "password";
		  }
	}
	
}

function mySelectBox() {
    var tetrar = document.getElementById("typeofencrypt");
    var strUser = tetrar.options[tetrar.selectedIndex].value;
    console.log(strUser);
    document.getElementById("typess").value = strUser;
}
function mySelectBoxUpdate() {
    var tetrar = document.getElementById("typeofencrypt1");
    var strUser = tetrar.options[tetrar.selectedIndex].value;
    console.log(strUser);
    document.getElementById("typess1").value = strUser;
}

addbtn.onclick = function() {

    document.getElementById("typess").value = "";
    document.getElementById("userid").value = "";
    document.getElementById("emailType").value = "";
    document.getElementById("emailAdress").value = "";
    document.getElementById("username").value = "";
    document.getElementById("password").value = "";
    document.getElementById("explanations").value = "";
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
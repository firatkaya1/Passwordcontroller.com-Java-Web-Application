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
        document.getElementById("userid").value = table.rows[currentRow].cells[0].innerHTML;
        document.getElementById("emailType").value = table.rows[currentRow].cells[1].innerHTML;
        document.getElementById("emailAdress").value = table.rows[currentRow].cells[2].innerHTML;
        document.getElementById("username").value = table.rows[currentRow].cells[3].innerHTML;
        document.getElementById("password").value = table.rows[currentRow].cells[4].innerHTML;
        document.getElementById("explanations").value = table.rows[currentRow].cells[5].innerHTML;
        modal.style.display = "block";
    }
}

function mySelectBox() {
    var tetrar = document.getElementById("typeofencrypt");
    var strUser = tetrar.options[tetrar.selectedIndex].value;
    console.log(strUser);
    document.getElementById("typess").value = strUser;
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

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
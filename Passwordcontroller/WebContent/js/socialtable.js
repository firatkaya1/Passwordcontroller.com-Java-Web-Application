var modal = document.getElementById("pop-up");
var btnEdit = document.getElementsByClassName("actions-edit");
var btnDelete = document.getElementsByClassName("actions-delete");
var showPassword = document.getElementsByClassName("show-password");
var table = document.getElementById("table");
var span = document.getElementById("closex");

function openModal() {
    modal.style.display = "block";
    document.getElementById("modalButton").value="SAVE";
    document.getElementById("userid").value = "";
    document.getElementById("type").value = "";
    document.getElementById("email").value = "";
    document.getElementById("username").value = "";
    document.getElementById("password").value = "";
    document.getElementById("description").value = "";
}
for (var i = 0; i < btnEdit.length; i++) {
    btnEdit[i].onclick = function() {
        modal.style.display = "block";
        
        document.getElementById("modalButton").value="UPDATE";
        
        document.getElementById("userid").value = table.rows[this.id].cells[0].innerHTML;
        document.getElementById("type").value = table.rows[this.id].cells[1].innerHTML;
        document.getElementById("email").value = table.rows[this.id].cells[2].innerHTML;
        document.getElementById("username").value = table.rows[this.id].cells[3].innerHTML;
        document.getElementById("password").value = document.getElementsByClassName("password")[this.id - 1].value;
        document.getElementById("description").value = table.rows[this.id].cells[5].innerHTML;
    }
}
for (var i = 0; i < btnDelete.length; i++) {
    btnDelete[i].onclick = function() {
        console.log("btn-delete." + this.id);
    }
}

for (var i = 0; i < showPassword.length; i++) {
    showPassword[i].onclick = function() {
        var currentPassword = document.getElementsByClassName("password")[this.id - 1];
        if (currentPassword.type === "password") {
            currentPassword.type = "text";
        } else {
            currentPassword.type = "password";
        }
    }
}


span.onclick = function() {
    modal.style.display = "none";
}
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
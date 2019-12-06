var password = document.getElementById("pass"),
    repassword = document.getElementById("repass");

function validatePassword() {
    if (password.value != repassword.value) {
        repassword.setCustomValidity("Passwords Don't Match");
    } else {
        repassword.setCustomValidity('');
    }
}
password.onchange = validatePassword;
repassword.onkeyup = validatePassword;
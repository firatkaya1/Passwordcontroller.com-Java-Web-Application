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

var email = document.getElementById("email"),
    reemail = document.getElementById("reemail");

function validateEmail() {
    if (email.value != reemail.value) {
        reemail.setCustomValidity("Email Addresss Don't Match");
    } else {
        reemail.setCustomValidity('');
    }
}
email.onchange = validateEmail;
reemail.onkeyup = validateEmail;

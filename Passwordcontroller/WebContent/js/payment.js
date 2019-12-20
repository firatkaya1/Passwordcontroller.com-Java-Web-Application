var inputField = document.querySelectorAll("input"),
    inputWrapper = document.querySelectorAll(".input-wrapper"),
    iconClose = document.querySelector(".icon-close"),
    btnOpen = document.querySelector(".btn-open"),
    modal = document.querySelector(".modal");

// Input Focus İsleri İcin Duzenlendi
inputField.forEach(function(el) {
    el.addEventListener("focus", animeInput);
    el.addEventListener("focusout", removeAnimeInput);
});

// İnput Graflari
function animeInput(event) {
    event.target.closest(".input-wrapper").classList.add("active");
}
function removeAnimeInput(event) {
    if (event.target.value == "") {
        event.target.closest(".input-wrapper").classList.remove("active");
    }
}

// Acilir Pencere

function openModal() {
    modal.classList.add("open");
}

function closeModal() {
    modal.classList.add("close");

    setTimeout(function() {
        modal.classList.remove("open");
        modal.classList.remove("close");
    }, 1500);

}
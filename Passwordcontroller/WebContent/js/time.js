var date = setInterval(function() {
    var d = new Date();
    document.getElementById("hours").innerHTML = d.toUTCString();
}, 1000);
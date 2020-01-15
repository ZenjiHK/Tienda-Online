setTimeout(function () {
    let kevin = document.getElementById("usuarioLogeadoDIV");
    if (kevin.innerHTML === "0") {
        document.getElementsByClassName("btnVerOPCUser")[0].style.display = "none";
        document.getElementsByClassName("btnVerOPCAdmin")[0].style.display = "none";
    } else if (kevin.innerHTML === "1") {
        document.getElementsByClassName("btnOcultarOPCUser")[0].style.display = "none";
        document.getElementsByClassName("btnVerOPCUser")[0].style.display = "inline";
        document.getElementsByClassName("btnVerOPCAdmin")[0].style.display = "none";
    } else if (kevin.innerHTML === "2") {
        document.getElementsByClassName("btnOcultarOPCUser")[0].style.display = "none";
        document.getElementsByClassName("btnVerOPCUser")[0].style.display = "none";
        document.getElementsByClassName("btnVerOPCAdmin")[0].style.display = "inline";
    }
}, 50);


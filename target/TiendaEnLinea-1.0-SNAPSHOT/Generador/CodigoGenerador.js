var gene = function () {
    var all = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!$%&/()=?¿";
    var cant = 10;
    var allChar = "";
    for ($x = 0; $x < parseInt(cant); $x++) {
        var ran = Math.floor(Math.random() * all.length);
        allChar = allChar + all[ran];
    }
    document.getElementsByClassName("contrasena")[0].value = allChar;
    confirm("Se ha generado una nueva clave.");
};




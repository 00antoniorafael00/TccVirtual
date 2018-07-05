function validaConsulta() {
    var titulo = document.getElementById('titulotcc');
    var curso = document.getElementById('curso');

    var retorno = true;

    if (!titulo.value && !curso.value) {
        alert('Preencha um dos campos');
        retorno = false;
    } 
    

    return retorno;
}



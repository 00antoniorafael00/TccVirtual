/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var msg = "";
var titulo = document.getElementById("tituloTrabalho");
var autor = document.getElementById("autor");
var orientador = document.getElementById("orientador");
var data = document.getElementById("dataBanca");
var horario = document.getElementById("horario");
var modalidade = document.getElementById("modalidade");
var numeroSala = document.getElementById("numeroSala");
var avaliadores = document.getElementById("avaliadores");
var form = document.getElementById("form");

var bt = document.getElementById("bt");

//bt.addEventListener("click",function (){
//    
//    
//});


validar();


function validar() {
    form.addEventListener("submit", function (e) {
        if (!verifica()) {
            e.preventDefault();
        }
    });
}
function verifica() {
    retorno = true;
    msg = "Campos obrigatórios \n";
    if (titulo.value === "") {
        msg += " Titulo\n";
        retorno = false;
    }
    if (autor.value === "") {
        msg += " Autor\n";
        retorno = false;
    }
    if (orientador.value === "") {
        msg += " Orientador \n";
        retorno = false;
    }
    if (data.value === "") {
        msg += " Data \n";
        retorno = false;
    }
    if (horario.value === "") {
        msg += " Horário \n";
        retorno = false;
    }
    if (modalidade.value === "") {
        msg += " Modalidade \n";
        retorno = false;
    }
    if (numeroSala.value === "") {
        msg += " Número de Sala \n";
        retorno = false;
    }
    if (avaliadores.selectedIndex !== 0) {
        msg += "Avaliadores \n";
        retorno = false;
    }
    if (!retorno) {
        alert(msg);
    }
    return retorno;
    
 
}


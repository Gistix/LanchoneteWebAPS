/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function sendFakeForm() {
    var fakeForm = document.getElementById("fakeForm");
    
    if (fakeForm != null) {
        fakeForm.submit();
    } else 
        alert("fakeForm não existe e precisa ser inserido no HTML.")
}

function onLoad() {
    update();   
}

function update () {
    var elementoErro = document.getElementById("erro");
    var elementoMensagem = document.getElementById("mensagem");
    
    var erro = sessionStorage.getItem("erro");
    var mensagem = sessionStorage.getItem("mensagem");
     
    if (erro != null && erro != "")
        elementoErro.textContent = erro;
    
    if (mensagem != null && mensagem != "")    
        elementoMensagem.textContent = mensagem;
    
    sessionStorage.setItem("erro", "");
    sessionStorage.setItem("mensagem", "");     
}

function redirect (xhttp) {
    var erro = xhttp.getResponseHeader("erro");
    var mensagem = xhttp.getResponseHeader("mensagem");               
    
    if (erro != null)
        sessionStorage.setItem("erro", erro);

    if (mensagem != null)                
        sessionStorage.setItem("mensagem", mensagem);

    var location = xhttp.getResponseHeader("url");

    if (location != null)
        window.location.href = location;                   
    else 
        update();
}

function sendGet(servlet) {
    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4) {
            if (this.status == 200) {
                redirect(xhttp);             
            }
        }
    };
    
    xhttp.open("POST", servlet, true);
    xhttp.send("Autenticar");
}

function sendGetReplace(servlet) {
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
      if (this.readyState == 4) {
          if (this.status == 200) {
              document.getElementById("content").innerHTML = this.responseText;
          } else if (this.status == 201) {
              redirect(xhttp);  
          }
      }
    };

    xhttp.open("POST", servlet, true);
    xhttp.send("Autenticar");
}
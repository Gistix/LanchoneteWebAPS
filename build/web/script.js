/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function onLoadSelect() {
    var select = document.getElementsByTagName("select");
    for (var i = 0; i < select.length; i++) {
        if (typeof select[i].onchange === "function")
            select[i].onchange();
    }
}

function onChange(select, precos) {  
    var precosList = JSON.parse(precos);
    var index = select.value;

    var precoElem = select.parentElement.querySelector("#preco");
    
    if (index > 0) {
        var preco = precosList[index-1];
        precoElem.innerText = "R$ " + preco.toFixed(2);
    } else
        precoElem.innerText = "--";
    
    onUpdateTotal(precosList);
}

function onChangeTipo(select) {  
    var name = select.options[select.selectedIndex].text;

    var iconeElem = document.getElementById("icone-ingrediente");
    
    iconeElem.className = "icone-ingrediente " + name.toLowerCase();
}

function onChangeTipoRemover(select) {     
    var name = select.options[select.selectedIndex].text;

    var select = document.getElementsByName("select-ingrediente");

    for (var i = 0; i < select.length; i++) {
        if (select[i].id != name) {
            select[i].className = "hide";
        } else  {
            select[i].className = "";
        }
    }   
}


function onUpdateTotal(precosList) {
    var precoTotalElem = document.getElementById("preco-total");
    var precoTotal = 0;
    
    var paoIndex = document.getElementsByName("select-Pao")[0].value;
    var carneIndex = document.getElementsByName("select-Carne")[0].value;
    var saladaIndex = document.getElementsByName("select-Salada")[0].value;
    var molhoIndex = document.getElementsByName("select-Molho")[0].value;
    
    precoTotal = precosList[paoIndex-1] + precosList[carneIndex-1];
    
    if (saladaIndex > 0)
        precoTotal += precosList[saladaIndex-1];
    
    if (molhoIndex > 0)
        precoTotal += precosList[molhoIndex-1];    
    
    precoTotalElem.innerText = "Total: R$ " + precoTotal.toFixed(2);   
}

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
            if (this.status == 201) {
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
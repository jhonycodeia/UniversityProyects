/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var ventanaGrafica = null;

function nodoNArio(raiz,hijos){
    this.valor=raiz;
    this.hijos=hijos;
}

function graficarNArio(raiz){
    var nodes_object = [];
    var edges_object = [];

    function bonsai(nodo,id){
        nodes_object.push({id: nodo.valor, label:nodo.valor})
        //console.log("ajá chico?"+nodes_object[nodes_object.length-1].id);
        if(nodo.hijos!=null){
            //console.log("trasputas");
            for (var i = 0; i < nodo.hijos.length; i++) {
                if(nodo.hijos[i]!=null){
                    var holita=(i+1)+'';
                    //console.log(" la dice "+(id+holita)); 
                                       
                    edges_object.push({from:nodo.valor, to:nodo.hijos[i].valor});
                    //console.log(edges_object[edges_object.length-1].from+" hacia "+edges_object[edges_object.length-1].to); 
                    bonsai(nodo.hijos[i],(id+holita));
                }
            }
        }
        
    }
    
    bonsai(raiz,0);    
    var nodes = new vis.DataSet(nodes_object);
    var edges = new vis.DataSet(edges_object);
    if(ventanaGrafica!==null) ventanaGrafica.close();
    ventanaGrafica = window.open('','ventana3','width=750,height=710,resizable=false,top='+ ((screen.height - 750) / 2) + ',left=' + ((screen.width - 750) / 2));
    crearPopup();    
    var container = ventanaGrafica.document.getElementById('visualization');
    var data = {nodes: nodes,edges: edges};
    //console.log("vamos a graficarCarajo"+edges_object[3].from);
    var options = {
        layout: {
            hierarchical: {
                direction: "UD",
                sortMethod: "directed"
            }
        }
    }
    var network = new vis.Network(container, data, options);
}

function arbolLibre(expresion,principe){
    var nodos=partes_relacion(expresion);
    //this.raiz=vamoAcrearLibre(nodos,-1);
    this.raiz=arbolNArioLetras(nodos,-1,principe);
    //console.log(raiz);
    return this.raiz;
}

function arbolNArioLetras(nodos,i,principe){
     var nodito;
     var datoSHijo;
     var NHijos=[];
     var datoPadre;
     if(i==-1){
     datoPadre=principe;
     }else{
         datoPadre=i;
     }
     for (var i = 0; i < nodos.length; i++) {
         if(datoPadre==nodos[i].izquierda){

             NHijos.push(arbolNArioLetras(nodos,nodos[i].derecha));
         }
     }
     //console.log(NHijos);
     nodito=new nodoNArio(datoPadre,NHijos);
     return nodito;
}
   
function vamoAyudarElArbol(arbolito){
    
    function inordenPalNArio(nodo){
        var mostrarInorden="";
        if(nodo!=null){
            if(nodo.hijos.length!=null){
                for (var i = 0; i < nodo.hijos.length; i++) {
                   if(i!=parseInt(nodo.hijos.length/2)){
                        mostrarInorden+=inordenPalNArio(nodo.hijos[i]);
                    }else{
                        mostrarInorden+=nodo.valor+",";
                    }
                }
            }else{
                mostrarInorden+=nodo.valor+",";
            }
            
        }
        return mostrarInorden;        
    }
     function preordenPalNArio(nodo){
        var mostrarInorden="";
        if(nodo!=null){
            mostrarInorden+=nodo.valor+",";
            for (var i = 0; i < nodo.hijos.length; i++) {
                if(i!=parseInt(nodo.hijos.length/2)){
                    mostrarInorden+=inordenPalNArio(nodo.hijos[i]);
                }else{
                    mostrarInorden+=nodo.valor+",";
                }
            }        
        }
        return mostrarInorden;        
    }
    function postordenPalNArio(nodo){
        var mostrarInorden="";
        if(nodo!=null){
            for (var i = 0; i < nodo.hijos.length; i++) {
                if(i!=parseInt(nodo.hijos.length/2)){
                    mostrarInorden+=inordenPalNArio(nodo.hijos[i]);
                }else{
                    mostrarInorden+=nodo.valor+",";
                }
            }
            mostrarInorden+=nodo.valor+",";        
        }
        return mostrarInorden;        
    }

    var vamo="inorden "+inordenPalNArio(arbolito.raiz)+"\n";
    vamo+="preorden "+preordenPalNArio(arbolito.raiz)+"\n";
    vamo+="postorden "+postordenPalNArio(arbolito.raiz)+"\n";
    return vamo;
}

function partes_relacion(expresion) {
    var objeto = [];
    var text = "";
    var partes = "";
    var hacer = false;
    //console.log(expresion);
    for (var i = 0; i < expresion.length; i++) 
    {
        /*
            cuando encuentra un partesis derecho parte por comas el text acomulado
            y guarda en el arreglo un object con atributo izquierda y derecha y vacia el text
        */
        if(expresion.charAt(i)==')')
        {
            hacer = false;
            partes = text.split(",");
            objeto.push({izquierda:partes[0],derecha:partes[1]});
            text = "";

        }
        //cuando encuentra parentesis izquierdo habilita hacer para guardar el acomulado de string
        if(expresion.charAt(i)=='(')
        {
            i++;
            hacer = true;
        }
        //guarda texto acomulado
        if(hacer)
        {
            text = text + expresion.charAt(i);
        }
    }
     
     return objeto;  
}

function crearPopup(){
    ventanaGrafica.document.write('<html lang="en">');
    ventanaGrafica.document.write('<head>');
    ventanaGrafica.document.write('<meta charset="utf-8">');
    ventanaGrafica.document.write('<meta http-equiv="X-UA-Compatible" content="IE=edge">');
    ventanaGrafica.document.write('<meta name="viewport" content="width=device-width, initial-scale=1">');
    ventanaGrafica.document.write('<meta name="description" content="">');
    ventanaGrafica.document.write('<meta name="author" content="">');
    ventanaGrafica.document.write('<title>Árbol libre</title>');
    ventanaGrafica.document.write('<link href="bootstrap/bootstrap.min.css" rel="stylesheet">');
    ventanaGrafica.document.write('<link href="bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">');
    ventanaGrafica.document.write('<link href="bootstrap/cover.css" rel="stylesheet">');
    ventanaGrafica.document.write('</head>');
    ventanaGrafica.document.write('<body>');
    ventanaGrafica.document.write('<div class="site-wrapper">');
    ventanaGrafica.document.write('<div class="site-wrapper-inner">');
    ventanaGrafica.document.write('<div class="cover-container">');
    ventanaGrafica.document.write('<div class="inner cover">');
    ventanaGrafica.document.write('<h1 class="cover-heading">Árbol Libre</h1>');  
   // ventanaGrafica.document.write('<div align="center"><p><strong>Expresión: </strong>'+ "expresion" +'</p>');
   // ventanaGrafica.document.write('<p><strong>Recorrido PreOrden: </strong>'+ preOrden.substring(0,preOrden.length-1) +'</p>');
   // ventanaGrafica.document.write('<p><strong>Recorrido InOrden: </strong>'+ inOrden.substring(0,inOrden.length-1) +'</p>');
   // ventanaGrafica.document.write('<p><strong>Recorrido PosOrden: </strong>'+ posOrden.substring(0,posOrden.length-1) +'</p></div>');
   // ventanaGrafica.document.write('</div>');
    ventanaGrafica.document.write('<div class="inner cover" id="visualization" style="height:550px;-webkit-border-radius:13px;background:white;"></div>');
    ventanaGrafica.document.write('</div>');
    ventanaGrafica.document.write('<div class="mastfoot">');
    ventanaGrafica.document.write('<div class="inner">');
    ventanaGrafica.document.write('<p>Curso Matemáticas discretas <a href="#">Brite Learn</a>, by <a href="#">Group Brite Learn</a>.</p>');
    ventanaGrafica.document.write('</div></div></div></div></div>');
    ventanaGrafica.document.write('<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>');
    ventanaGrafica.document.write('</body>');
    ventanaGrafica.document.write('</html>');
        
}

function generarNiveles(niveles) {
    document.getElementById("matriz").innerHTML = "";
    
    for (var i = 0; i < niveles; i++) {
        var fila = document.createElement("tr");
        
        var aux1 = document.createElement("th");
        aux1.innerHTML = 'Nivel <strong style="color:orange;">' + (i+1) + '</strong>: &nbsp;';
        fila.appendChild(aux1);
        
        var valor = document.createElement("td");
        valor.innerHTML = '<input name="level" type="text">';
        fila.appendChild(valor);

        document.getElementById("matriz").appendChild(fila);
    }

}

function getNiveles(){
    var raiz = document.getElementById("raiz").value;
    var relaciones = document.getElementsByName("level");
    var text = "";
    for(var i = 0; i < relaciones.length; i++){
        text += relaciones[i].value;
    }     
    var arbolito = arbolLibre(text,raiz);
    //Retorna cadenas vacias.
    //console.log(vamoAyudarElArbol(arbolito));
    graficarNArio(arbolito);
    
}


var nodos=new Array();
var menor=-1;
var inicio=-1;
var fin=-1;
var ventanaGrafica = null;
var result = "";

function opciones1(num) 
{       
        nodos = new Array();
	//conjunto arreglo de elementos que corresponde a los nodos
	var conjunto = document.getElementById("conjunto").value.split(",");
	//relacion arreglo de objeto relacion con atributo izquierda,derecha y valor
	nodos = partes_relacion1(document.getElementById("relacion").value);
	menor=-1;
	inicio=-1;
	fin=-1;
	//para los botones
	if(num===2){	 	
            if(ventanaGrafica!==null) ventanaGrafica.close();
            ventanaGrafica = window.open('','ventana1','width=750,height=740,resizable=false,top='+ ((screen.height - 700) / 2) + ',left=' + ((screen.width - 800) / 2));
            result = prim(conjunto.length);
            crearPopup1(conjunto,document.getElementById("relacion").value,result);	    
            graficar1(conjunto,nodos);	
	 }
	 if(num===3){
            if(ventanaGrafica!==null) ventanaGrafica.close();
            ventanaGrafica = window.open('','ventana1','width=750,height=740,resizable=false,top='+ ((screen.height - 700) / 2) + ',left=' + ((screen.width - 800) / 2));    
            result = kruskal(conjunto.length);
            crearPopup1(conjunto,document.getElementById("relacion").value,result);	    
            graficar1(conjunto,nodos);	
	 }
         if(num===4){
            if(document.getElementById("inicioFinD").value !== ""){
                inicio=(document.getElementById("inicioFinD").value).split(",");
                fin=conjunto.indexOf(inicio[1]);
                inicio=conjunto.indexOf(inicio[0]);
                result = pintarDijsktra(conjunto,dijkstra(inicio,fin,conjunto));
                if(result !== "wrong"){
                    if(ventanaGrafica!==null) ventanaGrafica.close();
                    ventanaGrafica = window.open('','ventana1','width=750,height=740,resizable=false,top='+ ((screen.height - 700) / 2) + ',left=' + ((screen.width - 800) / 2));
                    crearPopup1(conjunto,document.getElementById("relacion").value,result);	    
                    graficar1(conjunto,nodos);
                }
            } else alert("Ingrese un elemento final e inicial, por favor.");
	}
}

function crearPopup1(conjunto,relacion,result){
        ventanaGrafica.document.write('<html lang="en">');
        ventanaGrafica.document.write('<head>');
        ventanaGrafica.document.write('<meta charset="utf-8">');
        ventanaGrafica.document.write('<meta http-equiv="X-UA-Compatible" content="IE=edge">');
        ventanaGrafica.document.write('<meta name="viewport" content="width=device-width, initial-scale=1">');
        ventanaGrafica.document.write('<meta name="description" content="">');
        ventanaGrafica.document.write('<meta name="author" content="">');
        ventanaGrafica.document.write('<title>Digrafo</title>');
        ventanaGrafica.document.write('<link href="bootstrap/bootstrap.min.css" rel="stylesheet">');
        ventanaGrafica.document.write('<link href="bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">');
        ventanaGrafica.document.write('<link href="bootstrap/cover.css" rel="stylesheet">');
        ventanaGrafica.document.write('</head>');
        ventanaGrafica.document.write('<body>');
        ventanaGrafica.document.write('<div class="site-wrapper">');
        ventanaGrafica.document.write('<div class="site-wrapper-inner">');
        ventanaGrafica.document.write('<div class="cover-container">');
        ventanaGrafica.document.write('<div class="inner cover">');
        ventanaGrafica.document.write('<h1 class="cover-heading">Grafo</h1>');  
        ventanaGrafica.document.write('<div align="center"><p>A = { '+ conjunto +'}</p><p></p><p>R = { '+ relacion +' }</p>');
        ventanaGrafica.document.write('<p> Resultado Algoritmo: '+ result.substring(0,result.length-1) +'</p>\n\
                                       <p><strong>Observación:</strong> La arista de color <strong>negro</strong> es el camino recorrido por el algoritmo.</p></div>');
        ventanaGrafica.document.write('<div class="inner cover" id="visualization" style="height:480px;-webkit-border-radius:13px;background:white;"></div>');
        ventanaGrafica.document.write('</div>');
        ventanaGrafica.document.write('<div class="mastfoot">');
        ventanaGrafica.document.write('<div class="inner">');
        ventanaGrafica.document.write('<p>Curso Matemáticas discretas <a href="#">Brite Learn</a><a href="#"></a>.</p>');
        ventanaGrafica.document.write('</div></div></div></div></div>');
        ventanaGrafica.document.write('<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>');
        ventanaGrafica.document.write('</body>');
        ventanaGrafica.document.write('</html>');
        
}

//funcion que retorna un arreglo con objetos relacion
function partes_relacion1(expresion) {
    var objeto = [];
    var text = "";
    var partes = "";
    var hacer = false;

    for (var i = 0; i < expresion.length; i++){
        /*
            cuando encuentra un partesis derecho parte por comas el text acomulado
            y guarda en el arreglo un object con atributo izquierda y derecha y vacia el text
        */
        if(expresion.charAt(i)==')'){
            hacer = false;
            partes = text.split(",");
            objeto.push({izquierda:partes[0],derecha:partes[1],valor:parseFloat(partes[2]),color:'#f1660f'});
            text = "";
        }
        //cuando encuentra parentesis izquierdo habilita hacer para guardar el acomulado de string
        if(expresion.charAt(i)=='('){
            i++;
            hacer = true;
        }
        //guarda texto acomulado
        if(hacer){
            text = text + expresion.charAt(i);
        }
    }

    return objeto;  
}

//funcion que grafica en el div de id visualization
function graficar1(conjunto,relacion) {
    //arreglo de los nodos y las arista o relacion de pares
    var nodes_object = [];
    var edges_object = [];

    for(var i=0;i<conjunto.length;i++){
        nodes_object.push({id: conjunto[i], label:conjunto[i]})
    }

    for(var j=0;j<relacion.length;j++){
        edges_object.push({from:relacion[j].izquierda, to: relacion[j].derecha, label:relacion[j].valor,color:relacion[j].color})
    }

    //grafica 
    var nodes = new vis.DataSet(nodes_object);
    var edges = new vis.DataSet(edges_object);
    var container = ventanaGrafica.document.getElementById('visualization');
    var data = {nodes: nodes,edges: edges};
    var options = {};
    var network = new vis.Network(container, data, options);
}

function matriz1(conjunto,relacion){
	var matriz = new Array(conjunto.length);
	for(var i=0;i<matriz.length;i++){
            matriz[i] = new Array(conjunto.length);
            for(var j=0;j<matriz.length;j++){
                matriz[i][j]=0;
            }
	}

	for(var i=0;i<conjunto.length;i++){
            for(var j=0;j<relacion.length;j++){
                if(relacion[j].izquierda==conjunto[i]){
                    matriz[i][posicion1(relacion[j].derecha,conjunto)]=relacion[j].valor;
                    matriz[posicion1(relacion[j].derecha,conjunto)][i]=relacion[j].valor;
                }
            }
	}
        
	function posicion1(id,conjunto){
            for(var i= 0; i < conjunto.length; i++){
                if(conjunto[i]==id) return i;
            }
	}
        
	return matriz;
}

function dijkstra(salida,final,conjunto){
    var resultado="";
    var matrizA = matriz1(conjunto,nodos);// es la matriz con cada valor de las aristas
    var costosMnimos=new Array();//
    var visitados=new Array(conjunto.length);
    
    for (var i = 0; i < conjunto.length; i++) {
        for (var j = 0; j < conjunto.length; j++) {
            resultado=resultado+matrizA[i][j]+"   ";
        }
        resultado="";
    } 
    
    for (var i = 0; i < conjunto.length; i++) {
        visitados[i]=false;
        costosMnimos[i]={desde:-1,acomulado:0};    
    }
    
    visitados[salida]=true;
    costosMnimos[salida].desde=salida;
    costosMnimos[salida].acomulado=0;
    
    try{
        while(salida!=final){
            inicio=-1;
            fin=-1;
            for (var i = 0; i < visitados.length; i++) {
                if(!(matrizA[salida][i]==0) && !visitados[i]){
                    costosMnimos[i].desde=salida;
                    costosMnimos[i].acomulado=costosMnimos[salida].acomulado+matrizA[salida][i];
                }
                if (!visitados[i] && costosMnimos[i].desde!=-1 && inicio==-1) {
                    inicio=costosMnimos[i].acomulado;
                    fin=i;
                } else if(!visitados[i] && costosMnimos[i].desde!=-1 && inicio>costosMnimos[i].acomulado){
                    inicio=costosMnimos[i].acomulado;
                    fin=i;
                    salida=costosMnimos[i].desde;
                }
            }

            visitados[fin]=true;
            resultado=resultado+"("+conjunto[salida]+","+conjunto[fin]+"),";    // el resultado pa q funcione
            salida=fin;
        }
    }catch(Exception){
        alert("El elemento inicial o final esta erróneo, por favor verifique.");
        return "wrong";
    }
    
    //alert(resultado);
    return resultado;

}

function pintarDijsktra(conjunto,resultado){
    var partido = partes_relacion1(resultado);
    for (var i = 0; i < nodos.length; i++) {
        for (var j = 0; j < partido.length; j++) {
            if((partido[j].izquierda==(nodos[i].izquierda) || partido[j].izquierda==nodos[i].derecha) && (partido[j].derecha==nodos[i].izquierda || partido[j].derecha==nodos[i].derecha)){
                var valor=nodos[i].valor;
                nodos[i]={izquierda:partido[j].izquierda,derecha:partido[j].derecha,valor:valor,color:'#0a0a09'};
            }
        }
    }
    
    return resultado;
}

function menorHoli(){
    var pos=0;
    for (var i = 0; i < nodos.length; i++) {
        if(menor==-1){
            menor=nodos[i].valor;
            inicio=nodos[i].izquierda;
            fin=nodos[i].derecha;
            pos=i;

        }
        if(menor>nodos[i].valor){
            menor=nodos[i].valor;
            inicio=nodos[i].izquierda;
            fin=nodos[i].derecha;
            pos=i;

        }
    }
    //alert(menor);
    nodos[pos]={izquierda:inicio,derecha:fin,valor:menor,color:'#0a0a09'};
}

function prim(nNodos){
    menorHoli();
    var posMenor=0;
    var yaToyPorAhi=new Array();
    var visitados=new Array(nNodos);
    var resultado="("+inicio+","+fin+","+menor+"),";
    
    for(var i = nNodos - 1; i >= 0; i--) {
        visitados[i]=false;
    }
    
    visitados[inicio]=true;
    visitados[fin]=true;
    yaToyPorAhi.push(inicio);
    yaToyPorAhi.push(fin);
    var camino=-1;
    
    while(yaToyPorAhi.length!=nNodos && nodos.length+1!=yaToyPorAhi.length){
        camino=-1;					
        for (var j = 0; j < nodos.length; j++) {
            ///El siguiente if me dice si los nodos ya fueron visitados,puede ser un nodo u otro pero no ambos.
            if ((visitados[nodos[j].izquierda] || visitados[nodos[j].derecha]) && !(visitados[nodos[j].izquierda] && visitados[nodos[j].derecha])) {
                var dato=nodos[j].valor;
                if (camino==-1) { //me inicializa camino
                    camino=dato;
                    posMenor=j; //me guarda la posición del menor en el arreglo nodos
                }
                if (camino>dato){ /// me compara cual de todos es menor y me lo pone.
                    camino=dato;
                    posMenor=j; //me guarda la posición del menor en el arreglo nodos
                }
            }			
        }
        
        if (visitados[nodos[posMenor].izquierda]) { //me pone el inicio como la izquierda, y el final como la derecha, recordemos que es un grafo NO DIRIJIDO!!!
            inicio=nodos[posMenor].izquierda;
            fin=nodos[posMenor].derecha;
        } else {
            fin=nodos[posMenor].izquierda;
            inicio=nodos[posMenor].derecha;
        }
        
        visitados[fin]=true;
        yaToyPorAhi.push(fin);
        
        nodos[posMenor]={izquierda:inicio,derecha:fin,valor:parseFloat(camino),color:'#0a0a09'};
        resultado=resultado+"("+inicio+","+fin+","+camino+"),";
    }
  
    return resultado;//esta variable me recoge todo!!! es la que retorna los pares ordenados de conjuntos ;) buena suerte!!!
}       

function kruskal(nNodos){			
        menorHoli();// Me devuelve el menor de los datos
        var yaToyPorAhi=new Array(); //Array que me cubre cuales nodos he visitado
        var visitados=new Array(nNodos);// según la posición de cada uno me lo marca como visitado o no
        var resultado="("+inicio+","+fin+","+menor+"),";
        for (var i = nNodos - 1; i >= 0; i--) {
            visitados[i]=false;
        }
        visitados[inicio]=true;
        yaToyPorAhi.push(inicio);
        yaToyPorAhi.push(fin);
        visitados[fin]=true;
        var camino=menor +1;
        while(yaToyPorAhi.length!=nNodos && nodos.length+1!=yaToyPorAhi.length){
                var encontro=false;
                for (var i = 0; i < nodos.length && !encontro; i++) {
                        if (!(visitados[nodos[i].izquierda] && visitados[nodos[i].derecha])) {
                                var dato=nodos[i].valor;
                                if (camino===dato) {
                                        if (visitados[nodos[i].izquierda]) { //me pone el inicio como la izquierda, y el final como la derecha, recordemos que es un grafo NO DIRIJIDO!!!
                                                inicio=nodos[i].izquierda;
                                                fin=nodos[i].derecha;
                                        } else {
                                                fin=nodos[i].izquierda;
                                                inicio=nodos[i].derecha;
                                        }
                                        encontro=true;
                                        nodos[i]={izquierda:inicio,derecha:fin,valor:parseFloat(camino),color:'#0a0a09'};
                                } 		
                        }	
                }


                if (encontro) {
                        visitados[fin]=true;
                        yaToyPorAhi.push(fin);
                        resultado=resultado+"("+inicio+","+fin+","+camino+"),";
                }else{
                    camino++;
                }
        }
        //alert(resultado);
        return resultado;//esta variable me recoge todo!!! es la que retorna los pares ordenados de conjuntos ;) buena suerte!!!
}

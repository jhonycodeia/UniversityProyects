//popup
var ventanaTabla = null;
var ventanaGrafica = null;
var ventanaWarshall = null;

function opciones(num){
        //conjunto arreglo de elementos que corresponde a los nodos	
        var conjunto = document.getElementById("conjunto").value.split(",");
	//relacion arreglo de objeto relacion con atributo izquierda y derecha
	var relacion = partes_relacion(document.getElementById("relacion").value);
        //matriz de adyacencia
	var adyacencia = matriz(conjunto,relacion);
	//matriz de warshall
	var matriz_warshall = warshall(matriz(conjunto,relacion));
        //relacion
        var rel = document.getElementById("relacion").value;
        //conjunto
        var conj = document.getElementById("conjunto").value;
        //verificar cual check esta seleccionado 1.Matriz 2.Digrafo 3.Warshall
	//para los botones
        var scan = new Comprobador();
        if(scan.ScanConjunto(conj) && scan.ScanRelacion(rel)){
            if(num===1){
                if(ventanaTabla!==null) ventanaTabla.close();
                 ventanaTabla = window.open('','ventana1','width=750,height=680,top='+ ((screen.height - 600) / 2) + ',left=' + ((screen.width - 800) / 2));
                llenarTabla(adyacencia,conjunto,2,conj,rel,ventanaTabla);
            }
            if(num===2){
                if(ventanaGrafica!==null) ventanaGrafica.close();
                 ventanaGrafica = window.open('','ventana2','width=750,height=710,top='+ ((screen.height - 650) / 2) + ',left=' + ((screen.width - 800) / 2));
                graficar(conjunto,relacion,conj,rel,ventanaGrafica);
            }
            if(num===3){
               if(ventanaWarshall!==null) ventanaWarshall.close();
                ventanaWarshall = window.open('','ventana3','width=600,height=550,top='+ ((screen.height - 800) / 2) + ',left=' + ((screen.width - 600) / 2));
                llenarTabla(matriz_warshall,conjunto,3,conj,rel,ventanaWarshall);
            }
        }
}

//clase comprobador
function Comprobador(){
    this.ScanRelacion = function(Exp){
        var x = Exp;
        if(x === "") return true;
        if(this.okParentesis(x)){
            if(this.okComasConjunto(x)){
                if(this.okComas(x)){
                    if(this.okRelacion(x)){
                        return true;
                    }else alert("Verifique los pares ordenados.");
                }else alert("Verifique la expresión, posiblemente comas.");
            }else alert("Verifique la expresión de la relación.");;
        }else alert("Verifique los parentesis.");;
        return false;
    };
    this.ScanConjunto = function(Exp){
        var x = Exp;
        if(x === ""){
            alert("Ingrese un conjunto, por favor.");
            return false;
        }
        if(this.okComasConjunto(x)){
            return true;
        }else alert("Verifique la expresión, las comas están mal en el conjunto.");
        return false;
    };   
    this.okParentesis = function(Exp){
        var p = 0;
        if((Exp.charAt(0) === '(') && (Exp.charAt(Exp.length-1) === ')')){
           for(var i=0; i<Exp.length; i++){
                if(Exp.charAt(i)==='('){
                    if(Exp.charAt(i+1) === '('){
                        return false;
                    }
                    p++;
                }
                else if(Exp.charAt(i)===')'){
                    p--;
                }
            }  
        }else{
            return false;
        } 
        return (p===0);     
    };
    this.okRelacion = function(exp){       
        for(var i = 0; i<exp.length; i++){
            if(exp.charAt(i) === '('){
                var temp = "";
                var idx = i+1;
                while(exp.charAt(idx) !== ')'){
                    temp+=exp.charAt(idx);
                    idx++;
                }
                var elems = temp.split(",");
                if(elems.length !== 2) return false;
            }
        }
        return true;
    };
    this.okComas = function(Exp){       
        for(var i=0; i<Exp.length;i++){
            if(i<Exp.length-1){
                if(Exp.charAt(i) === ')'){
                    if(Exp.charAt(i+1) === ',' && Exp.charAt(i+2) === '('){
                        i=i+2;
                    }else return false;
                }
            }
        }
        return true;
    };
    this.okComasConjunto = function(Exp1){       
        var Exp = this.limpiarParentesis(Exp1);
        var sw=true;
        if(Exp.charAt(0) === "," || Exp.charAt(Exp.length-1) === ","){
            return false;
        }else{
            for(var i=0; i<Exp.length-1;i++){
                if(this.Coma(Exp.charAt(i)) && this.Coma(Exp.charAt(i+1)))
                    return false;
            }
        }
        return sw;
    };
    this.limpiarParentesis = function(Exp){
        var aux="";
        for(var i=0; i<Exp.length; i++){
            if((Exp.charAt(i)!=='(')&&(Exp.charAt(i)!==')')) aux = aux + Exp.charAt(i);
        }
        return aux;
    }; 
    this.Coma = function(x){
          return x === ',';
    };
}

function validacionRelacion(e){
    conjunto = document.getElementById("conjunto").value;
    key = e.keyCode || e.which;
    //espacio
    if(key === 32) return false;
    //conjunto vacio
    if(conjunto === ""){
        alert("Ingrese un conjunto primero.");
        return false;
    }    
    teclado = String.fromCharCode(key);
    permitidos = conjunto;
    especiales = [40,44,41,8];
    //teclas especiales "(),"
    for(var i in especiales){
        if(key === especiales[i]){
            return true;
        }
    }
    //si no ingresa ningun permitido
    if(permitidos.indexOf(teclado) === -1){
        return false;
    }
}

function validacionConjunto(e){
    NUMEROS = "0123456789";
    LETRAS = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
    key = e.keyCode || e.which;
    teclado = String.fromCharCode(key);
    especiales = [44,8];
    //teclas especiales "(),"
    for(var i in especiales){
        if(key === especiales[i]){
            return true;
        }
    }
    if((NUMEROS.indexOf(teclado) === -1) && (LETRAS.indexOf(teclado.toUpperCase()) === -1)){
        return false;
    }
}

//funcion que retorna un arreglo con objetos relacion
function partes_relacion(expresion) {
	var objeto = [];
	var text = "";
	var partes = "";
	var hacer = false;

	for (var i = 0; i < expresion.length; i++) 
	{
		/*
			cuando encuentra un partesis derecho parte por comas el text acomulado
			y guarda en el arreglo un object con atributo izquierda y derecha y vacia el text
 		*/
		if(expresion.charAt(i)===')')
		{
			hacer = false;
			partes = text.split(",");
			objeto.push({izquierda:partes[0],derecha:partes[1]});
			text = "";

		}
		//cuando encuentra parentesis izquierdo habilita hacer para guardar el acomulado de string
		if(expresion.charAt(i)==='(')
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

function matriz(conjunto,relacion){
	var matriz = new Array(conjunto.length);
	for(var i=0;i<matriz.length;i++){
		matriz[i] = new Array(conjunto.length);
		for(var j=0;j<matriz.length;j++){
				matriz[i][j]=0;
		}
	}

	for(var i=0;i<conjunto.length;i++){
		for(var j=0;j<relacion.length;j++){
			if(relacion[j].izquierda===conjunto[i]){
				matriz[i][posicion(relacion[j].derecha,conjunto)]++;
			}
		}
	}
        
	function posicion(id,conjunto){
		for(var i= 0; i < conjunto.length; i++){
			if(conjunto[i]===id) return i;
		}
	}
	return matriz;
}

function llenarTabla(matriz,conjunto,option,rel,conj,ventana){
        crearPopup(option,rel,conj,ventana);
	ventana.document.getElementById("matriz").innerHTML = "";
	var elementos = ventana.document.createElement("tr");
	var aux = ventana.document.createElement("th");
	aux.innerHTML = " ";
	elementos.appendChild(aux);
	for(var i=0;i<conjunto.length;i++){
		var dato = ventana.document.createElement("th");
                dato.innerHTML = "&nbsp;&nbsp;"+conjunto[i]+"&nbsp;&nbsp;";
		elementos.appendChild(dato);
	}
	ventana.document.getElementById("matriz").appendChild(elementos);
	for(var i=0;i<conjunto.length;i++){
		var fila = ventana.document.createElement("tr");
		var aux1 = ventana.document.createElement("th");
                aux1.innerHTML = conjunto[i]+"&nbsp;";
		fila.appendChild(aux1);
		for(var j=0;j<conjunto.length;j++){
			var valor = ventana.document.createElement("td");
                        if(i===0){
                            if(j===0)valor.id="corner1";
                            else if(j===conjunto.length-1)valor.id="corner4";
                        }else if(j===0){
                            if(i===conjunto.length-1)valor.id="corner2";
                            else valor.id="left";
                        }else if(j===conjunto.length-1){
                            if(i===conjunto.length-1) valor.id="corner3"
                            else valor.id="right";
                        }
			valor.innerHTML = "&nbsp;&nbsp;"+matriz[i][j]+"&nbsp;&nbsp;";
			fila.appendChild(valor);
		}
		ventana.document.getElementById("matriz").appendChild(fila);
	}

}

//funcion que grafica en el div de id visualization
function graficar(conjunto,relacion,rel,conj,ventana) {
	//arreglo de los nodos y las arista o relacion de pares
	var nodes_object = [];
	var edges_object = [];
	for(var i=0;i<conjunto.length;i++)
	{
		nodes_object.push({id: conjunto[i], label:conjunto[i]});
	}
	for(var j=0;j<relacion.length;j++)
	{
		edges_object.push({from:relacion[j].izquierda, to: relacion[j].derecha, arrows:'to'});
	}

	//grafica 
	var nodes = new vis.DataSet(nodes_object);
        var edges = new vis.DataSet(edges_object);
	crearPopup(1,rel,conj,ventana);
        var container = ventana.document.getElementById("visualization");
  	var data = {nodes: nodes,edges: edges};
        var options = {};
        var network = new vis.Network(container, data, options);
        
}

function warshall(matriz) {
    var cant = matriz.length;
    for (var k=0;k<cant; k++){
	for(var i=0;i<cant;i++){
            for(var j=0;j<cant;j++){
                if(matriz[i][k] === 1 && matriz[k][j]===1){
                    matriz[i][j] = 1;
                }
            }
	} 	
    }
    return matriz;
}

function crearPopup(option,conjunto,relacion,ventana){
        ventana.document.write('<html lang="en">');
        ventana.document.write('<head>');
        ventana.document.write('<meta charset="utf-8">');
        ventana.document.write('<meta http-equiv="X-UA-Compatible" content="IE=edge">');
        ventana.document.write('<meta name="viewport" content="width=device-width, initial-scale=1">');
        ventana.document.write('<meta name="description" content="">');
        ventana.document.write('<meta name="author" content="">');
        ventana.document.write('<title>Digrafo</title>');
        ventana.document.write('<link href="bootstrap/bootstrap.min.css" rel="stylesheet">');
        ventana.document.write('<link href="bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">');
        ventana.document.write('<link href="bootstrap/cover.css" rel="stylesheet">');
        ventana.document.write('<style>th,td{padding-top:4%;padding-bottom:4%;}\n\
                                       #left{border-left: orange 3px solid;}\n\
                                       #right{border-right: orange 3px solid;}\n\
                                       #corner1{border-left: orange 3px solid;border-top: orange 3px solid;}\n\
                                       #corner2{border-left: orange 3px solid;border-bottom: orange 3px solid;}\n\
                                       #corner3{border-right: orange 3px solid;border-bottom: orange 3px solid;}\n\
                                       #corner4{border-right: orange 3px solid;border-top: orange 3px solid;}</style>');
        ventana.document.write('</head>');
        ventana.document.write('<body>');
        ventana.document.write('<div class="site-wrapper">');
        ventana.document.write('<div class="site-wrapper-inner">');
        ventana.document.write('<div class="cover-container">');
        ventana.document.write('<div class="inner cover">');
        if(option===1){
            ventana.document.write('<h1 class="cover-heading">Grafo Dirigido</h1>');  
            ventana.document.write('<div align="center"><p>A = { '+ conjunto +'}</p><p></p><p>R = { '+ relacion +' }</p></div>');
            ventana.document.write('<div class="inner cover" id="visualization" style="height:480px;-webkit-border-radius:13px;background:white;"></div>');
        }
        else{
            if(option===2)ventana.document.write('<h1 class="cover-heading">Matriz de Adyacencia</h1>');    
            else ventana.document.write('<h1 class="cover-heading">Algoritmo de Warshall</h1>');    
            ventana.document.write('<div align="center"><p class="lead">A = { '+ conjunto +'}</p><p></p><p class="lead">R = { '+ relacion +' }</p>');
            ventana.document.write('<p></p><p></p><table id="matriz"></table></div>');
        }
        ventana.document.write('</div>');
        ventana.document.write('<div class="mastfoot">');
        ventana.document.write('<div class="inner">');
        ventana.document.write('<p>Curso Matemáticas discretas <a href="#">Brite Learn</a><a href="#"></a>.</p>');
        ventana.document.write('</div></div></div></div></div>');
        ventana.document.write('<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>');
        ventana.document.write('</body>');
        ventana.document.write('</html>');
}





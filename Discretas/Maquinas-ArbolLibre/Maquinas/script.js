var ventanaTabla = null;
var ventanaGrafica = null;

function opciones(num) {
	var estados = document.getElementById("Estados").value.split(",");
	var F = document.getElementById("funcionF").value;
	var G = document.getElementById("funcionG").value;
	var I = document.getElementById("Entrada").value.split(",");
	var O = document.getElementById("Salida").value.split(",");
	var cadena = document.getElementById("cadena").value;
	var relacion = partes_relacion(F,G);
	//para los botones
	if(num==1){
            if(ventanaGrafica!==null) ventanaGrafica.close();
            ventanaGrafica = window.open('','ventana1','width=750,height=670,top='+ ((screen.height - 670) / 2) + ',left=' + ((screen.width - 800) / 2));
            graficar(estados,relacion);
        }
 	if(num==2){
            if(ventanaTabla!==null) ventanaTabla.close();
            ventanaTabla = window.open('','ventana2','width=730,height=540,top='+ ((screen.height - 540) / 2) + ',left=' + ((screen.width - 800) / 2));
            llenarTabla(matriz(estados,I,O,relacion),estados,I,O);
        }
	if(num==3)
            document.getElementById("salida").value=convertir(cadena,relacion,estados);
}
//funcion que retorna un arreglo con objetos relacion
function partes_relacion(f,g) {
	var objeto = [];
	var text = "";
	var hacer = false;
	for (var i = 0; i < f.length; i++){
		if(f.charAt(i)==')')
		{
			hacer = false;
			var partes = text.split(",");
			objeto.push({de:partes[0],a:partes[2],entrada:partes[1],salida:"n"});
			text = "";

		}
		if(f.charAt(i)=='(')
		{
			i++;
			hacer = true;
		}
		if(hacer)
		{
			text = text + f.charAt(i);
		}
	}
	for (var i = 0; i < g.length; i++){
		if(g.charAt(i)==')')
		{
			hacer = false;
			var partes = text.split(",");
			objeto[buscar(objeto,partes[0],partes[1])].salida = partes[2];
			text = "";
		}
		if(g.charAt(i)=='(')
		{
			i++;
			hacer = true;
		}
		if(hacer)
		{
			text = text + g.charAt(i);
		}
	}
 	return objeto;  

	function buscar(arr,de,entrada){
		for (var i=0;i<arr.length;i++) {
			if(arr[i].de==de && arr[i].entrada==entrada)
				return i;
		}
		return -1;
	}
}

function matriz(estados,I,O,relacion){
	var matriz = new Array(estados.length);
	for(var i=0;i<matriz.length;i++){
		matriz[i] = new Array(I.length + O.length);
		for(var j=0;j<I.length + O.length;j++){
			var dato;
			if(j<I.length)
				dato = buscar(estados[i],I[j],relacion,true);
			else
				dato = buscar(estados[i],O[j-I.length],relacion,false);
			matriz[i][j]=dato;
				
		}
	}
	function buscar(de,a,arr,entra){
		for(var i= 0; i < arr.length; i++){
			if(arr[i].de==de && arr[i].entrada==a){
				if(entra)
					return arr[i].a;
				return arr[i].salida;
			}
		}
		if(entra)
			return " ";
		return "n";
	}
	return matriz;
}

function llenarTabla(matriz,estados,I,O){
        crearPopup(2,ventanaTabla)
	ventanaTabla.document.getElementById("matriz").innerHTML = "";
	var elementos = ventanaTabla.document.createElement("tr");
	var aux = ventanaTabla.document.createElement("th");
	aux.innerHTML = "Estado";
        aux.id = "right-bottom";
	elementos.appendChild(aux);
	for(var i=0;i<I.length + O.length;i++){
		var dato = ventanaTabla.document.createElement("th");
		if(i<I.length){
                    dato.innerHTML = I[i];
                    dato.id = "bottom";
                } else{
                    dato.innerHTML = O[i-I.length];
                    dato.id = "bottom";
                }
                if(i === I.length-1)dato.id = "right-bottom";
		elementos.appendChild(dato);
	}
	ventanaTabla.document.getElementById("matriz").appendChild(elementos);
	for(var i=0;i<estados.length;i++){
		var fila = ventanaTabla.document.createElement("tr");
		var aux1 = ventanaTabla.document.createElement("th");
		aux1.innerHTML = estados[i];
                aux1.id = "right";
		fila.appendChild(aux1);
		for(var j=0;j<I.length+O.length;j++){
			var valor = ventanaTabla.document.createElement("td");
			valor.innerHTML = matriz[i][j];
			fila.appendChild(valor);
                        if(j === I.length-1) valor.id = "right";
		}
		ventanaTabla.document.getElementById("matriz").appendChild(fila);
	}
}

//funcion que grafica en el div de id visualization
function graficar(conjunto,relacion) 
{
	//arreglo de los nodos y las arista o relacion de pares
	var nodes_object = [];
	var edges_object = [];
	for(var i=0;i<conjunto.length;i++)
	{
		nodes_object.push({id: conjunto[i], label:conjunto[i]})
	}
	for(var j=0;j<relacion.length;j++)
	{
		var aux = relacion[j].entrada;
		if(relacion[j].salida!="n")
			aux = relacion[j].entrada + ", " + relacion[j].salida;
		edges_object.push({from:relacion[j].de, to: relacion[j].a, label: aux, arrows:'to'})
	}

	//grafica 
	var nodes = new vis.DataSet(nodes_object);
        var edges = new vis.DataSet(edges_object);
        crearPopup(1,ventanaGrafica);
	var container = ventanaGrafica.document.getElementById('visualization');
  	var data = {nodes: nodes,edges: edges};
        var options = {};
        var network = new vis.Network(container, data, options);
}

function convertir(cadena,relacion,estados){
	var convertido = "";
	var estado = estados[0];
	for(var i=0;i<cadena.length;i++){
		convertido += buscar(cadena.charAt(i));
	}
	function buscar(valor){
		for(var i=0;i<relacion.length;i++){
			if(relacion[i].de==estado && relacion[i].entrada==valor){
				estado = relacion[i].a;
				return relacion[i].salida;
			}
		}
	}
	return convertido;
}

function crearPopup(option,ventana){
        ventana.document.write('<html lang="en">');
        ventana.document.write('<head>');
        ventana.document.write('<meta charset="utf-8">');
        ventana.document.write('<meta http-equiv="X-UA-Compatible" content="IE=edge">');
        ventana.document.write('<meta name="viewport" content="width=device-width, initial-scale=1">');
        ventana.document.write('<meta name="description" content="">');
        ventana.document.write('<meta name="author" content="">');
        ventana.document.write('<title>Maquina de Estado</title>');
        ventana.document.write('<link href="bootstrap/bootstrap.min.css" rel="stylesheet">');
        ventana.document.write('<link href="bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">');
        ventana.document.write('<link href="bootstrap/cover.css" rel="stylesheet">');
        ventana.document.write('<style>th,td{padding:6px;margin:8px;}\n\
                                       table{border: orange 2px solid;}\n\
                                       #right{border-right: orange 2px solid;}\n\
                                       #right-bottom{border-right: orange 2px solid;border-bottom: orange 2px solid;}\n\
                                       #bottom{border-bottom: orange 2px solid;}</style>');
        ventana.document.write('</head>');
        ventana.document.write('<body>');
        ventana.document.write('<div class="site-wrapper">');
        ventana.document.write('<div class="site-wrapper-inner">');
        ventana.document.write('<div class="cover-container">');
        ventana.document.write('<div class="inner cover">');
        if(option===1){
            ventana.document.write('<h1 class="cover-heading">Diagrama de Estado</h1>');  
            ventana.document.write('<div class="inner cover" id="visualization" style="height:480px;-webkit-border-radius:13px;background:white;"></div>');
        }
        else if(option===2){
            ventana.document.write('<h1 class="cover-heading">Tabla de Estado</h1>');        
            ventana.document.write('<br/><div align="center"><table id="matriz"></table></div></div>');
        }
        ventana.document.write('</div>');
        ventana.document.write('<div class="mastfoot">');
        ventana.document.write('<div class="inner">');
        ventana.document.write('<p>Curso Matemáticas discretas <a href="#">Brite Learn</a>, by <a href="#">Group Brite Learn</a>.</p>');
        ventana.document.write('</div></div></div></div></div>');
        ventana.document.write('<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>');
        ventana.document.write('</body>');
        ventana.document.write('</html>');
}

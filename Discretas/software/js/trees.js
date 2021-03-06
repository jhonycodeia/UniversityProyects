var ventanaGrafica = null;
var inOrden = "";
var preOrden = "";
var posOrden = "";

//retornar variable
function retornar(letter){
    var anterior = document.getElementById("expresion").value;//obtiene lo que hay en el campo de texto de la calculadora
    document.getElementById("expresion").value=anterior+letter;//adiciona el elemento presionado
}

//eliminartodo
function limpiarTextField(){
    document.getElementById("expresion").value = "";
}

//Logica
//cambiar expresion a operadores logicos 
function cambiarExpresion(exp){
    var expresion = "";
    for(var i = 0; i<exp.length; i++){
       switch(exp.charAt(i)){
        case "^":
            expresion += '&';break;
        case "~":
            expresion += '!';break;
        case "v":
            expresion += '|';break;
        case "→":
            expresion += '>';break;
        case "↔":
            expresion += '<';break;
        case "⊻":
            expresion += '+';break;
        default:
            expresion += exp.charAt(i);break;
        }
   }
   return expresion;
}

function tipoExpresion(exp){
    NUMEROS = "0123456789";
    for(var i= 0; i<exp.length; i++){
        if(NUMEROS.indexOf(exp.charAt(i)) !== -1){
            return true;
        }   
    }
    return false;
}
//accion
function accion(){
    
    var exp = document.getElementById("expresion").value;
    //Cuando construyo la expresión no me coje esos putos símbolos raros. Por eso, los cambio.
    var expresion = "";
    if(!tipoExpresion(exp))    
        expresion = cambiarExpresion(exp);
    else{
        expresion = exp;
    }

    var validacion = new Comprobador();
    var vars = validacion.Scan(expresion);
    //wrong si la validación de los parentesís blabla está mal.
    if(vars!=="wrong"){
        if(expresion.length!==0){
            var e = new Expresion(vars);
            var exp = e.CompletoPrefija();
            for(var idx=0; idx<exp.length; idx++){
                if((exp[idx])==="!") exp.splice(idx+1,0,"M");
            }
                       
            if((exp.length!==0)){                
                var ar = new ArbolExpresion();
                ar.ArbolExpresion(exp);
                inOrden = arreglarExpresion(ar.InOrden());
                preOrden = arreglarExpresion(ar.PreOrden());
                posOrden = arreglarExpresion(ar.PosOrden());
                //alert("expresion"+ exp);
                if(ventanaGrafica!==null) ventanaGrafica.close();
                ventanaGrafica = window.open('','ventana3','width=750,height=830,resizable=false,top='+ ((screen.height - 780) / 2) + ',left=' + ((screen.width - 800) / 2));
                graficar(ar.Raiz);
            }
        }
    }
    
}

function limpiarParentesis(Exp){
    var aux="";
    for(var i=0; i<Exp.length; i++){
        if((Exp.charAt(i)!=='(')&&(Exp.charAt(i)!==')')) aux = aux + Exp.charAt(i);
    }
    return aux;
}

function arreglarExpresion(expresion){
    var statement = "";
    for(var i = 0; i<expresion.length; i++){
        if(expresion.charAt(i)!=="M"){
            statement += expresion.charAt(i);
        }else i++;
    }
    return statement;
}

//graficar árbol
function graficar(raiz) {
    //arreglo de los nodos y las arista o relacion de pares
    var nodes_object = [];
    var edges_object = [];

    function arbol(nodo,id){
        //M representa el machete jaja, cuando sea M pues no lo dibuje.
        if(nodo.getData()!=="M"){
            nodes_object.push({id: id, label:nodo.getData()});
            if(nodo.getIzquierda()!==null){
                edges_object.push({from:id, to: id+'1'});
                arbol(nodo.getIzquierda(),id+'1');
            }
            if(nodo.getDerecha()!==null){
                edges_object.push({from:id, to: id+'2'});
                arbol(nodo.getDerecha(),id+'2');
            }
        }
    }
    arbol(raiz,0);
    //grafica 
    var nodes = new vis.DataSet(nodes_object);
    var edges = new vis.DataSet(edges_object);
    crearPopup();
    var container = ventanaGrafica.document.getElementById('visualization');
    var data = {nodes: nodes,edges: edges};
    var options = {
        layout: {
            hierarchical: {
                direction: "UD",
                sortMethod: "directed"
            }
        }
    };

    var network = new vis.Network(container, data, options);
}

function crearPopup(){
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
        ventanaGrafica.document.write('<h1 class="cover-heading">Árbol Binario</h1>');  
        ventanaGrafica.document.write('<div align="center"><p><strong>Expresión: </strong>'+ document.getElementById("expresion").value +'</p>');
        ventanaGrafica.document.write('<p><strong>Recorrido PreOrden: </strong>'+ preOrden.substring(0,preOrden.length-1) +'</p>');
        ventanaGrafica.document.write('<p><strong>Recorrido InOrden: </strong>'+ inOrden.substring(0,inOrden.length-1) +'</p>');
        ventanaGrafica.document.write('<p><strong>Recorrido PosOrden: </strong>'+ posOrden.substring(0,posOrden.length-1) +'</p></div>');
        ventanaGrafica.document.write('<div class="inner cover" id="visualization" style="height:550px;-webkit-border-radius:13px;background:white;"></div>');
        ventanaGrafica.document.write('</div>');
        ventanaGrafica.document.write('<div class="mastfoot">');
        ventanaGrafica.document.write('<div class="inner">');
        ventanaGrafica.document.write('<p>Curso Matemáticas discretas <a href="#">Brite Learn</a><a href="#"></a>.</p>');
        ventanaGrafica.document.write('</div></div></div></div></div>');
        ventanaGrafica.document.write('<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>');
        ventanaGrafica.document.write('</body>');
        ventanaGrafica.document.write('</html>');
        
}

//Clase ArbolExpresion
function ArbolExpresion(){
    
    this.Raiz;  
            
    this.ArbolExpresion = function(Exp){
        var aux =  Exp[0];
        var tipo = this.tipo(Exp);
        var id_node;
        if(!tipo) id_node = this.cambiarOperador(aux.toString());
        else id_node = aux.toString();
        var q = new Nodo(id_node);
        var op = new Nodo(id_node);
        var p = new Pila();
        var antesOperando = false;
        this.Raiz = q;
        for(var i=1; i<Exp.length; i++){
            var aux2 = Exp[i];
            var id;
            if(!tipo) id = this.cambiarOperador(aux2.toString());
            else id = aux2.toString();
            op = new Nodo(id);
            
            if(antesOperando){
                q = p.sacar();
                q.setDerecha(op);
            }else{
                q.setIzquierda(op);
                p.poner(q);
            }
            q = op;
            antesOperando = !this.operador(Exp[i]);
        }   
    };
    
    this.cambiarOperador = function(c){
        switch(c){
            case "&":
                return "^";
            case "!":
                return "~";
            case "|":
                return "v";
            case ">":
                return "→";
            case "<":
                return "↔";
            case "+":
                return "⊻";
            default:
                return c;
        }
    };
    
    this.operador = function(c){
        var operadores = ['&','+','>','|','!','<','*','/','-','^'];
        var existe = false;
        var aux = c.toString().charAt(0);
        for(var i=0; ((i<operadores.length) && (!existe)); i++){
            if(aux === operadores[i]) existe = true;
        }
        return existe;
    };
    
    this.tipo = function(exp){
        NUMEROS = "0123456789";
        for(var i = 0; i<exp.length; i++){
            if(NUMEROS.indexOf(exp[i].charAt(0))!== -1){
                return true;
            }
        }
        return false;
    };
    
    this.InOrden = function(){
        return this.getInOrden(this.Raiz);
    };
    
    this.getInOrden = function(nodo){
       var texto = "";
       if(nodo!==null){
           texto += this.getInOrden(nodo.getIzquierda());
           texto += (nodo.getData()+",");
           texto += this.getInOrden(nodo.getDerecha());
       }
       return texto;
    };
    
    this.PosOrden = function(){
        return this.getPosOrden(this.Raiz);
     };

    this.getPosOrden = function(nodo){
        var text = "";
        if(nodo!==null){
            text += this.getPosOrden(nodo.getIzquierda());
            text += this.getPosOrden(nodo.getDerecha());
            text += (nodo.getData()+",");
        }
        return text;
     };

    this.PreOrden = function(){
        return this.getPreOrden(this.Raiz);
     };

    this.getPreOrden = function(nodo) {
        var text = "";
        if(nodo!==null){
            text += (nodo.getData()+",");
            text += this.getPreOrden(nodo.getIzquierda());
            text += this.getPreOrden(nodo.getDerecha());
        }
        return text;
     };
             
}

//Clase Expresion
function Expresion(expr){
    
    this.Exp = expr; 
    this.tipo = tipoExpresion(expr);
            
    this.getExpresion = function(){
        return this.Exp;
    };
    
    this.CompletoPrefija = function() {
        var sep = this.Separar();
        var completo = new Array();
        var n = sep.length-1;
        var j=0;
        var pfija = this.preFija();
        
        //alert(pfija);
        
        for(var i=0;((i<pfija.length)&&(j<=n));i++){
            var e1 = pfija[i];            
            if(this.isLetterUpper(e1) || this.isDigit(e1)){
                completo.push(sep[j]);
                j++;
            }else completo.push(e1);
        }
        return completo;
    };   
    
    this.preFija = function(){
        var c;
        var d;
        var e;
      	var i;
        var prioridadCima;
        var prioridadOper;
      	var expPre = new Array();
        var aux = new Pila();
        var med = new Pila();
        var pre = new Pila();
	var Expr = this.Clasica();
        
        for(i=0;i<Expr.length;i++){
            aux.poner(Expr.charAt(i));
        }
        while(!aux.vacia()){
            c = aux.sacar();            
            if(c === ')'){
                med.poner(c);
            }else {    
                if(c === '('){
                    e = med.cima();
                    while(e !== ')'){
                        c = med.sacar();
                        pre.poner(c);
			e = med.cima();
                    }
                    med.sacar();
		}else 
                    if(this.operador(c)){
                        e = med.cima(); 
		        prioridadCima = this.prioridad(e);
                        prioridadOper = this.prioridad(c);
                        while(!med.vacia() && (prioridadOper < prioridadCima)){
                            d = med.sacar();
                            pre.poner(d);
                            e = med.cima();
                            prioridadCima = this.prioridad(e);
			}
                        med.poner(c);
                    }else pre.poner(c);
                }
	}
  
	while(!med.vacia()){
            c = med.sacar();
            pre.poner(c);
	}
	while(!pre.vacia()){
            c = pre.sacar();
            expPre.push(c);
	}
   	return expPre;
    };
    
    this.operador = function(c){
        var operadores = ['&','+','>','|','!','<','*','/','-','^'];
        var op = false;
        for(var i=0;((i<operadores.length) && (!op)); i++){
            if(operadores[i] === c) op = true;
        }
       return op; 
    };
    
    this.prioridad = function(op){
        var r = 4;
        if(op !== null){ 
            switch(op){
                case ')' : {r = 0; break;}
                case '(' : {r = 0; break;}
                case '&' : {r = 1; break;}
                case '|' : {r = 1; break;}
                case '>' : {r = 1; break;}
                case '<' : {r = 1; break;}
                case '+' : {r = (!this.tipo)? 1 : 0; break;}
                case '/' : {r = 1; break;}
                case '*' : {r = 1; break;}
                case '-' : {r = 0; break;}
                case '^' : {r = 2; break;}
                case '!' : {r = 2; break;}
            }
        }
        return r;
    };

    this.Separar = function(){      
        var i=0;
        var n = ((this.Exp).length)-1;
        var aux1;
        var aux2 = this.Exp;
        var e = new Array();
        var tipo = tipoExpresion(aux2);
        while((i<=n)){
            if(!tipo){
                while((i<=n)&&(!this.isLetter(aux2.charAt(i)))) i++;
                aux1="";
                while((i<=n)&&((this.isLetter(aux2.charAt(i))))){    
                    aux1=aux1+aux2.charAt(i);
                    i++;
                }
            }else{
                while((i<=n)&&(!this.isDigit(aux2.charAt(i)))) i++;
                aux1="";
                while((i<=n)&&((this.isDigit(aux2.charAt(i))))){    
                    aux1=aux1+aux2.charAt(i);
                    i++;
                }
            }
            e.push(aux1);
        }
        return e;
    };
    
    this.isDigit = function(digit){
       var numeros="0123456789.";
       for(var i=0; i<digit.length; i++){
          if (numeros.indexOf(digit.charAt(i),0)!==-1){
             return true;
          }
       }
       return false;
    };
    
    this.isLetter = function(texto){
       var letras="abcdefghyjklmnñopqrstuvwxyz";
       for(var i=0; i<texto.length; i++){
          if (letras.indexOf(texto.charAt(i),0)!==-1){
             return true;
          }
       }
       return false;
    };
    
    this.isLetterUpper = function(texto){
       var letras="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
       for(var i=0; i<texto.length; i++){
          if (letras.indexOf(texto.charAt(i),0)!==-1){
             return true;
          }
       }
       return false;
    };
       
    this.Valores = function(){
        var a = this.Separar();
        var aux="[ "; 
        for(var i=0; i<a.length;i++){
            if((i+1)===a.length) aux = aux + a[i].toString();
            else aux = aux + a[i].toString() + " ";
        }
        aux = aux + " ]";
        return aux;
    };
    
    this.Clasica = function(){
        var Cara = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var p = -1;        
        var aux = this.Exp;
        var n = aux.length-1;
        var i = 0;
        var aux1 = "";
        var tipo = tipoExpresion(aux);
        while(i<=n){
            if(!tipo){
                while((i<=n)&&(!this.isLetter(aux.charAt(i)))){  
                    aux1 = aux1+aux.charAt(i);
                    i++;
                }
                var sw=false;
                while((i<=n)&& (this.isLetter(aux.charAt(i)))){    
                    if(sw===false){
                        sw=true;
                        p++;
                    }
                    i++;
                }
            }else{
                while((i<=n)&&(!this.isDigit(aux.charAt(i)))){  
                    aux1 = aux1+aux.charAt(i);
                    i++;
                }
                var sw=false;
                while((i<=n)&& (this.isDigit(aux.charAt(i)))){    
                    if(sw===false){
                        sw=true;
                        p++;
                    }
                    i++;
                }
            }
            if((p!==-1)&&(sw)) aux1 = aux1+Cara.charAt(p);
        }
        //alert(aux1);
        return aux1;
    };
}

//Clase nodo
function Nodo(dat){
    this.HI = null;
    this.data = dat;
    this.HD = null ;
            
    this.setIzquierda = function(Hizq){
        this.HI = Hizq;
    };
    
    this.setDerecha = function(Hder){
        this.HD = Hder;
    };
    
    this.getData = function(){
        return this.data;
    };
    
    this.getIzquierda = function(){
        return this.HI;
    };
    
    this.getDerecha = function(){
        return this.HD;
    };
    
}

//clase Pila
function Pila(){
    this.v = new Array();
    this.tope = -1;
    this.max = 100;
        
    this.Pila = function(max){
        this.max = max;
        this.tope = -1;
    };
    
    this.vacia = function(){
        return (this.tope === -1);
    };
    
    this.llena = function(){
        return (this.tope === this.max-1);
    };
    
    this.poner = function(dato){
        if(!this.llena()){
            var pos = this.tope++; 
            this.v[pos] = dato;
        }
    };

    this.sacar = function(){
        var dato = null;
        if(!this.vacia()){
            this.tope--;
            dato = this.v[this.tope];           
        }
        return dato;
    };
    
    this.cima = function(){
    	if(!this.vacia()){
            var pos = this.tope-1;
            return this.v[pos];
        }
        else return null;   
    };	
}

//clase comprobador
function Comprobador(){
    this.Scan = function(Exp){
        var x = this.limpiarEspacios(Exp);
        if(this.okParentesis(x)){
            if(this.okOperadores(x)){
                return x;
            }else alert("Verifique la expresión, hay operadores juntos.");
        }else alert("Verifique los parentesis.");;
        return "wrong";
    };   
    this.limpiarEspacios = function(Exp){
        var aux = "";
        for(var i=0; i<Exp.length; i++){
            if(Exp.charAt(i)!==' ') aux = aux + Exp.charAt(i);
        }
        return aux;
    };
    this.okParentesis = function(Exp){
        var p = new Pila();
        for(var i=0; i<Exp.length; i++){
            if(Exp.charAt(i)==='(') p.poner(Exp.charAt(i));
            else{
                if(Exp.charAt(i)===')'){
                    if(p.vacia()) return false;
                    else p.sacar();
                }
            }
        }
        return (p.vacia()===true);     
    };
    this.okOperadores = function(Exp1){       
        var Exp = this.limpiarParentesis(Exp1);
        if(this.Operador(Exp.charAt(0))||(this.Operador(Exp.charAt(Exp.length-1)))) return false;
        else{
            var sw=true;
            for(var i=1; i<Exp.length-1;i++){
                if(this.Operador(Exp.charAt(i))&&(this.Operador(Exp.charAt(i+1)))) return false;   
            }
            return sw;
        }
    };
    this.limpiarParentesis = function(Exp){
        var aux="";
        for(var i=0; i<Exp.length; i++){
            if((Exp.charAt(i)!=='(')&&(Exp.charAt(i)!==')')) aux = aux + Exp.charAt(i);
        }
        return aux;
    }; 
    this.Operador = function(x){
          var sw = false;
          switch(x){
             case '&' : sw = true; break;
             case '+' : sw = true; break;
             case '*' : sw = true; break;
             case '/' : sw = true; break;
            // case '-' : sw = true; break;
             case '>' : sw = true; break;
             case '<' : sw = true; break;
             case '|' : sw = true; break;     
          }  
	  return sw;
    };
}

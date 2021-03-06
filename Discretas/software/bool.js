//ASÍ DEBE SER LOS BOTONES DE LOS OPERADORES Y PROPOSICIONES


//ASÍ CALCULAN EL RESULTADO
//<input type="button" value="Calcular" id="calcular" onclick="(new Calcular()).calcular()">

//ASÍ CREAN LA TABLA
//<input type="button" style="width:40%" value="Tabla" id="tabla" onclick="crearTabla()"/>



var variables = ["x","1","y","1","z","1","w","1"];
var verdades = [0,0,0,0];
var proposiciones = ["x","y","z","w"];
var finalStatement = "";
var tableStatement = "";
var tipo_tabla = new Array();
var proposicionesSimples = new Array();
var array = new Array();
var answers = new Array();
var ventana = null;

//cambiar valores de verdad
function switchValue(value){
    var rdnbutton = document.getElementsByName("valor");
    var textFields = document.getElementsByName("value");
    var i;
    for(i=0; i<rdnbutton.length;i++){
        if(rdnbutton[i].checked === true){
            textFields[i].value = value;
            break;
        }
    }
       
    for(var k=0; k<variables.length; k++){
        if(variables[k]===(rdnbutton[i].value)){
            if(value==="true") variables[k+1] = "1";
            else variables[k+1] = "0";
        }
    } 
}

//retornar variable
function retornar(num,statement){
    var anterior=document.fo.valores.value;//obtiene lo que hay en el campo de texto de la calculadora
    document.getElementById("valores").value=anterior+num;//adiciona el elemento presionado
    finalStatement+=statement;
}

//eliminar ultimo valor DEL
function eliminar(){
    var anterior=document.fo.valores.value;
    var nuevovalor=anterior.substring(0,anterior.length-1);
    finalStatement = finalStatement.substring(0,finalStatement.length-1);
    document.getElementById("valores").value=nuevovalor;
}

//eliminartodo
function limpiarTextField(){
    document.fo.valores.value="";
    document.fo.resultado.value="";
    
    for(var i = 0; i< texts.length ;i++){
        texts[i].value = "";
    }
    finalStatement = "";
}

//cerrarVentana
function cerrarTabla(obj){
    obj.close();
}
  
function crearTabla(){
    if(tableStatement!=="" && tableStatement.length!==0){
        answers = new Array();
        var valor = "";
        var n = calcularCantVariables(tableStatement);
        var rows = Math.pow(2,n);
        if(ventana!==null) ventana.close();
        ventana = window.open('','ventana','width=800,height=550,top='+ ((screen.height - 550) / 2) + ',left=' + ((screen.width - 900) / 2));
        ventana.document.write('<head><title>Tabla de compuertas lógicas</title></head>');
	    ventana.document.write('<body bgcolor="#6B6B6D">');
        ventana.document.write('<style>');
        ventana.document.write('*{font-family: "arial";}');
        ventana.document.write('table, th, td {border: 1px solid black;width:100px;color="white;"}');
	    ventana.document.write('input[type="button"],[type="submit"]{');
        ventana.document.write('font-size: 20px;');
        ventana.document.write('color: white;');
        ventana.document.write('background: black;');
        ventana.document.write('}');
        ventana.document.write('table{width:100%; height:400px; text-align:center;border:black 3px solid;border-radius:7px;border-spacing: 0px;margin:0 auto;}input[type="button"]{border-style:solid;border-radius:6px;');
        ventana.document.write('border-radius: 10px;border-spacing: 0px; border: black 5px solid;');
        ventana.document.write('margin:0 auto;}');
        ventana.document.write('</style>');        
        ventana.document.write('<body>');
        ventana.document.write('<table>');
        ventana.document.write('<caption><label><strong><font color="white" size="4px">Tabla de compuertas lógicas</font></strong></label><br></caption>');
        ventana.document.write('<thead>');
        ventana.document.write('<tr>');
        
        for(var i=0; i<verdades.length; i++){
            if(verdades[i] ){
                ventana.document.write('<th><label><font color="white">'+proposiciones[i].toUpperCase()+'</font></label></th>');
                
            }
        }
        if(tableStatement.length===1){
            ventana.document.write('<th><label><font color="white">'+proposicionesSimples[0].toUpperCase()+'</font></label></th>');
        }else{
            generarEncabezado();
            for(var pos=0; pos<array.length; pos++){
                ventana.document.write('<th><label><font color="white">'+ array[pos] +'</font></label></th>');
            }
        }
        ventana.document.write('</tr>');
        ventana.document.write('</thead>');

        

        for(var idx=0; idx<rows; idx++){
            ventana.document.write('<tr>');
            var k=0;
            for(var j=n-1;j>=0;j-=1){
                var value = parseInt((idx/parseInt(Math.pow(2,j))))%2;
                if(value === 1) valor="1";
                else valor="0";
                ventana.document.write('<td><label><font color="white">'+ valor.toUpperCase() +'</font></label></td>');
                cambiarValor(proposicionesSimples[k],valor);
                k++;
            }
            var resultado = (new Calcular()).calcularTabla();
            if(answers.length>0){
                for(var index=0; index<answers.length; index++){
                    ventana.document.write('<td><label><font color="white">'+ answers[index].toUpperCase() +'</font></label></td>');               
                }
                tipo_tabla.push(answers[answers.length-1]);
            }else{
                ventana.document.write('<td><label><font color="white">'+ resultado.toUpperCase() +'</font></label></td>');
                tipo_tabla.push(resultado);
            }                
            ventana.document.write('</tr>');
            answers = new Array();
        }
        ventana.document.write('</table>');
	ventana.document.write('<td colspan="5"><hr size="4px" color="black"></td>');
        ventana.document.write('<div ALIGN="center">');
        ventana.document.write('<input type="button" value="Cerrar" onclick="opener.cerrarTabla(window)" />');
        ventana.document.write('</div>');
        ventana.document.write('</body>');
        array = new Array();
        proposicionesSimples = new Array();
        verdades = [0,0,0,0];
    } else alert("No hay expresión guardada");    
}

function calcularCantVariables(statement){
    var props = statement;
    for (var i=0; i<props.length; i++){
        switch (props[i]) {
            case "x":
                verdades[0] = true;
                break;
            case "y":
                verdades[1] = true;
                break;
            case "z":
                verdades[2] = true;
                break;
            case "w":
                verdades[3] = true;
                break;
        }            
    }
    var cantValues = 0;
    for(var idx=0;idx<verdades.length;idx++){
        if(verdades[idx]){
            switch (idx) {
                case 0:
                    proposicionesSimples.push("x");
                    break;
                case 1:
                    proposicionesSimples.push("y");
                    break;
                case 2:
                    proposicionesSimples.push("z");
                    break;
                case 3:
                    proposicionesSimples.push("w");
                    break;
            } 
            cantValues++;
        }
    }
    return cantValues;
}

function cambiarValor(proposicion,valor){
    for(var i=0; i<variables.length; i++){
        if(variables[i]===proposicion){
            variables[i+1]=valor; break;
        }
    }
}

function tipoTabla(){
    var TAUTOLOGICA = 0;
    var CONTRADICCION = 0;
    for(var i=0; i<tipo_tabla.length;i++){
        if(tipo_tabla[i]==="1") TAUTOLOGICA++;
        else CONTRADICCION++;
    }
    var tipo = "";
    if(TAUTOLOGICA===tipo_tabla.length) tipo="TAUTOLOGÍA";
    else if(CONTRADICCION===tipo_tabla.length) tipo="CONTRADICCIÓN";
    else tipo="CONTINGENCIA";
    tipo_tabla = new Array();
    return tipo;
}

function generarEncabezado(){
    var expresion= tableStatement;
    if(expresion.length!==0){
        var aux = expresion;
        var e = new Expresion(aux);
        var exp = e.CompletoPrefija();
        for(var idx=0; idx<exp.length; idx++){
            if((exp[idx])==="!") exp.splice(idx+1,0,"+");
        }
        if((exp.length!==0)){                
            var ar = new ArbolExpresion();
            ar.ArbolExpresion(exp);
            ar.getExpresion(); 
        }
    }
}

//Logica
//Clase ArbolExpresion
function ArbolExpresion(){
    
    this.Raiz;  
        
    this.Evaluador = function(){
        return this.Evaluar(this.Raiz);
    };
    
    this.ArbolExpresion = function(Exp){
        var aux =  Exp[0];
        var q = new Nodo(aux.toString());
        var op = new Nodo(aux.toString());
        var p = new Pila();
        var antesOperando = false;
        this.Raiz = q;
        for(var i=1; i<Exp.length; i++){
            var aux2 = Exp[i];
            op = new Nodo(aux2.toString());
            if(antesOperando){
                q = p.sacar();
                q.setHD(op);
            }else{
                q.setHI(op);
                p.poner(q);
            }
            q = op;
            antesOperando = !this.operador(Exp[i]);
        }      
    };
    
    this.Hoja = function(nodo){
        return ((nodo.getHI()===null)&&(nodo.getHD()===null));
    };
    
    this.operador = function(c){
        var operadores = ['&','⨁','>','|','!','<'];
        var existe = false;
        var aux = c.toString().charAt(0);
        for(var i=0; ((i<operadores.length) && (!existe)); i++){
            if(aux === operadores[i]) existe = true;
        }
        return existe;
    };
    
    this.Evaluar = function(R){
       var res="";
       if(R===null) return res;
       else{
            if(this.Hoja(R)){
                var aux = R.getData();
                res = aux;
            }else{ 
                var op = R.getData().charAt(0);             
                var vizq = this.Evaluar(R.getHI());
                var vder = this.Evaluar(R.getHD()); 
                switch(op){
                    case '&' : res = (vizq==="1" && vder==="1")? "1": "0";break;
                    case '|' : res = (vizq==="0" && vder==="0")? "0": "1";break;
                    case '>' : res = (vizq==="1" && vder==="0")? "0": "1";break;
                    case '⨁' : res = (!(vizq===vder))? "1": "0";break;
                    case '<' : res = (vizq===vder)? "1": "0";break;
                    case '!' : res = (vder==="0")? "1": "0";break;
                    default:; break;
                }
                answers.push(res);
            }  
       }
       return res;
    };
    
    this.getExpresion = function(){
        this.getEncabezado(this.Raiz);
    };
    
    this.getEncabezado = function(R){
       var res="";
       if(R===null) return res;
       else{
            if(this.Hoja(R)){
                var aux = R.getData();
                res = aux;
            }else{ 
                var op = R.getData().charAt(0);             
                var vizq = this.getEncabezado(R.getHI());
                var vder = this.getEncabezado(R.getHD()); 
                switch(op){
                    case '&' : op = '·';break;
                    case '|' : op = '+';break;
                    case '>' : op = '→';break;
                    case '<' : op = '↔';break;
		    case '⨁' : op = '⨁';break;

                }
                if(op==='!') res='(´'+vder.toUpperCase()+')';
                else res='('+vizq.toUpperCase()+op+vder.toUpperCase()+')';
                array.push(res);
            }         
       }
       return res;
    };
}

//Clase Calcular
function Calcular(){
      
    this.calcular = function(){ 
        var  temp = finalStatement;
        var resultado="";
        var validacion = new Comprobador();
        var vars = validacion.Scan(temp);
        if(vars!=="wrong"){
            var expresion = "";
            for(var i=0; i<vars.length ;i++){
                switch (vars[i]){
                    case "x":
                        expresion+=variables[1];
                        break;
                    case "y":
                        expresion+=variables[3];
                        break;
                    case "z":
                        expresion+=variables[5];
                        break;
                    case "w":
                        expresion+=variables[7];
                        break;
                    default:
                        expresion+=(vars[i]);
                        break; 
                }
            }       
            if(expresion.length!==0){
                var aux = expresion;
                var e = new Expresion(aux);
                var exp = e.CompletoPrefija();
                for(var idx=0; idx<exp.length; idx++){
                    if((exp[idx])==="!") exp.splice(idx+1,0,"+");
                }
                if((exp.length!==0)){                
                    var ar = new ArbolExpresion();
                    ar.ArbolExpresion(exp);
                    resultado = ar.Evaluador(); 
                }
            } 
            if(resultado!==""){
                var word = document.getElementById("valores").value;
                if(word.length<30){
                    
                } else document.getElementById("resultado").value = "Expresión ≡ "+ resultado.toUpperCase();
            }
            else{
                
                alert("No hay ninguna expresión");
            }
            document.getElementById("valores").value = "";
            tableStatement=finalStatement;
            finalStatement="";
        }    
        return resultado;        
    }; 
    
    this.calcularTabla = function(){ 
        var vars = tableStatement;
        var expresion = "";
        for(var i=0; i<vars.length ;i++){
            switch (vars[i]){
                case "x":
                    expresion+=variables[1];
                    break;
                case "y":
                    expresion+=variables[3];
                    break;
                case "z":
                    expresion+=variables[5];
                    break;
                case "w":
                    expresion+=variables[7];
                    break;
                default:
                    expresion+=(vars[i]);
                    break; 
            }
        }
        var resultado="";
        if(expresion.length!==0){
            var aux = expresion;
            var e = new Expresion(aux);
            var exp = e.CompletoPrefija();
            for(var idx=0; idx<exp.length; idx++){
                if((exp[idx])==="!") exp.splice(idx+1,0,"+");
            }
            if((exp.length!==0)){                
                var ar = new ArbolExpresion();
                ar.ArbolExpresion(exp);
                resultado = ar.Evaluador(); 
            }
        } 
        return resultado;        
    };
}

//Clase Expresion
function Expresion(expr){
    
    this.Exp = expr; 
            
    this.getExpresion = function(){
        return this.Exp;
    };
    
    this.CompletoPrefija = function() {
        var sep = this.Separar();
        var completo = new Array();
        var n = sep.length-1;
        var j=0;
        var pfija = this.preFija();
        for(var i=0;((i<pfija.length)&&(j<=n));i++){
            var e1 = pfija[i];            
            if(this.isLetterUpper(e1)){
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
        var operadores = ['&','⨁','>','|','!','<'];
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
                case '⨁' : {r = 1; break;}
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
        while((i<=n)){
            while((i<=n)&&(!this.isLetter(aux2.charAt(i)))) i++;
            aux1="";
            while((i<=n)&&((this.isLetter(aux2.charAt(i))))){    
                aux1=aux1+aux2.charAt(i);
                i++;
            }
            e.push(aux1);
        }
        return e;
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
        while(i<=n){
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
            if((p!==-1)&&(sw)) aux1 = aux1+Cara.charAt(p);
        }
        return aux1;
    };
}

//Clase nodo
function Nodo(dat){
    this.HI = null;
    this.data = dat;
    this.HD = null ;
            
    this.setHI = function(Hizq){
        this.HI = Hizq;
    };
    
    this.setHD = function(Hder){
        this.HD = Hder;
    };
    
    this.getData = function(){
        return this.data;
    };
    
    this.getHI = function(){
        return this.HI;
    };
    
    this.getHD = function(){
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
                if(this.okProposiciones(x)) return x;
                else alert("Verifique la expresión, hay dos proposiciones juntas.");
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
    this.okProposiciones = function(Exp1){       
        var Exp = this.limpiarParentesis(Exp1);
        var sw=true;
        for(var i=0; i<Exp.length-1;i++){
            if(this.Proposicion(Exp.charAt(i))&&(this.Proposicion(Exp.charAt(i+1)))) return false;   
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
    this.Operador = function(x){
          var sw = false;
          switch(x){
             case '&' : sw = true; break;
             case '⨁' : sw = true; break;
             case '>' : sw = true; break;
             case '<' : sw = true; break;
             case '|' : sw = true; break;     
          }  
	  return sw;
    };
    this.Proposicion = function(x){
          var sw = false;
          switch(x){
             case 'p' : sw = true; break;
             case 'q' : sw = true; break;
             case 'r' : sw = true; break;
             case 's' : sw = true; break;
          }  
	  return sw;
    };
}
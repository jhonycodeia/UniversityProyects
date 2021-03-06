package Grafico;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Crearhtml {

    private String conjunto(String text) {
        StringTokenizer token = new StringTokenizer(text, "(),", false);
        ArrayList<String> lista = new ArrayList<>();
        String texto = "";
        while (token.hasMoreTokens()) {
            String aux = token.nextToken();

            if (!lista.contains(aux)) {
                lista.add(aux);
            }
        }
        for (int i = 0; i < lista.size(); i++) {
            texto += lista.get(i) + ",";
        }

        return texto.substring(0, texto.length() - 1);
    }
   
    private void openURL(String url) {
        
        String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Windows")) 
            {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } 
            else if (osName.startsWith("Mac OS X")) 
            {
                Runtime.getRuntime().exec("open " + url);
            } 
            else 
            {
                System.out.println("Please open a browser and go to "+ url);
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Failed to start a browser to open the url " + url);
        }
    }
    public void crear(String texto) {
        try {
            File file = new File("Grafo\\diagrama.html");
            FileWriter write = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(write);

            buffer.write("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "	<head>\n"
                    + "		<meta charset=\"utf-8\">\n"
                    + "		<title>\n"
                    + "			Simulador : Relaciones Binarias\n"
                    + "		</title>\n"
                    + "		<script src=\"vis.js\" type=\"text/javascript\"></script>\n"
                    + "	</head>\n"
                    + "	<body>\n"
                    + "		<style>\n"
                    + "\n"
                    + "			#visualization\n"
                    + "			{\n"
                    + "				background: #000000;\n"
                    + "				border-radius: 30px 30px 30px 30px;\n"
                    + "				border: 5px solid #7a767a;\n"
                    + "				margin: 0 auto;\n"
                    + "				width: 90%;\n"
                    + "				height: 700px;\n"
                    + "			}\n"
                    + "                    h1{"
                    + "                        font-family: 'Helvetica Neue',monospace;"
                    + "                        text-align: center;"
                    + "                        font-size: 40px;"
                    + "                        margin: 0 auto;"
                    + "                    }\n"
                    + "                    body{"
                    + "                        background-image: url('fondo.jpg');"
                    + "                    }\n"
                    + "                    #conjunto{"
                    + "                        text-align: center;"
                    + "                        font-family: 'Helvetica Neue',monospace;"
                    + "                        font-size: 20px;"
                    + "                        padding-top: 30px;"
                    + "                       margin: 0 auto;"
                    + "                   }"
                    + "\n"
                    + "		</style>\n"
                    + "\n"
                    + "		<script>\n"
                    + "\n"
                    + "		function partes_relacion(expresion) \n"
                    + "		{\n"
                    + "			var objeto = [];\n"
                    + "			var text = \"\";\n"
                    + "			var partes = \"\";\n"
                    + "			var hacer = false;\n"
                    + "\n"
                    + "			for (var i = 0; i < expresion.length; i++) \n"
                    + "			{\n"
                    + "		\n"
                    + "				if(expresion.charAt(i)==')')\n"
                    + "				{\n"
                    + "					hacer = false;\n"
                    + "					partes = text.split(\",\");\n"
                    + "					objeto.push({izquierda:partes[0],derecha:partes[1]});\n"
                    + "					text = \"\";\n"
                    + "\n"
                    + "				}\n"
                    + "		\n"
                    + "				if(expresion.charAt(i)=='(')\n"
                    + "				{\n"
                    + "					i++;\n"
                    + "					hacer = true;\n"
                    + "				}\n"
                    + "				if(hacer)\n"
                    + "				{\n"
                    + "					text = text + expresion.charAt(i);\n"
                    + "				}\n"
                    + "			}\n"
                    + "	 \n"
                    + "	 		return objeto;  \n"
                    + "		}\n"
                    + "\n"
                    + "		function graficar(conjunto,relacion) \n"
                    + "		{\n"
                    + "	\n"
                    + "			var nodes_object = [];\n"
                    + "			var edges_object = [];\n"
                    + "			for(var i=0;i<conjunto.length;i++)\n"
                    + "			{\n"
                    + "				nodes_object.push({id: conjunto[i], label:conjunto[i],color:'#FFFFFF'})\n"
                    + "			}\n"
                    + "			for(var j=0;j<relacion.length;j++)\n"
                    + "			{\n"
                    + "				edges_object.push({from:relacion[j].izquierda, to: relacion[j].derecha, arrows:'to',color:'#FFFFFF'})\n"
                    + "			}\n"
                    + "\n"
                    + "			var nodes = new vis.DataSet(nodes_object);\n"
                    + "    		var edges = new vis.DataSet(edges_object);\n"
                    + "			var container = document.getElementById('visualization');\n"
                    + "  			var data = {nodes: nodes,edges: edges};\n"
                    + "    		var options = {};\n"
                    + "    		var network = new vis.Network(container, data, options);\n"
                    + "		}\n"
                    + "\n"
                    + "		</script>\n"
                    + "		<h1>GRAFO DE SEGUIDORES</h1>\n"
                    + "		<div id=\"visualization\"></div>\n"
                    + "         <div id=\"conjunto\"></div>\n"
                    + "\n"
                    + "		<script>\n"
                    + "			var elementos = \""+conjunto(texto)+"\";\n"
                    + "			var union = \""+texto+"\";\n"
                    + "			\n"
                    + "			var conjunto =elementos.split(\",\");\n"
                    + "			var relacion = partes_relacion(union);\n"
                    + "\n"
                    + "			graficar(conjunto,relacion);\n"
                    + "                 var div_conjunto = document.getElementById('conjunto');"
                    + "                 div_conjunto.innerHTML = 'Relaciones: ' + union;"
                    + "\n"
                    + "		</script>\n"
                    + "	</body>\n"
                    + "</html>");

            buffer.close();
            write.close();
            
            openURL(file.getPath());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

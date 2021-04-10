package co.com.endava.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReverse {

	private static final String DELIMITER = "()<>";
	private static final String DELIMITER_O = "(<";
	private static final String DELIMITER_C = ")>";
	private static final String DELIMITER_PATTERN = "[" + DELIMITER + "]";
	private static final String DELIMITER_PATTERN_O = "[" + DELIMITER_O + "]";
	private static final String DELIMITER_PATTERN_C = "[" + DELIMITER_C + "]";

	public static String reverseCadena(String message) throws Exception {

		if (message.length() >= 0 && message.length() <= 50) {			
			if (validarJerarquia(message)) {
				return reverseCadenaSin(message);
			} else {
				return reverseCadenaCon(message);
			}
		} else {
			throw new Exception("Tamaño no valido debe ser entre 0 y 50");
		}

	}

	private static String reverseCadenaCon(String message) throws Exception {

		List<String> aux = new ArrayList<>();
		List<String> words = new ArrayList<>();
		Pattern pat = Pattern.compile(DELIMITER_PATTERN);
		StringTokenizer st = new StringTokenizer(message, DELIMITER, true);

		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			Matcher mat = pat.matcher(s);
			aux.add(s);

			if (!mat.matches()) {
				words.add(s);
			}
		}
		System.out.println("palabras"+words);
		System.out.println("before"+aux);
		for (String string : words) {
			int index = posicion(string, aux);
			System.out.println("index "+index);
			if(index!=-1) {
				aux.set(index, reverse(string));
				aux.remove(index-1);
				aux.remove(index);				
				System.out.println("after 1"+aux);
				aux.set(index-2, aux.get(index-2)+aux.get(index-1));
				aux.remove(index-1);
				System.out.println("after 2"+aux);				
			}
		}
		return reverseCadena(cadenas(aux));
	}

	private static int posicion(String word, List<String> aux) {
		int index = aux.indexOf(word);
		try {
			Pattern pat1 = Pattern.compile(DELIMITER_PATTERN_O);
			Pattern pat2 = Pattern.compile(DELIMITER_PATTERN_C);
			Matcher mat1 = pat1.matcher(aux.get(index - 1));
			Matcher mat2 = pat2.matcher(aux.get(index + 1));
			
			if (mat1.matches() && mat2.matches() && validarCierre(index,aux) && !aux.get(index - 1).equals(aux.get(index + 1))) {
				return index;
			}
		} catch (Exception e) {	}
		return -1;
	}
	
	private static boolean validarJerarquia(String texto) {
		Pattern pat = Pattern.compile(DELIMITER_PATTERN);
		StringTokenizer st = new StringTokenizer(texto, DELIMITER, true);
		String delimiter = "";
				
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			Matcher mat = pat.matcher(s);

			if (mat.matches()) {				
				if(delimiter.length()>1) {
					if(delimiter.charAt(delimiter.length()-1)==s.charAt(0)) {
						return false;
					}
				}
				delimiter += s;
			}
		}
		
		return true;
	}
	
	private static boolean validarCierre(int index,List<String> aux) {
		Pattern pat = Pattern.compile(DELIMITER_PATTERN_C);		
		try {
			for (int i = index+2; i < aux.size(); i++) {
				Matcher mat = pat.matcher(aux.get(i));
				if(mat.matches()) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private static String cadenas(List<String> aux) {
		String texto="";
		for (String string : aux) {
			texto +=string;
		}
		return texto;
	}
	
	private static String reverseCadenaSin(String message) {
		boolean parentesis = false;

		Pattern pat = Pattern.compile(DELIMITER_PATTERN);
		StringBuilder texto = new StringBuilder();
		StringTokenizer st = new StringTokenizer(message, DELIMITER, true);
		int i = 0;

		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			Matcher mat = pat.matcher(s);
			if (mat.matches()) {
				parentesis = !parentesis;
			} else if (parentesis) {
				texto.append(reverse(s));
			} else {
				texto.append(s);
			}
		}

		return texto.toString();
	}

	private static String reverse(String message) {
		return new StringBuilder(message).reverse().toString();
	}
	
}

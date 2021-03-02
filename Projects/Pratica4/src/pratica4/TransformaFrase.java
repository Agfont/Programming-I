package pratica4;
import java.util.*;
public class TransformaFrase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner (System.in);
		System.out.println("Entra una frase: ");
		String paraula = teclado.nextLine();
		System.out.print("La frase Transformada es: " + transforma(paraula));
		
	}
	static String transforma(String paraula) {
		String str = "";
		int len = paraula.length();
		char chr;
		if (paraula.substring(len-2, len).equals("fi")) {
        	// recorregut
        	for (int i=0 ; i < len; i++) {
               chr = paraula.charAt(i);
               if ((esVocal(chr)) || (esSigne(chr))) {
               }
               else {
            	   str += chr;
               }
        	}
        	int lenStr = str.length(); 
        	str = str.substring(0,lenStr-2);
        }
        else {
        	str = paraula;
        	}
		return str;
	}
	static boolean esVocal(char lletra) {
		if (lletra == 'a' || lletra == 'e' || lletra == 'i' || lletra == 'o' || lletra == 'u') {
			return true;
		}
		else {
			return false;
		}
	}
	static boolean esSigne(char lletra) {
		if (lletra == '.' || lletra == ',' || lletra == ':' || lletra == ';' || lletra == '-') {
			return true;
		}
		else {
			return false;
		}
	}
}

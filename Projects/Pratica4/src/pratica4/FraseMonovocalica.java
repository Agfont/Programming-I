/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica4;
import java.util.Scanner;
/**
 *
 * @author mat.aules
 */
public class FraseMonovocalica {
    public static void main (String [] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Entra una frase:");
        String paraula = teclado.nextLine();
        System.out.println("La frase monovocalica es: " + monovocalica(paraula));
    }
    static String monovocalica (String paraula) {
        int len = paraula.length();
        char letra;
        String paraulaNou = "";
        if (paraula.substring(len-2, len).equals("fi")) {
        	// recorregut
        	for (int i=0 ; i < len; i++) {
                letra = paraula.charAt(i);
                if (letra == 'a' || letra == 'e' || letra == 'o' || letra == 'u') {
                	paraulaNou += "i";
                }
                else {
                	paraulaNou += letra;
                }	
        	}
        	paraulaNou = paraulaNou.substring(0,len-3);
        }
        else {
        	paraulaNou = paraula;
        	}
        return paraulaNou;
        }
    }
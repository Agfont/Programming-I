import java.util.Scanner;
public class Exercici1{
	public static void main ( String [] args ) {
		// Entradas
		Scanner teclado = new Scanner(System.in);
		double amplada = teclado.nextDouble();
		double alcada = teclado.nextDouble();
		
		// Creacion d'objetos
		Rectangle meu = new Rectangle (amplada, alcada) ;
		
		System.out.println ("L�area d�un rectangle d�amplada " +
		meu.amplada + " i alcada " + meu.alcada + " �s "+ meu.getArea());
		System.out.println ("El perimetre �s " + meu.getPerimetre());
		}
	}	

class Rectangle {
		
	// Atributs
	double amplada, alcada, area, perimetre;
		
	
	// Constructor per defecte
	Rectangle () {
		
		}
		
	// Constructor amb parametres
	Rectangle ( double amplada , double novaAlcada ) {
		this.amplada = amplada ;
		alcada = novaAlcada ;
		}
		
	// Metode per obtenir l�area del rectangle
	double getArea () {
		return amplada * alcada;
		}
		
	// Metode per obtenir el perimetre del rectangle
	double getPerimetre () {
		return 2*amplada + 2*alcada;
		}
	
	}	
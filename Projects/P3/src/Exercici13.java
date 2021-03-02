/*
 * Autor: Arthur Font Gouveia
 * Data: 17/10/2018
 */
import java.util.Scanner;
public class Exercici13 {
	public static void main ( String [] args ) {
		// Entradas
		Scanner teclado = new Scanner(System.in);
		String nom;
		Double nota1, nota2, nota3, puntsAdd;
		nom = teclado.next();
		nota1 = teclado.nextDouble();
		nota2 = teclado.nextDouble();
		nota3 = teclado.nextDouble();
		puntsAdd = teclado.nextDouble();
		
		/* Creeu un alumne , demaneu les dades de l’alumne a l’usuari , i crideu elmetode 
		 * calcularNotaFinal () i veureNotaFinalFormatText ()
		 */
		Alumne meuAlumne = new Alumne(nom, nota1, nota2, nota3, puntsAdd);
		meuAlumne.modificarMaxPuntsExtra(1.5);
		meuAlumne.calcularNotaFinal();
		System.out.println(meuAlumne.veureNotaFinalFormatText());
	}
}

class Alumne {
	static double maxPuntsExtra = 1.5;
	String nom;
	String notaTexto;
	double notaExamen1;
	double notaExamen2;
	double notaExamen3;
	double puntsExtra;
	double notaFinal; // La nota final es calcula fent la mitjana de les notes dels examens + puntsExtra
	
	Alumne ( String nom ) {
		this . nom = nom ;
	}
	// La resta de parametres s’inicien per defecte a 0.0
	
	
	// Constructor amb parametres
	Alumne ( String nom , double n1 , double n2 , double n3,	
			double puntsExtra ) {
		this.nom = nom ;
		this.notaExamen1 = n1 ;
		this.notaExamen2 = n2 ;
		this.notaExamen3 = n3 ;
		this.puntsExtra = puntsExtra ;
	}
	
	void modificarMaxPuntsExtra ( double max ){
		maxPuntsExtra = max ;
		if (puntsExtra >= maxPuntsExtra) {
			puntsExtra = 1.5;
		}
	}
	
	/* Tests del metode calcularNotaFinal ()*
	 * 
	 */
	void calcularNotaFinal () {
		// Escriu el codi que falta
		notaFinal = (notaExamen1 + notaExamen2 + notaExamen3)/3 + puntsExtra;
		if (notaFinal >= 10) {
			notaFinal = 10;
		}
	}
	
	
	
	/* Tests del metode veureNotaFinalFormatText ()
	 *
	 */
	
	/* Mostar la nota en el seu equivalent en text ; en el cas que la nota 
	 * sigui Insuficient mostrar el text i la nota numerica
	 */
	String veureNotaFinalFormatText () {
		// Escriu el codi que falta
		if (notaFinal < 5) {
			notaTexto = "Insuficient " + notaFinal;
		}
		else if ((notaFinal >= 5) && (notaFinal < 6)) {
			notaTexto = "Suficient";
		}
		else if ((notaFinal >= 6) && (notaFinal < 7)) {
			notaTexto = "Bé";
		}
		else if ((notaFinal >= 7) && (notaFinal < 8)) {
			notaTexto = "Notable Baix";
		}
		else if ((notaFinal >= 8) && (notaFinal < 9)) {
			notaTexto = "Notable Alt";
		}
		else if ((notaFinal >= 9) && (notaFinal <= 10)) {
			notaTexto = "Excel·lent";
		}
		return notaTexto;
		
	}
}



/* Atributs de classe : maxPuntsExtra (el valor del atributo no cambia para cada objecto de la classe)
 * Atributs d" objecte : nom, notaExamen1, notaExame2, notaexamen3, puntsExtra, notaFinal, notaTexto
 * (el valor del atributo puede cambiar para cada objecto de la classe)
 * 
 * Los metodos pertenencen a la classe Alumne.
 * El metode veureNotaFinalFormatText() es un metodo de objecto (manipula los atributos de objecto)
 * El metode modificarMaxPuntsExtra() es un metodo de classe (manipula los atributos de classe)
 */
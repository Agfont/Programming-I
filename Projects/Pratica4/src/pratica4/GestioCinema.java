package pratica4;

import java.util.Scanner;

public class GestioCinema {
	public static void main (String [] args) {
		Scanner teclado = new Scanner (System.in);
		System.out.print("Nombre de files: ");
	    int numFiles = teclado.nextInt();
	    System.out.print("Nombre de columnes: ");
	    int numButaquesF = teclado.nextInt();
	    Cinema cine = new Cinema (numFiles, numButaquesF);
	    boolean sortida = false;
	    
	    while (!sortida) {
			menuOpcions();
			int opcio = teclado.nextInt();
			switch(opcio) {
			case 1:
				System.out.print("File butaca ha ser ocupada: ");
				int butacaF = teclado.nextInt();
				System.out.print("Columna butaca ha ser ocupada: ");
				int butacaC = teclado.nextInt();
				int llamada = cine.ocuparButaca(butacaF, butacaC);
				if (llamada == -1) {
					System.out.println("La butaca no existeix");
				}
				else if (llamada == -2) {
					System.out.println("La butaca ja estava ocupada");
				}
				else {
					System.out.println("La butaca s'ha ocupat correctament");
					
				}
				break;
			case 2:
				System.out.print("File butaca ha ser lliurada: ");
				int butacaLiureF = teclado.nextInt();
				System.out.print("Columna butaca ha ser lliurada: ");
				int butacaLiureC = teclado.nextInt();
				int llamadaF = cine.lliurarButaca(butacaLiureF, butacaLiureC);
				if (llamadaF == -1) {
					System.out.println("La butaca no existeix");
				}
				else if (llamadaF == -2) {
					System.out.println("La butaca ja estava lliure");
				}
				else {
					System.out.println("La butaca s'ha lliurat correctament");
				}
				break;
			case 3:
				cine.lliurarButaques();;
				break;
			case 4:
				cine.mostrarButaques();
				break;
			case 5:
				sortida = true;
				break;
			case 6:
				System.out.println("Butaques juntes?");
				int butaquesJuntes = teclado.nextInt();
				System.out.println(cine.PrimeraColumnaAmbButaquesLliuresJuntes(butaquesJuntes));
				break;
			}
	    }
	}
	
    public static void menuOpcions() {
    	System.out.println();
		System.out.println("1. Ocupar Butaca.");
		System.out.println("2. Lliurar Butaca.");
		System.out.println("3. Lliurar totes les butaques.");
		System.out.println("4. Mostrar butaques.");
		System.out.println("5. Sortir.");
		System.out.println("Introdueix la seva opcio: ");
		System.out.println();
    }
}
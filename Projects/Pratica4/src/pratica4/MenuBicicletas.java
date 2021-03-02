package pratica4;
import java.util.*;
public class MenuBicicletas {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		int opcio = -1; 
		boolean f1 = false;
		Bicicleta bici;
		TaulaBicicleta tb = new TaulaBicicleta(10);
		
		while (!f1) {
			showMenu();
			opcio = scan.nextInt();
			switch(opcio) {
			case 1:
				System.out.println("Model ?");
				String model = scan.next();
				System.out.println("Pes ?");
				double pes = scan.nextDouble();
				System.out.println("Suspensio (S/N)?");
				String s = scan.next();
				System.out.println("Preu ?");
				double preu = scan.nextDouble();
				bici = new Bicicleta (model,pes,s,preu);
				tb.afegirBici(bici);
				break;
			case 2:
				tb.mostrarBicis();
				break;
			case 3:
				System.out.println(tb.getBiciMinimoCostePerKilo());
				break;
			case 4:
				System.out.println("Pes ?");
				int peso = scan.nextInt();
				System.out.println(tb.getBiciMinimoPes(peso));
				break;
			case 5:
				f1 = true;
				break;
			}
		}
	}
	public static void showMenu() {
		System.out.println();
		System.out.println("1. Afegir bicicleta");
		System.out.println("2. Mostrar bicis");
		System.out.println("3. Obtenir la bicicleta que tingui menor cost per kilogram");
		System.out.println("4. Obtenir la bicicleta de pes inferior a um pes entrat per l'usuari, si és que n'hi ha alguna");
		System.out.println("5. Sortir");
		System.out.println("Introdueix la seva opcio: ");
		System.out.println();
	}
}

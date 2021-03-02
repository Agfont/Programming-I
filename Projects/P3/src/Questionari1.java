import java.util.Scanner;
import java.util.Random;
public class Questionari1 {
	public static void main (String [] args) {
		Scanner teclado = new Scanner(System.in);
		Circle circle0 = new Circle ();
		Circle circle1 = new Circle (1.6);
		Circle circle2;
		double ra; // Podem anomenar -la radi enlloc de ra?
		
		System.out.println("Num de circles: " + Circle.numCircles);
		System.out.println("Area del circle0 " + "amb radi "
							+ circle0.radi + " = " + circle0. calcularArea ());
		System.out.println("Area del circle1 " + "amb radi "
							+ circle1.radi + " = " + circle1. calcularArea ());
		System.out.print("Introdueix el radi del circle2: ");
		
		ra = teclado.nextDouble ();
		circle2 = new Circle (ra);
		
		System.out.println("Area del circle2 "+ "amb radi "
		+ circle2.radi + " = " + circle2. calcularArea ());
		System.out.println("Num de circles: " + Circle.numCircles);
		
		circle0. mostrarCircle ();
		circle1. mostrarCircle ();
		circle2. mostrarCircle ();
		}
}

class Circle{
	double radi;
	int id, tirada, n;
	static int numCircles = 0;
	Random aleatorio;
	
	Circle (){
		id = ++ numCircles;
		}
	
	Circle(double r){
		id = ++ numCircles;
		radi = r;
		}
	
	double calcularArea (){
		return Math.PI * radi * radi;
		}
	
	void mostrarCircle (){
		System.out.println("El meu id: " + id + " i el meu radi: " + radi);
		}
	int tirarDaus() {
		Random aleatorio = new Random();
		tirada = aleatorio.nextInt(6);
		n = tirada + 1;
		return n;
	}
		
}
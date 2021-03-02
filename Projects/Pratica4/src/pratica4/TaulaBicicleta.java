package pratica4;

public class TaulaBicicleta {
	Bicicleta [] taulaBicicletes;
	int nbicis = 0;
	
	TaulaBicicleta(int max) {
		if (max > 25) {
			taulaBicicletes = new Bicicleta [25];
		}
		else {
			taulaBicicletes = new Bicicleta [max];
		}
		
	}
	void afegirBici(Bicicleta b) {
		if (nbicis < 25) {
			taulaBicicletes[nbicis] = b;
			nbicis++;
		}
		else {
			System.out.println("Too many bikes");
		}
	}
	void mostrarBicis() {
		for (int i=0; i < nbicis; i++) {
			System.out.println(taulaBicicletes[i].toString());
		}
	}
	
	Bicicleta getBiciMinimoCostePerKilo () {
		double menor;
		double min = 10000.0;
		int position = -1;
		// Recorregut
		for (int i=0; i < nbicis; i++) {
			menor = taulaBicicletes[i].preu/ taulaBicicletes[i].pes;
			if (menor < min) {
				min = menor;
				position = i;
			}
		}
		return taulaBicicletes[position];
	}
	
	Bicicleta getBiciMinimoPes (int peso) {
		boolean trobat = false;
		int j = taulaBicicletes.length - 1;
		// Cerca
		for (int i=0; i < nbicis && !trobat; i++) {
			if (taulaBicicletes[i].pes < peso) {
				j = i;
				trobat = true;
			}
		}
		return taulaBicicletes[j];
	}
}
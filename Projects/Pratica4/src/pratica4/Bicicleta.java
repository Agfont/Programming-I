package pratica4;

public class Bicicleta {
	String model;
	double pes, preu;
	boolean suspensio;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Bicicleta(String model, double pes, String s, double preu) {
		this.model = model;
		this.pes = pes;
		this.suspensio = s.equals("S");
		this.preu = preu;
	}
	
	public String toString() {
		return model + " " + pes + " " + suspensio + " " + preu;
	}
}
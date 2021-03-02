
public class Lista2 {
	static final float EPSILON = 0.000001f;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c, d, i;
		float x, f, g, h, z;
		boolean sonIgualsF, sonIgualsD;
		char car1 = 'a', car2;
		
		b = 3 * 10 / 7;
		c = 3 / 10 * 7;
		System.out.println("b= " + b + ", c= " + c);
		       
		z = 10e-3f;
		System.out.println("z= " + z);
		
		x = 1000;
		x = 1 / x;
		a = (int) x;
		System.out.println("b=" + b + ", x=" + x + ", a=" + a);
		       
		d = 6 % 10;
		System.out.println("d=" + d);
		       
		f = 0.0f;
		f += 0.02f;
		f += 0.03f;
		
		sonIgualsF = f == 0.05f;
		System.out.println("sonIgualsF = " + sonIgualsF);
		       
		sonIgualsF = Math.abs(f - 0.05f) < EPSILON;
		System.out.println("sonIgualsF = " + sonIgualsF);
		       
		g = 1.000001f;
		h = 0.000001f;
		sonIgualsD = (g-h) == 1.0;
		System.out.println("sonIgualsD = " + sonIgualsD);
		       
		sonIgualsD = Math.abs((g-h) - 1.0) < EPSILON;
		System.out.println("sonIgualsD = " + sonIgualsD);
		       
		car2 = (char) (car1 + 1);
		System.out.println("car2 = " + car2);
		       
		i = car2 + 1;
		System.out.println("i = " + i + ", i = " + (char) i);

		       		
	}
}

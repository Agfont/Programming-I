import java.util.Scanner;

public class Cinema {
    /**
     * @param args the command line arguments
     */
    int numFiles ,numButaquesF;
    boolean [][] butaques;
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    Cinema (int numFiles, int numButaquesF) {
    	this.numFiles = numFiles;
    	this.numButaquesF = numButaquesF;
        butaques = new boolean [numFiles][numButaquesF];
    }
    
    int ocuparButaca(int fila, int columna) {
    	int ocupar = 0;
    	if ((fila > numFiles) || (columna > numButaquesF)) {
    		ocupar = -1;
    	}
    	else if (ocupar != 1 && butaques [fila][columna]) {
    		ocupar = -2;
    	}
    	else  {
    		butaques[fila][columna] = true;
    	}
        return ocupar;
    }
    
    int lliurarButaca(int fila, int columna) {
    	int lliurar = 0;
    	if ((fila > numFiles) || (columna > numButaquesF)) {
    		lliurar = -1;
    	}
    	else if (lliurar != 1 && !butaques [fila][columna]) {
    		lliurar = -2;
    	}
    	else {
    		butaques[fila][columna] = false;
    	}
        return lliurar;
    }
    
    void lliurarButaques() {
    	for (int i=0;i<numFiles;i++){
            for(int j=0;j<numButaquesF;j++){
                butaques[i][j] = false;
            }
        }
    }
    void mostrarButaques() {
    	System.out.print("Num butaca: ");
    	for (int k=0;k<numButaquesF;k++){
    		System.out.print(k + "  ");
    	}
    	System.out.println();
    	for (int i=0;i<numFiles;i++){
    		System.out.print("Fila: " + i + "     ");
            for(int j=0;j<numButaquesF;j++){
            	if (butaques[i][j]) {
                    System.out.print("O" + "  ");

            	}
            	else {
                    System.out.print("L" + "  ");

            	}
            }
            System.out.println();
        }
    }
    int PrimeraColumnaAmbButaquesLliuresJuntes (int numButaquesJuntes){
        int num = 0, aux = 0, indexColumna = -1;
        boolean trobat = false;
        while (!trobat) {
        	for (int i=0;i<numButaquesF;i++){
                for(int j=0;j<numFiles;j++){
                    if (!butaques[j][i]) {
                        num += 1;
                    }
                    else {
                        if (aux < num) {
                            aux = num;
                        }  
                        num = 0;
                    }
                }
                if (aux == numButaquesJuntes) {
                    indexColumna = i;
                    trobat = true;
                }
            }
        	trobat = true;
        }
        return indexColumna;
    }
}
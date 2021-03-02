/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.ub.juanadearco;

import edu.ub.juanadearco.actors.Clau;
import edu.ub.juanadearco.actors.Heroina;
import edu.ub.juanadearco.actors.Menjar;
import edu.ub.juanadearco.actors.Serp;
import edu.ub.juanadearco.actors.Vida;

/**
 * Demo.
 * 
 * @author Prog1
 */
public class Practica{

    private Joc joc;
    private Castell castell;
    private Heroina heroina;

    private static final int MAX_MENJAR_PER_HABITACIO = 2;
    
    private Practica() {
        castell = new Castell(3, 3); //3 pisos
        
        castell.addHabitacio(0, 0, crearHabitacio0Planta0());
        castell.addHabitacio(0, 1, crearHabitacio1Planta0());
        castell.addHabitacio(0, 2, crearHabitacio2Planta0());                            
        
        castell.addHabitacio(1, 0, crearHabitacio0Planta1());
        castell.addHabitacio(1, 1, crearHabitacio1Planta1());
        castell.addHabitacio(1, 2, crearHabitacio2Planta1());
        
        castell.addHabitacio(2, 0, crearHabitacio0Planta2());
        castell.addHabitacio(2, 1, crearHabitacio1Planta2());
        castell.addHabitacio(2, 2, crearHabitacio2Planta2());
        
        heroina = new Heroina();
        Habitacio h = castell.getHabitacio(0, 0);
        int[] p = h.getPosicioCela(10, 10);
        heroina.setPosicioInicial(p[0], p[1]);
        
        joc = new Joc(castell, heroina);
        
        // Llamadas
        distribuirMenjar();
        distribuirVida();
        distribuirSerp();
        distribuirClaus();
        
        GuiJoc gui = new GuiJoc(joc);      
    }
    
        
    private Habitacio crearHabitacio0Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_0.txt");
        
        Porta porta = h.getPorta(14, 24); //(0-16, 0-24)
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 1)); // (0-14, 1-23)

        porta = h.getPorta(0, 10);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 10));        

        // Ascensor para piso 1 (Subida)
        porta = h.getPorta(0, 12);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 12));        
        
        return h;
    }
    
    private Habitacio crearHabitacio1Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_1.txt");

        Porta porta = h.getPorta(1, 0);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 23));
       
        return h;
    }

    private Habitacio crearHabitacio2Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_2.txt");
        Porta porta = h.getPorta(16, 10);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 10));
        
        return h;
    }
    
    
    // Nuevas habitaciones
    private Habitacio crearHabitacio0Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_0.txt");
        
        Porta porta = h.getPorta(8,0);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8, 23));

        porta = h.getPorta(8, 24);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8,1)); 
        
        // Ascensor para Piso 0 (Bajada)
        
        porta = h.getPorta(16, 12);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 12));
        
        // Ascensor para piso 2 (Subida)
        porta = h.getPorta(0, 12);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 12));
        
        return h;
    }
    
    private Habitacio crearHabitacio1Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_1.txt");
        
        Porta porta = h.getPorta(8, 24);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8,1));
        
        return h;
    }
    
    private Habitacio crearHabitacio2Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_2.txt");
        
        Porta porta = h.getPorta(8,0);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8, 23));
        
        return h;
    }
    
    private Habitacio crearHabitacio0Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_0.txt");
        
        Porta porta = h.getPorta(8,0);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8, 23));

        porta = h.getPorta(8, 24);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8,1)); 
        
        // Ascensor para Piso 1 (Bajada)
        
        porta = h.getPorta(16, 12);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 12));
        return h;
    }
    
    private Habitacio crearHabitacio1Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_1.txt");
        
        Porta porta = h.getPorta(8, 24);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8,1));
        
        return h;
    }
    
    private Habitacio crearHabitacio2Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_2.txt");
         
        Porta porta = h.getPorta(8,0);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8, 23));
        
        return h;
    }
    
    // distribuir
    
    private void distribuirVida() {
        Habitacio h1 = castell.getHabitacio(2,1);
        Habitacio h2 = castell.getHabitacio(2,2);
        Vida v1 = new Vida("Vida", 100, 174, 12, 26, 24);
        Vida v2 = new Vida("Vida", 100, 174, 12, 26, 24);
        
        int[] posicio1 = h1.getPosicioCela(2,2);
        v1.setPosicioInicial(posicio1[0], posicio1[1]);
        h1.addActor(v1);
        
        int[] posicio2 = h2.getPosicioCela(14,22);
        v2.setPosicioInicial(posicio2[0], posicio2[1]);
        h2.addActor(v2);        

    }
    
    private void distribuirSerp() {
        Habitacio h1 = castell.getHabitacio(0,0);
        Habitacio h2 = castell.getHabitacio(1,0);
        Habitacio h3 = castell.getHabitacio(2,0);
        Habitacio h4 = castell.getHabitacio(1,1);
        Habitacio h5 = castell.getHabitacio(1,2);
        
        Serp s1 = new Serp("Serpente 1", 50, 700, 0, 40, 42);
        Serp s2 = new Serp("Serpente 2", 50, 700, 42, 40, 42);
        Serp s3 = new Serp("Serpente 3", 50, 700, 84, 40, 42);
        Serp s4 = new Serp("Serpente 1", 50, 700, 0, 40, 42);
        Serp s5 = new Serp("Serpente 2", 50, 700, 42, 40, 42);
     
        int[] posicio1 = h1.getPosicioCela(6,11);
        s1.setPosicioInicial(posicio1[0], posicio1[1]);
        h1.addActor(s1);
        
        int[] posicio2 = h2.getPosicioCela(11,12);
        s2.setPosicioInicial(posicio2[0], posicio2[1]);
        h2.addActor(s2);        
        
        int[] posicio3 = h3.getPosicioCela(12,6);
        s3.setPosicioInicial(posicio3[0], posicio3[1]);
        h3.addActor(s3);
        
        int[] posicio4 = h4.getPosicioCela(8,18);
        s4.setPosicioInicial(posicio4[0], posicio4[1]);
        h4.addActor(s4);
        
        int[] posicio5 = h5.getPosicioCela(8,6);
        s5.setPosicioInicial(posicio5[0], posicio5[1]);
        h5.addActor(s5);
        
    }
    
   private void distribuirClaus() {
        String[] clausComuns = {  "Ferro", "Bronze", "Llauto", "Plata"} ;
        String clauOr = "Or";
        
        int[] dades = { 675, 50, 20, 30 };
        int numClaus = 5;
                
        for (int k = 0; k < numClaus; k++) {
            int i = (int)(Math.random() * castell.getNumPlantes());
            int j = (int)(Math.random() * castell.getNumHabitacions(i));
            Habitacio h = castell.getHabitacio(i, j);
            int[] cela = obtenirCelaLliure(h);
            int iclau = (int)(Math.random() * clausComuns.length);
            Clau clau = new Clau(clausComuns[iclau], 
                        dades[0], dades[1], dades[2], 
                        dades[3]);
                    
                int[] posicio = h.getPosicioCela(cela[0], cela[1]);
                clau.setPosicioInicial(posicio[0], posicio[1]);
                h.addActor(clau);
        }
        
        int i = (int)(Math.random() * castell.getNumPlantes());
        int j = (int)(Math.random() * castell.getNumHabitacions(i));
        Habitacio h = castell.getHabitacio(i, j);
            
        int[] cela = obtenirCelaLliure(h);
        Clau clau = new Clau(clauOr, 
                    dades[0], dades[1], dades[2], 
                    dades[3]);
                    
        int[] posicio = h.getPosicioCela(cela[0], cela[1]);
        clau.setPosicioInicial(posicio[0], posicio[1]);
        h.addActor(clau);          
    }
    
    private void distribuirMenjar() {
        String[] menjars = {  "Pizza", "Pollastre", "Síndria" } ;
        // { calories,x,y,width,height } de cada imatge
        int[][] dades = {
            { 25, 540, 14, 30, 22 },
            { 50, 439, 14, 27, 23 },
            { 50, 97, 100, 30, 20 }
        };
        
        for (int i = 0; i < castell.getNumPlantes(); i++) {
            
            for (int j = 0; j < castell.getNumHabitacions(i); j++) {
                Habitacio h = castell.getHabitacio(i, j);
                int numMenjars = (int)(Math.random() * (MAX_MENJAR_PER_HABITACIO + 1));
                
                for (int k = 0; k < numMenjars; k++) {
                    int[] cela = obtenirCelaLliure(h);
                    int imenjar = (int)(Math.random() * menjars.length);
                    Menjar m = new Menjar(menjars[imenjar], 
                            dades[imenjar][0], dades[imenjar][1], dades[imenjar][2], 
                            dades[imenjar][3], dades[imenjar][4]);
                    
                    int[] posicio = h.getPosicioCela(cela[0], cela[1]);
                    m.setPosicioInicial(posicio[0], posicio[1]);
                    h.addActor(m);                     
                }
            }
            
        }
    }
   
    private int[] obtenirCelaLliure(Habitacio h) {
        int fila = 0;
        int col = 0;
        int cela[] = null;
        boolean trobada = false;
        boolean terra = false;
        
        while (!trobada) {            
            terra = false;
            while (!terra) {
                fila = (int)(Math.random() * Constants.NUM_CELES_VERTICALS);
                col = (int)(Math.random() * Constants.NUM_CELES_HORIZONTALS);
                terra = h.getValor(fila, col) == Constants.SIMBOL_TERRA;
            }
            
            // comprovar que cap actor està dins la cela
            Actor[] actors = h.getActorsAsArray();
            int i = 0;
            boolean lliure = true;
            while (i < actors.length && lliure) {
                cela = h.getCela(actors[i].getPosicioInicial()[0], 
                        actors[i].getPosicioInicial()[1]);
                lliure = fila != cela[0] || col != cela[1];            
                i++;
            }         
            trobada = lliure;
        }
        return new int[] { fila, col };
    }
    

    /**
     * Principal.
     * 
     * @param args
     */
    public static void main(String[] args) {
        new Practica();
    }
    
}

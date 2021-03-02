/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.juanadearco.actors;

import edu.ub.juanadearco.Actor;
import edu.ub.juanadearco.Colisio;
import edu.ub.juanadearco.Constants;
import edu.ub.juanadearco.Context;
import edu.ub.juanadearco.Util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author SERGIO
 */

public class Vida extends AbstractActor {

    private int health;
    private Image image;
    private int amplada;
    private int alcada;
    private String nom;
    
    public Vida(String nom, int health, int imgPosX, int imgPosY, 
            int imgAmplada, int imgAlcada) {
        this.nom = nom;
        this.health = health;
        this.image = Util.carregarImatge("objectes.png", 
                imgPosX, imgPosY, imgAmplada, imgAlcada);
        this.amplada = imgAmplada;
        this.alcada = imgAlcada;
        setEstat(Constants.ESTAT_ACTIU);
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public void actualitzar(Context context) {
        // no fem res, es estàtic
    }
    
    public Rectangle getLimits() {
        return new Rectangle(getX(), getY(), amplada, alcada);
    }
    
    public void tractarColisio(Colisio colisio) {
        Actor actor = colisio.getActor();
        if (actor instanceof Heroina) {
	        actor.setVida(health);
	        setEstat(Constants.ESTAT_INACTIU);
        }
    }
    
    public void render(Graphics2D g) {
        g.drawImage(image, getX(), getY(), observer);
        g.setColor(Color.RED);
        Font f = new Font("Dialog", Font.BOLD, 10);
        g.setFont(f);
        g.drawString(nom, getX(), getY() - 3);
    }
}
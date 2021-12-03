
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luiz Felix
 */
public abstract class Tiro extends Thread {
     Graphics gr;
     int x, y;
     BufferedImage laser;
     int y0;
    BufferedImage laser0;
    final int largura = 20;
    final int altura = 55;
    boolean explodiu=false;
    

    public Tiro(Graphics gr, int x, int y, BufferedImage laser, BufferedImage laser0) {
        this.gr = gr;
        this.x = x;
        this.y = y;
        this.laser = laser;
        this.laser0= laser0;
        gr.drawImage(laser0, x, y, null);
    }
    
     @Override
    abstract public void run();
        
       
    public  void explode(){
        explodiu=true;
        x=-200;
        
       
    }
    
}


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
public abstract class Nave extends Thread {
    
      Graphics gr;
      int x, y;
      BufferedImage nave;
      boolean vivo, explodiu;
     

    public Nave(Graphics g, int x, int y, BufferedImage nave) {
        this.gr = g;
        this.x = x;
        this.y = y;
        this.nave = nave;
        vivo= true;
        explodiu=false;     
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVivo() {
        return vivo;
    }

    public boolean isExplodiu() {
        return explodiu;
    }
    
    public void morre(){
        x=y=-100;
       
        vivo=false;
    }
    
    void draw(){
        gr.drawImage(nave, x, y, null);
    }
    
    void moveX(int velocidade){
        x+=velocidade;
    }
    
    void moveY(int velocidade){
        y+=velocidade;
    }

    abstract void explode();
}

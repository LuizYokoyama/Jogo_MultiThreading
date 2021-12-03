
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
public class MeuTiro extends Tiro{
    
    
    
    public MeuTiro(Graphics gr, int x, int y, BufferedImage laser, BufferedImage laser0) {
        super(gr, x+35, y-36, laser, laser0);
        y0= y-36;      
    }
    
    @Override
    public void run(){
        Tela.blaster1.play();
         while((y>-60) && !explodiu){
            try {
                suspend();
            } catch (Exception ex) {
                
            }        
            if (y0<=y+20) {
                if (Tela.falcon.direita) gr.drawImage(laser0, x+5, y0, null);
                else if (Tela.falcon.esquerda) gr.drawImage(laser0, x-5, y0, null);
                        else gr.drawImage(laser0, x, y0, null);
            }           
            y-=6;          
            gr.drawImage(laser, x, y,null);
         }
         x=-100;
    }
    
    
}

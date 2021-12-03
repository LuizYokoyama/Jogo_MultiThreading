
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
public class TieTiro extends Tiro{
    
    

    public TieTiro(Graphics gr, int x, int y, BufferedImage laser, BufferedImage laser0) {
        super(gr, x+13, y+32, laser, laser0);
        y0=y+32;
    }

    @Override
    public void run() {
        Tela.blaster2.play();
            while(y<Tela.telaY && !explodiu){
               try {
                   suspend();
               } catch (Exception ex) {

               }
               if (y0>y-20) gr.drawImage(laser0, x, y0, null);
               y+=6;
               gr.drawImage(laser, x, y,null);
            }
            x= -100;
        }
    
}

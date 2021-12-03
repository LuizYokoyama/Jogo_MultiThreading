
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
public class NaveFalcon extends Nave{
    
    boolean direita, esquerda;
    static final int largura = 90;
    static final int altura = 90;
    static final int MARGEMX = 15;
    static final int MARGEMY = 22;
    boolean imune;
    
    public NaveFalcon(Graphics gr, int x, int y, BufferedImage nave) {
        super(gr, x, y, nave);
        direita= esquerda= false;
        imune=true;
        
    }

    public void setDireita(boolean direita) {
        this.direita = direita;
    }

    public void setEsquerda(boolean esquerda) {
        this.esquerda = esquerda;
    }
    

   
    @Override
   public void run(){
       while (vivo){
           if (!explodiu){
               if (imune) nave=Tela.falconShield; 
               else nave=Tela.falconImage;
               if (direita && (Tela.telaX > x+largura)) super.moveX(2);
               if (esquerda && (x>0)) super.moveX(-2);
               draw();
               suspend();
           } else { //ANIMAÇÃO DA EXPLOSÃO DA NAVE FALCON
               for (int i=0; i<=7; i++){
                    nave=Tela.explosaoFalcon[i];
                    for (int a=0; a<5; a++){
                      draw();
                      suspend();       
                    }                    
                }                
                revive();
           }          
       }
       draw();
   }

    @Override
    void explode() {
        Tela.explosao1.play();
        if (!explodiu){
            explodiu=true;
             
            if (Tela.vidas>0) Tela.vidas--;
        }  
    }

    private void revive() {
        if (Tela.vidas>0){
            explodiu=false;
            imune=true;
            nave= Tela.falconImage;
        } else morre();        
    }
    
   
    
}

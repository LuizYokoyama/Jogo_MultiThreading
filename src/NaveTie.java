
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luiz Felix
 */
public class NaveTie extends Nave{
    
    private Random random;
    static final int largura = 47;
    static final int altura = 58;
    int dx=0, dy=0;
    private List<TieTiro> tiros;
    
    public NaveTie(Graphics g, int x, int y, BufferedImage nave) {
        super(g, x, y, nave);
        random = new Random();
        tiros = new ArrayList<>();
        while (0==dx){
            dx=random.nextInt(3);
        }
        
        while (dy==0){
            dy=random.nextInt(3);
        }    
    }

    @Override
    void explode() {
        explodiu=true;
        Tela.explosao2.play();     
    }
    
    @Override
    public void run(){
        while(vivo){           
            if (!explodiu){
                suspend();
                if ((x>Tela.telaX-largura) || x<0) dx= -dx;             
                if (random.nextInt(200)==13) {
                      dx =-dx;
                      dy= 1-random.nextInt(3);
                }
                if (random.nextInt(60)==13) {
                    TieTiro novoTiro= new TieTiro(gr, x, y, Tela.laserVerm, Tela.laserVerm0);
                    tiros.add(novoTiro);
                    novoTiro.start();
                }              
                if (y>Tela.telaY-250 || y<0) dy= -dy;
                if (y<-3) dy=5; //A NAVE APARECE ALEATORIAMENTE EM CIMA DA TELA
                else if (dy==5) dy=1;                
                moveX(dx);
                moveY(dy);               
                moveTirosTie();//MOVE OS TIROS DO "TIE FIGHTER"
                    draw();
            } else { //ANIMAÇÃO DA EXPLOSÃO:                 
                for (int i=0; i<=5; i++){
                    nave=Tela.explosao[i];
                    for (int a=0; a<13; a++){
                        suspend();
                        moveTirosTie();
                        draw();
                    }
                }
                morre();                
            }                        
        }
       draw(); 
    }

    private void moveTirosTie() {
         for (TieTiro tt: tiros){ 
               if (!Tela.falcon.explodiu)             
                            if ((Tela.falcon.x+NaveFalcon.largura-NaveFalcon.MARGEMX > tt.x)
                                 && (tt.x+tt.largura > Tela.falcon.x+NaveFalcon.MARGEMX)
                                 && (Tela.falcon.y+NaveFalcon.altura-NaveFalcon.MARGEMY > tt.y)
                                 && (tt.y+tt.altura > Tela.falcon.y+NaveFalcon.MARGEMY)){
                                    if (Tela.falcon.imune) Tela.falcon.imune=false;
                                        else Tela.falcon.explode();
                                tt.explode();
                            }
                       tt.resume();                              
                    }
    }  
}

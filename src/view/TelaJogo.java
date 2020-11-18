package view;


import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import App.Game;
import controller.MenuController;
import model.Jogador;
import model.MyButton;
 





import model.Sprite;
import model.Xml;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TimerTask;

import javax.swing.*;

import som.Som;
import App.Game;
import controller.MenuController;
import model.Jogador;
import model.MyButton;


 
public class TelaJogo extends TelaAbstract implements ActionListener{
	 
    public static String tema;
    private Jogador objJogadorJogada;
    static  Sprite cartas;
    
        
         public TelaJogo( Jogador jog, int codJog, int fatorJogo ){        
 
       super(jog, fatorJogo);
 
 
        objJogadorJogada = jog;
        temaJogada( codJog );
    	try{
 			cartas= new Sprite(77, 77, 9, 2);

 		}catch (IOException e) {
 			e.printStackTrace();
 			System.out.println("Não foi possível carregar a Sprite");
 		}
    	
    	cartas.preparaArrayImagens();
    	 audio.aberturaSom();
       

        for ( int cont = 0; cont < ( fator * fator ); cont++ ){
 
            posicoesFiguras[ cont ] = new MyButton(imagemPadrao, cartas.getImagens()[cont]);
            posicoesFiguras[ cont ].addActionListener( this );
            painelImagens.add( posicoesFiguras[ cont ] );
        }

        botaoSair.addActionListener(this);
        
        setVisible( true );

    }
 
    public void actionPerformed( ActionEvent event ){        

        
    	if ( event.getSource() == botaoSair ){

    		dispose();
    		new MenuController().control();
    	}


    	else{

    		if( primeiroClique ){

    			qtdeTentativas++; 


    			if ( !acertou ){

    				botaoUm = (MyButton) botaoClicadoUm;
    				botaoDois = (MyButton) botaoClicadoDois;

    				audio.acertoSomParar();

    				botaoUm.setImagemPadrao();
    				botaoDois.setImagemPadrao();

    				audio.erroSom();
    			}

    			botaoClicadoUm = event.getSource();

    			botaoUm = (MyButton) botaoClicadoUm;
    			botaoUm.setImagemBotao();                


    			primeiroClique = !primeiroClique;
    		}


    		else{                

    			botaoClicadoDois = event.getSource();
    			botaoDois = (MyButton) botaoClicadoDois;                                


    			if ( botaoClicadoDois == botaoClicadoUm ){

    				acertou = false;

    				JOptionPane.showMessageDialog( null, "Ação não permitida!",
    						"Ação Não Permitida", JOptionPane.WARNING_MESSAGE );
    			}


    			else{            


    				botaoDois.setImagemBotao();

    				
    					if ( botaoUm.getImagemBotao().equals( botaoDois.getImagemBotao())){

    						audio.erroSomParar();

    						acertou = true;
    						qtdeAcerto++;                            


    						botaoUm.setEnabled( false );
    						botaoDois.setEnabled( false );  

    						audio.acertoSom();
    						
    						
    						objJogadorJogada.incrementarPontos();

    						labelPontosJogador.setText( ""+objJogadorJogada.obterPontos() );
    						labelTentativas.setText("" + qtdeTentativas);
    						
    					

    						if ( qtdeAcerto == ((fator*fator)/2) ){
    							audio.fimSom();
    							JOptionPane.showMessageDialog( null, "Parabéns você conseguiu!!!");
    							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    							audio.fimSomParar();
    							System.gc();
    						}
    					}
    				

    					else{

    						acertou = false;                            
                       
    						
    						objJogadorJogada.decrementarPontos();

    						labelPontosJogador.setText( ""+objJogadorJogada.obterPontos() );
    						labelTentativas.setText("" + qtdeTentativas);
   
    				}
    					
    				primeiroClique = !primeiroClique;
    			}

    		}
    	}
    }



	public Jogador getObjJogadorJogada() {
		return objJogadorJogada;
	}

	public int getFator() {
		return fator;
	}

	public String getTema() {
		return tema;
	}
	
   
 
}

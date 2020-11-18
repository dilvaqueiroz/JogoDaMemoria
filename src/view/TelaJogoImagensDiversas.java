package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import som.Som;
import model.Jogador;
import model.MyButton;
import model.RetornePasta;
import controller.MenuController;

public class TelaJogoImagensDiversas extends TelaAbstract implements ActionListener{


    private Icon  imagens[], imagens8[];
   
        
         public  TelaJogoImagensDiversas( Jogador jog, int fatorJogo ){        
 
         super(jog, fatorJogo);
 
        preparaArrayImagens();
        audio.aberturaSom();
            
 
        for ( int cont = 0; cont < ( fator * fator ); cont++ ){
 
            posicoesFiguras[ cont ] = new MyButton(imagemPadrao,imagens[cont]);
            posicoesFiguras[ cont ].addActionListener( this );
            painelImagens.add( posicoesFiguras[ cont ] );
        }
        
        botaoSair.addActionListener(this);
        
        setVisible( true );

    }

    private void preparaArrayImagens(){
 
        int posicaoNoArray, x, y;
 
        this.imagens8 = new Icon[(fator * fator)/2];
        
        
       URL tmp=RetornePasta.retornarEnderecoPasta(); 
       
       
        for ( x = 0; x < ((fator*fator)/2); x++ ){
        	try {
				URL tmp2=new URL(tmp +""+( x + 1 ) + ".png"); 
			    this.imagens8[ x ] = new ImageIcon(tmp2);
        	} catch (MalformedURLException e) {
				e.printStackTrace();
			}
         
        }
 
        this.imagens = new Icon[ (fator*fator) ];
 
        for ( x = 0; x < 2; x++ ){
 
            for ( y = 0; y < ((fator*fator)/2); y++ ){
 
                do{
                    posicaoNoArray = ( int ) ( Math.random() * (fator*fator) );        
 
                }while( this.imagens[ posicaoNoArray ] != null );
 
                this.imagens[ posicaoNoArray ] = imagens8[ y ];
 
            }
        }
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
    							//mostrarResumoJogo();
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
//    						chamarOutroJogador();
    				
   
    				}
    					
    				primeiroClique = !primeiroClique;
    			}

    		}
    	}
    }

}


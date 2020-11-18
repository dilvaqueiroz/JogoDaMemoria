package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.MenuController;
import model.Jogador;
import model.MyButton;
import model.Sprite;

public class TelaJogoMultiplayer extends TelaAbstract implements ActionListener{

    public static String tema;
    static  Sprite cartas;
	
    public TelaJogoMultiplayer(Jogador jog, Jogador jog2, int fatorJogo, int codJog) {
		super(jog, jog2, fatorJogo);
		fator = fatorJogo;
		 
	    objJogadorJogada = jog;
	    temaJogada( codJog );
		try{
				cartas= new Sprite(77, 77, 9, 2);

			}catch (IOException e) {
				e.printStackTrace();
				System.out.println("Não foi possível carregar a Sprite");
			}
		botaoSair.addActionListener(this ); 
		cartas.preparaArrayImagens();
		 audio.aberturaSom();
	   

	    for ( int cont = 0; cont < ( fator * fator ); cont++ ){

	        posicoesFiguras[ cont ] = new MyButton(imagemPadrao, cartas.getImagens()[cont]);
	        posicoesFiguras[ cont ].addActionListener(this );
	        painelImagens.add( posicoesFiguras[ cont ] );
	    }
	    
	    setVisible( true );

	}

  public void chamarOutroJogador(){
	  
	 if(jogadorNeutro.equals(objJogadorJogada)){
		 jogadorNeutro=objJogadorJogada2;
	 }
	 else{
		 jogadorNeutro=objJogadorJogada;
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
    						
    						if(jogadorNeutro.equals(objJogadorJogada)){
    							

    						objJogadorJogada.incrementarPontos();

    						labelPontosJogador.setText( ""+objJogadorJogada.obterPontos() );
    						labelTentativas.setText("" + qtdeTentativas);
    						}
    						
    						else{
    							objJogadorJogada2.incrementarPontos();

	    						labelPontosJogador2.setText( ""+objJogadorJogada2.obterPontos() );
	    						labelTentativas2.setText("" + qtdeTentativas);
    						}

    						if ( qtdeAcerto == ((fator*fator)/2) ){
    							audio.fimSom();
    							JOptionPane.showMessageDialog( null, "Fim de jogo!!!");
    							//mostrarResumoJogo();
    							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    							audio.fimSomParar();
    							System.gc();
    						}
    					}
    				

    					else{

    						acertou = false;                            
                       
    						if(jogadorNeutro.equals(objJogadorJogada)){

    						objJogadorJogada.decrementarPontos();

    						labelPontosJogador.setText( ""+objJogadorJogada.obterPontos() );
    						labelTentativas.setText("" + qtdeTentativas);
    					} 
    						else{
    							objJogadorJogada2.decrementarPontos();

	    						labelPontosJogador2.setText( ""+objJogadorJogada2.obterPontos() );
	    						labelTentativas2.setText("" + qtdeTentativas);
    						}
    						chamarOutroJogador();
    				}
    					
    				primeiroClique = !primeiroClique;
    			}

    		}
    	}
    }
}

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.MenuController;
import model.Jogador;
import model.MyButton;
import model.Sprite;
import som.Som;

public abstract class TelaAbstract extends JFrame {

	    public Object botaoClicadoUm = new Object();
	    public Object botaoClicadoDois = new Object();
	    public JLabel labelPontosJogador, labelNomeJogador , labelImagemJogador, labelImagemPontos,labelImagemTentativas,labelTentativas;
	    public JLabel labelPontosJogador2, labelNomeJogador2 , labelImagemJogador2, labelImagemPontos2,labelImagemTentativas2,labelTentativas2;
	    public JPanel painelImagens, painelPontos;
	    public JButton botaoSair;
	    public Icon imagemSair, imagemPadrao;
	    private GridLayout grid;
	    private Container container;
	    public static String tema;
	    public Jogador objJogadorJogada,objJogadorJogada2, jogadorNeutro;
	    public int qtdeAcerto, qtdeTentativas = 0;
	    public boolean primeiroClique = true;
	    public boolean acertou = true;
	    public MyButton botaoUm, botaoDois, posicoesFiguras[];
	    public Som audio;
	    public static  Sprite cartas;
	    public static int fator;
	    
	    public TelaAbstract(Jogador jog, int fatorJogo) {
	    	
	    	super("Jogo da Memória");
	    	
	    	fator = fatorJogo;
	    	 
	        objJogadorJogada = jog;
	    	 
	       
	        container = getContentPane();
	        
	        audio = new Som();
	      
	        
	 
	        try {
	        	labelImagemJogador = new JLabel( new ImageIcon(ImageIO.read(new File("res/jogador.gif"))));
	        	labelImagemPontos = new JLabel( new ImageIcon(ImageIO.read(new File("res/pontuacao.gif"))));
	        	labelImagemTentativas = new JLabel( new ImageIcon(ImageIO.read(new File("res/tentativas.gif"))));
			} catch (IOException e) {
				e.printStackTrace();
			}
	        

	        
	        labelNomeJogador = new JLabel(objJogadorJogada.obterNome());
	        labelPontosJogador= new JLabel("" + objJogadorJogada.obterPontos());
	        labelTentativas= new JLabel("" + qtdeTentativas);
	 
	        imagemSair = new ImageIcon("/res/sair.gif");       
	 
	        botaoSair = new JButton(" Voltar ", imagemSair);
//	        botaoSair.addActionListener( this );        
	 
	        painelImagens = new JPanel();
	        painelPontos = new JPanel();        
	 
	        painelPontos.setBackground( Color.white );
	        painelPontos.add(labelImagemJogador);
	        painelPontos.add(labelNomeJogador);
	        painelPontos.add(labelImagemPontos);
	        painelPontos.add(labelPontosJogador);
	        painelPontos.add(labelImagemTentativas);
	        painelPontos.add(labelTentativas);        
	 
	        grid = new GridLayout( fator, fator, 5, 5 );
	 
	        painelImagens.setLayout( grid );                
	 
	        imagemPadrao = new ImageIcon("res/standard.gif");
	 
	        posicoesFiguras = new MyButton[( fator * fator )];  
	        
	 
	       
	        container.add( painelPontos, BorderLayout.NORTH);
	        container.add( botaoSair, BorderLayout.SOUTH );
	        container.add( painelImagens );
	 
	        double d_largura = (fator == 4?82.5:80);
	 
	        d_largura *= fator;
	 
	        int i_largura = (int) d_largura;
	 
	        setSize( i_largura, i_largura+70 );
	        setLocationRelativeTo(null);  
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setResizable( false );
		}
	    
	    
	    public TelaAbstract(Jogador jog,Jogador jog2, int fatorJogo) {
	    	
	    	super("Jogo da Memória");
	    	
	    	fator = fatorJogo;
	    	 
	        objJogadorJogada = jog;
	        objJogadorJogada2= jog2;
	    	 
	        jogadorNeutro=objJogadorJogada;
	       
	        container = getContentPane();
	        
	        audio = new Som();
	      
	        
	 
	        try {
	        	labelImagemJogador = new JLabel( new ImageIcon(ImageIO.read(new File("res/jogador.gif"))));
	        	labelImagemPontos = new JLabel( new ImageIcon(ImageIO.read(new File("res/pontuacao.gif"))));
	        	labelImagemTentativas = new JLabel( new ImageIcon(ImageIO.read(new File("res/tentativas.gif"))));
	        	labelImagemJogador2 = new JLabel( new ImageIcon(ImageIO.read(new File("res/jogador.gif"))));
	        	labelImagemPontos2 = new JLabel( new ImageIcon(ImageIO.read(new File("res/pontuacao.gif"))));
	        	labelImagemTentativas2 = new JLabel( new ImageIcon(ImageIO.read(new File("res/tentativas.gif"))));
			} catch (IOException e) {
				e.printStackTrace();
			}
	        

	        
	        labelNomeJogador = new JLabel(objJogadorJogada.obterNome());
	        labelPontosJogador= new JLabel("" + objJogadorJogada.obterPontos());
	        labelTentativas= new JLabel("" + qtdeTentativas);
	        
	        labelNomeJogador2 = new JLabel(objJogadorJogada2.obterNome());
	        labelPontosJogador2= new JLabel("" + objJogadorJogada2.obterPontos());
	        labelTentativas2= new JLabel("" + qtdeTentativas);
	 
	        imagemSair = new ImageIcon("/res/sair.gif");       
	 
	        botaoSair = new JButton(" Sair do Jogo ", imagemSair);
//	        botaoSair.addActionListener( this );        
	 
	        painelImagens = new JPanel();
	        painelPontos = new JPanel();        
	 
	        painelPontos.setBackground( Color.white );
	        painelPontos.add(labelImagemJogador);
	        painelPontos.add(labelNomeJogador);
	        painelPontos.add(labelImagemPontos);
	        painelPontos.add(labelPontosJogador);
	        painelPontos.add(labelImagemTentativas);
	        painelPontos.add(labelTentativas);  
	        painelPontos.add(labelImagemJogador2);
	        painelPontos.add(labelNomeJogador2);
	        painelPontos.add(labelImagemPontos2);
	        painelPontos.add(labelPontosJogador2);
	        painelPontos.add(labelImagemTentativas2);
	        painelPontos.add(labelTentativas2);
	 
	        grid = new GridLayout( fator, fator, 5, 5 );
	 
	        painelImagens.setLayout( grid );                
	 
	        imagemPadrao = new ImageIcon("res/standard.gif");
	 
	        posicoesFiguras = new MyButton[( fator * fator )];  
	        
	 
	       
	        container.add( painelPontos, BorderLayout.NORTH);
	        container.add( botaoSair, BorderLayout.SOUTH );
	        container.add( painelImagens );
	 
	        double d_largura = (fator == 4?82.5:80);
	 
	        d_largura *= fator;
	 
	        int i_largura = (int) d_largura;
	 
	        setSize( i_largura, i_largura+70 );
	        setLocationRelativeTo(null);  
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setResizable( false );
		}
 

	    public void temaJogada( int codTema ){
	    	 
	        switch( codTema ){
	 
	                case 1: this.tema = "res/frutas.png";
	            break;
	 
	            case 2: this.tema = "res/comidas.png";
	            break;
	 
	        }
	    }
	      
		public Jogador getObjJogadorJogada() {
			return objJogadorJogada;
		} 

}

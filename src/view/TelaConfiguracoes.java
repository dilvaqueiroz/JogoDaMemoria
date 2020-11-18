package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaConfiguracoes extends JFrame{
	
	 
	    private Container container;
	    private JButton botaoVoltar, botaoJogar;
	    private JPanel painelBotoes, painelDados, painelCabecalho;
	    private JPanel painelCentro, painelRodape;
	    private Icon  imagemRodape, imagemJogar,imagemVoltar;
	    private JLabel  nomeLabel, dificuldadeJogo;
	    private JLabel texto1, desenvolvimento;
	    private GridLayout gridBotoes, gridDados, gridCabecalho, gridRodape;
	    private JTextField fieldNome,fieldDificuldade;
	    private Font  fonte10;
	    private JComboBox matrizBox;
	    
	    private String matrizNomes[] = 
	    	{"2", "4", "6", "8"};
	  
	 
	    public TelaConfiguracoes() {
		                
	 
	        super( "Configurações" );                
	 
	 
	       
	        gridBotoes = new GridLayout( 1, 1, 5, 5 );
	        gridDados = new GridLayout( 4, 1, 10, 10 );
	        gridCabecalho = new GridLayout( 1, 1, 10, 10 );
	        gridRodape = new GridLayout( 1, 1, 10, 10 );
	 
	       
	        fonte10 = new Font( "Verdana", Font.ITALIC, 10 );
	 
	        
	        imagemJogar = new ImageIcon("res/jogar.gif");
	        imagemVoltar = new ImageIcon("res/voltar.png");
	               
	 
	        
	        botaoJogar = new JButton( "Jogar", imagemJogar );
	        botaoJogar.setHorizontalAlignment( SwingConstants.CENTER );
	        botaoJogar.setHorizontalTextPosition( SwingConstants.LEFT);
	 
	        
	        botaoVoltar = new JButton( "Voltar", imagemVoltar );
	        botaoVoltar.setHorizontalAlignment( SwingConstants.RIGHT );
	        botaoVoltar.setHorizontalTextPosition( SwingConstants.LEFT );
	 
	        
	        painelBotoes = new JPanel();
	        painelBotoes.setBackground( Color.lightGray );
	        painelBotoes.setLayout( gridBotoes );
	        painelBotoes.add( botaoVoltar );
	        painelBotoes.add( botaoJogar );        
	 
	       
	        texto1 = new JLabel( "Configurações" );
	        texto1.setHorizontalAlignment( SwingConstants.CENTER );        
	 
	      
	        painelCabecalho = new JPanel();
	        painelCabecalho.setLayout( gridCabecalho );
	        painelCabecalho.setBackground( Color.pink );
	        painelCabecalho.add( texto1 );
	 
	        nomeLabel= new JLabel ("Digite seu nome:");
	        fieldNome= new JTextField(10);
	       
	       
	        dificuldadeJogo = new JLabel( "Digite a matriz desejada:" );
	        dificuldadeJogo.setHorizontalAlignment( SwingConstants.LEFT );
	        
	        matrizBox = new JComboBox(matrizNomes);
	        matrizBox.setMaximumRowCount(4);
	        
//	        fieldDificuldade = new JTextField( 3 );
//	        fieldDificuldade.setHorizontalAlignment( SwingConstants.LEFT );
	 
	        
	        
	        painelCentro = new JPanel();
	        painelCentro.setLayout( gridDados );
	        painelCentro.setBackground( Color.lightGray );
	        painelCentro.add(nomeLabel);
	        painelCentro.add(fieldNome );
	        painelCentro.add( dificuldadeJogo );
//	        painelCentro.add(fieldDificuldade);
	        painelCentro.add(matrizBox);
	        
	
	        imagemRodape = new ImageIcon(("res/Dilva.png"));
	 
	       
	        desenvolvimento = new JLabel(
	        "Queirós",
	        imagemRodape, SwingConstants.CENTER );
	        desenvolvimento.setFont( fonte10 );        
	 
	       
	        painelRodape = new JPanel();
	        painelRodape.setLayout( gridRodape );
	        painelRodape.setBackground( Color.white );
	        painelRodape.add( desenvolvimento );        
	 
	       
	        painelDados = new JPanel();
	        painelDados.setLayout( new BorderLayout( 5, 5));
	        painelDados.setBackground( Color.lightGray );
	        painelDados.add( painelCabecalho, BorderLayout.NORTH);
	        painelDados.add( painelCentro );
	        painelDados.add( painelBotoes, BorderLayout.SOUTH );        
	 
	     
	        container = getContentPane();
	        container.setLayout( new BorderLayout( 5, 5 ) );
	        container.setBackground( Color.lightGray  );
	        container.add( painelRodape, BorderLayout.SOUTH );
	        container.add( painelDados );        
	 
	        setSize( 250, 250 );
	        setVisible( true );
	        setResizable( false );
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	
	    }



		public JButton getBotaoVoltar() {
			return botaoVoltar;
		}




		public JButton getBotaoJogar() {
			return botaoJogar;
		}



		public JTextField getFieldNome() {
			return fieldNome;
		}



		public JTextField getFieldDificuldade() {
			return fieldDificuldade;
		}



		public JComboBox getMatrizBox() {
			return matrizBox;
		}



	    
}

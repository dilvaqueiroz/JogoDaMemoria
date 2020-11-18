package view;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import model.Jogador;
 
public class Menu extends JFrame{    
	 
    private Container container;
    private JButton botaoSair, botaoIniciarJogo,menuConfiguracoes,multiplayer;
    private JPanel painelBotoes, painelDados, painelCabecalho;
    private JPanel painelCentro, painelRodape, painelImagem;
    private Icon imagemPainel, imagemRodape, imagemJogar, titulo,imagemSair,imagemConfig,imagemMultiplayer;
    private JLabel labelImagemPainel, nomeJogador, temaJogada;
    private JLabel texto1, desenvolvimento, creditos;
    private GridLayout gridBotoes, gridDados, gridCabecalho, gridRodape;
    private JComboBox temasJogada;
    private JTextField fieldNomeJogador;
    private Font  fonte10;
    private ButtonGroup dificuldadeGroup;
    private JMenu menuDificuldade;
    private JMenuBar barraMenu;
    private JRadioButtonMenuItem facil, dificil;
    private JLabel nivelDificuldade;
 
  
    private String nomesTemas[] =
    { "Fruits", "Foods"};    
 
 
 
    public Menu(){                   
 
        super( "Bem-vindo ao Jogo da Memória!" );                
 
 
        nivelDificuldade = new JLabel("Nível de dificuldade: FÁCIL");
        nivelDificuldade.setForeground(Color.blue);
 
       
        gridBotoes = new GridLayout( 1, 2, 5, 5 );
        gridDados = new GridLayout( 6, 1, 10, 10 );
        gridCabecalho = new GridLayout( 1, 1, 10, 10 );
        gridRodape = new GridLayout( 1, 1, 10, 10 );
 
       
        imagemPainel = new ImageIcon("res/painel.png");
        labelImagemPainel = new JLabel( imagemPainel );
        painelImagem = new JPanel();
        painelImagem.add( labelImagemPainel );
        painelImagem.setBackground( Color.white );
 
        fonte10 = new Font( "Verdana", Font.ITALIC, 10 );
 
        
        imagemJogar = new ImageIcon("res/jogar.gif");
        imagemSair = new ImageIcon("res/sair.gif");
        imagemConfig=new ImageIcon("res/config.png");
        imagemMultiplayer= new ImageIcon("res/multiplayer.png");
        
        menuConfiguracoes=new JButton("Configurações",imagemConfig);
        menuConfiguracoes.setHorizontalTextPosition( SwingConstants.LEFT );
        
        multiplayer=new JButton("Multiplayer",imagemMultiplayer);
        multiplayer.setHorizontalTextPosition( SwingConstants.LEFT );
        
        botaoIniciarJogo = new JButton( "Iniciar Jogo", imagemJogar );
        botaoIniciarJogo.setSize( 250, 15 );
        botaoIniciarJogo.setHorizontalAlignment( SwingConstants.CENTER );
        botaoIniciarJogo.setHorizontalTextPosition( SwingConstants.LEFT);
 
        
        botaoSair = new JButton( "Sair do Jogo", imagemSair );
        botaoSair.setSize( 250, 15 );
        botaoSair.setHorizontalAlignment( SwingConstants.RIGHT );
        botaoSair.setHorizontalTextPosition( SwingConstants.LEFT );
 
        
        painelBotoes = new JPanel();
        painelBotoes.setBackground( Color.lightGray );
        painelBotoes.setLayout( gridBotoes );
        painelBotoes.add( botaoSair );
        painelBotoes.add( botaoIniciarJogo );
        painelBotoes.add(multiplayer);
        painelBotoes.add(menuConfiguracoes);
      
 
       
        titulo = new ImageIcon(("res/titulo.png"));
        texto1 = new JLabel( titulo );
        texto1.setHorizontalAlignment( SwingConstants.CENTER );        
 
      
        painelCabecalho = new JPanel();
        painelCabecalho.setLayout( gridCabecalho );
        painelCabecalho.setBackground( Color.lightGray );
        painelCabecalho.add( texto1 );
 
       
        nomeJogador = new JLabel("Digite seu nome:");
        nomeJogador.setHorizontalAlignment( SwingConstants.LEFT );
 
        
        fieldNomeJogador = new JTextField( 15 );
        fieldNomeJogador.setHorizontalAlignment( SwingConstants.LEFT );
 
       
        temaJogada = new JLabel( "Escolha o tema:" );
        temaJogada.setHorizontalAlignment( SwingConstants.LEFT );
 
        
        temasJogada = new JComboBox( nomesTemas );
        temasJogada.setMaximumRowCount( 4 );
        
        creditos = new JLabel(
                "<html><p>Desenvolvido por: Dilva Queirós &nbsp; Curso: BSI</p> <p> Disciplina: MPOO &nbsp; UFRPE/UAST </p> ", SwingConstants.CENTER );
                creditos.setFont( fonte10 );
        
        painelCentro = new JPanel();
        painelCentro.setLayout( gridDados );
        painelCentro.setBackground( Color.lightGray );
        painelCentro.add( temaJogada );
        painelCentro.add( temasJogada );
        painelCentro.add( nomeJogador );
        painelCentro.add( fieldNomeJogador );
        painelCentro.add(nivelDificuldade);
        painelCentro.add(creditos);
 
        menuDificuldade = new JMenu("Nível de Dificuldade");
        menuDificuldade.setBackground( Color.lightGray  );
        
 
        dificuldadeGroup = new ButtonGroup();
 
 
        facil = new JRadioButtonMenuItem("Fácil (4X4)");
        facil.setSelected(true);
 
        dificil = new JRadioButtonMenuItem("Difícil (6X6)");
 
        
        dificuldadeGroup.add(facil);
        dificuldadeGroup.add(dificil);
 
        menuDificuldade.add(facil);
        menuDificuldade.add(dificil);
 
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        barraMenu.setBackground( Color.lightGray  );
    
   
       
 
        barraMenu.add(menuDificuldade);
       
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
        painelDados.setLayout( new BorderLayout( 10, 10 ));
        painelDados.setBackground( Color.lightGray );
        painelDados.add( painelCabecalho, BorderLayout.NORTH);
        painelDados.add( painelCentro );
        painelDados.add( painelBotoes, BorderLayout.SOUTH );        
 
     
        container = getContentPane();
        container.setLayout( new BorderLayout( 5, 5 ) );
        container.setBackground( Color.lightGray  );
        container.add( painelRodape, BorderLayout.SOUTH );
        container.add( painelImagem, BorderLayout.WEST );
        container.add( painelDados );        
 
        setSize( 800,425 );
        setVisible( true );
        setResizable( false );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
 
    }
 


	public JRadioButtonMenuItem getFacil() {
		return facil;
	}

	public JRadioButtonMenuItem getDificil() {
		return dificil;
	}

	public JButton getBotaoSair() {
		return botaoSair;
	}

	public JButton getBotaoIniciarJogo() {
		return botaoIniciarJogo;
	}

	public JComboBox getTemasJogada() {
		return temasJogada;
	}


	public JTextField getFieldNomeJogador() {
		return fieldNomeJogador;
	}


	public void setFieldNomeJogador(JTextField fieldNomeJogador) {
		this.fieldNomeJogador = fieldNomeJogador;
	}

	public JLabel getNivelDificuldade() {
		return nivelDificuldade;
	}

	public JButton getMenuConfiguracoes() {
		return menuConfiguracoes;
	}



	public JButton getMultiplayer() {
		return multiplayer;
	}
 
	
}





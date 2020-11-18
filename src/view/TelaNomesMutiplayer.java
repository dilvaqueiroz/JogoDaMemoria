package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaNomesMutiplayer extends JFrame{
	
	private JLabel playerLabel, multiplayerLabel;
	private JTextField playerField,multiplayerField;
	private JButton ok, botaoVoltar;
	private Container container;
	private JPanel painelBotoes, painelDados, painelCabecalho;
    private JPanel painelCentro, painelRodape;
    private Icon  imagemRodape, imagemJogar,imagemVoltar;
    private JLabel texto1, desenvolvimento;
    private GridLayout gridBotoes, gridDados, gridCabecalho, gridRodape;
    private JRadioButtonMenuItem facil, dificil;
    private JMenu menuDificuldade;
    private JMenuBar barraMenu;
    private ButtonGroup dificuldadeGroup;
    private JLabel nivelDificuldade;
    
    private Font  fonte10;
	
public TelaNomesMutiplayer() {
    
	gridBotoes = new GridLayout( 1, 1, 5, 5 );
    gridDados = new GridLayout( 4, 1, 10, 10 );
    gridCabecalho = new GridLayout( 1, 1, 10, 10 );
    gridRodape = new GridLayout( 1, 1, 10, 10 );

   
    fonte10 = new Font( "Verdana", Font.ITALIC, 10 );

    
    imagemJogar = new ImageIcon("res/jogar.gif");
    imagemVoltar = new ImageIcon("res/voltar.png");
           

    
    ok = new JButton( "Jogar", imagemJogar );
    ok.setHorizontalAlignment( SwingConstants.CENTER );
    ok.setHorizontalTextPosition( SwingConstants.LEFT);
    
    botaoVoltar = new JButton( "Voltar", imagemVoltar );
    botaoVoltar.setHorizontalAlignment( SwingConstants.RIGHT );
    botaoVoltar.setHorizontalTextPosition( SwingConstants.LEFT );

    
    painelBotoes = new JPanel();
    painelBotoes.setBackground( Color.lightGray );
    painelBotoes.setLayout( gridBotoes );
    painelBotoes.add( botaoVoltar );
    painelBotoes.add( ok );    

   
    texto1 = new JLabel( "Configuração de Player" );
    texto1.setHorizontalAlignment( SwingConstants.CENTER );        

  
    painelCabecalho = new JPanel();
    painelCabecalho.setLayout( gridCabecalho );
    painelCabecalho.setBackground( Color.pink );
    painelCabecalho.add( texto1 );

    
    playerLabel= new JLabel ("Digite o nome Jogador1:");
    playerField= new JTextField(10);
   
   
    multiplayerLabel = new JLabel( "Digite o nome Jogador2:" );
    multiplayerField = new JTextField( 10 );
 
    
    
    painelCentro = new JPanel();
    painelCentro.setLayout( gridDados );
    painelCentro.setBackground( Color.lightGray );
    painelCentro.add(playerLabel);
    painelCentro.add(playerField);
    painelCentro.add(multiplayerLabel);
    painelCentro.add(multiplayerField);
    

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

    setSize( 250,250  );
    setVisible( true );
    setResizable( false );
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

}

public JTextField getPlayerField() {
	return playerField;
}

public JTextField getMultiplayerField() {
	return multiplayerField;
}

public JButton getOk() {
	return ok;
}

public JButton getBotaoVoltar() {
	return botaoVoltar;
}

public JRadioButtonMenuItem getFacil() {
	return facil;
}

public JRadioButtonMenuItem getDificil() {
	return dificil;
}

public JLabel getNivelDificuldade() {
	return nivelDificuldade;
}

public void setNivelDificuldade(JLabel nivelDificuldade) {
	this.nivelDificuldade = nivelDificuldade;
}


}

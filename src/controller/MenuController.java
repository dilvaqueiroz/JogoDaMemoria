package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import model.Jogador;
import view.Menu;
import view.TelaConfiguracoes;
import view.TelaJogo;

public class MenuController {
	
	Menu menu;
	String nomeObjJogador;
	private Jogador objJogador;
    private TelaJogo objTelaJogo;
    private int indiceTemas[] = { 1, 2 }; 
    private int indiceTema = 1;
    private boolean jogoFacil = true;
   
	
	public MenuController(){
		menu=new Menu();
		//System.out.println(getClass().getResource("/res"));

	}

	public void control(){
		
		menu.getBotaoIniciarJogo().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {

				menu.dispose();
	            nomeObjJogador = menu.getFieldNomeJogador().getText();
	            objJogador= new Jogador(nomeObjJogador);      

	            if(jogoFacil)
	              objTelaJogo= new TelaJogo(objJogador, indiceTema, 4);
	             
	     
	            else
	                objTelaJogo = new TelaJogo(objJogador, indiceTema, 6 );
		        }

		});
		

		 
   menu.getBotaoSair().addActionListener(new ActionListener() {
	

	public void actionPerformed(ActionEvent e) {
		System.exit( 0 );
		
	}
});
   
   menu.getFacil().addActionListener(new ActionListener(){

       public void actionPerformed(ActionEvent evt){
           jogoFacil = true;
           menu.getNivelDificuldade().setText("Nível de dificuldade: FÁCIL");
           menu.getNivelDificuldade().setForeground(Color.blue);
       }
   });
   

	
	menu.getDificil().addActionListener(new ActionListener(){
		 
        public void actionPerformed(ActionEvent evt){
            jogoFacil = false;
            menu.getNivelDificuldade().setText("Nível de dificuldade: DIFÍCIL");
            menu.getNivelDificuldade().setForeground(Color.red);
        }
    });

	
	menu.getMultiplayer().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			menu.dispose();
			new TelaNomesController(menu).control();
		}
	});
	
	   menu.getMenuConfiguracoes().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			menu.dispose();
			new ConfiguracoesController().control();
		}
	});
			
//			public void itemStateChanged(ItemEvent e) {
//				
//		      new ConfiguracoesController().control();
//				
//			}
//		});
	


   
    menu.getTemasJogada().addItemListener(new ItemListener() {
		
	
		public void itemStateChanged(ItemEvent e) {

		        if ( e.getStateChange() == ItemEvent.SELECTED )

		            indiceTema = indiceTemas[ menu.getTemasJogada().getSelectedIndex() ];
		 
			
		}
	});
	
    
}


public Jogador getObjJogador() {
	return objJogador;
}


}

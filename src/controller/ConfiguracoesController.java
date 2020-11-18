package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import model.Jogador;
import view.Menu;
import view.TelaConfiguracoes;
import view.TelaJogo;
import view.TelaJogoImagensDiversas;

public class ConfiguracoesController {
		
		String nomeObjJogador;
		private Jogador objJogador;
	    private TelaJogoImagensDiversas objTelaJogo;
	    TelaConfiguracoes telaConfig;
		
		public ConfiguracoesController() {
			
			telaConfig=new TelaConfiguracoes();
			System.out.println(getClass().getResource("/res"));
			

		}

		public void control(){
			
			telaConfig.getBotaoJogar().addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
				
		            	nomeObjJogador = telaConfig.getFieldNome().getText();
		            	objJogador= new Jogador(nomeObjJogador); 
		            	
		            	if(telaConfig.getFieldNome().getText().equals("")){
		            		JOptionPane.showMessageDialog(null, "Preencha os campos das configurações");
		            	}
		            	else{
		            		telaConfig.dispose();
		            		int i = Integer.parseInt((String) telaConfig.getMatrizBox().getSelectedItem());
				            	 objTelaJogo= new TelaJogoImagensDiversas(objJogador,i);		        
		            	}  
			    }
			   
				
			});
			

			 
	   telaConfig.getBotaoVoltar().addActionListener(new ActionListener() {
		

		public void actionPerformed(ActionEvent e) {
		   telaConfig.dispose();
		   new MenuController().control();
		}
	}); 
	}


	public Jogador getObjJogador() {
		return objJogador;
	}


}


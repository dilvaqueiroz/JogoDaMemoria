package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Jogador;
import view.Menu;
import view.TelaJogo;
import view.TelaJogoMultiplayer;
import view.TelaNomesMutiplayer;

public class TelaNomesController {
	
	TelaNomesMutiplayer tnm;
	String nomeObjJogador,nomeObjJogador2;
	private Jogador objJogador,objJogador2;
	private TelaJogoMultiplayer objTelaJogo;
	private int indiceTemas[] = { 1, 2 };
	private int indiceTema;
	private boolean jogoFacil = true;
	Menu m;
	
	public TelaNomesController(Menu m) {
		this.m=m;
		tnm= new TelaNomesMutiplayer();
	}
	
	public void control(){
		tnm.getOk().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tnm.dispose();
				nomeObjJogador = tnm.getPlayerField().getText();
	            objJogador= new Jogador(nomeObjJogador);
	            nomeObjJogador2 = tnm.getMultiplayerField().getText();
	            objJogador2= new Jogador(nomeObjJogador2);      

	            indiceTema = indiceTemas[m.getTemasJogada().getSelectedIndex()];
	            
	            if(m.getFacil().isSelected())
	              objTelaJogo= new TelaJogoMultiplayer(objJogador, objJogador2, 4 ,indiceTema);
	             
	     
	            else
	                objTelaJogo = new TelaJogoMultiplayer(objJogador,objJogador2, 6 ,indiceTema);
				
			}
		});
		
		   tnm.getBotaoVoltar().addActionListener(new ActionListener() {
				

				public void actionPerformed(ActionEvent e) {
				   tnm.dispose();
				   new MenuController().control();
				}
			});
	}

}

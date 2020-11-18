package model;

import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.JButton;

import som.Som;

public class MyButton extends JButton{
	 
    private Icon imagemPadrao;
    private Icon imagemBotao;
    Temporizador t;
    private Som audio;
 
    public MyButton(Icon imagemPadrao, Icon imagens){
 
        super();
        audio = new Som();
        this.imagemBotao = imagens;
        this.imagemPadrao = imagemPadrao;
        t=new Temporizador();
        t.start();

 
   
    }
    
    public class Temporizador extends Thread{
    	

       public void run(){
    	  
    	   try {
    		 setImagemBotao();
    		Thread.sleep(10000);
    		audio.aberturaSomParar();
    		setImagemPadrao();
    		 
    		
    		   
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	  
       }
    }
 
    public void setImagemPadrao(){
 
        this.setIcon(imagemPadrao);
    }
 
    public void setImagemBotao(){
 
        this.setIcon(imagemBotao);
    }    
    

	public Icon getImagemBotao(){
 
        return this.imagemBotao;
    }
}

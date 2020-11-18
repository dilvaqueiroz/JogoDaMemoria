package model;

	
	import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import view.TelaAbstract;
import view.TelaJogo;

	public class Sprite{
		private Icon  imagens8[], imagens[];
		TelaAbstract tj;
		BufferedImage spriteSheet = ImageIO.read(new File(tj.tema));   

		int width, height;
		int rows, columns;
		BufferedImage[] sprites;
		Image aparencia;
		
		public Sprite(int width, int height, int columns, int rows) throws IOException {
			this.width = width;
			this.height = height;
			

			this.rows = columns;
			this.columns = rows;
		

			sprites = new BufferedImage[columns * rows];
			for(int i = 0; i < columns; i++) {
				for(int j = 0; j < rows; j++) {
					sprites[(i * rows) + j] = spriteSheet.getSubimage(i * width, j * height, width, height);
				}
			}
			
			
		}
		
        public void preparaArrayImagens(){
       	 
            int posicaoNoArray, x, y;
     
			 this.imagens8 = new Icon[(tj.fator * tj.fator)/2];
     
            for ( x = 0; x < ((tj.fator * tj.fator)/2); x++ ){
     
                this.imagens8[x] = new ImageIcon(sprites[x]);
            }
     
            this.imagens = new Icon[ (tj.fator * tj.fator) ];
     
            for ( x = 0; x < 2; x++ ){
     
                for ( y = 0; y < ((tj.fator * tj.fator)/2); y++ ){
     
                    do{
                        posicaoNoArray = ( int ) ( Math.random() * (tj.fator * tj.fator) );        
     
                    }while( this.imagens[ posicaoNoArray ] != null );
     
                    this.imagens[ posicaoNoArray ] = imagens8[ y ];
     
                }
            }
        }

		public Icon[] getImagens() {
			return imagens;
		}
        
	}

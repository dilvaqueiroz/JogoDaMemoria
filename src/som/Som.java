package som;

	import java.applet.Applet;
	import java.applet.AudioClip;

	public class Som {
		
		private AudioClip abertura, acerto, erro, fim;
		
		public Som(){
			
			abertura = Applet.newAudioClip(this.getClass().getResource("abertura.wav"));
			acerto = Applet.newAudioClip(this.getClass().getResource("acerto.wav"));
			erro = Applet.newAudioClip(this.getClass().getResource("erro.wav"));
			fim = Applet.newAudioClip(this.getClass().getResource("fim.wav"));
		}

		public void aberturaSom(){abertura.play();}
		public void aberturaSomParar(){abertura.stop();}
		public void acertoSom(){acerto.play();}
		public void acertoSomParar(){acerto.stop();}
		public void erroSom(){erro.play();}
		public void erroSomParar(){erro.stop();}
		public void fimSom(){fim.play();}
		public void fimSomParar(){fim.stop();}
		
	}


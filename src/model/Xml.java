package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class Xml {
		public static void escreverXML(Jogador j){
			Element rank = new Element("Rank");
			
			Document d = new Document(rank);
			
			//for(Jogador jogador : j ){
				Element num = new Element("Numero");
				
				num.setAttribute("Posição", Integer.toString(1));
				
				Element nome = new Element("Nome");
				nome.setText(j.obterNome());
				num.addContent(nome);
				
				Element pontos = new Element("Pontos");
				pontos.setText(Integer.toString(j.obterPontos()));
				num.addContent(pontos);
				
				rank.addContent(num);
			//}
			
			XMLOutputter xout = new XMLOutputter();
			OutputStream out = null;
			
			try {
				out = new FileOutputStream(new File("rank.xml"));
				xout.output(d, out);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public static void lerXML(){
			
			Document d = null;
			
			SAXBuilder builder = new SAXBuilder();
			
			try {
				d = builder.build("rank.xml");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Element rank = d.getRootElement();
			
			java.util.List<Element> lista = rank.getChildren();
			
			for(Element e : lista){
				System.out.println("Posição: " + e.getAttributeValue("Posição"));
				System.out.println("Nome: " + e.getChildText("Nome"));

				System.out.println("Pontos: " + e.getChildText("Pontos"));
   }
		}
		}

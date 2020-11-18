package model;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFileChooser;

public class RetornePasta {
public static URL retornarEnderecoPasta(){

    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("choosertitle");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);
    
    URL tmp = null;
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      try {
		tmp=new File(chooser.getSelectedFile().getPath()).toURI().toURL() ;
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    } else {
      System.out.println("No Selection ");
    }
    return tmp;
}


}

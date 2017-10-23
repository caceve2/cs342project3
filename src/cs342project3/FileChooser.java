package cs342project3;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FileChooser {
	private File selectedFile;
	private JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	
	public FileChooser() 
	{

		

		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			 selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
		}
		
	}
	
	public File getFile() 
	{
		return selectedFile;
	}
	
	

}

package cs342project3;
//Carlos Aceves and David Sanchez
//class to get and save files
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FileChooser {
	private File selectedFile;
	private JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	
	//gets a file from directory
	public FileChooser() 
	{

		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);
		
		//file is then selected
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			 selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
		}
		
	}
	
	//return the file selected
	public File getFile() 
	{
		return selectedFile;
	}
	
	

}

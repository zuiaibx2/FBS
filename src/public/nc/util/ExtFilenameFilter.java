package nc.util;

import java.io.File;
import java.io.FilenameFilter;

public class ExtFilenameFilter extends javax.swing.filechooser.FileFilter implements FilenameFilter {

	private String extFileName;
	private String filetypeDescription;

	public ExtFilenameFilter(String extFileName) {
		this.extFileName = extFileName.toLowerCase();
	}

	public ExtFilenameFilter(String extFileName, String filetypeDescription) {
		this.extFileName = extFileName.toLowerCase();
		this.filetypeDescription = filetypeDescription;
	}

	public boolean accept(File dir, String name) {
		return name.toLowerCase().endsWith(extFileName);
	}

	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		return file.getName().toLowerCase().endsWith(extFileName);
	}

	@Override
	public String getDescription() {
		return filetypeDescription;
	}
}

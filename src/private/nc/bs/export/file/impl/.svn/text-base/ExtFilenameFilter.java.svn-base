package nc.bs.export.file.impl;

import java.io.File;
import java.io.FilenameFilter;

public class ExtFilenameFilter implements FilenameFilter{

	private String extFileName;
	public ExtFilenameFilter(String extFileName)
	{
		this.extFileName = extFileName.toLowerCase();
	}

	public boolean accept(File dir, String name)
	{
		return name.toLowerCase().endsWith(extFileName);
	}

}

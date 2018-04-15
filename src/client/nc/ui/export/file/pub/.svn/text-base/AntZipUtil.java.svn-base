package nc.ui.export.file.pub;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import nc.bs.logging.Logger;

import org.apache.tools.zip.ZipOutputStream;

public class AntZipUtil {

	public static void zipFile(String zipFileName, String inputFileName)
			throws IOException {
		ZipOutputStream zipOUT = null;
		try {
			zipOUT = new ZipOutputStream(new FileOutputStream(zipFileName));
			zipOUT.setEncoding("GBK");
			File inputFile = new File(inputFileName);
			zipIt(zipOUT, inputFile, "");
		} finally {
			closeOutputStream(zipOUT);
		}
	}

	public static void zipFile(String zipFileName, File inputFile)
			throws IOException {
		ZipOutputStream zipOUT = null;
		try {
			zipOUT = new ZipOutputStream(new FileOutputStream(zipFileName));
			zipOUT.setEncoding("GBK");
			zipIt(zipOUT, inputFile, "");
		} finally {
			closeOutputStream(zipOUT);
		}
	}

	public static void zipFiles(String zipFileName, String[] inputFileNames)
			throws IOException {
		ZipOutputStream out = null;
		try {
			out = new ZipOutputStream(new FileOutputStream(zipFileName));
			out.setEncoding("GBK");
			String fileName = null;
			for (int i = 0, size = inputFileNames.length; i < size; i++) {
				fileName = inputFileNames[i];
				File inputFile = new File(fileName);
				zipIt(out, inputFile, "");
			}
		} finally {
			closeOutputStream(out);
		}
	}

	public static void zipFiles(String zipFileName, File[] inputFiles)
			throws IOException {
		ZipOutputStream out = null;
		try {
			out = new ZipOutputStream(new FileOutputStream(zipFileName));
			out.setEncoding("GBK");
			File inputFile = null;
			for (int i = 0, size = inputFiles.length; i < size; i++) {
				inputFile = inputFiles[i];
				zipIt(out, inputFile, "");
			}
		} finally {
			closeOutputStream(out);
		}
	}

	/**
	 * 能支持中文的压缩, 参数base 开始为 ""
	 */
	protected static void zipIt(org.apache.tools.zip.ZipOutputStream zipOUT,
			File f, String base) throws IOException {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			if (base != null && base.length() > 0) {
				base = base + f.getName() + "/";
			} else {
				base = f.getName() + "/";
			}
			File fileItem = null;
			for (int i = 0; i < fl.length; i++) {
				fileItem = fl[i];
				zipIt(zipOUT, fileItem, base);
			}
		} else {
			if (base != null && base.length() > 0) {
				base = base + f.getName();
			} else {
				base = f.getName();
			}

			FileInputStream fis = null;
			try {
				zipOUT.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
				fis = new FileInputStream(f);
				byte[] buffer = new byte[8192];
				int i = 0;
				while ((i = fis.read(buffer)) != -1) {
					zipOUT.write(buffer, 0, i);
				}
			} finally {
				closeInputStream(fis);
			}
		}
	}

	public static void unZipFile(String unZipFileName, String unZipPath)
			throws Exception {
		org.apache.tools.zip.ZipFile zipFile = null;
		try {
			zipFile = new org.apache.tools.zip.ZipFile(unZipFileName);
			unZipFileByOpache(zipFile, unZipPath);
		} finally {
			if (zipFile != null) {
				try {
					zipFile.close();
				} catch (Exception e) {
					Logger.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * 解压文件 unZip为解压路径
	 */
	@SuppressWarnings("rawtypes")
	protected static void unZipFileByOpache(
			org.apache.tools.zip.ZipFile zipFile, String unZipRoot)
			throws IOException {
		java.util.Enumeration e = zipFile.getEntries();
		while (e.hasMoreElements()) {
			org.apache.tools.zip.ZipEntry zipEntry = (org.apache.tools.zip.ZipEntry) e
					.nextElement();

			InputStream fis = null;
			FileOutputStream fos = null;
			try {
				fis = zipFile.getInputStream(zipEntry);
				if (zipEntry.isDirectory()) {

				} else {
					File file = new File(unZipRoot + File.separator
							+ zipEntry.getName());
					File parentFile = file.getParentFile();
					parentFile.mkdirs();
					fos = new FileOutputStream(file);
					byte[] b = new byte[1024];
					int len = -1;
					while ((len = fis.read(b, 0, b.length)) != -1) {
						fos.write(b, 0, len);
					}
					fos.flush();
				}
			} finally {
				closeInputStream(fis);
				closeOutputStream(fos);
			}
		}
	}

	protected static void closeOutputStream(OutputStream outs) {
		if (outs != null) {
			try {
				outs.close();
			} catch (Exception e) {
				Logger.error(e.getMessage(), e);
			}
		}
	}

	protected static void closeInputStream(InputStream inputs) {
		if (inputs != null) {
			try {
				inputs.close();
			} catch (Exception e) {
				Logger.error(e.getMessage(), e);
			}
		}
	}

	public static void main(String[] args) {
		try {
			String[] files = new String[] { "E:/DEV/fbsxj/src/nc",
					"E:/DEV/fbsxj/src/allen" };
			zipFiles("c:/tttt.zip", files);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

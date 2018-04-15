package nc.ui.export.file.pub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Properties;

import nc.bs.logging.Logger;
import nc.ui.export.allen.encoding.Encoding;
import nc.ui.export.allen.encoding.ExtEncodingUtil;
import nc.ui.export.allen.util.FileReadUtil;
import nc.vo.pub.BusinessException;

public class FileUtil {
	public static boolean isUTF8Encoding(String filePath) throws IOException
	{
		byte[] data = FileReadUtil.readBytes(new File(filePath));
        return ExtEncodingUtil.isRightEncoding(data, Encoding.UTF_8);
	}
	
	
	public static String readSqlFileContent(File file) throws BusinessException
	{
		BufferedReader breader = null;
		try
		{
			StringBuilder sqlContent = new StringBuilder(1024);
			
			
			if (isUTF8Encoding(file.getAbsolutePath()))
			{
				breader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			}
			else
			{
				breader = new BufferedReader(new FileReader(file));
			}
			
			String line = null;
			while((line = breader.readLine()) != null)
			{
				line = line.trim();
				if (line.length() == 0)
				{
					continue;
				}
				
				if (line.startsWith("--"))
				{
					continue;
				}
				
				sqlContent.append(" \n").append(line);
			}
			
			return sqlContent.toString();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new BusinessException("读取文件" + file.getAbsolutePath() + "发生异常：" + e.getMessage(), e);
		}
		finally
		{
			if (breader != null)
			{
				try
				{
					breader.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Properties readPropertiesFileContent(File file) throws BusinessException
	{
		Properties p = new Properties();
		BufferedReader breader = null;
		try
		{
			if (isUTF8Encoding(file.getAbsolutePath()))
			{
				breader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			}
			else
			{
				breader = new BufferedReader(new FileReader(file));
			}
			
//			Properties p = new Properties();
//			p.load(breader);
			p.load(new FileInputStream(file));
			return p; 
		}
		catch(Exception e)
		{
			throw new BusinessException("读取文件" + file.getAbsolutePath() + "发生异常：" + e.getMessage(), e);
		}
		finally
		{
			if (breader != null)
			{
				try
				{
					breader.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Object readJavaObjectFromSerieDataFile(File file)
	{
		if (!file.exists())
		{
			return null;
		}
		
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			return ois.readObject();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (fis != null)
			{
				try
				{
					fis.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static boolean writeObjectToSerieDataFile(Object obj, File file)
	{
		FileOutputStream fos = null;
		try
		{
			File parentFolder = file.getParentFile();
			if (!parentFolder.exists())
			{
				parentFolder.mkdirs();
			}
			
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			if (fos != null)
			{
				try
				{
					fos.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void cpFile(File srcFile, String targetFile) 
	{
		int length = 2097152;
		FileInputStream in = null;
		FileOutputStream out = null;
		FileChannel inC = null;
		FileChannel outC = null;
		
		int index = targetFile.lastIndexOf("/");
		int index2 = targetFile.lastIndexOf("\\");
		index = index>index2?index:index2;
		String folderPath = targetFile.substring(0, index);
		File foler = new File(folderPath);
		if (!foler.exists()) 
		{
			foler.mkdirs();
		}
		
		try 
		{
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(targetFile);

			inC = in.getChannel();
			outC = out.getChannel();

			ByteBuffer b = null;
			while (true) 
			{
				if (inC.position() == inC.size()) 
				{
					return;
				}

				if ((inC.size() - inC.position()) < length) 
				{
					length = (int) (inC.size() - inC.position());
				}
				else 
				{
					length = 2097152;
				}

				b = ByteBuffer.allocateDirect(length);
				inC.read(b);
				b.flip();
				outC.write(b);
				outC.force(false);
			}
		} 
		catch (Exception e) 
        {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			if (inC != null)
			{
				try {
					inC.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (outC != null)
			{
				try 
				{
					outC.close();
				} catch (Exception e) {
					Logger.error(e.getMessage(), e);
				}
			}
		}
	}
	
	/**
	 * @Title: getFolderNameByTime
	 * @Description: 根据时间生成文件夹名称
	 * @Author: 王凯强
	 * @Time: 2016年10月14日 下午2:03:04
	 * @return
	 */
	public static String getFolderNameByTime(){
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		String folderName = sdf.format(new java.util.Date());
		return folderName;
	}
	
	/**
	 * @Title: createFolder
	 * @Description: 创建路径
	 * @Author: 王凯强
	 * @Time: 2016年10月14日 下午1:46:32
	 * @param path
	 */
	public static File createFolder(String path){
		File folder = new File(path);
		if (!folder.exists())
		{
			folder.mkdirs();
		}
		return folder;
	}
	
	/**
	 * @Title: deleteFolder
	 * @Description: 删除路径
	 * @Author: 王凯强
	 * @Time: 2016年10月14日 下午1:46:32
	 * @param path
	 */
	public static void deleteFolder(String path){
		if(path == null) {
			return ;
		}
		File folder = new File(path);
		if (folder.exists()) {
			deleteDir(folder);
		}
	}
	
	private static boolean deleteDir(File file) {
        if (file.isDirectory()) {
            String[] children = file.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(file, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return file.delete();
    }
}

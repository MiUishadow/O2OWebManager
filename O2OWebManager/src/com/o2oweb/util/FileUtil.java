package com.o2oweb.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class FileUtil {
	private static Logger log = Logger.getLogger(FileUtil.class);

	public static boolean removeFile(String fileName) {
		if ((fileName == null) || (fileName.trim().equals(""))) {
			log.info("file name is null.");
			return false;
		}
		try {
			File file = new File(fileName);
			if ((file.exists()) && (file.isFile()) && (file.canRead())
					&& (!file.delete())) {
				log.info("delete file " + file.getName() + " failed.");
			}

			file = null;
		} catch (Exception e) {
			log.info(e.getMessage());
			return false;
		}
		return true;
	}

	public static boolean findFile(String fileName) {
		if ((fileName == null) || (fileName.trim().equals(""))) {
			log.info("file name is null.");
			return false;
		}
		try {
			File file = new File(fileName);
			if (file.exists())
				return true;
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return false;
	}

	public static void writeFile(String fileName, boolean isRewrite,
			Vector<String> vct) {
		if ((fileName == null) || (fileName.trim().equals(""))) {
			log.info("file name is null.");
			return;
		}
		try {
			File file = new File(fileName);
			if ((file.exists()) && (file.isFile()) && (file.canRead())
					&& (file.canWrite())) {
				FileOutputStream fos = new FileOutputStream(file);
				for (String str : vct) {
					fos.write(str.getBytes("utf-8"));
				}
				fos.close();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public static void copyFile(String src, String dest) throws IOException {
		FileInputStream in = new FileInputStream(src);
		File file = new File(dest);
		if ((!file.exists()) && (!file.createNewFile())) {
			log.info("create new file failed.");
		}

		FileOutputStream out = new FileOutputStream(file);

		byte[] buffer = new byte[1024];
		int c;
		while ((c = in.read(buffer)) != -1) {
			for (int i = 0; i < c; i++)
				out.write(buffer[i]);
		}
		in.close();
		out.close();
	}

	public static void renameFile(String path, String oldname, String newname) {
		if ((oldname == null) || (path == null) || (newname == null)
				|| (newname.trim().equals("")) || (oldname.trim().equals(""))
				|| (path.trim().equals(""))) {
			return;
		}
		if (!oldname.equals(newname)) {
			File oldfile = new File(path + "/" + oldname);
			File newfile = new File(path + "/" + newname);
			if (newfile.exists()) {
				log.info(newname + "�Ѿ����ڣ�");
			} else if (!oldfile.renameTo(newfile))
				log.info("rename '" + newfile + "' failed.");
		}
	}

	public static void changeDirectory(String filename, String oldpath,
			String newpath, boolean cover) {
		if ((filename == null) || (oldpath == null) || (newpath == null)
				|| (filename.trim().equals("")) || (oldpath.trim().equals(""))
				|| (newpath.trim().equals(""))) {
			return;
		}
		if (!oldpath.equals(newpath)) {
			File oldfile = new File(oldpath + "/" + filename);
			File newfile = new File(newpath + "/" + filename);
			if (newfile.exists()) {
				if (cover)
					if (!oldfile.renameTo(newfile)) {
						log.info("rename '" + newfile + "' failed.");
					} else
						log.info("����Ŀ¼���Ѿ����ڣ�" + filename);
			} else if (!oldfile.renameTo(newfile))
				log.info("rename '" + newfile + "' failed.");
		}
	}

	@SuppressWarnings("unchecked")
	public static Vector<String> readFileByVector(String path)
			throws IOException {
		File file = new File(path);
		if ((!file.exists()) || (file.isDirectory()))
			throw new FileNotFoundException();
		FileInputStream fis = new FileInputStream(file);
		byte[] buf = new byte[1024];
		Vector vct = new Vector();
		while (fis.read(buf) != -1) {
			String tmp = new String(buf);
			vct.add(tmp.trim());
			buf = new byte[1024];
		}
		fis.close();
		return vct;
	}

	public static String readFileByString(String path) throws IOException {
		File file = new File(path);
		if ((!file.exists()) || (file.isDirectory()))
			throw new FileNotFoundException();
		FileInputStream fis = new FileInputStream(file);
		byte[] buf = new byte[1024];
		StringBuffer sb = new StringBuffer();
		while (fis.read(buf) != -1) {
			sb.append(new String(buf));
			buf = new byte[1024];
		}
		fis.close();
		return sb.toString();
	}

	public static String bufferedReader(String path, String split)
			throws IOException {
		File file = new File(path);
		if ((!file.exists()) || (file.isDirectory()))
			throw new FileNotFoundException();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();
		while (temp != null) {
			sb.append(temp + split);
			temp = br.readLine();
		}
		br.close();
		return sb.toString();
	}

	public static String bufferedReader(String path) throws IOException {
		return bufferedReader(path, "  ");
	}

	public static Document readXml(String path) throws DocumentException,
			IOException {
		File file = new File(path);
		BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
		SAXReader saxreader = new SAXReader();
		Document document = saxreader.read(bufferedreader);
		bufferedreader.close();
		return document;
	}

	public static void createDir(String path) {
		File dir = new File(path);
		if ((!dir.exists()) && (!dir.mkdir()))
			log.info("create new direct failed.");
	}

	public static void createFile(String path, String filename)
			throws IOException {
		File file = new File(path + "/" + filename);
		if ((!file.exists()) && (!file.createNewFile()))
			log.info("create new file failed.");
	}

	public static void delFile(String path, String filename) {
		File file = new File(path + "/" + filename);
		if ((file.exists()) && (file.isFile()) && (!file.delete()))
			log.info("delete file failed.");
	}

	public static void delDir(String path) {
		File dir = new File(path);
		if (dir.exists()) {
			File[] tmp = dir.listFiles();
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i].isDirectory()) {
					delDir(path + "/" + tmp[i].getName());
				} else if (!tmp[i].delete()) {
					log.info("delete file " + tmp[i].getName() + " failed.");
				}
			}

			if (!dir.delete())
				log.info("delete direct failed.");
		}
	}

	public static boolean wirteFile(Vector<String> vct, String fileDir) {
		if ((vct == null) || (vct.size() <= 0) || (fileDir == null)
				|| (fileDir.trim().equals(""))) {
			return false;
		}

		File file = new File(fileDir);
		FileOutputStream out = null;
		try {
			if ((!file.exists()) && (!file.createNewFile())) {
				log.info("create new file failed.");
			}

			out = new FileOutputStream(file, true);
			for (int i = 0; i < vct.size(); i++) {
				StringBuffer sb = new StringBuffer();
				sb.append((String) vct.get(i));
				out.write(sb.toString().getBytes("utf-8"));
			}
			out.close();
		} catch (IOException ie) {
			log.info("write file error.");
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					log.info("close file error.");
				}
			}
		}

		return true;
	}

	public static boolean wirteFile(String value, String fileDir) {
		if ((value == null) || (fileDir == null) || (fileDir.trim().equals(""))) {
			return false;
		}

		File file = new File(fileDir);
		FileOutputStream out = null;
		try {
			if ((!file.exists()) && (!file.createNewFile())) {
				log.info("create new file failed.");
			}

			out = new FileOutputStream(file, true);
			out.write(value.getBytes("utf-8"));
			out.close();
		} catch (IOException ie) {
			log.info("write file error.");
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					log.info("close file error.");
				}
			}
		}

		return true;
	}

	/**
	 * ��ȡ����ļ���
	 * 
	 * @param name
	 * @param url
	 * @return
	 */
	public static String getFilename(String url, String filename) {
		String fn = "";

		fn = DateTimeUtil.getComplexTime() + "_" + new Random().nextInt(1000)
				+ "." + getExt(filename);

		return fn;
	}

	public static String getExt(String url) {
		int pos = url.lastIndexOf(".");
		return url.substring(pos + 1).toLowerCase();
	}
}
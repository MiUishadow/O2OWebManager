package com.o2oweb.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.entity.Image;
import com.o2oweb.entity.Item;
import com.o2oweb.entity.Rollbar;
import com.o2oweb.service.ImageService;
import com.o2oweb.service.ItemService;
import com.o2oweb.service.RollbarService;
import com.o2oweb.util.BaseAction;
import com.o2oweb.util.POIUtil;
import com.o2oweb.util.PropertiesUtil;

@Scope("request")
@Service("ajaxfileAction")
public class Ajaxfileaction extends BaseAction {

	@Autowired
	private ItemService itemService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private RollbarService rollbarService;

	private File file2upload;
	private File excel2upload;
	private File detialimg;

	private String itemId;
	private String fileName;
	private String fileExt;

	private int imgindex;
	private String imgtitle;

	private static String urlpre = "/O2OWebSit/image/getImage?imageID=";

	@Override
	public String execute() throws Exception {
		// 得到工程保存图片的路径
		PropertiesUtil pu = new PropertiesUtil();
		String root = pu.getValue("imageURL");

		InputStream is = new FileInputStream(file2upload);

		// 得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)
		File destFile = new File(root, createFileName());

		// 把图片写入到上面设置的路径里
		OutputStream os = new FileOutputStream(destFile);
		byte[] buffer = new byte[400];
		int length = 0;
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		is.close();
		os.close();

		Image image = new Image();
		image.setImageUrl(destFile.getAbsolutePath());
		image.setItemId(Integer.parseInt(itemId));
		imageService.save(image);

		JSONObject obj = new JSONObject();
		obj.accumulate("status", true);
		obj.accumulate("info", "上传成功");

		writeResponse(obj);
		return super.execute();
	}

	public void importExcel() {

		JSONObject obj = new JSONObject();
		try {
			// 若上传文件不为excel，返回错误信息
			if (!fileExt.equals("xls") && !fileExt.equals("xlsx")) {
				obj.accumulate("status", false);
				obj.accumulate("info", "上传失败，文件格式错误！");
				writeResponse(obj);
				return;
			}
			String keys = "名称（必填）,分类（必填）,条码（必填）,库存量（必填）,进货价（必填）,销售价（必填）";

			List<Map<String, String>> list = POIUtil.importExcelToMap(
					excel2upload, keys);

			double total = list.size();
			double now = 0;
			HttpSession session = getSession();

			for (Map<String, String> row : list) {
				Item item = new Item();
				item.setDiscount(1);
				item.setLevelId(0);
				item.setItemName(row.get("名称（必填）").trim());
				item.setPrice(Float.valueOf(row.get("销售价（必填）").trim()));
				String category_text = row.get("分类（必填）").trim();
				if("无".endsWith(category_text)){
					item.setLevelId(0);
				}else{
					try {
						item.setLevelId(Integer.valueOf(category_text));
					} catch (Exception e) {
						item.setLevelId(0);
					}
				}
				item.setStockNum(Integer.valueOf(row.get("库存量（必填）").trim()));
				item.setBarCode(row.get("条码（必填）").trim());
				item.setInPrice(Float.valueOf(row.get("进货价（必填）").trim()));
				itemService.save(item);

				now++;
				session.setAttribute("percent", now / total);
				System.out.println("insert percent " + now / total);
			}
			obj.accumulate("status", true);
			obj.accumulate("info", "导入成功");
			writeResponse(obj);

		} catch (Exception e) {
			obj.accumulate("status", false);
			obj.accumulate("info", "数据导入异常");
			writeResponse(obj);
			e.printStackTrace();
		}
	}

	public void rollimgedit() {

		Image image = new Image();

		JSONObject obj = new JSONObject();

		FileOutputStream fout = null;
		FileInputStream fin = null;
		File imgfile = null;
		PropertiesUtil pu = new PropertiesUtil();
		String root = pu.getValue("imageURL");
		try {
			fin = new FileInputStream(file2upload);
			imgfile = new File(root, createFileName());
			fout = new FileOutputStream(imgfile);

			int length = 0;
			byte[] buffer = new byte[1024];
			while ((length = fin.read(buffer)) > 0) {
				fout.write(buffer, 0, length);
			}
			fin.close();
			fout.close();

			image.setImageName(imgtitle);
			image.setImageUrl(imgfile.getAbsolutePath());

			imageService.save(image);

			Rollbar rollbar = rollbarService.getRollbar(1);

			rollbarService.setrollimgid(imgindex, rollbar, image.getIdimage(),
					imgtitle);

			rollbarService.update(rollbar);

			obj.accumulate("status", true);
			obj.accumulate("info", "图片设置成功，请关闭上传窗口");
			writeResponse(obj);

		} catch (Exception e) {
			imageService.remove(image);
			imgfile.deleteOnExit();

			obj.accumulate("status", false);
			obj.accumulate("info", "图片设置失败");
			writeResponse(obj);

		}
	}

	public void detialImgupload() {
		Image image = new Image();

		JSONObject obj = new JSONObject();

		FileOutputStream fout = null;
		FileInputStream fin = null;
		File imgfile = null;
		PropertiesUtil pu = new PropertiesUtil();
		String root = pu.getValue("imageURL");
		try {
			fin = new FileInputStream(detialimg);
			imgfile = new File(root, createFileName());
			fout = new FileOutputStream(imgfile);

			int length = 0;
			byte[] buffer = new byte[1024];
			while ((length = fin.read(buffer)) > 0) {
				fout.write(buffer, 0, length);
			}
			fin.close();
			fout.close();

			image.setImageUrl(imgfile.getAbsolutePath());

			imageService.save(image);

			int imgid = image.getIdimage();

			obj.accumulate("status", true);
			obj.accumulate("info", urlpre + imgid);
			writeResponse(obj);

		} catch (Exception e) {
			imageService.remove(image);
			imgfile.deleteOnExit();

			obj.accumulate("status", false);
			obj.accumulate("info", "图片设置失败");
			writeResponse(obj);

		}
	}

	private String createFileName() {
		Random r = new Random();
		DateFormat df = new SimpleDateFormat("yyMMddhhmmss");
		return String.format("%s%06d", new Object[] { df.format(new Date()),
				Integer.valueOf(r.nextInt(100000)) });
	}

	public File getFile2upload() {
		return file2upload;
	}

	public void setFile2upload(File file2upload) {
		this.file2upload = file2upload;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public File getExcel2upload() {
		return excel2upload;
	}

	public void setExcel2upload(File excel2upload) {
		this.excel2upload = excel2upload;
	}

	public int getImgindex() {
		return imgindex;
	}

	public void setImgindex(int imgindex) {
		this.imgindex = imgindex;
	}

	public String getImgtitle() {
		return imgtitle;
	}

	public void setImgtitle(String imgtitle) {
		this.imgtitle = imgtitle;
	}

	public File getDetialimg() {
		return detialimg;
	}

	public void setDetialimg(File detialimg) {
		this.detialimg = detialimg;
	}

}

package com.o2oweb.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.entity.Item;
import com.o2oweb.service.ItemService;
import com.o2oweb.util.BaseAction;
import com.o2oweb.util.FileUtil;
import com.o2oweb.util.POIUtil;

@Scope("request")
@Service("fileAction")
public class FileAction extends BaseAction {
	private String fileName;
	private ItemService itemService;
	private List<File> file;

	public void importExcel() {

		try {
			log.debug("fileName: " + this.fileName);

			// 若上传文件不为excel，返回错误信息
			if (!this.fileName.endsWith(".xls")) {
				writeResponse(false, "上传失败，文件格式错误！");
				return;
			}
			File excelFile = new File(this.fileName);
			String keys = "名称（必填）,分类（必填）,条码（必填）,库存量（必填）,进货价（必填）,销售价（必填）";
			// 如果该路径下文件不存在
			if (!FileUtil.findFile(this.fileName)) {
				writeResponse(false, "导入异常，导入文件不存在！");
				log.error("导入异常,导入文件不存在");
				return;
			}

			List<Map<String, String>> list = POIUtil.importExcelToMap(
					excelFile, keys);

			for (Map<String, String> row : list) {
				Item item = new Item();
				item.setDiscount(1);
				item.setLevelId(0);
				item.setItemName(row.get("名称（必填）").trim());
				item.setPrice(Float.valueOf(row.get("销售价（必填）").trim()));
				item.setStockNum(Integer.valueOf(row.get("库存量（必填）").trim()));
				item.setBarCode(row.get("条码（必填）").trim());
				item.setInPrice(Float.valueOf(row.get("进货价（必填）").trim()));
				// itemService.save(item);
			}

			writeResponse(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void importPicture() {
		try {
			// 得到工程保存图片的路径
			String root = ServletActionContext.getRequest().getRealPath(
					"/upload");

			// 循环上传的文件
			for (File f : file) {
				InputStream is = new FileInputStream(f);

				// 得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)
				File destFile = new File(root, createFileName(f.getName()));

				// 把图片写入到上面设置的路径里
				OutputStream os = new FileOutputStream(destFile);
				byte[] buffer = new byte[400];
				int length = 0;
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}
				is.close();
				os.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String createFileName(String name) {
		Random r = new Random();
		DateFormat df = new SimpleDateFormat("yyMMddhhmmss");
		return String.format(
				"%s%s%06d",
				new Object[] { name, df.format(new Date()),
						Integer.valueOf(r.nextInt(100000)) });
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ItemService getItemService() {
		return itemService;
	}

	@Resource
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

}

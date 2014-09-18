package test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.o2oweb.entity.Item;
import com.o2oweb.util.PropertiesUtil;

public class TestCode {
	@Test
	public void testName() {
		String code = "test";
		Random r = new Random();
		DateFormat df = new SimpleDateFormat("yyMMddhhmmss");
		System.out.println(String.format(
				"%s%s%06d",
				new Object[] { code, df.format(new Date()),
						Integer.valueOf(r.nextInt(100000)) }));
	}
	
	@Test
	public void testProperties() {
		Random r = new Random();
		DateFormat df = new SimpleDateFormat("yyMMddhhmmss");
		File destFile = new File(PropertiesUtil.getValue("imageURL"),
				String.format(
						"%s%s%06d",
						new Object[] { "test", df.format(new Date()),
								Integer.valueOf(r.nextInt(100000)) }));
		System.out.println(destFile.getPath());
		System.out.println(PropertiesUtil.getValue("imageURL"));
	}
}

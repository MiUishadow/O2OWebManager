package test;

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
}

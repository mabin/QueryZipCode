import java.util.List;

import org.junit.Test;

import utils.OptData;
import utils.OptFile;


import beans.AddressInfo;


import junit.framework.TestCase;


public class TestGenerics extends TestCase {
	@Test
	public void test(){
//		List<AddressInfo> addrs = OptFile.getFileData("E:\\project\\QueryZipCode\\123.xls");
//		OptFile.setFileData("E:\\project\\QueryZipCode\\out.xls", addrs);
//		OptFile.getDatabase("E:\\project\\QueryZipCode\\ZipData.xls");
		
		OptData data = new OptData();
		data.initData("E:\\project\\QueryZipCode\\123.xls", "E:\\project\\QueryZipCode\\ZipData.xls");
		data.select("91436","16689 Oldham St");
	}
}

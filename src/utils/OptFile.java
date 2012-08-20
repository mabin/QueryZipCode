package utils;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import beans.AddressInfo;

public final class OptFile {
	
	public static List<AddressInfo> getFileData(String srcFilePath){
		List<AddressInfo> addrs = new LinkedList<AddressInfo>();
		File srcFile = new File(srcFilePath);
		Workbook workbook = null ;
		try{
			workbook = Workbook.getWorkbook(srcFile);
			Sheet sheet = workbook.getSheet(0);
			
			int row = sheet.getRows();
			for (int i=0; i<row; i++){
				AddressInfo addr = new AddressInfo();
				Cell[] cells = sheet.getRow(i);
				addr.setAddress(cells[0].getContents());
				addr.setZipcode(cells[1].getContents());
				addrs.add(addr);
			}
			
//			for (int j=0; j<addrs.size(); j++){
//				AddressInfo addr = addrs.get(j);
//				System.out.println(addr.getZipcode()+"   "+addr.getAddress());
//			}
			workbook.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return addrs;
	}
	
	public static void setFileData(String destFilePath,List<AddressInfo> addrs){
		File destFile = new File(destFilePath);
		WritableWorkbook workbook = null ;
		try{
			workbook = Workbook.createWorkbook(destFile);
			if (workbook !=null){
				WritableSheet sheet = workbook.createSheet("AddressInfo", 0);
				int row = addrs.size();
				for (int i=0; i<row; i++){
					AddressInfo addr = addrs.get(i);
					Label label0 = new Label(0,i,addr.getZipcode());
					Label label1 = new Label(1,i,addr.getState());
					Label label2 = new Label(2,i,addr.getCity());
					Label label3 = new Label(3,i,addr.getAddress());
					Label label4 = new Label(4,i,addr.getPhone());
					
					sheet.addCell(label0);
					sheet.addCell(label1);
					sheet.addCell(label2);
					sheet.addCell(label3);
					sheet.addCell(label4);
				}
			}
			
			workbook.write();
			workbook.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static List<String[]> getDatabase(String databaseFilePath){
		List<String[]> dbList = new LinkedList<String[]>();
		File dbFile = new File(databaseFilePath);
		Workbook workbook = null ;
		try{
			workbook = Workbook.getWorkbook(dbFile);
			Sheet sheet = workbook.getSheet(0);
			
			int row = sheet.getRows();
			for (int i=0; i<row; i++){
				String[] datas = new String[4];
				Cell[] cells = sheet.getRow(i);
				datas[0] = cells[0].getContents();
				datas[1] = cells[1].getContents();
				datas[2] = cells[2].getContents();
				datas[3] = cells[3].getContents();
				dbList.add(datas);
			}
			
//			for (int j=0; j<dbList.size(); j++){
//				String[] addr = dbList.get(j);
//				System.out.println(addr[0]+"   "+addr[1]+"   "+addr[2]+"   "+addr[3]);
//			}
			workbook.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return dbList;
	}
	
}

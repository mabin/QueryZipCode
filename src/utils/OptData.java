package utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


import beans.AddressInfo;

public class OptData {
	public final int ZIPCODE = 0;
	public final int STATE = 1;
	public final int CITY = 2;
	public final int AREACODE = 3;
	List<AddressInfo> addrs = new LinkedList<AddressInfo>();
	List<String[]> database = new LinkedList<String[]>();
	
	public void initData(String srcFilePath,String dbFilePath){
		addrs = OptFile.getFileData(srcFilePath);
		database = OptFile.getDatabase(dbFilePath);
	}
	
	public AddressInfo select(String zipcode, String address){
		AddressInfo addr = new AddressInfo();
		Iterator<String[]> iter = database.iterator();
		while (iter.hasNext()){
			String[] data = iter.next();
			if (data[0].equals(zipcode)){
				String state = data[1]; 
				String city = data[2];
				String phone = data[3]+optPhone();
				address = optAddress(address);
				System.out.println(address+"  "+zipcode+"  "+state+"  "+city+"  "+phone);
			}
		}
		return null;
	}
	
	public String optAddress(String address){
		
		int building = Integer.parseInt(address.split(" ")[0])+58;
		address.replaceFirst("^\\d\\b", String.valueOf(building));
		return address;
	}
	
	public String optPhone(){
		String phone = String.valueOf(RandomNumUtils.getInt(1000000, 9999999));
		return phone;
	}
	
}

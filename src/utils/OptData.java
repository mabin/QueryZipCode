package utils;

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
	
	public List<AddressInfo> PackageData(){
		List<AddressInfo> resultList = new LinkedList<AddressInfo>();
		Iterator<AddressInfo> iter = addrs.iterator();
		
		while (iter.hasNext()){
			AddressInfo addr = iter.next();
			addr = select(addr.getZipcode(),addr.getAddress());
			resultList.add(addr);
		}
		
		return resultList;
	}
	
	
	public AddressInfo select(String zipcode, String address){
		AddressInfo addr = null;
		Iterator<String[]> iter = database.iterator();
		while (iter.hasNext()){
			String[] data = iter.next();
			if (data[0].equals(zipcode)){
				String state = data[1]; 
				String city = data[2];
				String phone = data[3]+optPhone();
				
				address = optAddress(address);
				addr = new AddressInfo();
				addr.setAddress(address);
				addr.setCity(city);
				addr.setPhone(phone);
				addr.setState(state);
				addr.setZipcode(zipcode);
				//System.out.println(address+"  "+zipcode+"  "+state+"  "+city+"  "+phone);
			}
		}
		if (addr == null){
			addr = new AddressInfo();
			addr.setAddress(address);
			addr.setZipcode(zipcode);
		}
		return addr;
	}
	
	public String optAddress(String address){
		String tmp = "";
		try{
			int building = Integer.parseInt(address.split(" ")[0])+58;
			tmp = address.replaceFirst(address.split(" ")[0], String.valueOf(building));
		}catch (Exception e){
			return address;
		}
		return tmp;
	}
	
	public String optPhone(){
		String phone = String.valueOf(RandomNumUtils.getInt(1000000, 9999999));
		return phone;
	}
	
}

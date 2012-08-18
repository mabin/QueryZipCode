package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ObjectFileUtils<T> {
	private T obj ;
	public ObjectFileUtils(T obj){
		this.setObj(obj) ;
	}
	
	public List<T> readFile(String srcFilePath){
		return null;
	}
	
	public void writeFile(String destFilePath){
		
	}
	

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public String showClassType(){
		return this.getObj().getClass().getName();
	}
	
}

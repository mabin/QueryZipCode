package utils;

public class ObjectDBUtils<T> {
	private T obj;
	public ObjectDBUtils(T obj){
		this.setObj(obj);
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public void insert(T obj){}
	public void delete(T obj){}
	public void update(T obj){}
	public void getObjs(){}
	public void getByparams(Object params){}
}

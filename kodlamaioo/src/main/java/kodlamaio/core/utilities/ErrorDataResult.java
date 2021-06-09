package kodlamaio.core.utilities;

public class ErrorDataResult<T> extends DataResult<T>{

	public ErrorDataResult(T data, String message) {
		super(data,message, false);
		
	}
	public ErrorDataResult(T data) {
		super(data, false); //yanlış olduğu zaman.
	}
	public ErrorDataResult(String message) {
		super(null, message, false); //boş ve yanlış olduğu zaman sadece mesaj.
	}
	
	public ErrorDataResult() { //sadece false
		super(null, false);		
	}
	
}

package kodlamaio.core.utilities;

public class DataResult<T> extends Result {

	private T data;
	
	public DataResult(T data, String message, boolean success) {
		super(message, success); //super base sınıfın contructorlarını çalıştırır.
		this.data = data;
	}
	
	public DataResult(T data,boolean success) {
		super(success); //mesaj yazıldığı zaman oluşacak constructor gönderilir.
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
}

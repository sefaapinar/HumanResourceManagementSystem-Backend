package kodlamaio.core.utilities;

public class Result {
	
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success = success;
	}
	
	public Result(String message, boolean success) {
		this.success = success;
		this.message= message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
}

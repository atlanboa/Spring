package spring.service.hello;

/*
 * FileName : Hello.java
 * ? package / private Field(property) / Constructor / getter,setter / ??? Method 
 * ?λ₯? κ°λ λΉ? κ·μ½? μ€?? ?Όλ°μ ?Έ Bean ::  POJO(Plain Old Java Object)
 */
public class Hello{
	
	///Field
	private String message = "Container ?? ?????";
	
	///Constructor Method
	public Hello() {
	}
	public Hello(String message) {
		this.message = message;
	}

	///Method
	//==> getter / setter Method definition
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//==> message λ₯? μΆλ ₯?? Method  
	public void printMessage() {
		System.out.println("\n"+getClass().getName()+"=>"+message);
	}
	
}//end of class
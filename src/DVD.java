public class DVD {
	private final String title; 
	private final int price;    
	boolean rental;			
	
	public DVD(String title, int price) {
		this.title = title;		
		this.price = price;		
		this.rental = false;		}
	
	
	//レンタル情報の取得・変更処理
	
	public boolean isRental() {return rental; }	 

	public void startRent() {this.rental = true; } 
   
	public void finishuRented() {this.rental = false; } 	

	//商品情報を返す処理
	
	public int getPrice() {return price; }		
	public String getTitle() {return title; }	
	
	
 }

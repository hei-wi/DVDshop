import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {
	private final Member member;
	private final DVD dvd;
	
	private final LocalDate rentalDate;
	private final LocalDate dueDate;
	private boolean returned;
	
	public Rental(Member member, DVD dvd) {
		this.member = member;
		this.dvd = dvd;
		
		
		//日付処理
		this.rentalDate = LocalDate.now();				//この貸出記録の貸出日
		this.dueDate = this.rentalDate.plusDays(7);		//この貸出記録の返却予定日(貸出日からｎ日後)
		this.returned = false;							//まだ返却されていない
	}
	
	public int charge() {
		return dvd.getPrice();
	}
	public Member getMember() {return member; }
	public DVD getDVD() { return dvd; }
	
	public LocalDate getRentalDate() {	return rentalDate; }
	public LocalDate getDueDate() { return dueDate; }
	public boolean isReturned() { return returned; }
	
	public void markReturned() { this.returned = true; }

	public boolean isOverdue() {
		
		LocalDate today = LocalDate.now();
		return today.isAfter(dueDate);
		
	}
	
	public  int calculateLateFee() {
		if(!isOverdue()) {
			return 0;
		}
		
		LocalDate today = LocalDate.now();
		long lateDays = ChronoUnit.DAYS.between(dueDate, today);
		
		return(int) lateDays * 100;
	}
	
}

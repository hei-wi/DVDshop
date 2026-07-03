
public class Regi {
	private int saletotal = 0;

	public Rental checkout(Member member, DVD dvd) {
		if (dvd.isRental()) {

			System.out.println(dvd.getTitle() + " は貸出中です");
			System.out.println();
			
			return null;
		} 

		dvd.startRent();
		Rental rental = new Rental(member, dvd);
		int calculatecharge = rental.charge();
		member.addPoint(calculatecharge / 100);

		this.saletotal += calculatecharge;

		return rental;
	}
	
	public int returnRental(Rental rental) {
		if(rental.isReturned()) {
			System.out.println("すでに返却済みです");
			System.out.println();
			return 0;
		}
		
		int lateFee = rental.calculateLateFee();
		rental.getDVD().finishuRented();
		rental.markReturned();
		this.saletotal += lateFee;
		return lateFee;
				
	}

	public int getSaletotal() {return saletotal;}
	
	}


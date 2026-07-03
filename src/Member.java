public class Member {
	private final String name;
	private int point  = 0;
	
	public Member(String name) {
		this.name = name; 	 
	}
	
	public void addPoint(int addPoint){this.point +=  addPoint;}
	public int getPoint() { return point; }
	public String getName() { return name; }
}

import java.util.Random;

public class Data {
    private static final String[]   FIRST = {"Favonius", "Tim", "Brad", "Scott", "Linda"};
    private static final String[]   SECOND = {"Cruise", "Temp", "Abbey", "Adam", "Albert", "Thomas"};
    private static final int[]      THIRD = {22, 23, 24, 25, 26, 27, 28, 29, 30};
    
    private static Random random = new Random(System.currentTimeMillis());
    
    private String first;
    private String second;
    private int third;
    
    public Data(String first, String second, int third) {
    	super();
    	this.first = first;
    	this.second = second;
    	this.third = third;
    }
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public int getThird() {
		return third;
	}
	public void setThird(int third) {
		this.third = third;
	}
    public static Data createRandomData(){
        return new  Data(FIRST[random.nextInt(FIRST.length)], 
                SECOND[random.nextInt(SECOND.length)], THIRD[random.nextInt(THIRD.length)]);
    }
}

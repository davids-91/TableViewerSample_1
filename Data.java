import java.util.Random;

import org.eclipse.swt.custom.CCombo;

public class Data {
    public static final String[]   FIRST = {"Favonius", "Tim", "Brad", "Scott", "Linda", "Ava", "Claire", "Joanne", "Natalie", "Tracey"};
    public static final String[]   SECOND = {"Cruise", "Temp", "Abbey", "Adam", "Albert", "Thomas", "Cameron", "Davidson", "Gibson", "Jackson"};
    public static final int[]      THIRD = {22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    public static final String[]   COMBO_ITEMS = {"Item1", "Item2", "Item3", "Item4", "Item5"};
    public static final String[][] COMBOBOXES = {Data.COMBO_ITEMS, Data.COMBO_ITEMS, Data.COMBO_ITEMS, Data.COMBO_ITEMS, Data.COMBO_ITEMS, Data.COMBO_ITEMS, Data.COMBO_ITEMS, Data.COMBO_ITEMS, Data.COMBO_ITEMS, Data.COMBO_ITEMS};
//    public static CCombo[] combobox = new CCombo[10];
//    public static List<CCombo> combobox = fillList();
    
    private static Random random = new Random(System.currentTimeMillis());
    
    private String first;
    private String second;
    private int third;
    private CCombo combo;
    private String selected_combo;
    
//    public static List<CCombo> fillList()
//    {
//    	List<CCombo> combobox = new ArrayList<>();
//    	for (int i = 0; i < COMBO_ITEMS.length; i++) {
//    		CCombo combo = new CCombo();
//    		combo.setItems(COMBO_ITEMS);
//    		combobox.add(combo);
//    	}
//    	return combobox;
//    }
    
    public Data(String first, String second, int third, String selected_combo) {
    	super();
    	this.first = first;
    	this.second = second;
    	this.third = third;
    	this.selected_combo = selected_combo;
    }
    public Data(String first, String second, int third) {
    	super();
    	this.first = first;
    	this.second = second;
    	this.third = third;
    	this.selected_combo = Data.COMBO_ITEMS[0];
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
	public String getCombo() {
		return selected_combo;
	}
	public void setCombo(String selected_combo) {
		this.selected_combo = selected_combo;
	}
//    public static Data createRandomData(){
//        return new  Data(FIRST[random.nextInt(FIRST.length)], 
//                SECOND[random.nextInt(SECOND.length)], THIRD[random.nextInt(THIRD.length)]);
//    }
}

import OO.OoJzt;
import PO.PoJzt;
public class Test {
	public static void main(String[] args) {
		OoJzt oj=new OoJzt('d','e',5);
		oj.setOe('o');
		oj.setUd('u');
		oj.setLevel(3);
		oj.build();
		
		PoJzt.build('d','e',1);
		
		
		OoJzt oj1=new OoJzt("./input.txt");
		oj1.build();
	}
}

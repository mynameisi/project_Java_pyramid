package OO;
import java.io.FileNotFoundException;
import tools.Constants;
import tools.Input;
import tools.Msg;
public class OoJzt {
	private char ud = 0;
	private char oe = 0;
	private int level = 0;
	public char getUd() {
		return ud;
	}
	public void setUd(char ud) {
		if ((ud != 'u') && (ud != 'd')) {
			Msg.errorMessage(ud + "是不合法的输入\n请输入 u[表示正向显示金字塔] 或者 d[表示反向显示金字塔]");
		}
		this.ud = ud;
	}
	public char getOe() {
		return oe;
	}
	public void setOe(char oe) {
		if ((oe != 'o') && (oe != 'e')) {
			Msg.errorMessage(oe + "是不合法的输入\n请输入 o[表示只显示奇数列的行] 或者 e[表示只显示偶数列的行]");
		}
		this.oe = oe;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level<=0){
			Msg.errorMessage(level + "是不合法的输入\n请输入大于等于1的值作为金字塔的层数");
		}
		this.level = level;
	}
	public OoJzt(char ud, int level) {
		super();
		this.setUd(ud);
		this.setLevel(level);
	}
	public OoJzt(char ud, char oe, int level) {
		super();
		this.setUd(ud);
		this.setOe(oe);
		this.setLevel(level);
	}
	public OoJzt(String fileName) {
		try {
			getUDOE(Input.getOneStringFromFile(Constants.inputFile));
		} catch (FileNotFoundException e) {
			Msg.errorMessage("输入文件不存在");
		}
	}
	public void getUDOE(String str) {
		setUd(str.charAt(0));
		String temp = "";
		if (str.charAt(1) == 'o' || str.charAt(1) == 'e') {
			setOe(str.charAt(1));
			temp = str.substring(2, str.length());
		} else {
			temp = str.substring(1, str.length());
		}
		try {
			setLevel(Integer.parseInt(temp));
		} catch (Exception e) {
			Msg.errorMessage(temp + "是不合法的输入\n请输入合理的金字塔层数");
		}
	}
	public void build() {
		System.out.println("正反: " + (ud == 'u' ? "正向显示金字塔" : "反向显示金字塔"));
		System.out.println("奇偶: " + (oe == 'e' ? "只显示偶数列的行" : oe == 'o' ? "只显示奇数列的行" : "全部显示"));
		System.out.println("层数: " + level);
		if (ud == 'u') {
			if (oe == 0) {
				buildUp();
			} else {
				buildUp(oe);
			}
		} else if (ud == 'd') {
			if (oe == 0) {
				buildDown();
			} else {
				buildDown(oe);
			}
		}
	}
	private void buildUp() {
		for (int i = 0; i < level; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	private void buildDown() {
		for (int i = 1; i <= level; i++) {
			for (int j = i; j <= level; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	private void buildUp(char oe) {
		for (int i = 0; i < level; i++) {
			if (oe == 'o' && i % 2 != 0) {
				continue;
			} else if (oe == 'e' && i % 2 == 0) {
				continue;
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	private void buildDown(char oe) {
		for (int i = 1; i <= level; i++) {
			int temp = level - i + 1;
			if (oe == 'o' && temp % 2 == 0) {
				continue;
			} else if (oe == 'e' && temp % 2 != 0) {
				continue;
			}
			for (int j = i; j <= level; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

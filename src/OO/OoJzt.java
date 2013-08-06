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
			Msg.errorMessage(ud + "�ǲ��Ϸ�������\n������ u[��ʾ������ʾ������] ���� d[��ʾ������ʾ������]");
		}
		this.ud = ud;
	}
	public char getOe() {
		return oe;
	}
	public void setOe(char oe) {
		if ((oe != 'o') && (oe != 'e')) {
			Msg.errorMessage(oe + "�ǲ��Ϸ�������\n������ o[��ʾֻ��ʾ�����е���] ���� e[��ʾֻ��ʾż���е���]");
		}
		this.oe = oe;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level<=0){
			Msg.errorMessage(level + "�ǲ��Ϸ�������\n��������ڵ���1��ֵ��Ϊ�������Ĳ���");
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
			Msg.errorMessage("�����ļ�������");
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
			Msg.errorMessage(temp + "�ǲ��Ϸ�������\n���������Ľ���������");
		}
	}
	public void build() {
		System.out.println("����: " + (ud == 'u' ? "������ʾ������" : "������ʾ������"));
		System.out.println("��ż: " + (oe == 'e' ? "ֻ��ʾż���е���" : oe == 'o' ? "ֻ��ʾ�����е���" : "ȫ����ʾ"));
		System.out.println("����: " + level);
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

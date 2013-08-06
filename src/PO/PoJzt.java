package PO;
import tools.Msg;
public final class PoJzt {
	private PoJzt() {
	};
	public static void build(char ud, int level) {
		judgeUd(ud);
		judgeLevel(level);
		System.out.println("正反: " + (ud == 'u' ? "正向显示金字塔" : "反向显示金字塔"));
		System.out.println("层数: " + level);
		if (ud == 'u') {
			buildUp(level);
		} else if (ud == 'd') {
			buildDown(level);
		}
	}
	public static void judgeLevel(int level) {
		if (level <= 0) {
			Msg.errorMessage(level + "是不合法的输入\n请输入大于等于1的值作为金字塔的层数");
		}
	}
	public static void judgeUd(char ud) {
		if ((ud != 'u') && (ud != 'd')) {
			Msg.errorMessage(ud + "是不合法的输入\n请输入 u[表示正向显示金字塔] 或者 d[表示反向显示金字塔]");
		}
	}
	public static void judgeOe(char oe) {
		if ((oe != 'o') && (oe != 'e')) {
			Msg.errorMessage(oe + "是不合法的输入\n请输入 o[表示只显示奇数列的行] 或者 e[表示只显示偶数列的行]");
		}
	}
	public static void build(char ud, char oe, int level) {
		judgeUd(ud);
		judgeOe(oe);
		judgeLevel(level);
		System.out.println("正反: " + (ud == 'u' ? "正向显示金字塔" : "反向显示金字塔"));
		System.out.println("奇偶: " + (oe == 'e' ? "只显示偶数列的行" : oe == 'o' ? "只显示奇数列的行" : "全部显示"));
		System.out.println("层数: " + level);
		if (ud == 'u') {
			buildUp(oe, level);
		} else if (ud == 'd') {
			buildDown(oe, level);
		}
	}
	private static void buildUp(int level) {
		for (int i = 0; i < level; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	private static void buildDown(int level) {
		for (int i = 1; i <= level; i++) {
			for (int j = i; j <= level; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	private static void buildUp(char oe, int level) {
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
	private static void buildDown(char oe, int level) {
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

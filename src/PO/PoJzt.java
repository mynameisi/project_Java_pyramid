package PO;
import tools.Msg;
public final class PoJzt {
	private PoJzt() {
	};
	public static void build(char ud, int level) {
		judgeUd(ud);
		judgeLevel(level);
		System.out.println("����: " + (ud == 'u' ? "������ʾ������" : "������ʾ������"));
		System.out.println("����: " + level);
		if (ud == 'u') {
			buildUp(level);
		} else if (ud == 'd') {
			buildDown(level);
		}
	}
	public static void judgeLevel(int level) {
		if (level <= 0) {
			Msg.errorMessage(level + "�ǲ��Ϸ�������\n��������ڵ���1��ֵ��Ϊ�������Ĳ���");
		}
	}
	public static void judgeUd(char ud) {
		if ((ud != 'u') && (ud != 'd')) {
			Msg.errorMessage(ud + "�ǲ��Ϸ�������\n������ u[��ʾ������ʾ������] ���� d[��ʾ������ʾ������]");
		}
	}
	public static void judgeOe(char oe) {
		if ((oe != 'o') && (oe != 'e')) {
			Msg.errorMessage(oe + "�ǲ��Ϸ�������\n������ o[��ʾֻ��ʾ�����е���] ���� e[��ʾֻ��ʾż���е���]");
		}
	}
	public static void build(char ud, char oe, int level) {
		judgeUd(ud);
		judgeOe(oe);
		judgeLevel(level);
		System.out.println("����: " + (ud == 'u' ? "������ʾ������" : "������ʾ������"));
		System.out.println("��ż: " + (oe == 'e' ? "ֻ��ʾż���е���" : oe == 'o' ? "ֻ��ʾ�����е���" : "ȫ����ʾ"));
		System.out.println("����: " + level);
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

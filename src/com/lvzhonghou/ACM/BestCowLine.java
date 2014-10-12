package com.lvzhonghou.ACM;

/**
 * @Description
 * Best Cow Line
 * ��������ΪN���ַ���S��Ҫ����һ������ΪN���ַ���T�������T��һ���մ�����󷴸����������������
 * 1����S��ͷ��ɾ��һ���ַ����ӵ�T��β��
 * 2����S��β��ɾ��һ���ַ����ӵ�T��β��
 * Ŀ����Ҫ�����ֵ��򾡿���С���ַ���T
 * 
 * @author zhonghou.lzh
 * @date 2014��10��11�� ����4:39:26
 * @version v1��0
 */
public class BestCowLine {
	/**
	 * @Description
	 * @param s
	 * @return
	 */
	public static char[] solve(char[] s) {
		char[] relt = new char[s.length];
		int index = 0;
		int start = 0;
		int end = s.length - 1;

		while (start <= end) {
			if (s[start] < s[end]) {
				relt[index++] = s[start++];
			} else if (s[start] > s[end]) {
				relt[index++] = s[end--];
			} else {
				int i, j;
				for (i = start, j = end; i <= j; i++, j--) {
					if (s[i] < s[j]) {
						relt[index++] = s[start++];
						break;
					} else if (s[i] > s[j]) {
						relt[index++] = s[end--];
						break;
					}
				}
				if (i > j) {
					relt[index++] = s[start++];
				}
			}
		}

		return relt;
	}

	/**
	 * @Description
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = {'A', 'C', 'D', 'B', 'C', 'B'};
		char[] relt = solve(s);
		
		for(int i = 0; i < relt.length; i++) 
			System.out.println(relt[i] + " ");

	}

}

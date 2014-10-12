package com.lvzhonghou.ACM;

/**
 * @Description
 * Best Cow Line
 * 给定长度为N的字符串S，要构造一个长度为N的字符串T。起初，T是一个空串，随后反复进行下列任意操作
 * 1、从S的头部删除一个字符，加到T的尾部
 * 2、从S的尾部删除一个字符，加到T的尾部
 * 目标是要构造字典序尽可能小的字符串T
 * 
 * @author zhonghou.lzh
 * @date 2014年10月11日 下午4:39:26
 * @version v1。0
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

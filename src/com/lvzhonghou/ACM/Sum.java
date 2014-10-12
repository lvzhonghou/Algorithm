package com.lvzhonghou.ACM;

/** 
 * @Description ����a1��a2������������an���ж��Ƿ���Դ���ѡ����������ʹ���ǵĺ�ǡ��Ϊk
 * @author zhonghou.lzh
 * @date 2014��10��10�� ����10:53:04 
 * @version v1��0
 */
public class Sum {
	static int[] a = {1, 2, 4, 7};
	static int n = a.length;
	static int k = 13;
	 /** 
	 * @Description depth first search
	 * @param i
	 * @param sum
	 * @return  
	 */
	public static boolean dfs(int i, int sum) {
		if(i == 4) 
			return sum == k;
		
		return dfs(i + 1, sum) || dfs(i + 1, sum + a[i]);
	}
	/** 
	 * @Description 
	 * @param args  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(dfs(0, 0))
			System.out.println("Yes");

	}

}

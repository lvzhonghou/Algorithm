package com.lvzhonghou.ACM;

/**
 * @Description
 *  Ӳ������
 *   ��1Ԫ��5Ԫ��10Ԫ��50Ԫ��100Ԫ��500Ԫ��Ӳ�Ҹ�C1��C5��C10��C50��C100��C500ö������Ҫ����ЩӲ����֧��AԪ��������Ҫ����Ӳ�ң����豾�����ٴ���һ��֧������
 * @author zhonghou.lzh
 * @date 2014��10��11�� ����10:40:17
 * @version v1��0
 */
public class Coins {
	static int[] V = { 1, 5, 10, 50, 100, 500 };
	static int[] C = { 3, 2, 1, 3, 0, 2 };

	// static int relt = 0;
	// static int K = 620;

	 /** 
	 * @Description 
	 *
	 * @param A
	 * @return  
	 */
	public static int solve(int A) {
		int relt = 0;

		for (int i = V.length - 1; i >= 0; i--) {
			int num = Math.min(A / V[i], C[i]);
			A -= num * V[i];
			
			relt += num;
		}
		
		return relt;
	}

	/**
	 * @Description
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int relt = solve(620);
		
		System.out.println(relt);
	}

}

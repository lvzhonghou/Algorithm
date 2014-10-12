package com.lvzhonghou.ACM;

/**
 * @Description
 *  硬币问题
 *   有1元、5元、10元、50元、100元、500元的硬币各C1、C5、C10、C50、C100、C500枚。现在要用这些硬币来支付A元，最少需要多少硬币？假设本题至少存在一种支付方案
 * @author zhonghou.lzh
 * @date 2014年10月11日 上午10:40:17
 * @version v1。0
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

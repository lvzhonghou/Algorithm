package com.lvzhonghou.ACM;

/**
 * @Description Fibonacci数列
 * @author zhonghou.lzh
 * @date 2014年10月10日 下午10:44:11
 * @version v1。0
 */
public class Fibonacci {

	/**
	 * @Description
	 * @param i
	 * @return
	 */
	public static int fibo(int i) {
		if (i == 0 || i == 1)
			return 1;
		return fibo(i - 1) + fibo(i - 2);

	}

	/**
	 * @Description
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fiboV = fibo(0);
		
		System.out.println(fiboV);

		
	}

}

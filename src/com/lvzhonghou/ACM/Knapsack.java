package com.lvzhonghou.ACM;

/**
 * @Description
 * 
 * @author zhonghou.lzh
 * @date 2014年10月24日 下午10:31:53
 * @version v1。0
 */
public class Knapsack {
	static int w[] = {2, 1, 3, 2};
	static int v[] = {3, 2, 4, 2};

	/**
	 * @Description
	 * @param i
	 * @param j
	 * @return
	 */
	public static int rec(int i, int j) {
		if (i == w.length) {
			return 0;
		} else if (w[i] > j) {
			return rec(i + 1, j);
		} else {
			return Math.max(rec(i + 1, j), rec(i + 1, j - w[i]) + v[i]);
		}
	}
	
	static int[][] dp = new int[w.length + 1][10];
	
	 /** 
	 * @Description 
	 * @param i
	 * @param j
	 * @return  
	 */
	public static int rec_v2(int i, int j) {
		if(dp[i][j] > 0)
			return dp[i][j];
		
		int ret = 0;
		
		if(i == w.length)
			ret =  0;
		else if(w[i] > j)
			ret = rec_v2(i + 1, j);
		else 
			ret = Math.max(rec_v2(i + 1, j - w[i]) + v[i], rec_v2(i + 1, j));
		
		dp[i][j] = ret;
		return ret;
	}
	

	/**
	 * @Description
	 * @param args
	 */
	public static void main(String[] args) {
		String s;
		s = "foo";
        for(int i=0;i<10;i+=1){
            s+=Integer.toString(i);
        }
        
        System.out.println(s);
        

		// TODO Auto-generated method stub
		//System.out.println(rec(0, 5));
		//System.out.println(rec_v2(0, 5));
	}

}

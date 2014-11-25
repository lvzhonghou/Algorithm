package com.lvzhonghou.ACM;

/** 
 * @Description 某推销员要从城市 v1 出发，访问其它城市 v2，v3，…，v6 各一次且仅一次，最后返回 v1。
 * @author zhonghou.lzh
 * @date 2014年11月25日 下午12:57:17 
 * @version v1。0
 */
public class Tsp {

	
	static int n = 6; 
	static int[][] D ;
	
	 /** 
	 * @Description 初始化D   
	 */
	private static void init() {
		D = new int[][]{{0, 10, 20, 30, 40, 50}, 
					{12, 0, 18, 30, 25, 21},
					{23, 19, 0, 5, 10, 15},
					{34, 32, 4, 0, 8, 16},
					{45, 27, 11, 10, 0, 18}, 
					{56, 22, 16, 20, 12, 0}
					};
	}
	
	/** 
	 * @Description 
	 * @param args  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j, k, min, temp;
		int b = (int)Math.pow(2, n-1);
		
		//初始化D
		init();
		
		int[][] F = new int[n][b];  //存放阶段最优值
		int[][] M = new int[n][b];	//存放最优策略
		
		//初始化F[][] M[][]
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++) {
				F[j][i] = -1;
				M[j][i] = -1;
			}
		
		//给F的第0列赋予初值
		for(i = 0; i < n; i++)
			F[i][0] = D[i][0];
		
		//遍历并且填表
		for(i = 1; i < b - 1; i++)
			for(j = 1; j < n; j++) {
				if(((int)Math.pow(2, j - 1) & i) == 0) {
					min = 65535;
					for(k = 1; k < n; k++)
						if(((int)Math.pow(2, k-1) & i) != 0)  {
							temp = D[j][k] + F[k][i-(int)Math.pow(2, k-1)];
							if(temp < min) {
								min = temp;
								F[j][i] = min;
								M[j][i] = k;
							}
							
						}
				}
			}
		
		
		//最后一列，即总最优值的计算  
	    min=65535;  
	    for(k=1;k<n;k++)  
	    {  
	        //b-1的二进制全1，表示集合{1,2,3,4,5}，从中去掉k结点即将k对应的二进制位置0  
	        temp = D[0][k] + F[k][b-1 - (int)Math.pow(2,k-1)];  
	        if(temp < min)  
	        {  
	            min = temp;  
	            F[0][b-1] = min;//总最优解  
	            M[0][b-1] = k;  
	        }  
	    }  
	    
	    System.out.println("最短路径长度为："+ F[0][b-1]);
	    
	    
	  //回溯查表M输出最短路径(编号0~n-1)  
	    System.out.println("最短路径如下");  
	    for(i=b-1,j=0; i>0; )//i的二进制是5个1，表示集合{1,2,3,4,5}  
	    {  
	        j = M[j][i];//下一步去往哪个结点  
	        i = i - (int)Math.pow(2,j-1);//从i中去掉j结点  
	        System.out.println("->" + j);  
	    }  
	    
	    System.out.println("->0");
	}

}

package com.lvzhonghou.ACM;

/**
 * @Description 
 * 	有一个大小为N * M的园子，雨后积起了水.八连通的积水被认为是连接在一起的。请求出园子里总共有多少水洼？ （八连通指的是下图中相对w的*部分）
 * 	***
 * 	*w*
 * 	***
 * @author zhonghou.lzh
 * @date 2014年10月10日 下午11:15:30
 * @version v1。0
 */
public class LakeCounting {
	static int Sum = 0;
	static char[][] L = new char[][] {
			{ 'w', '.', '.', '.', '.', '.', '.', '.', '.', 'w', 'w', '.' },
			{ '.', 'w', 'w', 'w', '.', '.', '.', '.', '.', 'w', 'w', 'w' },
			{ '.', '.', '.', '.', 'w', 'w', '.', '.', '.', 'w', 'w', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.', 'w', 'w', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.', '.', 'w', '.', '.' },
			{ '.', '.', 'w', '.', '.', '.', '.', '.', '.', 'w', '.', '.' },
			{ '.', 'w', '.', 'w', '.', '.', '.', '.', '.', 'w', 'w', '.' },
			{ 'w', '.', 'w', '.', 'w', 'w', '.', '.', '.', '.', 'w', '.' },
			{ '.', 'w', '.', 'w', '.', '.', '.', '.', '.', '.', 'w', '.' },
			{ '.', '.', 'w', '.', '.', '.', '.', '.', '.', '.', 'w', '.' }};

	 /** 
	 * @Description 深度遍历的次数即为水洼的个数
	 * @param x
	 * @param y  
	 */
	public static void dfs(int x, int y) {
		if (L[x][y] == 'w')
			L[x][y] = '.';

		for (int lx = -1; lx <= 1; lx++)
			for (int ry = -1; ry <= 1; ry++) {
				if (lx + x >= 0 && lx + x < L.length && ry + y >= 0
						&& ry + y < L[0].length ) {
					if( L[lx + x][ry + y] == 'w')
						dfs(lx + x, ry + y);
				}
			}

	}

	public static void main(String[] args) {
		for(int i = 0; i < L.length; i++) 
			for(int j = 0; j < L[0].length; j++) 
				if(L[i][j] == 'w') {
					Sum++;
					dfs(i, j);
				}
		
		System.out.println("sum is " + Sum);
	}

}

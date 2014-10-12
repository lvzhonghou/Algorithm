package com.lvzhonghou.ACM;

/**
 * @Description 
 * 	��һ����СΪN * M��԰�ӣ���������ˮ.����ͨ�Ļ�ˮ����Ϊ��������һ��ġ������԰�����ܹ��ж���ˮ�ݣ� ������ָͨ������ͼ�����w��*���֣�
 * 	***
 * 	*w*
 * 	***
 * @author zhonghou.lzh
 * @date 2014��10��10�� ����11:15:30
 * @version v1��0
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
	 * @Description ��ȱ����Ĵ�����Ϊˮ�ݵĸ���
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

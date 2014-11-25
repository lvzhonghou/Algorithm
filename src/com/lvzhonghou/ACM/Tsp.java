package com.lvzhonghou.ACM;

/** 
 * @Description ĳ����ԱҪ�ӳ��� v1 ������������������ v2��v3������v6 ��һ���ҽ�һ�Σ���󷵻� v1��
 * @author zhonghou.lzh
 * @date 2014��11��25�� ����12:57:17 
 * @version v1��0
 */
public class Tsp {

	
	static int n = 6; 
	static int[][] D ;
	
	 /** 
	 * @Description ��ʼ��D   
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
		
		//��ʼ��D
		init();
		
		int[][] F = new int[n][b];  //��Ž׶�����ֵ
		int[][] M = new int[n][b];	//������Ų���
		
		//��ʼ��F[][] M[][]
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++) {
				F[j][i] = -1;
				M[j][i] = -1;
			}
		
		//��F�ĵ�0�и����ֵ
		for(i = 0; i < n; i++)
			F[i][0] = D[i][0];
		
		//�����������
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
		
		
		//���һ�У���������ֵ�ļ���  
	    min=65535;  
	    for(k=1;k<n;k++)  
	    {  
	        //b-1�Ķ�����ȫ1����ʾ����{1,2,3,4,5}������ȥ��k��㼴��k��Ӧ�Ķ�����λ��0  
	        temp = D[0][k] + F[k][b-1 - (int)Math.pow(2,k-1)];  
	        if(temp < min)  
	        {  
	            min = temp;  
	            F[0][b-1] = min;//�����Ž�  
	            M[0][b-1] = k;  
	        }  
	    }  
	    
	    System.out.println("���·������Ϊ��"+ F[0][b-1]);
	    
	    
	  //���ݲ��M������·��(���0~n-1)  
	    System.out.println("���·������");  
	    for(i=b-1,j=0; i>0; )//i�Ķ�������5��1����ʾ����{1,2,3,4,5}  
	    {  
	        j = M[j][i];//��һ��ȥ���ĸ����  
	        i = i - (int)Math.pow(2,j-1);//��i��ȥ��j���  
	        System.out.println("->" + j);  
	    }  
	    
	    System.out.println("->0");
	}

}

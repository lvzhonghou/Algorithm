package com.lvzhonghou.ACM;

import java.util.Arrays;

/** 
 * @Description 
 * �����������
 * ��n���,ÿ����ֱ���siʱ�俪ʼ����tiʱ�����������ÿ������㶼����ѡ�����������ѡ���˲��룬��ô��ʼ���ն�����ȫ�̲��롣���⣬���빤����ʱ��β����ص���
 * ��ʹ�ǿ�ʼ��˲��ͽ�����˲����ص�Ҳ�ǲ�����ģ�
 * 
 * @author zhonghou.lzh
 * @date 2014��10��11�� ����2:00:38 
 * @version v1��0
 */
class Interval implements Comparable<Interval>{
	int start ;
	int end;
	
	/**
	 * Description 
	 * @param o
	 * @return 
	 * @see java.lang.Comparable#compareTo(java.lang.Object) 
	 */ 
	@Override
	public int compareTo(Interval o) {
		// TODO Auto-generated method stub
		if(this.end <= o.end)
			return 1;
		
		return 0;
	}
	
	/**
	 * Creates a new instance of Interval.
	 * Description 
	 * @param start
	 * @param end
	 */
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class IntervalScheduling {
	
	 /** 
	 * @Description 
	 * @param s
	 * @param t
	 * @return  
	 */
	public static int solve(int[] s, int[] t) {
		Interval[] intervals = new Interval[s.length];
		
		for(int i = 0; i < s.length; i++) {
			intervals[i] = new Interval(s[i], t[i]);
		}
		
		Arrays.sort(intervals);
		
		int last = 0; //last selection's end time
		int relt = 0;// the result 
		for(int i = 0; i < s.length; i++) {
			if(last < intervals[i].start) {
				relt++;
				last = intervals[i].end;
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
		int[] s = {1, 2, 4, 6, 8};
		int[] t = {3, 5, 7, 9, 10};
		
		int relt = solve(s, t);
		System.out.println(relt);
	}

}

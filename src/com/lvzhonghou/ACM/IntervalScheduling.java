package com.lvzhonghou.ACM;

import java.util.Arrays;

/** 
 * @Description 
 * 区间调度问题
 * 有n项工作,每项工作分别在si时间开始，在ti时间结束。对于每项工作，你都可以选择参与与否。如果选择了参与，那么自始至终都必须全程参与。此外，参与工作的时间段不能重叠（
 * 即使是开始的瞬间和结束的瞬间的重叠也是不允许的）
 * 
 * @author zhonghou.lzh
 * @date 2014年10月11日 下午2:00:38 
 * @version v1。0
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

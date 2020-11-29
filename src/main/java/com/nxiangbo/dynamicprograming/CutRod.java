package com.nxiangbo.dynamicprograming;
/**
 * 钢条切割问题
 * @author nxiangbo
 *
 */
public class CutRod {
	public static int memorizedCutRod(int[] p, int n){
		int result = 0;
		//保存已计算过的子问题的解的数组
		int res[] = new int[n+1];
		for (int i = 0; i < res.length; i++) {
			res[i] = -1;
		}
		result = memorizedCutRodAux(p, n, res);
		return result;
	}
	
	public static int memorizedCutRodAux(int[] p, int n, int[] r){
		//如果已经计算过该子问题的解，直接返回
		if(r[n]>=0){
			return r[n];
		}
		
		int q = -1;
		if(n==0){
			 q = 0;
		} else{
			//r(n)=max(p[i]+r(n-i))
			//p[i]表示切割成长度为i的钢条的收益
			//r(n-i)剩余钢条的最大收益值
			 for(int i = 1;i<=n;i++){
				 q = Math.max(q, p[i]+memorizedCutRodAux(p, n-i, r));
			 }
		}
		r[n] = q;
		return q;
	}
	
	public static int bottomUpCutRod(int[] p, int n){
		//保存子问题的结果，res[n]就是我们所需的最优解
		int[] res = new int[n+1];
		//依次求出规模为i = 1...n的子问题
		for(int i=1; i<=n; i++){
			int q = -1;
			for(int j=1;j<=i;j++){
				q = Math.max(q, p[j]+res[i-j]);
			}
			res[i] = q;
		}
		
		return res[n];
		
	}
	
	public static void extendedBottomUpCutRod(int[] p, int n){
		int[] res = new int[n+1];
		//用来保存最优解的切割的钢条的长度
		int[] solve = new int[n+1];
		
		res[0] = 0;
		for (int i = 1; i <= n; i++) {
			int q = -1;
			for(int j = 1; j<=i;j++){
				if(q<p[j]+res[i-j]){
					q = p[j]+res[i-j];
					solve[i] = j;
				}
			}
			res[i] = q;
		}
		
		print(res[n], solve, n);
	}
	
	public static void print(int maxValue, int[] solve, int n) {
		System.out.println(maxValue);
		while(n>0){
			System.out.print(solve[n]+", ");
			n = n - solve[n];
		}
	}

	public static void main(String[] args) {
		int[] p = {0,1,5,8,9,10,17,17,20,24,30};
		int n = 9;
		int result = memorizedCutRod(p, n);
		System.out.println(result);
		int result2 = bottomUpCutRod(p, n);
		System.out.println(result);
		
		extendedBottomUpCutRod(p, n);
	}
}

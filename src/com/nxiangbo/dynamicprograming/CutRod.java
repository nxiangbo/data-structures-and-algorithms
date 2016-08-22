package com.nxiangbo.dynamicprograming;
/**
 * �����и�����
 * @author nxiangbo
 *
 */
public class CutRod {
	public static int memorizedCutRod(int[] p, int n){
		int result = 0;
		//�����Ѽ������������Ľ������
		int res[] = new int[n+1];
		for (int i = 0; i < res.length; i++) {
			res[i] = -1;
		}
		result = memorizedCutRodAux(p, n, res);
		return result;
	}
	
	public static int memorizedCutRodAux(int[] p, int n, int[] r){
		//����Ѿ��������������Ľ⣬ֱ�ӷ���
		if(r[n]>=0){
			return r[n];
		}
		
		int q = -1;
		if(n==0){
			 q = 0;
		} else{
			//r(n)=max(p[i]+r(n-i))
			//p[i]��ʾ�и�ɳ���Ϊi�ĸ���������
			//r(n-i)ʣ��������������ֵ
			 for(int i = 1;i<=n;i++){
				 q = Math.max(q, p[i]+memorizedCutRodAux(p, n-i, r));
			 }
		}
		r[n] = q;
		return q;
	}
	
	public static int bottomUpCutRod(int[] p, int n){
		//����������Ľ����res[n]����������������Ž�
		int[] res = new int[n+1];
		//���������ģΪi = 1...n��������
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
		//�����������Ž���и�ĸ����ĳ���
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

package com.nxiangbo.search;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		LinearProbingHashST<String, Integer> st =  new LinearProbingHashST();
		System.setIn(new FileInputStream("tale_demo"));
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String key = in.next();
			if(!st.contains(key)){
				st.put(key, 1);
			} else{
				st.put(key, st.get(key)+1);
			}
		}
		System.out.println(st.toString());
//		System.out.println(Math.abs(Integer.MAX_VALUE+1));
	}
}

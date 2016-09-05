package com.nxiangbo.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortTest {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("word"));
		Scanner in = new Scanner(System.in);
		String[] strs = new String[35];
		while(in.hasNext()){
			for(int i=0;i<strs.length;i++){
				strs[i] = in.next();
			}
			InsertionSort iSort = new InsertionSort();
			iSort.sort(strs);
			iSort.print(strs);
			
			BubbleSort bSort = new BubbleSort();
			bSort.sort(strs);
			bSort.print(strs);
			
			QuickSort qSort = new QuickSort();
			qSort.sort(strs);
			qSort.print(strs);
		}
	}
}

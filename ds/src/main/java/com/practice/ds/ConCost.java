package com.practice.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ConCost {
	private static ArrayList<HashSet<Integer>> arrayList = null;
	private static HashSet<Integer> output =null;
	private static ArrayList<Integer> finalArray =null;
	private static int amt;

	
	public static void findConCost(int index, int parentSum) {
		int size=arrayList.size();
		HashSet<Integer> set = arrayList.get(index);
		for (Integer price : set) {
			int childSum=0;
			
			if (size-1 == index) {
				childSum=parentSum+price;
				if (childSum<=amt) {
//					System.out.println("sum: "+newsum);
					output.add(childSum);
				}
				
			} else {
				if (size>index+1) {
					childSum=parentSum+price;
					
					if (childSum< amt) {
						findConCost(index+1, childSum);
					}
				}
			}
			
		}
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int testcase=Integer.parseInt(br.readLine());
//		if (testcase < 1 || testcase > 50) {
//			throw new Exception("testcase should be between 1 and 50");
//		}
		finalArray = new ArrayList<Integer>(testcase);
		StringTokenizer st = null;
		int items;
		for (int i = 1; i <= testcase ; i++) {
			
			st = new StringTokenizer(br.readLine());
			items=Integer.parseInt(st.nextToken());
						 			
//			 if (items < 1 || items > 100) {
//					throw new Exception("Number of items should be between 1 and 100");
//				}
			 amt=Integer.parseInt(st.nextToken());
			 
//			 if (amt < 1 || amt > 1000) {
//					throw new Exception("Amount should be between 1 and 1000");
//				}
			arrayList = new ArrayList<HashSet<Integer>>(items);
			output =  new HashSet<>();
			HashSet<Integer> set = null;
			for (int j = 1; j <= items; j++) {
				st=new StringTokenizer(br.readLine());
								
//				if (Integer.parseInt(strArray[0]) < 0 || Integer.parseInt(strArray[0]) > 100) {
//					throw new Exception("Manufacturer should be between 1 and 100");
//				}
				
				if (Integer.parseInt(st.nextToken()) != 0) {
					set=new HashSet<Integer>();
					while(st.hasMoreTokens())
						set.add(Integer.parseInt(st.nextToken()));
					arrayList.add(set);
				}
			}
			
			//method call
			findConCost(0, 0);
			finalArray.add(output.size());
		}
		br.close();
		
		PrintStream psConsole = new PrintStream(System.out);
		for (Integer i : finalArray) {
			if (i==0) {
				psConsole.write("NO".getBytes());
			}else{
			psConsole.write(("YES "+i).getBytes());
			}
			psConsole.println();
		}
		psConsole.flush();
		psConsole.close();
		
	}

}

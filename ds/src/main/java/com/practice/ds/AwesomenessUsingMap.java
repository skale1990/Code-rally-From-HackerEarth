package com.practice.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * Hello world!
 *
 */
public class AwesomenessUsingMap 
{

	private static int[] testcases = null;
	private static int[] []inputs = null;
	private static StringTokenizer tokenizer = null;
	
	private static void findAwesomenessofArrangement() throws IOException {
		PrintStream psConsole = new PrintStream(System.out);
		double sum ,awesomeness;
		
		for (int i = 0; i < inputs.length; i++) {
			sum =0; awesomeness=0;
			for (int j = 0; j < inputs[i].length; j++) {
				if (inputs[i][j] !=0) {
					sum = sum
							+ inputs[i].length
									* ((inputs[i][j]  + (inputs[i][j] * inputs[i].length)) / 2d);
				}
			}
			awesomeness=sum/inputs[i].length;
			psConsole.write(BigDecimal.valueOf(awesomeness).setScale(6).toString().getBytes());
			psConsole.println();
		}
		psConsole.flush();
		psConsole.close();

		

	}

	public static void main(String[] args) throws Exception {
//		Pattern pattern = Pattern.compile("\\s+");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
//		Matcher matcher = pattern.matcher(line);
//		if (matcher.find()) {
//			throw new Exception("testcase should not contain space");
//		}
//		int testcase=Integer.parseInt(line);
//		if (testcase < 1 || testcase > 10) {
//			throw new Exception("testcase should be between 1 and 10");
//		}
		
		testcases = new int[Integer.parseInt(line)];
		
		
		
		inputs = new int[testcases.length][];
		for (int i = 0; i < inputs.length ; i++) {
			line=br.readLine().trim();
//			matcher = pattern.matcher(line);
//			if (matcher.find()) {
//				throw new Exception("Number of elements should not contain space");
//			}
//			NorOfElements = Integer.parseInt(line);
//			if (NorOfElements < 1 || NorOfElements > 100000) {
//				throw new Exception(
//						"Number of elements should be between 1 and 100000");
//			}
			inputs[i] = new int[Integer.parseInt(line)];
			tokenizer = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < inputs[i].length ; j++) {
					inputs[i][j]=Integer.parseInt(tokenizer.nextToken());
				}
			
			}
		br.close();
		findAwesomenessofArrangement();
			
	}

}

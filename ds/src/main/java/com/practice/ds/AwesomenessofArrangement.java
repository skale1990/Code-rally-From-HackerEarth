package com.practice.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * Little Dipu is a small kid and like all kids he likes to play, but he plays with numbers (He is extraordinary you know). Today his father gave him N numbers A1, A2, A3 . . . AN to play. First of all, Dipu calculated the number of different arrangements he can make. Two arrangements A1, A2, A3 . . . AN and B1, B2, B3 . . . BN are different if Ai ≠ Bi for any i (1 ≤ i ≤ N) . 
 Now Dipu wants to arrange his numbers in each of these different arrangements and wants to calculate expected awesomeness of the arrangements. 

 Awesomeness of an arrangement A1, A2, A3 . . . AN is defined as 1*A1 + 2*A2 + 3*A3 . . . N*AN 

 Now Since Dipu is a small kid, he cannot do these calculations by himself. It is now your job to find the expected awesomeness of arrangements for Dipu. 

 Input

 First line of input contains the number of test cases T. First line of each test case contains the count of numbers N. Next line contains N space separated numbers A1, A2, A3 . . . AN, the numbers that Dipu has. 
 Output

 For each test case, output a single value, the expected awesomeness of all distinct arrangements of given numbers. Answer should be exactly rounded to 6 digits after decimal. 
 Constraints

 1 ≤ T ≤ 10 
 1 ≤ N ≤ 105
 0 ≤ Ai ≤ 105 
 Sample Input(Plaintext Link)
 2
 3
 1 2 2
 4
 4 1 3 1
 Sample Output(Plaintext Link)
 10.000000
 22.500000
 Explanation
 In 1st test case, there are 3 distinct possible arrangements - 1 2 2 - awesomeness = 11 2 1 2 - awesomeness = 10 2 2 1 - awesomeness = 9 so, expected awesomeness = (11+10+9)/3 = 10.000000

 In 2nd test case, there are 12 distinct possible arrangements - 1 1 3 4 - awesomeness = 28 1 1 4 3 - awesomeness = 27 1 3 1 4 - awesomeness = 26 1 3 4 1 - awesomeness = 23 1 4 1 3 - awesomeness = 24 1 4 3 1 - awesomeness = 22 3 1 1 4 - awesomeness = 24 3 1 4 1 - awesomeness = 21 3 4 1 1 - awesomeness = 18 4 1 1 3 - awesomeness = 21 4 1 3 1 - awesomeness = 19 4 3 1 1 - awesomeness = 17 so, expected awesomeness = (28+27+26+23+24+22+24+21+18+21+19+17)/12 = 22.500000
 */
public class AwesomenessofArrangement {

	private static void findAwesomenessofArrangement(ArrayList<Integer> numbers) {

		BigDecimal awesomeness = BigDecimal.ZERO;

		Double sum = new Double(0);
		int NorElements = numbers.size();
		for (int i = 0; i < NorElements; i++) {
			int number = numbers.get(i);
			sum = sum
					+ Double.valueOf(NorElements
							* (((number * 1) + (number * NorElements)) / 2d));
		}
		awesomeness = awesomeness.add(new BigDecimal(sum));
		System.out.println(awesomeness.divide(new BigDecimal(NorElements))
				.setScale(6));

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		if (Integer.parseInt(line) < 1 || Integer.parseInt(line) > 10) {
			throw new Exception("testcase should be between 1 and 10");
		}
		ArrayList<ArrayList<Integer>> testCases = new ArrayList<>(
				Integer.parseInt(line));
		Integer NorOfElements = null;
		ArrayList<Integer> inputs = null;
		StringTokenizer tokenizer = null;

		for (int i = 1; i <= Integer.valueOf(line); i++) {
			NorOfElements = Integer.valueOf(br.readLine());
			if (NorOfElements < 1 || NorOfElements > 100000) {
				throw new Exception(
						"Number of elements should be between 1 and 100000");
			}
			inputs = new ArrayList<Integer>(NorOfElements);
			tokenizer = new StringTokenizer(br.readLine());
			if (tokenizer.countTokens() == NorOfElements) {
				for (int j = 0; j < NorOfElements; j++) {
					inputs.add(Integer.valueOf(tokenizer.nextToken()));
				}
			} else {
				throw new Exception(
						"Number of elments not specified as mentioned");
			}

			testCases.add(inputs);
		}

		// ArrayList<BigDecimal> outputs = new ArrayList<BigDecimal>();
		for (ArrayList<Integer> input : testCases) {
			// outputs.add(findAwesomenessofArrangement(input));
			findAwesomenessofArrangement(input);
		}

	}

}

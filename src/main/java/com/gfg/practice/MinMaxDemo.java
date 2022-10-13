package com.gfg.practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class MinMaxDemo {

	public static void main(String[] args) {

		String path = "C://Users//omnie//Documents//fileInput.txt";
		String outputPath = "C://Users//omnie//Documents//fileOutput.txt";
		try {

			System.setOut(new PrintStream(outputPath));
			System.out.println("Hello Outpur ???");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (BufferedReader stream = new BufferedReader(new InputStreamReader(new FileInputStream(path)));) {



			int A[] = Arrays.stream(stream.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int s = 252576;
			System.out.println(">>>> " + A[12432] + " Is Equal : " + (s == A[12432]));
			System.out.println("Sum of Min and Max is : " + subarraySum(A, A.length, s));

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

		ArrayList<Integer> index = new ArrayList<>();

		int pivot = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == s) {
				index.add(pivot + 1);
				index.add(i + 1);
				break;
			} else if ((i + 1 == n) || (sum > s && pivot < n)) {
				System.out.println("Index : " + i + " , Sum : " + sum + " , Pivot : " + pivot);
				i = pivot;
				pivot++;
				sum = 0;
				if (pivot >= n) {
					index.add(-1);
					System.out.println(">>>>>>>>> Pivot Finished <<<<<<<<<<<<");
					break;
				}

			}
		}
		return index;

	}
}

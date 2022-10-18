package com.gfg.practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class FindLeastGreater {

	public static void main(String[] args) {

		String path = "C://Users//omnie//Documents//fileInput.txt";
		String outputPath = "C://Users//omnie//Documents//fileOutput.txt";
		try {

			System.setOut(new PrintStream(outputPath));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (BufferedReader stream = new BufferedReader(new InputStreamReader(new FileInputStream(path)));) {

			int A[] = Arrays.stream(stream.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			System.out.println("Output : " + findLeastGreater1(A.length, A));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Integer> findLeastGreater1(int n, int[] arr) {
		ArrayList<Integer> result = new ArrayList<>();
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = n - 1; i >= 0; i--) {
			set.add(arr[i]);
			if (set.higher(arr[i]) == null)
				result.add(-1);
			else
				result.add(set.higher(arr[i]));

		}
		Collections.reverse(result);
		return result;
	}

	public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
		ArrayList<Integer> result = new ArrayList<>();
//		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < n; i++) {
			int currentValue = arr[i];
			int index = 0;
			int leastGreater = arr[i];
			for (int j = i + 1; j < n; j++) {
				if (currentValue < arr[j]) {
					if (leastGreater > arr[j]) {
						index = j;
						leastGreater = arr[j];
					} else if (leastGreater == currentValue) {
						leastGreater = arr[j];
						index = j;
					}
				}
			}

			if (index != 0) {
				arr[i] = arr[index];
			} else {
				arr[i] = -1;
			}

//			System.out.println("Iteration No : " + (i + 1));
//			System.out.println(Arrays.toString(arr));
			result.add(arr[i]);
		}
		return result;
	}
}

package com.gfg.practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaximizeTheSumOfSelectedNumberInArray {

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

			System.out.println("Maximize Sum is : " + maximizeSum1(A, A.length));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int maximizeSum(int arr[], int n) {
		int sum = 0;

		Arrays.sort(arr);
		System.out.println(">>>>>>>> Array To be processed : " + (Arrays.toString(arr)));
		System.out.println("\n\n");

		for (int i = n - 1; i >= 0; i--) {

			System.out.println("SUM previous value : " + sum + "  ,  " + "SUM New value : " + (sum + arr[i])
					+ "  , current index : " + i + "  , Current Value ARR : " + arr[i] + " , Next Value ARR : "
					+ (i - 1 >= 0 ? arr[i - 1] : "N/A"));

			if (arr[i] == Integer.MIN_VALUE)
				continue;

			sum += arr[i];
			int k = i;
			while (k - 1 >= 0 && i >= 0) {
				k--;
				if (arr[k] != Integer.MIN_VALUE) {
					if (arr[i] - 1 == arr[k]) {
						arr[k] = Integer.MIN_VALUE;
					} else if (arr[i] == arr[k])
						continue;
					break;
				}

			}

			arr[i] = Integer.MIN_VALUE;
			System.out.println(">>>>>>>> Array : " + (Arrays.toString(arr)));
			System.out.println("\n\n");
		}

		return sum;
	}

	public static int maximizeSum1(int arr[], int n) {
		Integer sum = Integer.valueOf(0);
		Map<String, Integer> result = new HashMap<>();
		result.put("sum", sum);

		Comparator<Integer> comparator = (a, b) -> {
			return a > b ? -1 : a < b ? 1 : 0;
		};

		System.out.println(">>>>>>>> Array To be processed : " + (Arrays.toString(arr)));
		Map<Integer, Integer> map = new HashMap<>();
		Arrays.stream(arr).forEach(value -> {
			if (map.containsKey(value)) {
				map.put(value, map.get(value) + 1);
			} else
				map.put(value, 1);
		});

		System.out.println(map);

		Arrays.stream(arr).boxed().sorted(comparator).forEach(value -> {
			System.out.println("current Value : " + value);
			System.out.println(map);
			System.out.println(result);
			if (map.containsKey(value)) {
				if (map.get(value) < 1)
					map.remove(value);
				else {
					result.put("sum", result.get("sum") + value);
					map.put(value, map.get(value) - 1);
					if (map.containsKey(value - 1)) {
						map.put(value - 1, map.get(value - 1) - 1);
					}
				}
			}
		});
		sum = result.get("sum");
		return sum;
	}
}

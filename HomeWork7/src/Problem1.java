import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem1 {
	private Map<String, Integer> dictionary;

	/**
	 * 
	 * @param inputFile
	 *            - input file
	 * @return List with single word in to line
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static List<String> readLineFromFile(File inputFile)
			throws FileNotFoundException, IOException {
		List<String> everyWord = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line = br.readLine();
			while (line != null) {
				String[] words = line.split(" ");
				for (String word : words) {
					everyWord.add(word.trim());
				}
				line = br.readLine();
			}
		}
		return everyWord;
	}

	public void FindWordInFile(String fileName) throws FileNotFoundException,
			IOException {
		long startTime = System.nanoTime();
		List<String> text = readLineFromFile(new File(fileName));
		long endTime = System.nanoTime();
		System.out.println("Total Time to read file: "
				+ (endTime - startTime) * (Math.pow(10, -9)));
		Map<String, Integer> dictionary = new HashMap();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of word");
		int numberWord = sc.nextInt();
		System.out.println("Enter " + numberWord + " words:");
		for (int i = 0; i < numberWord; i++) {
			String word = sc.next();
			dictionary.put(word, 0);
		}
		int currentCount = -1;
		for (String word : text) {
			if (dictionary.containsKey(word)) {
				currentCount = dictionary.get(word);
				dictionary.put(word, currentCount + 1);
			}
		}
		for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

}

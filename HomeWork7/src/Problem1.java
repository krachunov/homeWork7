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
	// private Map<String, Integer> dictionary;

	/**
	 * 
	 * @param inputFile
	 *            - input file
	 * @return List with single word in to line
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static Map<String, Integer> readLineFromFile(File inputFile)
			throws FileNotFoundException, IOException {
		Map<String, Integer> everyWord = new HashMap();

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line = br.readLine();
			int currentCount = -1;
			while (line != null) {
				String[] words = line.split(" ");
				for (String word : words) {
					if (!everyWord.containsKey(word)) {
						everyWord.put(word, 1);
					} else {
						currentCount = everyWord.get(word);
						everyWord.put(word, currentCount + 1);
					}
				}
				line = br.readLine();
			}
		}
		return everyWord;
	}

	public void FindWordInFile(String fileName) throws FileNotFoundException,
			IOException {
		long startTime = System.nanoTime();
		Map<String, Integer> text = readLineFromFile(new File(fileName));
		long endTime = System.nanoTime();
		System.out.println("Total Time to read file: " + (endTime - startTime)
				* (Math.pow(10, -9)));
		List<String> searchingWord = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of word");
		int numberWord = sc.nextInt();
		System.out.println("Enter " + numberWord + " words:");
		for (int i = 0; i < numberWord; i++) {
			String word = sc.next();
			searchingWord.add(word.trim());
		}
		int currentCount = -1;
		for (String word : searchingWord) {
			if (text.containsKey(word)) {
				System.out.println(word + " -> " + text.get(word));
			}
		}
	}

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Problem1 {

	public static List<String> readFile(File inputFile) throws FileNotFoundException,
			IOException {
		List<String> everyLine = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line = br.readLine();
			while (line != null) {
				everyLine.add(line);
				line = br.readLine();
			}
		}
		return everyLine;

	}
}

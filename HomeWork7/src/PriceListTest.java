import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

public class PriceListTest {

	public static void main(String[] args) {
		PriceList priceList = new PriceList();

		long startTime = System.nanoTime();

		for (int i = 0; i < 500000; i++) {
			Random random = new Random();
			int randomPrice = random.nextInt(10000);
			priceList.add("product" + i, randomPrice);
		}

		long endTime = System.nanoTime();
		System.out.println("Total Time to add 500 000 elements: "
				+ (endTime - startTime) * (Math.pow(10, -9)));

		long startTime2 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			Random random = new Random();
			int randomStartPrice = random.nextInt(1000);
			int randomEndPrice = random.nextInt(1000);

			while (randomStartPrice > randomEndPrice) {
				randomStartPrice = random.nextInt(1000);
				randomEndPrice = random.nextInt(1000);
			}
			Object[] arrayProduc = priceList.findPriceRange(randomStartPrice,
					randomEndPrice);
		}
		long endTime2 = System.nanoTime();
		System.out.println("Time to finde element: " + (endTime2 - startTime2)
				* (Math.pow(10, -9)));

		System.out.println("");
	}
}

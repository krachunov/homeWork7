import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

public class PriceListTest {

	public static void main(String[] args) {
		PriceList priceList = new PriceList();
		final int PRICE_LIMIT = 100; // Set price range between 0 and value
										// PRICE_LIMIT;

		long startTime = System.nanoTime();

		for (int i = 0; i < 500000; i++) {
			Random random = new Random();
			int randomPrice = random.nextInt(PRICE_LIMIT);
			priceList.add("product" + i, randomPrice);
		}

		long endTime = System.nanoTime();
		System.out.println("Total Time to add 500 000 elements: "
				+ (endTime - startTime) * (Math.pow(10, -9)));

		long startTime2 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			Random random = new Random();
			int randomStartPrice = random.nextInt(PRICE_LIMIT);
			int randomEndPrice = random.nextInt(PRICE_LIMIT);

			while (randomStartPrice > randomEndPrice) {
				randomStartPrice = random.nextInt(PRICE_LIMIT);
				randomEndPrice = random.nextInt(PRICE_LIMIT);
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

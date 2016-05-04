import java.util.Random;

import by.epamlab.Artist;
import by.epamlab.Canvas;

public class Runner {

	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		
		Artist artist = new Artist(canvas);
		Thread artistThread = new Thread(artist);
		artistThread.start();
		
		Random random = new Random();
		int someTime = random.nextInt(1000);
		try {
			Thread.sleep(someTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		artist.setInterrupt();
		
		System.out.println("The application is completed.");
	}

}

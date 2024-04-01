package exercise.ex111.com.example;

import exercise.ex111.com.example.model.Singer;
import exercise.ex111.com.example.model.Song;

public class BestAlbum {

	public static void main(String[] args) {
		
		Singer takuro = new Singer("吉田拓郎", 19460405);
		Singer kuwata = new Singer("桑田佳祐", 19560226);
		
		Song[] songs = {
				new Song("今日までそして明日から", 181, 19710721, takuro),
				new Song("MERRY X'MAS IN SUMMER", 302, 19860705, kuwata),
				new Song("今はまだ人生を語らず", 273, 19741210, takuro)
				
		};
		
		int no = 1;
		for (Song song : songs) {
			System.out.println(no++ + "." + song);
		}
		
	}

}

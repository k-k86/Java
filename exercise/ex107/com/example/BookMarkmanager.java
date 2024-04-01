package exercise.ex107.com.example;

public class BookMarkmanager {

	public static void main(String[] args) {
		
		BookMark[] array = new BookMark[3];
		
		array[0] = new BookMark("http://www.example.com/");
		array[1] = new BookMark("http://www.example.org/");
		array[2] = new BookMark("http://www.example.co.jp/");
		
		for(BookMark bookmark : array) {
			
			bookmark.printUrl();
		}
	}

}

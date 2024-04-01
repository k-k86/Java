package exercise.ex111.com.example.model;

public class Song {
	
	private String title;
	private int time;
	private int date;
	private Singer singer;
	
	public Song(String title, int time, int date, Singer singer) {
		this.title = title;
		this.time = time;
		this.date = date;
		this.singer = singer;
	}
	
	public String toString() {
		return title + ", " + (time / 60) + ":" + (time % 60) +", " + date + "発売, " + singer.getName() + "(当時" + singer.getAge(date) + "歳)";
	}
}

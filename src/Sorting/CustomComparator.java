package Sorting;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Sort based on released year (descending), if released year is same then sort based on song name.
 *  
 * if x > y return positive value
 * if x < y return negative value
 * if x==y return 0
 */
public class CustomComparator implements Comparator<Song> {

	public static void main(String[] args) {
		Song s1 = new Song();
		s1.setReleasedYear(2014);
		s1.setMovie("Ma Annayaa");
		Song s2 = new Song();
		s2.setReleasedYear(2014);
		s2.setMovie("Hello Brother");
		Song s3 = new Song();
		s3.setReleasedYear(2016);
		s3.setMovie("I");
		Song s4 = new Song();
		s4.setReleasedYear(2016);
		s4.setMovie("Dil Mushil Hei");
		Song s5 = new Song();
		s5.setReleasedYear(2015);
		s5.setMovie("YMC");
		Song s6 = new Song();
		s6.setReleasedYear(2015);
		s6.setMovie("Aashique");
		Song s7 = new Song();
		s7.setReleasedYear(2014);
		s7.setMovie("Croods");
		Song s8 = new Song();
		s8.setReleasedYear(2016);
		s8.setMovie("Zootopia");
		Song s9 = new Song();
		s9.setReleasedYear(2016);
		s9.setMovie("Angry Birds");
		Song s10 = new Song();
		s10.setReleasedYear(2016);
		s10.setMovie("Finding Dory");
		Song[] songs={s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};
		for(int i=0; i<songs.length; i++)System.out.println(songs[i].getReleasedYear()+" "+songs[i].getMovie());
		System.out.println();
		Arrays.sort(songs,new CustomComparator());
		for(int i=0; i<songs.length; i++)System.out.println(songs[i].getReleasedYear()+" "+songs[i].getMovie());

	}

	@Override
	public int compare(Song s1, Song s2) {
		if (s1.getReleasedYear() == s2.getReleasedYear()) {
			return s1.getMovie().compareTo(s2.getMovie());
		}
		return s2.getReleasedYear() - s1.getReleasedYear();
		// if s1 released year > s2 released year result will be positive value
		// if s1 released year < s2 released year result will be negative value
	}

}

class Song {
	private String name;
	private String movie;
	private int releasedYear;
	private String artist;

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedYear(int releasedYear) {
		this.releasedYear = releasedYear;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}

package com.kh.chapter1.list.vo;

public class Music implements Comparable<Music> {
	private String title;
	
	private String artist;
	
	private int ranking;
	
	public Music() {
	}

	public Music(String title, String artist, int ranking) {
		this.title = title;
		this.artist = artist;
		this.ranking = ranking;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "Music [title=" + title + ", artist=" + artist + ", ranking=" + ranking + "]";
	}
	
	/*
	 * compareTo() 메소드에서 반환되는 값을 가지고 정렬 기준을 잡는다.
	 *   - 자신과 매개값으로 전달된 인스턴스가 같은 인스턴스인지 비교한다. 
	 *   - 자신과 비교해서 같으면 0을 반환하고, 자신이 크다면 양의 정수를 반환, 자신이 작다면 음의 정수를 반환한다.
	 */
	@Override
	public int compareTo(Music music) {
		
		// 랭킹 순서대로 정렬하는 코드
		return (this.ranking > music.ranking) ? 1 : (this.ranking == music.ranking) ? 0 : -1; // 오름차순
//		return (this.ranking > music.ranking) ? -1 : (this.ranking == music.ranking) ? 0 : 1; // 내림차순
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

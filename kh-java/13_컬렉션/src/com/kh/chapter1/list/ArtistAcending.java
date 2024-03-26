package com.kh.chapter1.list;

import java.util.Comparator;

import com.kh.chapter1.list.vo.Music;

public class ArtistAcending implements Comparator<Music>{

	/*
	 * 반환되는 정수값을 가지고 정렬의 기준을 잡는다.
	 *   - 두 개의 매개값으로 전달된 인스턴스를 비교한다.
	 *   - 비교해서 같으면 0을 반환하고, 첫 번째 인스턴스가 크면 양의 정수를 반환하고, 
	 *     두 번째 인스턴스가 크면 음의 정수를 반환한다.
	 */
	@Override
	public int compare(Music music1, Music music2) {
		int result = music1.getArtist().compareTo(music2.getArtist());
		
		if(result == 0) {
			result = (music1.getRanking() > music2.getRanking()) ? 1 : (music1.getRanking() == music2.getRanking()) ? 0 : -1;
		}
		
		return result;
	}

}

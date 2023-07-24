package com.kh.chapter2.set;

import java.util.Set;
import java.util.TreeSet;

import com.kh.chapter2.set.vo.Music;

public class B_TreeSet {
	public void method1() {
		TreeSet<String> ts = new TreeSet<>();
		
		// 중복제거, 인스턴스를 오름차순으로 정렬, null 저장 안됨
		ts.add("하하하");
//		ts.add(null);
		ts.add("나나나");
		ts.add("가가가");
//		ts.add(null);
		ts.add("다다다");
		ts.add("다다다");
		ts.add("하하하");
		
		System.out.println(ts);
		System.out.println(ts.first());
		System.out.println(ts.last());
	}
	
	public void method2() {
//		Set<Music> set = new TreeSet<>();
//		Set<Music> set = new TreeSet<>(new Comparator<Music>() {
//			@Override
//			public int compare(Music o1, Music o2) {
//				
//				return o1.getTitle().compareTo(o2.getTitle());
//			}
//		});
		Set<Music> set = new TreeSet<>((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
		
		set.add(new Music("TOMBOY", "(G)I-DLE", 6));
		set.add(new Music("TOMBOY", "(G)I-DLE", 6));
		set.add(new Music("Nxde", "(G)I-DLE", 2));
		set.add(new Music("사건의 지평선", "윤하", 1));
		set.add(new Music("바라보기", "MC THE MAX", 1));
		set.add(new Music("Cookie", "NewJeans", 4));
		set.add(new Music("Cookie", "NewJeans", 4));
		
		for (Music music : set) {
			System.out.println(music);
		}
		
		
	}

}

package com.kh.chapter2.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.kh.chapter2.set.vo.Music;

public class A_HashSet {
	// HashSet을 생성하고 저장, 출력 테스트
	public void method1() {
		Set<String> set = new HashSet<>();
		
		set.add(null);
		set.add("반갑습니다.");
		set.add(new String("반갑습니다."));
		set.add("여러분");
		set.add("반갑습니다.");
		set.add("여러분");
		set.add(null);
		
		/*
		 * 저장 순서가 유지되지 않고 중복된 데이터는 제거된다.
		 *   - String 클래스에는 hashCode(), equals() 메소드가 오버라이딩 되어있다.
		 *   - 실제 데이터가 동일한 경우에 동일 인스턴스로 인식되어서 저장되지 않는다.
		 */
		System.out.println(set);
		System.out.println();
		
		// Set에 저장된 인스턴스에 접근하는 방법
		// 1. 향상된 for 문을 사용하는 방법
		for (String str : set) {
			System.out.println(str);
		}
		
		System.out.println();
		
		// 2. HashSet에 저장된 인스턴스들을 ArrayList에 담아서 사용하는 방법
		List<String> list = new ArrayList<>(set);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		
		// 3. Iterator 반복자를 사용하는 방법
		//   - 가져올 인스턴스가 있는지 확인할 때는 hasNext() 메소드를 사용한다.
		//   - 하나의 인스턴스를 가져올 때는 next() 메소드를 사용한다.
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	// HashSet에 Music 인스턴스를 저장, 출력 테스트
	public void method2() {
		Set<Music> set = new HashSet<>();
		
		set.add(new Music("TOMBOY", "(G)I-DLE", 6));
		set.add(new Music("TOMBOY", "(G)I-DLE", 6));
		set.add(new Music("Nxde", "(G)I-DLE", 2));
		set.add(new Music("사건의 지평선", "윤하", 1));
		set.add(new Music("Cookie", "NewJeans", 4));
		set.add(new Music("Cookie", "NewJeans", 4));
		
		for (Music music : set) {
			System.out.println(music);
		}
	}
}

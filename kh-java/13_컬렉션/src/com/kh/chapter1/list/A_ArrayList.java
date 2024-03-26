package com.kh.chapter1.list;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.chapter1.list.vo.Music;

public class A_ArrayList {
	// ArrayList를 생성하고 저장, 출력 테스트
	public void method1() {
		List list = new ArrayList();
		
		// 인스턴스를 저장할 때는 add() 메소드를 사용한다.
		list.add("안녕하세요.");
		list.add(LocalDateTime.now());
		list.add(3.14); // 오토 박싱이 적용된다.
		list.add(false);
		list.add('a');
		list.add(1);
		
		System.out.println(list);
		System.out.println("size : " + list.size());
		System.out.println();
		
		// 인덱스에 해당하는 인스턴스를 가져올 때는 get() 메소드를 사용한다.
		String str = (String) list.get(0);
		LocalDateTime now = (LocalDateTime) list.get(1);
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		for (Object object : list) {
			System.out.println(object);
		}
		
		System.out.println();
		
		// 인스턴스의 중복 저장을 허용한다.
		list.add("안녕하세요.");
		
		// null 저장을 허용한다.
		list.add(null);
		list.add(null);
		
		// 원하는 인덱스 위치에 인스턴스를 추가할 수 있다.
		list.add(2, 125000);
		
		System.out.println(list);
		System.out.println();
		
		// 원하는 인덱스 위치에 인스턴스를 변경할 수 있다.
		list.set(2, false);
		
		System.out.println(list);
		System.out.println();
		
		// 저장된 인스턴스를 삭제할 때 remove() 메소드를 사용한다.
		list.remove(2);
		list.remove("안녕하세요.");
//		list.remove(3.14);
		list.remove(new Double(3.14));
		list.remove(Integer.valueOf("1"));
		boolean result1 = list.remove("안녕하세요.");
		boolean result2 = list.remove("안녕하세요.");
		
		System.out.println(list);
		System.out.println(list.isEmpty());
		System.out.println(result1);
		System.out.println(result2);
		System.out.println();
		
		// 저장된 인스턴스를 모두 삭제할 때는  clear() 메소드를 사용한다.
		list.clear();
		System.out.println(list);
		System.out.println(list.isEmpty());
	}

	// ArrayList에 문자열, 정수를 저장, 정렬 테스트
	public void method2() {
		/*
		 * 컬렉션에서 제네릭스(<>)을 사용하는 이유
		 *   - 명시된 타입의 인스턴스만 저장하도록 제한을 두기 위해서 사용한다.
		 *   - 컬렉션에 저장된 인스턴스를 꺼내서 사용할 때 매번 형 변환을 하지 않아도 된다.
		 * 
		 * 리스트의 정렬
		 *   - String, Wrapper 인스턴스들의 경우엔 Comparable 인터페이스가 내부적으로 구현되어 있어서 
		 *     Collections.sort() 메소드를 통해서 정렬이 가능하다.
		 *   - 개발자가 작성하는 클래스의 인스턴스도  Collections.sort() 메소드를 통해서 정렬이 가능하게 하고 싶다면
		 *     Comparable 인터페이스를 구현하면 된다.
		 * 
		 */
		ArrayList<String> list = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		list.add("banana");
		list.add("apple");
		list.add("orange");
		list.add("mango");
		list.add("grape");
		
//		String banana = list.get(0);
//		String apple = list.get(1);
		
		list2.add(7);
		list2.add(1);
		list2.add(8);
		list2.add(10);
		list2.add(3);
		list2.add(2);
		
		System.out.println(list);
		System.out.println(list2);
		System.out.println();
		
		// 오름차순으로 리스트 정렬
		// Comparable 인터페이스를 구현하고 있는 인스턴스를 가지고 있는 리스트를 인자로 전달한다.
		Collections.sort(list);
		Collections.sort(list2);
		
		System.out.println(list);
		System.out.println(list2);
		System.out.println();
		
		// 내림차순으로 리스트 정렬
		// Collections.sort() 메소드를 통해서 오름차순으로 정렬 후에 reverse() 메소드를 호출하여 내림차순으로 정렬한다.
		Collections.reverse(list);
		Collections.reverse(list2);
		
		System.out.println(list);
		System.out.println(list2);
		System.out.println();
	}

	// ArrayList에 Music 인스턴스를 저장, 정렬 테스트
	public void method3() {
		List<Music> list = new ArrayList<>();
				
		list.add(new Music("TOMBOY", "(G)I-DLE", 6));
		list.add(new Music("Nxde", "(G)I-DLE", 2));
		list.add(new Music("사건의 지평선", "윤하", 1));
		list.add(new Music("Cookie", "NewJeans", 4));
		list.add(new Music("After LIKE", "아이브", 5));
		list.add(new Music("바라보기", "엠씨더맥스", 3));
		
		for (Music music : list) {
			System.out.println(music);
		}
		
		System.out.println();
		
		// 랭킹순으로 리스트를 정렬
		Collections.sort(list);
		
		for (Music music : list) {
			System.out.println(music);
		}
		
		System.out.println();
		
		// 아티스트순으로 리스트를 정렬
		Collections.sort(list, new ArtistAcending());
		
		for (Music music : list) {
			System.out.println(music);
		}
		
		System.out.println();
		
		// 익명 구현 객체를 사용하는 방법
//		Collections.sort(list, new Comparator<Music>() {
//			@Override
//			public int compare(Music o1, Music o2) {
//				
//				return o1.getTitle().compareTo(o2.getTitle());
//			}
//		});
		
		// 람다식을 사용하는 방법
		Collections.sort(list, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
		

		for (Music music : list) {
			System.out.println(music);
		}
		
		System.out.println();
	}
}

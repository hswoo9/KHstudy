package com.kh.chapter3.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chapter3.map.vo.Snack;

public class A_HashMap {
	public void method1() {
		Map<String, Snack> map = new HashMap<>();
		
		// 저장 순서 유지 x, 키값 중복 저장 x (단, 중복된 키값으로 저장하면 기존에 있던 값을 덮어쓴다.)
		map.put("다이제", new Snack("초코맛", 1105));
		map.put("칸쵸", new Snack("바나나맛", 300));
		map.put("프링글스", new Snack("어니언맛", 572));		
		map.put("프링글스", new Snack("오리지날", 500));		
		map.put("홈런볼", new Snack("초코맛", 587));
		map.put("꼬북칩", new Snack("츄러스맛", 338));
		map.put("꼬북칩", new Snack("질소맛", 8));
		
		System.out.println(map);
		System.out.println();
		
		// Map 컬렉션에서 Key에 해당하는 Value를 얻어오는 메소드
		Snack snack = map.get("다이제");
		
		System.out.println(snack);
		System.out.println();
		
		// Map 컬렉션에 담겨있는 인스턴스의 개수를 얻어오는 메소드
		System.out.println("size : " + map.size());
		System.out.println();
		
		// Map 컬렉션에서 키값에 해당하는 Entry 인스턴스를 삭제하는 메소드
		map.remove("홈런볼");
		
		System.out.println(map);
		System.out.println("size : " + map.size());
		System.out.println("isEmpty : " + map.isEmpty());
		System.out.println();
		
		// Map 컬렉션에 담겨있는 모든 Entry 인스턴스를 삭제하는 메소드
		map.clear();
		System.out.println(map);
		System.out.println("size : " + map.size());
		System.out.println("isEmpty : " + map.isEmpty());
		System.out.println();
	}

	public void method2() {
		Map<String, Snack> map = new HashMap<>();
		
		map.put("다이제", new Snack("초코맛", 1105));
		map.put("칸쵸", new Snack("바나나맛", 300));
		map.put("프링글스", new Snack("어니언맛", 572));		
		map.put("홈런볼", new Snack("초코맛", 587));
		map.put("꼬북칩", new Snack("츄러스맛", 338));
		map.put("스윙칩", new Snack("빨간맛", 352));
		
//		Map 컬렉션은 인덱스의 개념이 없어서 반복문을 사용할 수 없다.
//		for (int i = 0; i < map.size(); i++) {
//		}
		
//		Map 컬렉션은 Iterable 인터페이스를 구현하지 않아서 향상된 for 문을 사용할 수 없다.
//		for (Entry<String, Snack> entry : map) {
//		}
		
//		List랑 Map은 구조가 달라서 ArrayList에 담아서 사용할 수 없다.
//		List<Entry<String, Snack>> list = new ArrayList<>(map);
		
//		1. ketSet() 메소드를 이용하는 방법
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			
			System.out.println("key : " + key);
			System.out.println("value : " + map.get(key));
		}
		
		System.out.println();
		
//		2. entrySet() 메소드를 이용하는 방법
		Set<Entry<String, Snack>> entrySet = map.entrySet();
		
		for (Entry<String, Snack> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
}

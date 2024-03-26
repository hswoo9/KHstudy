## 컬렉션(Collection)
### 1. 컬렉션
* 자료구조는 데이터를 효율적으로 이용하는 방법으로 데이터에 편리하게 접근하고, 효율적으로 사용하기 위해서 데이터를 저장하거나 조직하는 방법을 말한다. 
* 컬렉션(컬렉션 프레임워크)은 자바에서 제공하는 자료구조를 담당하는 프레임워크이다.
* java.util 패키지에 컬렉션과 관련된 인터페이스와 클래스들이 포함되어 있다.
* 컬렉션을 사용하면 데이터의 추가, 삭제, 정렬 등의 처리가 간단하게 해결되어 자료구조적 알고리즘을 구현할 필요가 없다.
#### 1.1. 배열의 문제점
* 한 번 크기를 지정하면 변경할 수 없다.
* 배열에 기록된 데이터에 대한 중간 위치의 추가, 삭제가 불편하다.
* 한 타입의 데이터만 저장 가능하다.
#### 1.2. 컬렉션의 장점
* 저장하는 크기의 제약이 없다.
* 데이터의 추가, 삭제, 정렬 등의 기능 처리가 간단하게 해결된다.
* 여러 타입의 데이터가 저장 가능하다.
#### 1.3. 주요 인터페이스
<table>
    <tr>
        <th colspan="2">인터페이스 분류</th>
        <th>구현 클래스</th
        ><th>특징</th>
    </tr>
    <tr>
        <td rowspan="2">Collection</td>
        <td>List</td>
        <td>ArrayList, Vector, LinkedList</td>
        <td>순서가 있는 데이터의 집합으로 데이터의 중복을 허용한다.</td>
    </tr>
    <tr>
        <td>Set</td>
        <td>HashSet, LinkedHashSet, TreeSet</td>
        <td>순서를 유지하지 않는 데이터의 집합으로 데이터의 중복을 허용하지 않는다.</td>
    </tr>
    <tr>
        <td colspan="2">Map</td>
        <td>HashMap, HashTable, TreeMap, Properties</td>
        <td>키(Key), 값(Value)의 쌍으로 이루어진 데이터의 집합으로 키(Key)의 중복을 허용하지 않으나 값(Value)의 중복은 허용한다.</td>
    </tr>
</table>

### 2. List
* List는 자료들을 순차적으로 늘어놓은 구조를 가지고 있다.
* 저장되는 객체를 인덱스로 관리하기 때문에 인덱스로 객체를 검색, 삭제할 수 있는 기능을 제공한다.
<br><img src="https://user-images.githubusercontent.com/26870393/162953150-c8b27b4e-726b-4228-a722-a84acacbc0a8.png"/><br>

* 중복되는 객체를 저장 가능하고 null 값도 저장될 수 있다.
* 특정 인덱스의 객체를 제거하면 바로 뒤 인덱스부터 마지막 인덱스까지 모두 앞으로 1씩 당겨진다.
* List 인터페이스의 주요 메소드는 아래와 같다.
  |리턴 타입|메소드|설명|
  |:--:|--|--|
  |boolean|add(E e)|주어진 객체를 맨 끝에 추가한다.|
  |void|add(int index, E element)|주어진 인덱스에 객체를 추가한다.|
  |boolean|addAll(Collection<? extends E> c)|주어진 Collection 타입 객체를 리스트에 추가한다.|
  |E|set(int index, E element)|주어진 인덱스에 저장된 객체를 주어진 객체로 바꾼다.|
  |boolean|contains(Object o)|주어진 객체가 저장되어 있는지를 확인한다.|
  |E|get(int index)|주어진 인덱스에 저장된 객체를 리턴한다.|
  |Iterator\<E>|iterator()|저장된 객체를 한 번씩 가져오는 반복자 리턴한다.|
  |boolean|isEmpty()|컬렉션이 비어 있는지 조사한다.|
  |int|size()|저장되어 있는 전체 객체수를 리턴한다.|
  |void|clear()|저장된 모든 객체를 삭제한다.|
  |E|remove(int index)|주어진 인덱스에 저장된 객체를 삭제한다.|
  |boolean|remove(Object o)|주어진 객체를 삭제한다.|
#### 2.1. ArrayList
* List 인터페이스의 구현 클래스이다.
* 배열과의 차이점은 저장 용량(capacity)을 초과한 객체들이 들어오면 자동적으로 저장 용량이 늘어난다.
* 동기화(Synchronized)를 제공하지 않는다.
* 동기화란, 하나의 자원(데이터)에 대해 여러 개의 스레드가 접근하려 할 때 한 시점에서 하나의 스레드만 사용할 수 있도록 하는 것을 말한다.
#### 2.2. Vector
* List 인터페이스의 구현 클래스이다.
* ArrayList와의 차이점은 동기화(Synchronized)를 제공한다.
* 멀티 스레드 환경에서 안전하게 객체를 추가, 삭제할 수 있는 것을 스레드가 안전(Thread Safe)하다고 한다.
#### 2.3. LinkedList
* List 인터페이스의 구현 클래스이다.
* ArrayList와 사용 방법은 동일하지만 내부 구조는 완전히 다르다.
* 데이터를 담고 있는 요소들이 앞/뒤로 연결된 노드들을 링크(인접 링크)해서 관리한다.
<br><img src="https://user-images.githubusercontent.com/26870393/162957380-13703525-d956-435c-8f09-95a6ba640896.png"/><br>

#### 2.4. Comparable, Comparator 인터페이스
* List를 정렬할 때 Collections.sort() 메소드를 사용하는데 이때 정렬 기준을 지정하기 위해 구현해야 하는 인터페이스이다.
* Collections.sort()를 호출할 때 Comparable 인터페이스를 구현하고 있는 객체를 가지고 있는 리스트를 매개 값으로 전달해야 한다.
* 리스트의 객체가 Comparable 인터페이스를 구현하고 있지 않는다면 Collections.sort() 메소드의 두 번째 인자로 Comparator 인터페이스를 구현한 객체를 전달해야 한다.
  |인터페이스|리턴 타입|메소드|설명|
  |:--:|--|--|--|
  |Comparable|int|compareTo(T o)|자신과 인자로 주어진 객체를 비교하여 같으면 0, 자신이 크면 양수, 자신이 작으면 음수를 반환한다.|
  |Comparator|int|compare(T o1, T o2)|두 개의 인자를 받아서 비교하여 같으면 0, 첫 번째 인자가 크면 양수, 두 번째 인자가 크면 음수를 반환한다.|
### 3. Set
* Set은 저장 순서를 유지하지 않는 구조를 가지고 있다.
* 중복되는 객체를 저장할 수 없고 null도 중복을 허용하지 않기 때문에 1개만 저장할 수 있다.
<br><img src="https://user-images.githubusercontent.com/26870393/162959147-9e8b8304-e4f1-4630-a2ac-bd38932eee36.png"/><br>

* 인덱스로 관리하지 않기 때문에 인덱스를 매개 값으로 갖는 메소드가 없다.
* 전체 객체를 대상으로 한 번씩 반복해서 가져오는 반복자(Iterator)를 제공한다.
* Set 인터페이스의 주요 메소드는 아래와 같다.
  |리턴 타입|메소드|설명|
  |:--:|--|--|
  |boolean|add(E e)|주어진 객체를 추가한다.|
  |boolean|addAll(Collection<? extends E> c)|주어진 Collection 타입 객체를 Set에 추가한다.|
  |boolean|contains(Object o)|주어진 객체가 저장되어 있는지를 확인한다.|
  |Iterator\<E>|iterator()|저장된 객체를 한 번씩 가져오는 반복자 리턴한다.|
  |boolean|isEmpty()|컬렉션이 비어 있는지 조사한다.|
  |int|size()|저장되어 있는 전체 객체수를 리턴한다.|
  |void|clear()|저장된 모든 객체를 삭제한다.|
  |boolean|remove(Object o)|주어진 객체를 삭제한다.|
#### 3.1. HashSet
* Set 인터페이스의 구현 클래스이다.
* HashSet은 객체들을 순서 없이 저장하고 동일한 객체는 중복 저장하지 않는다. 
* 내부적으로 hashCode(), equals() 메소드를 사용해서 중복된 객체를 확인한다.
#### 3.2. LinkedHashSet
* Set 인터페이스의 구현 클래스이다.
* HashSet과 동일하지만 입력된 순서대로 데이터를 관리한다.
* iteration 작업을 할 경우, Set에 삽입된 순서대로 접근한다.
#### 3.3. TreeSet
* Set 인터페이스의 구현 클래스이다.
* 검색 기능을 강화시킨 컬렉션으로 이진 트리(Binary Tree)를 이용해서 객체를 저장한다.
* Set에서 제공하지 않는 검색 메소드를 제공한다.
#### 3.4. Iterator
* Iterator는 컬렉션에 저장된 객체에 접근할 때 사용되는 반복자이다.
* Iterator의 주요 메소드는 아래와 같다.
  |리턴 타입|메소드|설명|
  |:--:|--|--|
  |boolean|hasNext()|반복자를 통해서 가져올 객체가 있는지 확인한다.|
  |E|next()|반복자를 통해서 하나의 객체를 가져온다.|

### 4. Map
* 키(key)와 값(value)으로 구성된 Entry 객체를 저장하는 구조를 가지고 있다.
* 키(key)와 값(value) 모두 객체이다.
<br><img src="https://user-images.githubusercontent.com/26870393/162959807-936ff9c1-a305-419e-80e5-c57a9ae59d7f.png"/><br>

* 키(key)는 중복 저장을 허용하지 않고 값(value)은 중복 저장이 가능하다.
* Map 인터페이스의 주요 메소드는 아래와 같다.
  |리턴 타입|메소드|설명|
  |:--:|--|--|
  |V|put(K key, V value)|주어진 키와 값을 추가, 저장이 되면 값을 리턴한다.|
  |boolean|containsKey(Object key)|주어진 키가 있는지 확인하여 결과 리턴한다.|
  |boolean|containsValue(Object value)|주어진 값이 있는지 확인하여 결과 리턴한다.|
  |Set<Map.Entry<K,V>>|entrySet()|키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 set에 담아서 리턴한다.|
  |V|get(Object key)|주어진 키의 값을 리턴한다.|
  |boolean|isEmpty()|컬렉션이 비어있는지 조사한다.|
  |Set\<K>|keySet()|모든 키를 Set 객체에 담아서 리턴한다.|
  |int|size()|저장된 키의 수를 리턴한다.|
  |Collection\<V>|values()|저장된 모든 값을 Collection에 담아서 리턴한다.|
  |void|clear()|모든 Map.Entry를 삭제한다.|
  |V|remove(Object key)|주어진 키와 일치하는 Map.Entry 삭제, 삭제가 되면 값을 리턴한다.|
#### 4.1. HashMap
* Map 인터페이스의 구현 클래스이다.
* 키로 사용할 객체는 hashCode()와 equals() 메소드를 재정의해야 한다.
* 대부분의 경우에 키값은 hashCode()와 equals()가 재정의된 String을 주로 사용한다.
#### 4.2. HashTable
* Map 인터페이스의 구현 클래스이다.
* HashMap과 차이점은 동기화(Synchronized)를 제공한다.
* 멀티 스레드 환경에서 안전하게 객체를 추가, 삭제할 수 있는 것을 스레드가 안전(Thread Safe)하다고 한다.
#### 4.3. TreeMap
* Map 인터페이스의 구현 클래스이다.
* 검색 기능을 강화시킨 컬렉션으로 이진 트리(Binary Tree)를 이용해서 객체를 저장한다.
* Map에서 제공하지 않는 검색 메소드를 제공한다.
### 5. Properties
* HashTable의 하위 클래스이다.
* Properties는 키와 값을 String 타입으로 제한한다.
* Properties는 프로퍼티(*.properties) 파일을 읽어 들일 때 주로 사용한다.
* Properties의 주요 메소드는 아래와 같다.
  |리턴 타입|메소드|설명|
  |:--:|--|--|
  |String|getProperty(String key)|Properties 객체에 해당 key 값에 해당하는 value 값을 리턴한다.|
  |Object|setProperty(String key, String value)|Properties 객체에 해당 key 값과 value 값이 세트로 저장한다.|
  |void|store(OutputStream out, String comments)|바이트 스트림으로 저장된 정보를 파일로 출력한다.|
  |void|store(Writer writer, String comments)|문자 스트림으로 저장된 정보를 파일로 출력한다.|
  |void|stroreToXML(OutputStream os, String comment)|저장된 정보를 바이트 스트림으로 xml로 출력한다.|
  |void|load(InputStream inStream)|바이트 스트림으로 저장된 파일의 내용을 읽어와서 Properties 객체에 저장한다.|
  |void|load(Reader reader)|문자 스트림으로 저장된 파일의 내용을 읽어와서 Properties 객체에 저장한다.|
  |void|loadFromXML(InputStream in)|바이트 스트림으로 저장된 xml 파일의 내용을 읽어와서 Properties 객체에 저장한다.|
## 제네릭스(Generics)
### 1. 제네릭스
* JDK 1.5부터 제공되는 기능이다.
* 클래스와 인터페이스, 메소드 내부에서 다룰 데이터의 타입을 지정할 수 있다.
* 타입 파라미터는 코드 작성 시 구체적인 타입으로 대체되어 다양한 코드를 생성하도록 도와준다.
#### 1.1. 제네릭스의 장점
* 실행 시 잘못된 타입 사용으로 발생할 수 있는 에러를 컴파일 시에 체크할 수 있다.
* 컬렉션에 저장되는 요소의 타입을 제한하기 때문에 불필요한 형 변환을 제거할 수 있다.
  ```java
  List list = new ArrayList();

  list.add("Hello");

  String str = (String) list.get(0);
  ```
  ```java
  List<String> list = new ArrayList<String>();

  list.add("Hello");

  String str = list.get(0);
  ```
### 2. 제네릭스 타입
* 타입 파라미터를 가지는 클래스와 인터페이스를 제네릭스 타입이라고 한다.
* 제네릭스 타입은 클래스 또는 인터페이스 이름 뒤에 "<>" 기호를 추가하고 사이에 타입 파라미터가 위치한다.
* 타입 파라미터는 대문자 알파벳 한 글자로 작성한다. 
  ```java
    // java.util 패키지의 ArrayList 클래스
    public class ArrayList<E> extends ... {
      ...
    }

    // java.util 패키지의 List 인터페이스
    public interface List<E> extends Collection<E> {
      ...
    }
  ```
* 제네릭스 타입의 클래스를 객체로 생성할 때 구체적인 타입으로 변경된다.
* jdk 1.7부터 중복 기술을 줄이기 위해 다이아몬드 연산자"<>"를 제공한다. 
* 컴파일러는 타입 파라미터 부분에 "<>" 연산자를 사용하면 타입 파라미터를 자동으로 설정한다. 
  ```java
  List<String> list = new ArrayList<>(); // 타입 추론

  ...
  ```
#### 2.1 멀티 타입 파라미터
* 제네릭스 타입은 두 개 이상의 멀티 타입 파라미터를 사용할 수 있는데, 이 경우 각 타입 파라미터를 콤마로 구분한다.
  ```java
  // java.util 패키지의 Map 인터페이스
  public interface Map<K, V> {
    ...
  } 
  ```
  ```java
  Map<String, Integer> map = new HashMap<>();

  ...
  ```
#### 2.2 제네릭스 타입과 상속
* 제네릭스 타입도 부모 클래스가 될 수 있고 타입 파라미터는 자식 클래스에도 기술해야 한다.
* 자식 클래스는 추가적으로 타입 파라미터를 가질 수 있다.
  ```java
  // java.util.function 패키지의 Function 인터페이스
  public interface Function<T, R> { 
    ... 
  }
  ```
  ```java
  // java.util.function 패키지의 UnaryOperator 인터페이스
  public interface UnaryOperator<T> extends Function<T, T> { 
    ... 
  }
  ```
### 3. 제네릭스 메소드
* 제네릭스 메소드는 리턴 타입과 매개 타입으로 타입 파라미터를 갖는 메소드를 말한다.
* 리턴 타입 앞에 "<>" 기호를 추가하고 타입 파라미터를 기술한다. 
* 제네릭스 메소드도 멀티 파라미터를 가질 수 있다.
* 타입 파라미터를 기술한 이후에는 리턴 타입과 매개 타입에서 타입 파라미터를 사용하면 된다.
  ```java
  // java.util 패키지의 Collections 클래스
  public class Collections {
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
      ...
    }
    public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) {
      ...
    }
    ...
  }
  ```
  ```java
  List<String> list = Arrays.asList("이몽룡", "홍길동", "문인수");
  
  Collections.<String>sort(list);
  ```
* 제네릭스 메소드를 호출할 때 타입 파라미터를 생략하면 매개값으로 구체적인 타입을 추론한다.
  ```java
  List<String> list = Arrays.asList("이몽룡", "홍길동", "문인수");

  Collections.sort(list); // 타입 추론
  ```
### 4. 제네릭스 타입 제한
* 타입 파라미터를 지정할 때 상속 및 구현 관계로 제한된 파라미터를 선언하려면 타입 파라미터 뒤에 extends 키워드를 붙이고 상위 타입을 명시하면 된다.
* 인터페이스로 제한된 파라미터를 선언할 때 implements를 사용하지 않고 동일하게 extends를 사용한다.
  ```java
    public <T extends 상위타입> 클래스명 {
      ...
    }
  ```
### 5. 와일드카드(Wildcard)
* 와일드카드 문자는 하나 이상의 다른 문자들을 대표적으로 상징하는 특수 문자(?, *)를 의미한다.
* 타입 파라미터로 \<?>는 모든 클래스나 인터페이스 타입이 올 수 있다.
* 타입 파라미터로 \<? extends T>는 T 타입이거나 T 타입을 상속하는 타입만 올 수 있다.
* 타입 파라미터로 \<? super T>는 T 타입이거나 T 타입의 부모 타입만 올 수 있다.

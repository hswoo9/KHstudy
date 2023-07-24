## 기본 API

### 1. API(Application Programming Interface)
* API는 운영 체제나 서버, 프로그래밍 언어가 제공하는 기능을 프로그램에서 사용할 수 있도록 만든 인터페이스를 말한다.
* 자바에서 API는 프로그램 개발에 자주 사용되는 클래스 및 인터페이스의 모음이다.
#### 1.1. java.lang 패키지
* java.lang 패키지는 자바 프로그램의 기본적인 클래스와 인터페이스를 담고 있는 패키지이다. (Object, System, Class, String, Math, Wrapper 클래스 등)
* java.lang 패키지에 있는 클래스와 인터페이스는 import 없이 사용할 수 있다.
#### 1.2. java.util 패키지
* java.util 패키지는 자바 프로그램 개발에 유용한 클래스와 인터페이스를 담고 있는 패키지이다. (Arrays, Calendar, Date, Objects 클래스 등)
### 2. Object 클래스
* Object는 자바의 최상위 부모 클래스로 모든 클래스는 Object 클래스의 자식이거나 자손 클래스이다.
* 클래스를 선언할 때 다른 클래스를 상속하지 않으면 Object 클래스를 상속하게 된다. 
* Object 클래스는 필드가 없고, 메소드로 구성되어 있으며 이 메소드들은 모든 클래스가 사용이 가능하다.
### 3. String 클래스
* 불변의 클래스로 값의 변경이 적고 읽기가 많은 경우에 사용하는 것이 좋다.
* String은 new 없이도 객체를 생성할 수 있는 유일한 객체이며 String 클래스의 다양한 생성자를 이용해서 직접 String 객체를 생성할 수 있다.
* 자바는 문자열 리터럴이 동일하다면 String 객체를 공유하도록 되어 있다.
  ```java
  // 아래 두 개의 참조 변수는 동일한 String 객체를 참조하게 된다.
  String str1 = "문인수"; 
  String str2 = "문인수"; 

  System.out.println(str1 == str2); // true
  ```
* 일반적으로 문자열을 저장할 경우에는 문자열 리터럴을 사용하지만, new 연산자를 사용해서 직접 String 객체를 생성시킬 수도 있다.
  ```java
  // 아래 두 개의 변수는 서로 다른 String 객체를 참조한다.
  String str1 = new String("문인수"); 
  String str2 = new String("문인수");

  // 문자열 생성 방법에 따라 비교 연산자의 결과가 달라질 수 있다. 
  System.out.println(str1 == str2); // false
  ```
* 문자열을 비교할 때에는 String 객체의 equals() 메소드를 사용해야 한다.
  ```java
  String str1 = "문인수"; 
  String str2 = new String("문인수");
  
  System.out.println(str1.equals(str2)); // true
  ```
### 4. StringTokenizer 클래스
* java.util 패키지에서 제공하는 클래스로 객체 생성 시 생성자로 전달받은 문자열과 구분자를 이용하여 문자열을 분리한다.

  ```java
    // 분리된 문자의 최소 단위를 토큰이라고 부른다.
    StringTokenizer st =  new StringTokenizer("Hello,World", ",");

    /*
      countTokens() : 꺼내지 않고 남아있는 토큰의 수를 확인한다.
      hasMoreTokens() : 남아 있는 토큰이 있는지 확인한다.
      nextToken() : 토큰을 하나씩 꺼내온다.
    */
	while(st.hasMoreTokens()) {
		System.out.println(stn.nextToken()); 
	}
  ```
### 5. StringBuffer, StringBuilder 클래스
* 가변의 클래스들로 String 클래스와 다르게 내부의 문자열을 수정할 수 있다.
* 이 두 클래스는 내부 버퍼(데이터를 임시로 저장하는 메모리)에 문자열을 저장해 두고, 그 안에서 추가, 수정, 삭제 작업을 할 수 있도록 설계되어 있다. 
* StringBuilder와 StringBuffer의 차이점은 동기화가 되느냐 안 되느냐의 차이이다. 
  * 멀티 스레드 환경에서는 StringBuffer의 사용을 권장한다.
  * 단일 스레드 환경에서는 StringBuilder의 사용을 권장한다.
  ```java
  StringBuilder sb = new StringBuilder("Hello");

  sb.append("World");

  System.out.println(sb); // HelloWorld
  ```
### 6. Wrapper 클래스
* 자바는 기본 타입의 값을 갖는 객체를 생성할 수 있는데 이 객체들을 Wrapper 객체라고 한다.
#### 6.1. Boxing과 UnBoxing
* 기본 타입의 값을 Wrapper 객체로 만드는 과정을 박싱(Boxing)이라고 한다.
  ```java
  // Boxing
  Integer iNum = new Integer(3);
  ```
* Wrapper 객체에서 기본 타입의 값을 얻어내는 과정을 언박싱(UnBoxing)이라고 한다.
  ```java
  // Unboxing
  int iNum = new Integer(3).intValue();
  ```
#### 6.1. Auto Boxing과 Auto UnBoxing
* 기본 타입 값이 자동적으로 박싱(Boxing)과 언박싱(UnBoxing)이 일어나는 것를 자동 박싱(Auto Boxing)과 자동 언박싱(Auto UnBoxing)이라고 한다.
* 자동 박싱(Auto Boxing)은 Wrapper 타입에 기본값이 대입될 경우에 발생한다.
  ```java
  // Auto Boxing
  Integer number = 10; 
  ```
* 자동 언박싱(Auto UnBoxing)은 기본 타입에 Wrapper 객체가 대입될 경우에 발생한다.
  ```java
  // Auto UnBoxing
  int number = new Integer(10); 
  ```
### 7. Data 클래스
* Date는 날짜를 표현하는 클래스이다. 
* Date 클래스에는 여러 개의 생성자가 선언되어 있지만 대부분 deprecated(비권장) 되어 현재는 Date() 생성자만 주로 사용한다. 
  ```java
  // Date() 생성자는 시스템으로부터 현재 날짜 및 시간을 읽어와 Date 객체로 만든다.
  Date now = new Date();

  System.out.println(now); // Sun Apr 03 14:11:17 KST 2022
  ```
### 8. SimpleDateFormat 클래스
* Date 클래스의 toString() 메소드는 영문으로 된 문자열을 리턴한다.
* 특정 문자열 포맷으로 날짜를 얻고 싶다면 java.text.SimpleDateFormat 클래스를 사용하면 된다.
* SimpleDateFormat 클래스는 날짜를 원하는 형식으로 표현하기 위해서 아래와 같은  패턴을 사용한다.
  |기호|의미|기호|의미|
  |--|--|--|--|
  |y|년|H|시(0~23)|
  |M|월|h|시(1~12)|
  |d|일|K|시(0~11)|
  |D|월 구분이 없는 일|k|시(1~24)|
  |E|요일|m|분|
  |a|오전/오후|s|초|
  |w|년의 몇 번째 주|S|밀리세컨드(1/1000초)|
  |W|월의 몇 번째 주|
  ```java
  // SimpleDateFormat의 생성자에 원하는 형식의 패턴을 지정해서 객체를 생성하면 된다. 
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
  //format()를 호출해서 패턴이 적용된 문자열을 얻을 수 있다.
  String formatDate = sdf.format(new Date());

  System.out.println(formatDate); // 2022년 4월 03일
  ```
### 9. java.time 패키지
* 자바 8부터 날짜와 시간을 나타내는 다양한 클래스들이 새롭게 추가되었다. 
* 이 클래스 들은 java.time 패키지와 하위 패키지로 제공되며 LocalDate, LocalTime, LocalDateTime, ZonedDateTime 클래스를 포함하고 있다.
* 위 클래스들은 날짜와 시간에 대한 정보를 얻어올 수 있는 다양한 메소드를 제공해 준다.

#### 9.1. LocalDate
* LocalDate 객체는 날짜 정보를 저장할 수 있다.
  ```java
  // 시스템으로부터 현재 날짜를 읽어와 LocalDate 객체를 생성 후 리턴한다.
  LocalDate date = LocalDate.now();

  System.out.println(date); // 2022-04-03
  ```
  ```java
  // 매개값으로 주어진 날짜 정보에 대한 LocalDate 객체를 생성 후 리턴한다.
  LocalDate date = LocalDate.of(2022, 5, 25);

  System.out.println(date); // 2022-05-25
  ```
#### 9.2. LocalTime
* LocalTime 객체는 시간 정보만을 저장할 수 있다.
  ```java
  // 시스템으로부터 현재 시간을 읽어와 LocalTime 객체를 생성 후 리턴한다.
  LocalTime time = LocalTime.now();

  System.out.println(time); // 14:39:57.549705600
  ```
  ```java
  // 매개값으로 주어진 시간 정보에 대한 LocalTime 객체를 생성 후 리턴한다.
  LocalTime time = LocalTime.of(12, 30, 50, 600000000);

  System.out.println(time); // 12:30:50.600
  ```
#### 9.3. LocalDateTime
* LocalDateTime 객체는 날짜와 시간 정보를 모두 저장할 수 있다.
  ```java
  // 시스템으로부터 현재 날짜 및 시간을 읽어와 LocalDateTime 객체를 생성 후 리턴한다.
  LocalDateTime today = LocalDateTime.now();

  System.out.println(today); // 2022-04-03T14:39:57.550705700
  ```
  ```java
  // 매개값으로 주어진 날짜 및 시간 정보에 대한 LocalDateTime 객체를 생성 후 리턴한다.
  LocalDateTime today = LocalDateTime.of(2022, 5, 25, 12, 30, 50, 600000000);

  System.out.println(today); // 2022-05-25T12:30:50.600
  ```
### 10. DateTimeFormatter 클래스
* 날짜와 시간을 포맷팅(Formatting)된 문자열로 변환하는 메소드를 제공하는 클래스이다.
  ```java
  LocalDateTime today = LocalDateTime.now();
  DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초");

  System.out.println(today.format(ofPattern)); // 2022년 04월 03일 03시 02분 48초
  ```
* DateTimeFormatter에 표준화된 포맷들이 상수로 미리 정의되어 있기 때문에 ofPattern() 메소드를 사용하지 않고 바로 이용할 수 있다.
  ```java
  LocalDate date = LocalDate.now();

  System.out.println(date.format(DateTimeFormatter.ISO_WEEK_DATE)); // 2022-W13-7
  ```

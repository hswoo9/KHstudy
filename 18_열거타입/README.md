## 열거 타입(Enumeration Type)
### 1. 열거 타입(Enumeration Type)
* 데이터 중에는 몇 가지로 한정된 값만 갖는 데이터가 있다.
* 한정된 값만을 갖는 데이터 타입이 열거 타입(Enumeration Type)이다. 
* 열거 타입은 몇 개의 열거 상수(Enumeration Constant) 중에서 하나의 상수를 저장하는 데이터 타입이다.
### 2. 열거 타입 선언
* 열거 타입은 클래스와 동일하게 소스 파일(.java)을 생성해야 한다.
* 열거 상수는 모두 대문자로 작성하는 것이 관례이다.
  ```java
  // public enum은 열거 타입을 선언하기 위한 키워드이다.
  // 열거 타입의 이름은 소스 파일명과 동일해야 한다.
  public enum Week {
     MONDAY, 
     TUESDAY, 
     WEDNESDAY,
     THURSDAY,
     FRIDAY,
     SATURDAY,
     SUNDAY
  }
  ```
### 3. 열거 타입 변수
* 열거 타입도 하나의 데이터 타입이므로 변수를 선언하고 사용해야 한다.
  ```java
  Week today;
  ```
* 선언된 열거 타입 변수에 열거 상수를 저장할 수 있다.
* 열거 상수는 단독으로 사용할 수 없고 반드시 `열거 타입.열거 상수`로 사용된다.
  ```java
  Week today = Week.FRIDAY;
  ```
### 4. 열거 타입 메소드
* name() 메소드는 열거 상수가 가지고 있는 문자열을 반환한다.
* ordinal() 메소드는 전체 열거 상수 중 몇 번째 열거 상수인지 정숫값을 반환한다. (0부터 시작)
* equals() 메소드는 매개값으로 전달되는 열거 상수와 동일한 열거 상수인지 확인 후 true 또는 false를 반환한다.
* compareTo() 메소드는 매개값으로 주어진 열거 상수를 기준으로 전후로 몇 번째 위치하는 정숫값을 반환한다.
  ```
  System.out.println(today.name());
  System.out.println(today.ordinal());
  System.out.println(today.equals(Week.SUNDAY));
  System.out.println(today.compareTo(Week.SUNDAY));
  ```
### 5. 열거 타입에 속성 추가하기
* 열거 타입의 열거 상수에 다른 속성을 추가할 수 있다.
* 열거 상수의 괄호()를 넣고 추가로 할 속성을 적어준다.
* 열거 타입에 필드를 설정하고 Getter를 통해 읽어 올 수 있다.
  ```java
  public enum Week {
    MONDAY("monday", 1),
    TUESDAY("tuesday", 2),
    WEDNESDAY("wednesday", 3),
    THURSDAY("thursday", 4),
    FRIDAY("friday", 5), 
    SATURDAY("saturday", 6),
    SUNDAY("sunday", 7);
  
    private final String name;
    private final int value;
  
    // 열거 타입의 생성자는 반드시 private으로 선언해야 한다.
    private Week(String name, int value) {
        this.name = name;
        this.value = value;
    }
  
    // 열거 타입의 name 값을 읽어오는 메소드이다.
    public String getName() {
        return this.name;
    }
    
    // 열거 타입의 value 값을 읽어오는 메소드이다.
    public int getValue() {
        return this.value;
    }
  ```

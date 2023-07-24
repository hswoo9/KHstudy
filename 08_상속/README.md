## 상속(Inheritance)

### 1. 상속
* 객체 지향 프로그래밍에서 상속은 부모 클래스의 멤버를 자식 클래스에게 물려주는 것이다.
* 부모에 해당하는 클래스를 부모 클래스 또는 상위, 슈퍼 클래스라 한다.
* 자식에 해당하는 클래스를 자식 클래스 또는 하위, 서브 클래스라 한다.
* 상속을 통해서 다른 클래스가 가지고 있는 멤버를 직접 만들지 않고 상속을 받음으로써 자신의 멤버처럼 사용할 수 있다.
### 2. 상속의 장점
* 코드의 중복을 줄여준다.
* 적은 양의 코드로 새로운 클래스 작성이 가능하다.
* 상속을 통해서 연관된 클래스들에 대한 공통적인 규약을 정의할 수 있다.
* 상속을 통해서 코드를 공통적으로 관리하기 때문에 코드의 추가 및 변경 용이하다.
### 3. 클래스의 상속
* 클래스의 상속 구문은 `[접근 제한자] class 자식클래스명 extends 부모클래스명 { ... }`이다.
* 자바는 다중 상속을 지원하지 않는다.
* 모든 클래스는 Object 클래스의 후손이다.
* 부모 클래스에서 private 접근 제한을 갖는 필드와 메소드는 상속에서 제외된다. 
  ``` java
  // 부모 클래스
  public class Animal {
    ...
  }
  ```
  ``` java
  // 자식 클래스
  public class Dog extends Animal {
    ...
  }
  ```
### 4. 자식 객체 생성
* 생성자는 객체 생성을 위한 특별한 메소드로 상속되지 않는다.
* 자식 클래스의 객체를 생성하면 부모 클래스의 생성자가 먼저 호출되면서 부모 객체가 생성되고 자식 객체가 생성된다.
* 자식 클래스의 생성자 안에서 super()를 통해서 부모 클래스의 생성자를 호출한다.
* super()는 자식 클래스의 생성자 첫 줄에 위치해야 한다.
  ``` java
  // 부모 클래스
  public class Animal {
    private String name;
    private String kinds;
    
    public Animal() {
    }

    public Animal(String name, String kinds) {
        this.name = name;
        this.kinds = kinds;
    }
  }
  ```
  ``` java
  // 자식 클래스
  public class Dog extends Animal {
    private int weight;

    public Dog() {
      // super() 생략 시 자동으로 생성한다.
    }

    public Dog(String name, String kinds, int weight) {
      super(name, kinds);

      this.weight = weight;
    }
  }
  ```
### 5. 메소드 오버라이딩(Overriding)
* 부모 클래스의 메소드를 자식 클래스에서 다시 재정의해서 사용하는 것을 메소드 오버라이딩이라 한다.
* @Override 어노테이션을 붙여 준다. (생략 가능)
* 자식 클래스에서 메소드 오버라이딩은 부모의 메소드와 동일한 선언부를 가져야 한다.
* 부모 클래스의 메소드가 private 접근 제한을 가지면 자식 클래스는 메소드를 오버라이딩 할 수 없다.
  ``` java
  // 부모 클래스
  public class Animal {
    private String name;
    private String kinds;
    
    public Animal() {
    }

    public Animal(String name, String kinds) {
        this.name = name;
        this.kinds = kinds;
    }

    public String bark() {
        return "짖는다.";
    }
  }
  ```
  ``` java
  // 자식 클래스
  public class Dog extends Animal {
    private int weight;

    public Dog() {
    }

    public Dog(String name, String kinds, int weight) {
      super(name, kinds);

      this.weight = weight;
    }

    @Override
    public String bark() {
        return "멍멍~ 짖는다.";
    }
  }
  ```
* 자식 객체에서 오버라이딩된 메소드를 호출하면 부모 객체의 메소드가 아닌 오버라이딩된 자식 메소드가 호출된다.
* 부모 객체의 메소드는 삭제되는 것이 아닌 오버라이딩된 메소드에 의해 가려지게 된다.
  ``` java
  Dog dog = new Dog();

  System.out.println(dog.bark()); // "멍멍~ 짖는다." 출력
  ```
* 자식 클래스 내부에서 오버라이딩된 부모 클래스의 메소드를 호출해야 하는 상황이 발생한다면 super를 통해서 부모 메소드를 호출할 수 있다.
  ``` java
  // 부모 클래스
  public class Animal {
    private String name;
    private String kinds;
    
    // 생성자 선언
    ... 

    public String bark() {
        return "짖는다.";
    }
  }
  ```
  ``` java
  // 자식 클래스
  public class Dog extends Animal {
    private int weight;

    // 생성자 선언
    ... 
    @Override
    public String bark() {
        return "멍멍~ " + super.bark();
    }
  }
  ```
### 6. final 클래스와 final 메소드
* final 키워드는 필드뿐만 아니라 클래스와 메소드 선언 시에 사용할 수 있다. 
* final 키워드를 클래스 선언에 붙이게 되면 이 클래스는 상속할 수 없는 클래스가 된다.
  ```java
  // java.lang에서 제공하는 String 클래스
  public final class String {
    ...
  }
  ```
* final 키워드를 메소드 선언에 붙이게 되면 이 메소드는 재정의할 수 없는 메소드가 된다.
  ```java
  // java.lang에서 제공하는 Object 클래스
  public class Object {
    public final void wait() {
        ...
    }
  }
  ```

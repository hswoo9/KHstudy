## 다형성(Polymorphism)

### 1. 다형성
* 다형성은 같은 타입이지만 실행 결과가 다양한 객체를 이용할 수 있는 성질을 말한다.
* 부모 클래스 타입의 참조 변수에 자식 객체들을 대입하여 다룰 수 있는 것이 다형성의 기본 개념이다.
#### 1.1. 업 캐스팅(Up Casting)
* 업 캐스팅은 자식 타입의 객체가 부모 타입의 객체로 형 변환되는 것을 말한다.
* 업 캐스팅은 자동으로 형 변환이 일어나기 때문에 부모 클래스 타입의 참조 변수가 모든 자식 객체들을 별도의 형 변환 없이 대입 받을 수 있다.
* 부모 타입으로 업 캐스팅된 이후에는 부모 클래스에 선언된 필드와 메소드만 접근이 가능하다.
* 단, 예외가 있는데 부모 타입의 메소드가 오버라이딩되었다면 오버라이딩된 메소드가 대신 호출된다.
  ``` java
  // Dog 클래스 타입의 객체를 Animal 클래스 타입의 참조 변수에 대입
  Animal animal = new Dog();

  // 자식 클래스에서 오버라이딩 된 코드가 실행된다.
  System.out.println(animal.bark()); // "멍멍~ 짖는다." 출력
  ```
  ``` java
  // Cat 클래스 타입의 객체를 Animal 클래스 타입의 참조 변수에 대입
  Animal animal = new Cat();

  // 자식 클래스에서 오버라이딩 된 코드가 실행된다.  
  System.out.println(animal.bark()); // "야옹~ 운다." 출력
  ```
#### 1.2. 바인딩
* 실제 실행할 메소드 코드와 호출하는 코드를 연결시키는 것을 바인딩이라 한다. 
* 프로그램이 실행되기 전에(컴파일 시점) 바인딩이 일어날 경우 정적 바인딩이라 한다.
* 정적 바인딩은 오버라이딩이 불가능한 메소드에서 발생한다. (static, private, final 메소드)
* 프로그램이 실행되면서 객체 타입을 기준으로 바인딩 되는 것을 동적 바인딩이라 한다.
* 동적 바인딩은 다형성을 가능하게 만들어주는 핵심적인 개념으로 오버라이딩된 메소드에서 발생한다.
#### 1.3. 다운 캐스팅(Down Casting)
* 다운 캐스팅은 부모 타입의 객체가 자식 타입의 객체로 형 변환되는 것을 말한다.
* 다운 캐스팅은 자동으로 형 변환이 일어나지 않기 때문에 형 변환 연산자를 사용해서 형 변환을 해야 한다.
  ``` java
  Animal animal = new Dog();
  // 클래스 간의 형 변환은 반드시 상속 관계에 있는 클래스들끼리만 가능하다.
  Dog dog = (Dog) animal; 
  ```
* 부모 클래스 타입 참조 변수가 실제로 참조하는 객체를 확인하지 않고 강제 형 변환을 시도하면 ClassCastException 예외가 발생할 수 있다.
* 객체가 어떤 클래스의 인스턴스인지 instanceof 연산자를 사용해서 확인할 수 있다.
  ``` java
  // animal이 참조하는 객체가 Dog 클래스로 생성된 객체이면 true
  // animal이 참조하는 객체가 Dog 클래스로 생성된 객체가 아니면 false
  if(animal instanceof Dog) {
    ...
  // animal이 참조하는 객체가 Cat 클래스로 생성된 객체이면 true
  // animal이 참조하는 객체가 Cat 클래스로 생성된 객체가 아니면 false
  } else if (animal instanceof Cat){
    ...
  } 
  ```
### 2. 추상 클래스(Abstract Class)
* 클래스들의 공통적인 특성을 추출해서 선언한 클래스를 추상 클래스라고 한다.
* 추상 클래스를 부모 타입으로, 객체로 생성될 실체 클래스가 자식 타입으로 구현되어 추상 클래스의 모든 특성을 물려받을 수 있다.
* 추상 클래스는 공통되는 필드와 메소드를 추출해서 만들었기 때문에 객체를 직접 생성해서 사용할 수 없고 부모 클래스로만 사용된다.
#### 2.1. 추상 클래스의 특징
* 관련 있는 클래스들의 공통된 필드와 메소드의 이름을 통일할 수 있다.
* 추상 클래스를 상속받는 자식 클래스를 작성하는 시간을 절약할 수 있다.
* 유지 보수와 코드 관리가 편해진다.

#### 2.2. 추상 클래스 선언
* 추상 클래스의 선언 구문은 `[접근 제한자] abstract class 클래스명 { ... }`이다.
* 추상 클래스 내에 필드, 메소드, 생성자를 포함할 수 있다.
* 추상 클래스는 객체로 생성이 안되지만 참조 변수의 타입으로는 사용이 가능하다.
  ```java
  public abstract class Animal {
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
  ```java
  Animal animal = new Animal(); // 에러 발생
  Animal animal = new Dog(); // 다형성 적용 가능
  ```
#### 2.3. 추상 메소드(Abstract Method)
* 추상 클래스에 선언된 메소드가 자식 클래스마다 실행 내용이 달라야 하는 경우 추상 메소드를 선언할 수 있다.
* 추상 메소드는 추상 클래스에서 선언할 수 있고 메소드의 선언부만 있는 메소드의 실행 내용인 중괄호({})가 없는 메소드이다.
* 추상 클래스를 상속하는 자식 클래스는 반드시 추상 메소드를 오버라이딩 해야 한다. 
* 오버라이딩하지 않으면 컴파일 에러가 발생하는데 자식 클래스에서 내용을 채우도록 강제화한다.
* 추상 메소드의 선언 구문은 `[접근 제한자] abstract 반환형 메소드명([매개 변수]);`이다.
  ```java
  public abstract class Animal {
    private String name;
    private String kinds;
    
    public Animal() {
    }

    public Animal(String name, String kinds) {
        this.name = name;
        this.kinds = kinds;
    }

    // 추상 메소드 선언
    public abstract String bark();
  }
  ```
  ``` java
  // 자식 클래스
  public class Dog extends Animal {
    private int weight;

    // 생성자 선언
    ... 

    // 추상 메소드는 반드시 오버라이딩 해야 한다.
    @Override
    public String bark() {
        return "멍멍~ 짖는다.";
    }
  }
  ```
### 3. 인터페이스(Interface)
* 인터페이스는 자바에서 클래스들이 구현해야 하는 동작을 지정하는 역할을 한다.
* 인터페이스는 실행 코드와 객체가 통신하는 접점으로 실행 코드가 인터페이스의 메소드를 호출하면 인터페이스는 객체의 메소드를 호출시킨다.
#### 3.1. 인터페이스의 특징
* 인터페이스를 사용하면 실행 코드를 변경하지 않고 사용하는 객체를 변경할 수 있다.
* 실행 코드에서는 코드의 변경 없이 실행 내용과 리턴 값을 다양화할 수 있다는 장점을 가지게 된다.
* 즉, 인터페이스는 다형성을 구현하는 중요한 역할을 한다. 
#### 3.2. 인터페이스 선언
* 인터페이스의 선언 구문은 `[접근 제한자] interface 인터페이스명 { ... }`이다.
* 인터페이스 선언은 class 키워드 대신에 interface 키워드를 사용한다.
* 인터페이스는 선언된 필드는 모두 public static final의 특성을 갖는다.
* 인터페이스에 선언된 메소드는 모두 public abstract의 특성을 갖는다. 
* 자바 8부터 디폴트 메소드와 정적 메소드도 선언이 가능하다.
  ```java
  public interface Runable {
    void run(); // public abstract 생략 가능
  }
  ```
#### 3.3. 인터페이스 구현
* 인터페이스를 구현하는 클래스는 클래스 선언부에 implements 키워드를 추가하고 인터페이스명을 명시해야 한다.
* 인터페이스를 구현하는 클래스는 인터페이스에 정의된 추상 메소드를 반드시 오버라이딩 해야 한다.
  ```java
  // 인터페이스 구현 방법
  public class Cat implements Runable {
    ...

    @Override
    public void run() {
      ...
    }
  }
  ```
* 상속과 다르게 인터페이스는 다중 구현이 가능하다.
  ```java
  // 인터페이스의 다중 구현 시 콤마(,)로 구분한다.
  public class Cat implements Runable, Swimable {
	  ...
    @Override
    public void run() {
      ...
    }

    @Override
    public void swim() {
      ...
    }
  }
  ```
* 인터페이스를 구현하는 클래스로 객체를 생성 후 구현된 메소드를 호출할 수 있다.
  ``` java
  Cat cat = new Cat();

  cat.run();
  cat.swim();
  ```  
#### 3.4. 인터페이스 상속
* 인터페이스도 다른 인터페이스를 상속할 수 있다.
* 인터페이스는 클래스와 달리 다중 상속을 허용한다.
* 인터페이스를 상속하는 구문은 `[접근 제한자] interface 하위인터페이스 extends 상위인터페이스1, 상위인터페이스2 { ... }`이다.
  ```java
  public interface Basic extends Runable, Swimable {
    void eat();
  }
  ```
* 하위 인터페이스를 구현하는 클래스는 하위 인터페이스의 추상 메소드 뿐만 아니라 상위 인터페이스들의 모든 추상 메소드들을 오버라이딩 해야 한다.
  ```java
  public class Cat implements Basic {
	  ...

    @Override
    public void eat() {
      ...
    }

    @Override
    public void run() {
      ...
    }

    @Override
    public void swim() {
      ...
    }
  }
  ```
### 4. 추상 클래스와 인터페이스
#### 4.1. 공통점
* 추상 메소드를 구현하도록 강제한다.
* 객체 생성은 불가능하고 참조 변수로서는 사용이 가능하다.
* 확장 가능한 프로그램 설계가 가능하고, 개선된 코드 구조와 가독성을 제공한다.
#### 4.2. 차이점
* 추상 클래스는 추상 클래스를 상속받아서 기능을 이용하고, 확장시키는데 목적이 있다.
* 인터페이스는 클래스의 기능(메소드)의 구현을 강제하기 위해서이다. 구현을 강제함으로써 구현 객체의 같은 동작을 보장할 수 있다.
* 인터페이스가 추상 클래스보다 더 강한 규칙성, 강제성을 제공한다.
### 참고
* 클래스에 abstract와 final 동시에 사용이 불가능하다.
* 메소드에 static과 abstract 동시에 사용이 불가능하다.
* abstract 메소드에 private 접근 제한자 지정이 불가능하다.

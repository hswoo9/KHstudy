## 예외처리
### 1. 에러(Error)
* 프로그램 수행 시 치명적 상황이 발생하여 비정상 종료 상황이 발생한 것을 프로그램 에러라고 한다.
#### 1.1. 에러의 종류
* 컴파일 에러는 소스코드 상의 문법 에러로 소스코드를 수정하여 해결할 수 있다.
* 런타임 에러는 프로그램 실행 중에 발생하는 에러로 사용자로부터 잘못된 값을 입력받거나 계산식의 오류 등으로 발생할 수 있다.
* 시스템 에러는 컴퓨터 하드웨어 오작동 또는 고장으로 인해 발생하는 에러로 소스코드를 수정하여 해결이 불가능하다.
### 2. 예외(Exception)
* 예외(Exception)란 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인해 발생하는 프로그램 오류를 말한다. 
* 예외의 경우 if 문 또는 예외 처리 구문을 통해서 예측 가능한 예외 상황에 대해서 해결이 가능하다.
* 모든 예외는 Exception 클래스를 상속하고 있으며 반드시 예외 처리해야 하는 Checked Exception과 해주지 않아도 되는 Unchecked Exception으로 나뉜다.
#### 2.1. CheckedException
* Exception을 상속하고 있는 예외들을 CheckedException이라 한다.
* 컴파일 시 예외 처리 코드가 있는지 검사하는 예외를 말한다.
* 예외 처리가 되어있지 않으면 컴파일 에러를 발생시킨다.(try ~ catch, throws)
* 조건문이나 소스코드 수정으로는 해결이 되지 않는다. 주로 외부에 매개체와 입출력이 일어날 때 발생한다.
#### 2.2. UnCheckedException
* RuntimeException을 상속하고 있는 예외들을 UnCheckedException이라 한다.
* 컴파일 시 예외 처리 코드가 있는지 검사하지 않는 예외를 말한다. 
* RuntimeException 같은 경우엔 프로그램 실행할 때 문제가 발생되는 것이기 때문에 충분히 예측이 가능하기 때문에 조건문들을 통해서 충분히 처리가 가능하다.
### 3. 예외 처리
* 프로그램에서 예외가 발생했을 경우 프로그램의 갑작스러운 종료를 막고 정상 실행을 유지할 수 있도록 처리하는 코드를 예외 처리 코드라고 한다.
#### 3.1. try-catch-finally 문
* try 블록에는 예외가 발생할 가능이 있는 코드가 위치한다.
* try 블록의 코드에서 예외가 발생하면 즉시 실행을 멈추고 catch 블록으로 이동하여 예외 처리 코드를 실행한다.
* finally 블록은 생략이 가능하고 예외 발생 여부와 상관없이 항상 실행할 내용이 있을 경우에 finally 블록을 작성해 준다.
  ```java
  try {
    ...
  } catch (IOException e1 | ClassNotFoundException e2) { // 멀티 catch
    ...
  } catch (Exception e) { // 다중 catch
    ... 
  } finally {
    // 예외 발생 여부와 상관없이 실행해야 하는 코드  
  }
  ```
#### 3.2. throws
* 메소드 내부에서 예외가 발생할 수 있는 코드를 작성할 때 try-catch 블록으로 예외를 처리하는 것이 기본이지만, throws 키워드를 통해서 메소드를 호출한 곳으로 예외를 떠넘길 수도 있다.
* throws 키워드는 메소드 선언부 끝에 작성되어 메소드에서 처리하지 않는 예외를 호출한 곳으로 떠넘기는 역할을 한다. 
  ```java
  // BufferedReader 클래스의 readLine() 메소드
  public String readLine() throws IOException {
    ...
  }
  ```
* throws가 붙어있는 메소드는 반드시 try 블록 내에서 호출되어야 한다. 만약 throws가 붙어있는 메소드를 호출한 곳에서 처리하지 않으려면 throws 키워드로 다시 예외를 떠넘길 수 있다.
#### 3.3. 예외와 오버라이딩
* 부모 클래스의 메소드를 자식 클래스에서 오버라이딩 시 메소드가 throws 하는 Exception과 같거나 하위 클래스이어야 한다.
  ```java
  public class Parent {
	public void method() throws IOException {
	  ...
	}
  }
  ```
  ```java
  public class Child extends Parent {
      
    // EOFException은 IOException의 하위 클래스이므로 오버라이딩이 가능하다.
	@Override
	public void method() throws EOFException { 
		. . . 
	}
  }
  ```
  ```java
  public class Child extends Parent {
      
    // Exception은 IOException의 상위 클래스이므로 오버라이딩이 불가능하다.
	@Override
	public void method() throws Exception { 
		. . . 
	}
  }
  ```

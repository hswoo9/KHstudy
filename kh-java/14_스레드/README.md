## 스레드(Thread)
### 1. 스레드
#### 1.1. 프로세스
* 운영체제에서 실행 중인 하나의 프로그램(애플리케이션)을 프로세스라 부른다.
* 프로세스는 프로그램이 실행될 때 마다 개별적으로 생성
* 하나의 프로그램(애플리케이션)은 다중 프로세스를 만들기도 한다.
#### 1.2. 스레드
* 스레드는 프로세스 내에서 할당된 자원을 이용해 실제 작업을 수행하는 작업 단위이다.
* 모든 프로세스는 하나 이상의 스레드를 가지며 각각 독립적인 작업 단위를 가진다.
* 하나의 스레드는 하나의 코드 실행 흐름이기 때문에 한 프로세스 내에 여러 개의 스레드가 존재한다면 여러 개의 실행 흐름이 생긴다는 의미이다.
#### 1.3. 메인 스레드
* 모든 자바 프로그램(애플리케이션)은 메인 스레드가 main()메소드를 실행하면서 시작된다.
* 메인 스레드는 main() 메소드의 첫 코드부터 아래로 순차적으로 실행되고, 코드를 모두 실행하거나 return 문을 만나면 프로그램(애플리케이션) 실행이 종료된다.
* 메인 스레드는 필요에 의해 작업 스레드를 만들어서 병렬로 코드를 실행할 수 있다.
### 2. 멀티 스레드 
* 멀티 스레드는 하나의 프로세스 내에서 여러 스레드가 동시에 작업을 수행하는 것을 말한다.
* 자바 프로그램(애플리케이션)은 메인 스레드가 종료되면 프로세스도 종료되지만 멀티 스레드 프로그램(애플리케이션)의 경우 실행 중인 스레드가 하나라도 있다면 프로세스가 종료되지 않는다.
* 멀티 스레드 프로그램(애플리케이션)은 하나의 프로세스 내부에 여러 개의 스레드가 생성되기 때문에 하나의 스레드가 예외를 발생시키면 프로세스 자체가 종료될 수 있다.
<br><br><img src="https://user-images.githubusercontent.com/26870393/163657300-f5c1a673-521a-4957-84c2-8f2dc838e4b3.png" width="800px"/><br>
* 멀티 스레드의 장단점
  |장점|단점|
  |--|--|
  |자원을 보다 효율적으로 사용이 가능하다.|동기화(Synchronization)에 주의해야 한다.|
  |사용자에 대한 응답성 향상이 향상된다.|교착상태(dead-lock)가 발생하지 않도록     주의해야 한다.|
  |애플리케이션의 응답성 향상이 향상된다.|프로그래밍 시 고려해야 할 사항이 많다.|
  |작업이 분리되어 코드가 간결해진다.||
  |CPU 사용률이 향상된다.||
  
  <img src="https://user-images.githubusercontent.com/26870393/163657526-12df805e-14e9-4540-9ca4-63e2033f892c.png" width="800px"/><br>

### 3. 스레드 생성
* 자바에서 작업 스레드도 객체로 생성되기 때문에 관련된 클래스와 인터페이스를 사용해 작업 스레드를 생성한다.
#### 3.1. java.lang.Thread 클래스를 상속받아 스레드를 생성
* Thread 클래스를 상속한 후 run 메소드를 재정의해서 작업 스레드가 실행할 코드를 작성하면 된다.
    ```java
    public class MyThread extends Thread {

        @Override
        public void run() {
            // 작업 스레드에서 실행할 코드
            ...
        }
    }
    ```
* 생성된 작업 스레드 객체에서 start() 메소드를 호출하면 작업 스레드는 자신의 run()메소드를 실행하게 된다.
    ```java
    public class Application {
        public static void main(String[] args) {
            MyThread thread = new MyThread(); 

            thread.start();
        }
    } 
    ```
#### 3.2. java.lang.Runnable 인터페이스를 구현하여 스레드를 생성
* Thread 클래스로부터 직접 작업 스레드 객체를 생성하려면 Runnable 인터페이스의 구현 객체를 매개값으로 갖는 생성자를 호출해야 한다.
    ```java
    public class MyRunnable implements Runnable {
    
        @Override
        public void run() {
            // 작업 스레드에서 실행할 코드
            ...
        }
    }
    ```
* Runnable 인터페이스의 구현 객체를 매개값으로 전달해서 Thread 객체를 생성한다. 
* 생성된 작업 스레드 객체에서 start() 메소드를 호출하면 작업 스레드는 자신의 run()메소드를 실행하게 된다.
    ```java
    public class Application {
        public static void main(String[] args) {
            MyRunnable runnable = new MyRunnable(); 
            
            Thread thread = new Thread(runnable);
    
            thread.start();
        }
    } 
    ```
* 익명 구현 객체를 통해 Runnable 인터페이스를 직적 구현해서 스레드 생성이 가능하다.
    ```java
    public class Application {
        public static void main(String[] args) {
            Thread thread = new Thread(new Runnable() {
                
                @Override
                public void run() {
                    // 작업 스레드에서 실행할 코드
                    ...
                }
            });
    
            thread.start();
        }
    } 
    ```
### 4. 스레드 스케줄링
* 스레드의 개수가 CPU 코어의 수보다 많을 경우, 스레드를 어떤 순서에 의해서 동시성으로 실행할 것인가를 결정하는 것을 스레드 스케줄링이라고 한다.
* 동시성은 하나의 CPU 코어에서 멀티 스레드가 번갈아가며 실행하는 성질을 말한다.
* 병렬성은 CPU 멀티 코어에서 개별 스레드를 동시에 실행하는 성질을 말한다. 
* 자바에서 스레드 스케줄링은 우선순위(Priority) 방식과 순환 할당(Round-Robin) 방식을 사용한다.
  <br><br><img src="https://user-images.githubusercontent.com/26870393/163661790-d3d7d7b3-8397-4c76-a35b-c726a4609750.png" width="800px"/><br>
#### 4.1. 우선순위 방식 (Priority)
* 우선순위 방식은 우선순위가 높은 스레드가 실행 상태를 더 많이 가지도록 스케줄링하는 방식이다. 
* 우선순위 방식에서 우선순위는 1 ~ 10까지 부여되는데 1이 가장 낮고 10이 가장 높다. (기본값은 5이다. )
* 우선순위를 부여하지 않으면 기본적으로 5의 우선순위를 갖는다.
* Thread 클래스의 setPriority() 메소드를 사용해서 우선순위를 지정할 수 있다.
    ```java
    public class Application {
        public static void main(String[] args) {
            Thread thread = new Thread(new Runnable() {
                    
                @Override
                public void run() {
                    // 작업 스레드에서 실행할 코드
                    ...
                }
            });

            // thread.setPriority(1);
            // thread.setPriority(Thread.MIN_PRIORITY); // 1
            // thread.setPriority(Thread.NORM_PRIORITY); // 5
            thread.setPriority(Thread.MAX_PRIORITY); // 10

            thread.start();
        }
    }
    ```
#### 4.2. 순환 할당 방식 (Round-Robin)
* 순환 할당 방식은 시간 할당량(Time Slice)을 정해서 스레드를 정해진 시간만큼 실행하고 정해진 시간이 끝나면 다른 스레드를 실행하는 방식이다.
* JVM에 의해서 정해지기 때문에 코드로 제어할 수 없다.
### 5. 스레드 컨트롤
* 스레드 컨트롤은 실행 중인 스레드의 상태를 제어하기 위한 것을 말한다.
* 효율적이고 정교한 스케줄링을 위한 스레드 상태를 제어하는 기능이다.
#### 5.1. 스레드 상태
* 실행 대기는 스레드 생성 후 start() 호출 시, 스케줄에 의해서 실행을 대기하는 상태이다.
* 실행은 실행 대기 상태의 스레드 중에서 스케줄링으로 선택되어 run() 메소드가 실행되고 있는 상태이다.
* 일시정지는 스레드가 실행 상태에서 일시정지된 상태이다. 일시정지된 스레드를 다시 실행 상태로 가기 위해서는 실행 대기 상태가 되어야 한다.
  <br><br><img src="https://user-images.githubusercontent.com/26870393/163662608-44df7122-d0b2-4569-a0c9-7150d5810858.png" width="800px"/><br>
#### 5.2. 스레드 제어 메소드
* 스레드의 상태를 제어하는 대표적인 메소드는 아래와 같다.
  |리턴 타입|메소드|설명|
  |:--:|--|--|
  |void|interrupt()|InterruptException을 발생시키고 일시 정지 상태인 스레드를 실행 대기 상태로 만든다. (예외 처리를 통해 스레드를 다시 실행하거나 종료할 수 있다.)|
  |void|join()|다른 스레드가 종료될 때까지 기다렸다가 종료되면 다시 해당 스레드를 실행한다.|
  |void|join(long millis)|지정된 시간이 지나거나 다른 스레드의 작업이 종료되면 해당 스레드를 실행한다.|
  |void|join(ling millis, int nanos)|지정된 시간이 지나거나 다른 스레드의 작업이 종료되면 해당 스레드를 실행한다.|
  |void|sleep(long millis)|실행 중인 스레드를 일정 시간 일시정지 상태로 만든다.|
  |void|sleep(long millis, int nanos)|실행 중인 스레드를 일정 시간 일시정지 상태로 만든다.|
  |void|yield()|실행 중인 스레드를 실행 대기 상태로 만들고 동일한 우선순위 또는 높은 우선순위를 갖는 스레드에게 실행 기회를 가질 수 있도록 양보한다.|
  |void|wait()|객체의 잠금을 풀고 스레드를 일시 정지 상태로 만든다.|
  |void|wait(long timeout)|객체의 잠금을 풀고 스레드를 일시 정지 상태로 만든다. 지정된 시간이 지나면 실행 대기 상태로 만든다.|
  |void|wait(long timeout, int nanos)|객체의 잠금을 풀고 스레드를 일시 정지 상태로 만든다. 지정된 시간이 지나면 실행 대기 상태로 만든다.|
  |void|notify()|wait()에 의해 일시 정지된 스레드 중 한 개를 실행 대기 상태로 만든다.|
  |void|notifyAll()|wait()에 의해 일시 정지된 모든 스레드들을 실행 대기 상태로 만든다. |
  |void|stop()|스레드를 즉시 종료 시킨다.|
### 6. 동기화(Synchronized)
* 동기화는 스레드가 사용 중인 객체의 작업이 끝날 때까지 사용 중인 객체에 잠금을 걸어서 다른 스레드가 접근할 수 없도록 한다.
* 자바는 동기화를 위해 동기화 메소드와 동기화 블록을 제공하는데 스레드가 객체 내부에 동기화 메소드 또는 동기화 블록을 실행하면 즉시 객체에 잠금을 걸어 다른 스레드가 객체에 접근하지 못하도록 한다.
* 동기화 메소드와 동기화 블록이 객체 내에 여러 개 있을 경우 스레드가 이들 중 하나를 실행하면 다른 스레드는 해당 메소드는 물론이고 객체 내의 다른 동기화 메소드 및 동기화 블록도 실행할 수 없다.
<br><br><img src="https://user-images.githubusercontent.com/26870393/163663476-7c518b79-288d-4a25-b4ba-0cb2087e7fac.png" width="700px"/><br>
* 동기화 메소드는 선언부에 synchronized 키워드를 붙이면 된다. 
    ```java
    // 메소드에 synchronized 키워드를 사용하여 동기화 메소드로 만든다.
    public synchronized void 메소드명() {

    }

    // 정적 메소드도 synchronized 키워드를 사용하여 동기화 메소드로 만들 수 있다.
    public static synchronized void 메소드명() {

    }
    ```
* 메소드 전체 내용이 아니라 일부 내용만 동기화하고 싶을 때는 동기화 블록을 만들면 된다. 
    ```java
    public void 메소드명() {
        ... 
        
        // 괄호() 안에는 공유 객체를 지정하는데 보통 this를 지정한다. 
        syschronized(this) { 
            ...
        }
    }
    ```




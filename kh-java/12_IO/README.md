## IO (Input/Output)

### 1. 입출력(IO)
* Input과 Output의 약자로 컴퓨터 내부 또는 외부 장치와 프로그램 간의 데이터를 주고받는 것을 입출력(IO)이라 한다.
* 데이터는 키보드, 파일 또는 네트워크로부터 입력될 수 있고 모니터, 파일 또는 네트워크로 출력 될 수 있다.
### 2. 스트림
* 자바에서 스트림은 입출력 장치에 데이터를 읽고 쓰기 위해서 제공하는 클래스이다.
* 스트림을 통해서 다양한 장치로부터 데이터 입출력에 대해 동일한 처리 방법을 제공한다.
* 모든 스트림은 단방향이며 각각의 장치마다 연결할 수 있는 스트림 존재한다.
<br><img src="https://user-images.githubusercontent.com/26870393/161754338-b9ac99c0-7be0-46fc-b9ec-28d448f6b6e4.png" width="800px"/><br>

#### 2.1. InputStream
* 바이트 기반 입력 스트림의 최상위 클래스로 추상 클래스이다.
* InputStream 스트림은 그림, 멀티미디어, 문자 등 모든 데이터를 입력받을 수 있다.
* InputStream을 상속받는 클래스들은 접미사로 InputStream이 붙는다.
  |최상위 클래스|하위 클래스|
  |:--:|:--:|
  |InputStream|FileInputStream|
  |InputStream|PipedInputStream|
  |InputStream|DataInputStream|
  |InputStream|BufferedInputStream|
  |InputStream|StringBufferedInputStream|
  |InputStream|ObjectInputStream|
* 외부 장치로부터 바이트 단위의 데이터를 읽어 올 수 있는 read() 추상 메소드가 정의되어 있다.
  |리턴 타입|메소드|
  |:--:|--|
  |int|read()|
  |int|read(byte[] b)|
  |int|read(byte[] b, int off, int len)|
  |void|close()|
* 사용한 시스템 자원 반납 후 입력 스트림을 닫는 close() 추상 메소드가 정의되어 있다.
#### 2.2. OutputStream
* 바이트 기반 출력 스트림의 최상위 클래스로 추상 클래스이다.
* OutputStream 스트림은 그림, 멀티미디어, 문자 등 모든 데이터를 출력할 수 있다.
* OutputStream을 상속받는 클래스들은 접미사로 OutputStream이 붙는다.
  |최상위 클래스|하위 클래스|
  |:--:|:--:|
  |OutputStream|FileOutputStream|
  |OutputStream|PipedOutputStream|
  |OutputStream|DataOutputStream|
  |OutputStream|BufferedOutputStream|
  |OutputStream|PrintStream|
  |OutputStream|ObjectOutputStream|
* 바이트 단위의 데이터를 외부 장치에 기록할 수 있는 write() 추상 메소드가 정의되어 있다.
  |리턴 타입|메소드|
  |:--:|--|
  |void|write(int b)|
  |void|write(byte[] b)|
  |void|write(byte[] b, int off, int len)|
* 버퍼에 잔류하는 모든 바이트를 출력하는 flush() 추상 메소드가 정의되어 있다.
* 사용한 시스템 자원 반납 후 출력 스트림을 닫는 close() 추상 메소드가 정의되어 있다.
#### 2.3. Reader
* 문자 기반 입력 스트림의 최상위 클래스로 추상 클래스이다.
* Reader는 문자 데이터만 입력받을 수 있다.
* Reader를 상속받는 클래스들은 접미사로 Reader가 붙는다.
  |최상위 클래스|하위 클래스|
  |:--:|:--:|
  |Reader|BufferedReader|
  |Reader|CharArrayReader|
  |Reader|InputStreamReader|
  |Reader|FileReader|
  |Reader|PipedReader|
  |Reader|StringReader|
* 외부 장치로부터 문자 단위의 데이터를 읽어 올 수 있는 read() 추상 메소드가 정의되어 있다.
  |리턴 타입|메소드|
  |:--:|--|
  |int|read()|
  |int|read(char[] c)|
  |int|read(char[] c, int off, int len)|
  |void|close()|
* 사용한 시스템 자원 반납 후 입력 스트림을 닫는 close() 추상 메소드가 정의되어 있다.
#### 2.4. Writer
* 문자 기반 출력 스트림의 최상위 클래스로 추상 클래스이다.
* Writer는 문자 데이터만 출력할 수 있다.
* Writer를 상속받는 클래스들은 접미사로 Writer가 붙는다.
  |최상위 클래스|하위 클래스|
  |:--:|:--:|
  |Writer|BufferedWriter|
  |Writer|CharArrayWriter|
  |Writer|OutputStreamWriter|
  |Writer|FileWriter|
  |Writer|PipedWriter|
  |Writer|StringWriter|
* 문자 단위의 데이터를 외부 장치에 기록할 수 있는 write() 추상 메소드가 정의되어 있다.
  |리턴 타입|메소드|
  |:--:|--|
  |void|write(int c)|
  |void|write(char[] c)|
  |void|write(char[] c, int off, int len)|
  |void|write(String str)|
  |void|write(String str, int off, int len)|
* 버퍼에 잔류하는 모든 문자열을 출력하는 flush() 추상 메소드가 정의되어 있다.
* 사용한 시스템 자원 반납 후 출력 스트림을 닫는 close() 추상 메소드가 정의되어 있다.
### 3. File 클래스
* 파일 시스템의 파일을 표현하는 클래스이다.
* 파일 크기, 파일 속성, 파일 이름 등의 정보를 얻어오는 것과 파일의 생성 및 삭제 기능을 제공한다.
* 데이터를 읽고 쓰는 기능은 지원하지 않는다.
* 파일의 데이터를 읽고 쓰기 위해서는 파일 관련 입출력 스트림을 사용해야 한다.
  ```java
  // 파일 객체를 생성했다고 해서 파일이나 디렉토리가 생성되는 것은 아니다.
  File file = new File("C:/data/test.txt");

  // createNewFile() 메소드를 호출해서 실제 파일을 생성한다.
  file.createNewFile();
  ```
### 4. 파일 관련 입출력 스트림
#### 4.1. FileInputStream
* InputStream의 하위 클래스로 파일로부터 바이트 단위로 데이터를 입력받는 클래스이다.
* FileInputStream은 그림, 오디오, 비디오, 텍스트 파일 등 모든 종류의 파일의 읽기가 가능하다.
  ```java
  // FileInputStream 객체가 생성될 때 파일과 직접 연결된다.
  // 실제 파일이 존재하지 않으면 FileNotFoundException이 발생한다.
  FileInputStream fis = new FileInputStream("C:/data/test.txt");
  ```
#### 4.2. FileOutputStream
* OutputStream의 하위 클래스로 바이트 단위로 데이터를 파일에 출력하는 클래스이다.
* FileOutputStream은 그림, 오디오, 비디오, 텍스트 파일 등 모든 종류의 파일로 저장이 가능하다.
  ```java
  // FileOutputStream 객체가 생성될 때 파일과 직접 연결된다.
  // 실제 파일이 존재하지 않으면 자동으로 생성하지만 이미 파일이 존재하는 경우 파일을 덮어쓴다.
  FileOutputStream fos = new FileOutputStream("C:/data/test.txt");
  ```
  ```java
  // 이미 존재하는 파일에 이어서 계속 작성하고 싶다면 아래 예제처럼 객체를 생성한다.
  FileOutputStream fos = new FileOutputStream("C:/data/test.txt", true);
  ```
#### 4.3. FileReader
* Reader의 하위 클래스로 텍스트 파일로부터 문자 단위로 데이터를 입력받는 클래스이다.
* FileReader는 텍스트가 아닌 그림, 오디오, 비디오 등의 파일은 읽기가 불가능하다.
  ```java
  // FileReader 객체가 생성될 때 파일과 직접 연결된다.
  // 실제 파일이 존재하지 않으면 FileNotFoundException이 발생한다.
  FileReader fr = new FileReader("C:/data/test.txt");
  ```
#### 4.4. FileWriter
* Writer의 하위 클래스로 문자 단위로 데이터를 텍스트 파일에 출력하는 클래스이다.
* FileWriter는 텍스트가 아닌 그림, 오디오, 비디오 등의 파일에 저장이 불가능하다.
  ```java
  // FileWriter 객체가 생성될 때 파일과 직접 연결된다.
  // 실제 파일이 존재하지 않으면 자동으로 생성하지만 이미 파일이 존재하는 경우 파일을 덮어쓴다.
  FileWriter fw = new FileWriter("C:/data/test.txt");
  ```
  ```java
  // 이미 존재하는 파일에 이어서 계속 작성하고 싶다면 아래 예제처럼 객체를 생성한다.
  FileWriter fw = new FileWriter("C:/data/test.txt", true);
  ```
### 6. 보조 스트림
* 보조 스트림은 기반 스트림(InputStream, OutputStream, Reader, Writer)의 기능을 향상시키거나 새로운 기능을 추가하기 위해 사용한다.
* 보조 스트림은 실제 데이터를 주고받는 스트림이 아니기 때문에 입출력 처리 불가능하다.
* 보조 스트림은 반드시 기반 스트림(InputStream, OutputStream, Reader, Writer)을 먼저 생성한 후 이를 이용하여 보조 스트림 생성해야 한다.
#### 6.1. 문자 변환 보조 스트림
* 기반 스트림이 바이트 기반 스트림이지만 데이터가 문자일 경우에 사용한다.
* InputStreamReader는 바이트 기반의 InputStream에 연결되어 문자 기반의 Reader로 변환하는 보조 스트림이다.
<br><img src="https://user-images.githubusercontent.com/26870393/162209498-ddc7135c-9f63-4edb-9194-0e267bb114e5.png"/><br>
* OutputStreamWriter는 바이트 기반의 OutputStream에 연결되어 문자 기반의 Writer로 변환하는 보조 스트림이다.
<br><img src="https://user-images.githubusercontent.com/26870393/162209533-7fe72fa5-74f8-40ea-8c90-c91a955169fa.png"/><br>
#### 6.2. 성능 향상 보조 스트림
* 입출력 성능에 영향을 미치는 입출력 장치(하드디스크, 네트워크 등)를 이용하는 경우에 사용한다.
* 입출력 장치(하드디스크, 네트워크 등)와 직접 작업하지 않고 버퍼에 데이터를 모아 한 번에 입출력 작업을 하여 성능을 향상한다.
* BufferedInputStream(BufferedReader)은 외부의 입력 장치로부터 데이터를 직접 읽지 않고 버퍼에 쌓아두었다가 데이터를 한 번에 읽음으로써 읽기 성능을 향상시키는 보조 스트림이다.
<br><img src="https://user-images.githubusercontent.com/26870393/162209289-46a79077-57a6-48e9-a4f1-034705859a9b.png"/><br>
* BufferedOutputStream(BufferedWriter)은 외부의 출력 장치로 데이터를 직접 출력하지 않고 버퍼에 쌓아두었다가 데이터를 한 번에 전송함으로써 출력 성능을 향상시키는 보조 스트림이다.
<br><img src="https://user-images.githubusercontent.com/26870393/162209360-ffc7cc6c-1166-47da-ac9e-035454b6d852.png"/><br>
#### 6.3. 기본 타입 입출력 보조 스트림
* 입출력 장치로 기본 자료형의 데이터를 읽고 출력하는 경우에 사용한다.
* 단, 입력된 자료형의 순서와 출력될 자료형의 순서가 일치해야 한다.
* DataInputStream은 바이트 기반의 데이터를 기본 자료형의 데이터로 읽을 수 있는 보조 스트림이다.
* DataOutputStream은 바이트 기반의 데이터를 기본 자료형의 데이터로 출력할 수 있는 보조 스트림이다.
<br><img src="https://user-images.githubusercontent.com/26870393/162209127-36eedb57-c6b9-4019-81cf-cc4b17cfe64c.png"/><br>
#### 6.4. 객체 입출력 보조 스트림
* 입출력 장치로 객체를 읽고 출력하는 경우에 사용한다.
* 단, 객체는 문자가 아니므로 바이트 기반 스트림으로 데이터를 변경해 주는 직렬화가 필수이다.
  * 직렬화란 스트림을 통해서 객체를 출력하기 위해 연속적인 데이터로 변환하는 것을 말한다.
  * 역직렬화란 스트림을 통해서 읽어들인 연속적인 데이터를 객체로 복원하는 것을 말한다.
* ObjectInputStream은 InputStream에 연결되어 객체를 역직렬화하는 보조 스트림이다.
* ObjectOutputStream은 OutputStream에 연결되어 객체를 직렬화하는 보조 스트림이다.
<br><img src="https://user-images.githubusercontent.com/26870393/162208945-30a80f84-e99c-416b-9d97-b14e5b352e8b.png"/><br>

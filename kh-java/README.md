# 자바 수업자료

## 1. 프로그래밍 기초
### 1.1. 프로그램
* 컴퓨터 프로그램이란 컴퓨터에게 특정 문제를 해결하기 위해 처리 방법과 순서를 기술해 놓은 작업지시서(명령문의 집합)이다.
### 1.2. 프로그래밍
* 프로그램의 목적에 따라 기능별 순서와 처리 방법을 설계하고 구현하는 것이다.
### 1.3. 프로그래머
* 프로그램을 설계하고 코딩하는 사람(프로그래밍)을 하는 사람을 뜻한다.
### 1.4. 프로그래밍 언어
* 사람의 언어와 기계의 언어의 중간 다리 역할을 하는 언어가 프로그래밍 언어이다.
* 프로그래밍 언어는 고급 언어와 저급 언어로 구분된다. (고급 언어일수록 사람이 이해하기 쉽고, 컴파일러라는 번역 도구가 필요)
* 프로그래밍 언어로 작성된 내용을 소스(Source)라고 부르고, 이 소스는 컴파일러(Compiler)라는 소프트웨어를 통해서 기계어로 변환된 후 컴퓨터에서 실행할 수 있게 된다.
## 2. 자바(Java)
### 2.1. 자바란?
* 1995년 썬 마이크로시스템즈의 제임스 고슬링(James Gosling)과 연구원들에 의해 개발한 개발된 객체지향 프로그래밍 언어로 전 세계적으로 다양한 분야에서 사용되고 있다.
* 2009년 4월 20일 썬 마이크로시스템즈가 오라클과 인수 합병되면서 자바는 오라클로 넘어가게 되었다.
### 2.2. 자바의 특징
* 객체 지향 프로그래밍(Object-Oriented Programming, OOP) 언어이다.
  * 객체 지향 프로그래밍은 프로그램을 개발하는 기법 중 하나로 객체들을 만들고 이러한 객체들을 연결해서 전체 프로그램을 완성하는 기법이다. 
* 운영체제에 독립적이다.
  * 자바 언어로 개발된 프로그램은 소스를 수정하지 않아도, 자바 실행 환경(JRE, Java Runtime Environment)이 설치되어 있는 모든 운영체제에서는 실행이 가능하다.
* 자동으로 메모리를 관리한다.
  * 자바는 개발자가 직접 메모리에 접근할 수 없도록 설계되었으며, 메모리는 자바가 가비지 컬렉터(Garbage Collector, GC)를 활용하여 직접 관리한다.
* 네트워크와 분산처리를 지원한다.
  * 다양한 종류의 네트워크와 관련된 API(Application Programing Interface)를 제공한다.
* 멀티 스레드를 지원한다.
  * 하나의 프로그램이 동시에 여러 가지 작업을 처리할 수 있도록 멀티 스레드를 지원한다.
* 동적 로딩을 지원한다.
  * 프로그램 실행 시 관련된 모든 파일을 메모리에 올리지(로딩) 않고 필요한 시점에 필요한 파일을 로딩한다. 
### 2.3. JVM(Java Virtual Machine)
* Windows, Linux, MacOS와 같은 운영체제(OS)에서는 자바 프로그램을 직접 실행할 수 없으며 JVM을 통해 자바 프로그램을 실행할 수 있다.
* JVM은 JDK(Java Development Kit) 또는 JRE(Java Runtime Environment)를 설치하면 자동으로 설치되는데 JDK와 JRE는 운영체제에 별로 제공되고 운영체제에 맞게 설치해야 한다.
* JVM이 설치된 환경에서 자바 프로그램을 실행하기 때문에 개발자는 운영체제와 상관없이 자바 프로그램을 개발할 수 있다. ("Write Once, Run Anywhere", 한 번 작성하면 어디서든 실행된다.)
### 2.4. 자바 프로그램의 실행 단계
* 확장자가 .java인 소스파일 작성을 작성한다.  
* 작성된 소스파일을 자바 컴파일러로 컴파일하여 확장자가 .class인 바이트코드(기계어)로 번역한다.
* 번역된 바이트코드(기계어)를 JVM에서 실행한다.
## 3. 자바 개발 환경 구축
### 3.1. 자바 설치
* JDK(Java Development Kit)
  * 자바 프로그램을 개발하기 위해서는 JDK(Java Development Kit)를 설치해야 한다. 
  * JDK는 프로그램 개발에 필요한 JRE(JVM), 라이브러리 API, 컴파일러 등의 개발 도구가 포함되어 있다.
* JRE(Java Runtime Environment)
  * 자바 프로그램 실행에 필요한 JVM, 라이브러리 API만 포함되어 있다.
  * 자바 프로그램을 개발하는 것이 아닌 프로그램을 실행만 한다면 JRE만 설치하면 된다.  
* JDK의 종류
  * Java SE(Standard Edition)
  * Java EE(Enterprise Edition)
  * Java ME(Micro Edition)
* JDK 설치
  * 오라클 JDK의 경우 유료이기 때문에 Temurin OpenJDK를 설치한다.
  * https://adoptium.net/ 접속 후 Temurin 11 (LTS)를 다운로드 및 설치를 한다.
  * 설치가 완료되면 "명령 프로롬트" 실행 후 아래의 명령어를 입력하여 JDK가 정상적으로 설치되었는지 확인한다.
    ```
    > java -version
    openjdk version "11.0.14.1" 2022-02-08
    OpenJDK Runtime Environment Temurin-11.0.14.1+1 (build 11.0.14.1+1)
    OpenJDK 64-Bit Server VM Temurin-11.0.14.1+1 (build 11.0.14.1+1, mixed mode)

    > javac -version
    javac 11.0.14.1
    ```
### 3.2. IDE 설치 
* IDE(Integrated Development Environment)
  * IDE는 프로그램 개발에 필요한 기능을 통합해서 제공해 주는 프로그램이다.
  * IDE는 소스 코드 편집기, 빌드 자동화, 코드 실행, 디버거 등의 기능을 제공해 준다.
* Eclipse IDE 설치
  * https://www.eclipse.org/downloads/ 접속 후 최신 버전의 Eclipse IDE를 다운로드한다.
  * 다운로드된 Installer 실행 후 Eclipse IDE for Enterprise Java Developers로 설치한다.
* JDK 설정
  * 상단 메뉴 -> Window -> Preferences에서 Compiler 검색 후 Compiler compliance level을 11로 변경한다.
  * 상단 메뉴 -> Window -> Preferences에서 Installed JREs 검색 후 앞에서 설치 한 JDK의 경로에서 JRE를 찾아서 지정한다.
* Encoding 설정
  * 상단 메뉴 -> Window -> Preferences에서 Encoding 검색 후 검색된 항목의 Encoding을 UTF-8로 변경한다.

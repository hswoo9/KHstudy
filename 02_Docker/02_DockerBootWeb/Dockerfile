# 베이스 이미지를 openjdk:11로 지정
FROM openjdk:11
# 작성자 라벨 설정
LABEL maintainer "kh<ismoon@iei.or.kr>"
# 버전 라벨 설정
LABEL version "1.0"
# 컨테이너의 /root에 SpringBoot_Web.jar 파일 복사
COPY SpringBoot_Web.jar /root
# docker build 명령어 실행 시 Dockerfile 내부로 값을 전달 받을 수 있는 PROFILE 변수 선언
ARG PROFILE=dev
# docker build 명령어 실행 시 Dockerfile 내부로 값을 전달 받을 수 있는 PORT 변수 선언
ARG PORT=8088
# Timezone 환경변수를 Asia/Seoul로 변경
ENV TZ=Asia/Seoul
# ARG는 이미지 빌드 시에만 적용되고 실제 컨테이너에서는 사용할 수 없기 때문에 입력받은 값을 ENV를 통해서 전달한다.
ENV PROFILE=${PROFILE}
EXPOSE ${PORT}
# 작업 디렉터리를 /root
WORKDIR /root
# 환경변수 설정 여부 확인
# RUN ["echo", "${TZ}"]
# 작업 디렉터리 변경 여부 확인
RUN pwd
# 컨테이너 실행 시 SpringBoot_Web.jar 파일 실행
CMD ["java", "-jar", "SpringBoot_Web.jar", "--spring.profiles.active=${PROFILE}"]
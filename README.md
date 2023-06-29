# MQTT Publisher

## 개요
MQTT 브로커로 REST API를 통해서 요청받은 메시지를 발행하는 아주 간단한 애플리케이션입니다.

### 기능 정의

애플리케이션에 구현할 기능은 다음과 같습니다.

* MQTT 브로커 서버와 자동 연결<BR>
  애플리케이션이 구동될 때 지정된 MQTT 브로커 서버와 자동으로 연결이 됩니다. MQTT 브로커 서버의 URL과 통신포트 번호는 resource/application.properties로부터 참조합니다.

* 메시지 발행<BR>
  문자열 형식의 메시지를 토픽과 함께 REST API로 전달하여 MQTT 브로커에 발행합니다. 발행이 완료된 메시지와 토픽은 REST API의 응답으로 다시 반환됩니다.
 
> **참고)** 스터디 차원에서 개발하는 어플리케이션이기 때문에 MQTT Broker 서버에 메시지를 발행할 때 익명접속을 허용합니다. SSL이나 사용자 계정 확인 등의 보안 기능은 사용하지 않습니다.

### 개발 환경

애플리케이션은 윈도우10이 설치되어 있는 개발 PC에서 개발했고, 테스트를 위해 MQTT 브로커를 여분으로 가지고 있던 라즈베리파이에 설치하여 사용했습니다. (MQTT 브로커는 개발 PC에 함께 설치해서 사용해도 상관없습니다.)

#### 개발 PC : 어플리케이션 개발 및 실행
* Windows 10
* Open JDK18 / Springboot 3.1.0
* IntelliJ

#### 라즈베리파이 : MQTT Broker 실행
* Raspbian(Raspberry Pi OS)
* mosquitto & mosquitto-clients

> **참고)** mosquitto는 많은 사용자를 보유하고 있는 대표적인 오픈소스 MQTT 브로커 중 하나입니다.

## API

```POST``` **MQTT 브로커에 메시지 발행**
```bash
http://127.0.0.1:8080/message
```
### Request Body

| Key | Value |
|-----|-------|
|"topic"| 메시지에 할당된 토픽 |
|"message"|MQTT브로커에 전달할 메시지|

Request Body 예시
```json
{
	"topic":"test",
	"message":"hello,world!!"
}
```
### Response Body

Request Body와 동일합니다.

### Example

```bash
$ curl -X 'POST' \
'http://127.0.0.1:8080/message' \
-H 'accept: application/json' \
-H 'Content-Type: application/json' \
-d '{"topic":"test","message":"hello"}'
```

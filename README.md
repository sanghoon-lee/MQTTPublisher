# MQTTPublisher

## 개요
스프링부트 프레임워크를 이용하여 개발된 MQTT Broker에 문자열 형식의 메시지를 발행하는 기능을 가진 아주 간단한 MQTT Message Publisher 어플리케이션입니다.

### 기능 정의

* 어플리케이션 구동시 MQTT Broker 서버와 연결 
> 어플리케이션이 구동되는 시점에 지정된 MQTT Broker 서버와 연결을 시도합니다. MQTT Broker 서버와 연결이 성공하면 언제든지 MQTT Broker 서버에 메시지를 발행할 수 있도록 연결 상태를 유지합니다.
> 만약, MQTT Broker 서버와의 연결이 끊어지게 된 것을 어플리케이션이 감지하게 된다면 자동적으로 재연결이 시도됩니다. 
* MQTT Broker 서버 연결 정보 설정
> resource/application.properties에 MQTT Broker 서버의 URL과 통신포트 번호를 지정하고, 어플리케이션이 MQTT Broker 서버와 연결하기 전에 해당 정보를 참조할 수 있도록 합니다.
* MQTT Broker 서버와의 연결상태 조회
> MQTT Broker와 연결 상태(Connected or Disconnected)를 조회할 수 있도록 REST API를 제공합니다.
* 메시지 발행
> 연결된 MQTT Broker 서버에 원하는 메시지를 발행할 수 있도록 REST API를 제공합니다. 
> 
> **참고)** 스터디 차원에서 개발한 어플리케이션이기 때문에 MQTT Broker 서버에 메시지를 발행할 때 익명접속을 허용합니다. SSL이나 사용자 계정 확인 등의 보안 기능은 사용하지 않습니다.

### 개발 환경

어플리케이션은 윈도우10이 설치되어 있는 개발PC에서 개발하였고, 테스트를 위해서 필요한 MQTT Broker는 집에 여분으로 가지고 있던 라즈베리파이에 설치하여 사용하였습니다.

#### 개발 PC : 어플리케이션 개발 및 실행
* Windows 10
* Open JDK18 / Springboot 3.1.0
* IntelliJ

#### 라즈베리파이 : MQTT Broker 실행
* Raspbian(Raspberry Pi OS)
* mosquitto & mosquitto-clients

> **참고)** MQTT Broker는 어플리케이션을 개발하는 PC에 설치해서 사용해도 상관없습니다.

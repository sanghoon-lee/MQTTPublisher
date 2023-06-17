package sanghoon.study.MQTTPublisher.domain;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class MQTTMessage {
    // MQTT 토픽명
    private String topic;
    // MQTT 수신시간
    private String receivedTime;
    // MQTT 메시지
    private String message;

    public MQTTMessage(String topic,String receivedTime,String message){
        this.topic = topic;
        this.receivedTime = receivedTime;
        this.message = message;
    }

    public String toString(){
        return "Topic : "+this.topic+", Received Time : "+receivedTime+", Message : "+message;
    }

    public Map<String, String> getMessage() {
        Map<String, String> payload = new HashMap<String, String>();
        payload.put("topic",getTopic());
        payload.put("receivedTime",getReceivedTime());
        payload.put("message",message);

        return payload;
    }
}

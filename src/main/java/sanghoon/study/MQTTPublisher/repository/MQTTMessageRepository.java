package sanghoon.study.MQTTPublisher.repository;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class MQTTMessageRepository implements MessageRepository{
    // MQTT 메시지의 토픽명
    private String topic;
    // MQTT 메시지의 수신시간
    private String receivedTime;
    // MQTT 메시지의 데이터
    private String data;

    public MQTTMessageRepository(String topic,String receivedTime,String data){
        this.topic = topic;
        this.receivedTime = receivedTime;
        this.data = data;
    }

    public String toString(){
        return "Topic : "+this.topic+", Received Time : "+receivedTime+", Data : "+data;
    }

    @Override
    public Map<String, String> getMessage() {
        Map<String, String> message = new HashMap<String, String>();
        message.put("topic",getTopic());
        message.put("receivedTime",getReceivedTime());
        message.put("data",data);

        return message;
    }
}

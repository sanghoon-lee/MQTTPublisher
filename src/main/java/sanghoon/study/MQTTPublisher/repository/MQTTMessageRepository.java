package sanghoon.study.MQTTPublisher.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sanghoon.study.MQTTPublisher.beans.MQTTConnector;
import sanghoon.study.MQTTPublisher.domain.MQTTMessage;

import java.util.Map;

@Slf4j
@Repository
public class MQTTMessageRepository implements MessageRepository{
    private final MQTTConnector mqttConnector;

    @Autowired
    public MQTTMessageRepository(MQTTConnector mqttConnector){
        this.mqttConnector = mqttConnector;
    }

    @Override
    public void publish(Map<String, String> message) {
        if(mqttConnector.isConnected()==false){
            log.error("MQTT Broker is not connected");
            return;
        }

        //MQTTMessage message = new MQTTMessage()
    }

    public void publish(MQTTMessage message){
        publish(message.getMessage());
    }
}

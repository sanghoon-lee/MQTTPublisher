package sanghoon.study.MQTTPublisher.beans;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class MQTTManager {
    @Value("${mqtt.broker.host}")
    private String host;    // application.properties 파일에서 mqtt.broker.host 항목의 값

    @Value("${mqtt.broker.port}")
    private int port;       // application.properties 파일에서 mqtt.broker.port 항목의 값

    private MqttAsyncClient mqttClient;

    @PostConstruct
    public void init(){
        log.info("host : "+host+", port : "+String.valueOf(port));

        String uuid = UUID.randomUUID().toString();
        try{
            String brokerURI = "tcp://"+host+":"+String.valueOf(port);
            mqttClient = new MqttAsyncClient(brokerURI,uuid);
            MqttConnectOptions connOpt = new MqttConnectOptions();
            connOpt.setCleanSession(true);
            mqttClient.connect(connOpt);
        } catch(MqttException e){
            e.printStackTrace();
        }

    }
}

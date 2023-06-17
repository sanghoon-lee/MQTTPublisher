package sanghoon.study.MQTTPublisher.beans;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sanghoon.study.MQTTPublisher.domain.MQTTMessage;

import java.util.UUID;

@Slf4j
@Component
public class MQTTConnector implements MqttCallback {
    @Value("${mqtt.broker.host}")
    private String host;    // application.properties 파일에서 mqtt.broker.host 항목의 값

    @Value("${mqtt.broker.port}")
    private int port;       // application.properties 파일에서 mqtt.broker.port 항목의 값

    private boolean connected;
    private MqttAsyncClient mqttClient;

    @PostConstruct
    public void init(){
        this.connected = false;

        String uuid = UUID.randomUUID().toString();
        String brokerURI = getBrokerURI();
        MqttConnectOptions connOpt = new MqttConnectOptions();
        connOpt.setCleanSession(true);
        connOpt.setKeepAliveInterval(5);

        log.info("MQTT Broker URI : "+brokerURI);

        try{
            mqttClient = new MqttAsyncClient(brokerURI,uuid);
            mqttClient.setCallback(this);
            mqttClient.connect(connOpt);
        } catch(MqttException e){
            log.error("MQTT Broker connection is failure : "+e.getMessage());
            return;
        }

        log.info("MQTT Broker connection is okay");
        this.connected = true;
    }

    private String getBrokerURI(){
        return "tcp://"+host+":"+String.valueOf(port);
    }

    public boolean isConnected(){
        return this.connected;
    }

    public void publish(MQTTMessage message){

    }

    @Override
    public void connectionLost(Throwable cause) {

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }
}

package sanghoon.study.MQTTPublisher.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MessageRepository {
    public void publish(Map<String,String> message);
}

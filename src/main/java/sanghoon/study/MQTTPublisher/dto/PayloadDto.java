package sanghoon.study.MQTTPublisher.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayloadDto {
    private String topic; // 토픽
    private String message; // 메시지
}

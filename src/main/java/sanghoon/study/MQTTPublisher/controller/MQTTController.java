package sanghoon.study.MQTTPublisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sanghoon.study.MQTTPublisher.dto.PayloadDto;
import sanghoon.study.MQTTPublisher.service.MQTTService;

@Controller
public class MQTTController {
    private final MQTTService mqttService;

    @Autowired
    public MQTTController(MQTTService mqttService){
        this.mqttService = mqttService;
    }

    @RequestMapping(value="/message",method=RequestMethod.POST)
    public @ResponseBody PayloadDto publish(@RequestBody PayloadDto payloadDto){
        return mqttService.publish(payloadDto);
    }
}

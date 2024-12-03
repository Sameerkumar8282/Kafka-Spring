package com.deliveryboy.deliveryBoy.service;

import com.deliveryboy.deliveryBoy.config.AppConstants;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public boolean updateLocation(String location){
        //topic name and location
        for(int i =0 ; i< 200000;i++) {
            this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
        }
        System.out.println("Location Produced");
        return true;
    }
}

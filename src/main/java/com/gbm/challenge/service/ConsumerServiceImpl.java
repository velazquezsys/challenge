package com.gbm.challenge.service;

import com.gbm.challenge.model.PositionMdl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 21:48
 * @email <velazquez.sys at gmail.com>
 */


@Slf4j
@Service
public class ConsumerServiceImpl implements ConsumerService {


    private final RestTemplate restTemplate;

    @Value("${endpoint.consumer}")
    private String endpointConsumer;

    public ConsumerServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    @Async
    public void processMessage(PositionMdl positionMdl) {

        ResponseEntity<String> entity;

        log.debug("position update is received for the vehicle id:{}", positionMdl.getVehicleId());

        entity = restTemplate.postForEntity(endpointConsumer, positionMdl, String.class);

        log.debug("update delivery result, code: {}, body: {}", entity.getStatusCode(), entity.getBody());
    }

    @Override
    public String receivePosition(PositionMdl positionMdl) {

        String message;
        message = "received position update";

        //TODO any business logic

        return message;
    }
}

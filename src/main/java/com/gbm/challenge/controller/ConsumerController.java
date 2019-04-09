package com.gbm.challenge.controller;

import com.gbm.challenge.model.PositionMdl;
import com.gbm.challenge.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.gbm.challenge.constant.EndPoint.API;
import static com.gbm.challenge.constant.EndPoint.VERSION;

/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 21:43
 * @email <velazquez.sys at gmail.com>
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(API + VERSION)
public class ConsumerController {

    private final ConsumerService consumerService;

    @PostMapping("/consumer/position")
    public ResponseEntity<String> savePosition(@Valid @RequestBody PositionMdl positionMdl) {

        String response;

        log.debug("receiving new vehicle position");

        response = consumerService.receivePosition(positionMdl);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

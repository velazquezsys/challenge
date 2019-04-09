package com.gbm.challenge.controller;

import com.gbm.challenge.domain.Position;
import com.gbm.challenge.model.PositionMdl;
import com.gbm.challenge.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.gbm.challenge.constant.EndPoint.API;
import static com.gbm.challenge.constant.EndPoint.VERSION;

/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 20:27
 * @email <velazquez.sys at gmail.com>
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(API + VERSION)
public class PositionController {

    private final PositionService positionService;

    @PostMapping("/position")
    public ResponseEntity<String> savePosition(@Valid @RequestBody PositionMdl positionMdl) {

        String result;

        log.debug("saving new vehicle position");

        result = positionService.savePosition(positionMdl);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/position")
    public ResponseEntity<Position> savePosition(@RequestParam Long vehicle) {

        Position result;

        log.debug("consulting vehicle position");

        result = positionService.getPosition(vehicle);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}

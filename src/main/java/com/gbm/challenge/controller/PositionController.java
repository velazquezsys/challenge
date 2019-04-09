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
import java.util.List;

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

        String response;

        log.debug("saving new vehicle position");

        response = positionService.savePosition(positionMdl);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/position")
    public ResponseEntity<Position> savePosition(@RequestParam Long vehicle) {

        Position response;

        log.debug("consulting vehicle position");

        response = positionService.getPosition(vehicle);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/position/history")
    public ResponseEntity<List<Position>> getVehicleHistorical(@RequestParam Long vehicle) {

        List<Position> response;

        log.debug("consulting historical vehicle position");

        response = positionService.getHistoricalPosition(vehicle);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

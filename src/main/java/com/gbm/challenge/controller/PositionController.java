package com.gbm.challenge.controller;

import com.gbm.challenge.model.PositionMdl;
import com.gbm.challenge.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.gbm.challenge.constant.EndPoint.API;
import static com.gbm.challenge.constant.EndPoint.VERSION;

/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 20:27
 * @email <velazquez.sys at gmail.com>
 */


@RequiredArgsConstructor
@RestController
@RequestMapping(API + VERSION)
public class PositionController {

    private final PositionService positionService;

    @PostMapping("position")
    public void savePosition(@Valid @RequestBody PositionMdl positionMdl) {

        positionService.savePosition(positionMdl);
    }


}

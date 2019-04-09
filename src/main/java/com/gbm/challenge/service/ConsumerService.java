package com.gbm.challenge.service;

import com.gbm.challenge.model.PositionMdl;

/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 21:48
 * @email <velazquez.sys at gmail.com>
 */

public interface ConsumerService {

    void processMessage(PositionMdl positionMdl);

    String receivePosition(PositionMdl positionMdl);
}

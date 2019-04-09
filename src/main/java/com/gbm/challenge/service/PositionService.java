package com.gbm.challenge.service;

import com.gbm.challenge.domain.Position;
import com.gbm.challenge.model.PositionMdl;

import java.util.List;

/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 20:37
 * @email <velazquez.sys at gmail.com>
 */
public interface PositionService {

    String savePosition(PositionMdl positionMdl);

    Position getPosition(Long vehicleId);

    List<Position> getHistoricalPosition(Long vehicleId);

}

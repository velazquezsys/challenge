package com.gbm.challenge.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 20:33
 * @email <velazquez.sys at gmail.com>
 */

@Data
public class PositionMdl {

    @NotNull(message = "{position.vehicleId.notNull}")
    @Positive
    Long vehicleId;

    @NotNull(message = "{position.latitude.notNull}")
    Long latitude;

    @NotNull(message = "{position.longitude.notNull}")
    Long longitude;

}

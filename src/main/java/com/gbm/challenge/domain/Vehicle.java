package com.gbm.challenge.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 20:42
 * @email <velazquez.sys at gmail.com>
 */

@Data
@Entity
@Table
public class Vehicle implements Serializable {

    @Id
    private Long id;

}

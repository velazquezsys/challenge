package com.gbm.challenge.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 20:42
 * @email <velazquez.sys at gmail.com>
 */


@NoArgsConstructor
@Data
@Entity
@Table
public class Position implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long latitude;

    private Long longitude;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date update;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private Vehicle vehicle;
}

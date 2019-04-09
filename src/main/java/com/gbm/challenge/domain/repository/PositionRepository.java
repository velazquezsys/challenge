package com.gbm.challenge.domain.repository;

import com.gbm.challenge.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 20:43
 * @email <velazquez.sys at gmail.com>
 */

public interface PositionRepository extends JpaRepository<Position, Long> {

    Optional<Position> findFirstByVehicleIdOrderByIdDesc(@Param("vehicleId") Long vehicleId);

    List<Position> findAllByVehicleId(@Param("vehicleId") Long vehicleId);
}

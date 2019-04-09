package com.gbm.challenge.service;

import com.gbm.challenge.domain.Position;
import com.gbm.challenge.domain.Vehicle;
import com.gbm.challenge.domain.repository.PositionRepository;
import com.gbm.challenge.domain.repository.VehicleRepository;
import com.gbm.challenge.model.PositionMdl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 20:37
 * @email <velazquez.sys at gmail.com>
 */

@RequiredArgsConstructor
@Service
public class PositionServiceImpl implements PositionService {

    private final VehicleRepository vehicleRepository;
    private final PositionRepository positionRepository;

    @Override
    public String savePosition(PositionMdl positionMdl) {

        String result;
        Optional<Vehicle> vehicle;
        Position position;

        vehicle = vehicleRepository.findById(positionMdl.getVehicleId());

        if (vehicle.isPresent()) {

            position = new Position();
            position.setLatitude(positionMdl.getLatitude());
            position.setLongitude(positionMdl.getLatitude());
            position.setVehicle(vehicle.get());

            positionRepository.save(position);

            result = "position of the vehicle was saved correctly";
        } else {
            result = "vehicle not found";
        }

        return result;
    }

    @Override
    public Position getPosition(Long vehicleId) {

        Position position;
        Optional<Position> optionalPosition;

        optionalPosition = positionRepository.findFirstByVehicleIdOrderByIdDesc(vehicleId);
        position = optionalPosition.orElseGet(Position::new);

        return position;
    }
}

package com.gbm.challenge.service;

import com.gbm.challenge.domain.Position;
import com.gbm.challenge.domain.Vehicle;
import com.gbm.challenge.domain.repository.PositionRepository;
import com.gbm.challenge.domain.repository.VehicleRepository;
import com.gbm.challenge.model.PositionMdl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Carlos Ever Isa\u00ed Vel\u00e1zquez Espinosa on 2019-04-08 20:37
 * @email <velazquez.sys at gmail.com>
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class PositionServiceImpl implements PositionService {

    private final VehicleRepository vehicleRepository;
    private final PositionRepository positionRepository;
    private final ConsumerService consumerService;

    @Override
    public String savePosition(PositionMdl positionMdl) {

        String result;
        Optional<Vehicle> vehicle;
        Position position;

        vehicle = vehicleRepository.findById(positionMdl.getVehicleId());

        if (vehicle.isPresent()) {

            log.debug("vehicle found, saving new position");

            position = new Position();
            position.setLatitude(positionMdl.getLatitude());
            position.setLongitude(positionMdl.getLongitude());
            position.setVehicle(vehicle.get());

            positionRepository.save(position);

            log.debug("sending real-time notification of vehicle position update ");
            //Async method
            consumerService.processMessage(positionMdl);

            result = "position of the vehicle was saved correctly";
        } else {
            log.debug("vehicle not found id:{}", positionMdl.getVehicleId());
            result = "vehicle not found";
        }

        return result;
    }

    @Override
    public Position getPosition(Long vehicleId) {

        Position position;
        Optional<Position> optionalPosition;

        log.debug("consulting vehicle: {} position", vehicleId);

        optionalPosition = positionRepository.findFirstByVehicleIdOrderByIdDesc(vehicleId);
        position = optionalPosition.orElseGet(Position::new);

        return position;
    }

    @Override
    public List<Position> getHistoricalPosition(Long vehicleId) {

        log.debug("consulting historical vehicle: {} position", vehicleId);

        return positionRepository.findAllByVehicleId(vehicleId);
    }
}

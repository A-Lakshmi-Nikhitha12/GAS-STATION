package com.Nikhitha.StationProjectFullStack.Controller;

import com.Nikhitha.StationProjectFullStack.Exception.StationNotFoundException;
import com.Nikhitha.StationProjectFullStack.Model.StationModel;
import com.Nikhitha.StationProjectFullStack.Repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class StationController {
    @Autowired
    private StationRepository stationRepository;

    @PostMapping("/station")
    StationModel newStation(@RequestBody StationModel newStation)
    {
        return stationRepository.save(newStation);
    }

    @GetMapping("/stations")
    List<StationModel> getAllStations()
    {
        return stationRepository.findAll();
    }

    @GetMapping("/station/{id}")
    StationModel getStationById(@PathVariable Long id)
    {
        return stationRepository.findById(id).orElseThrow(()->new  StationNotFoundException(id));
    }

    @PutMapping("/station/{id}")
    StationModel updateStation(@RequestBody StationModel newStation,@PathVariable Long id)
    {
        return stationRepository.findById(id)
                .map(stationModel -> {
                    stationModel.setName(newStation.getName());
                    stationModel.setAddress(newStation.getAddress());
                    stationModel.setImageData(newStation.getImageData());
                    stationModel.setPrice(newStation.getPrice());
                    return stationRepository.save(stationModel);
                }).orElseThrow(()->new StationNotFoundException(id));
    }

    @DeleteMapping("/station/{id}")
    String deleteStation(@PathVariable Long id)
    {
        if(!stationRepository.existsById(id))
        {
            throw new StationNotFoundException(id);
        }
        stationRepository.deleteById(id);
        return "Station with id "+id+" has been deleted successfully.";
    }
}

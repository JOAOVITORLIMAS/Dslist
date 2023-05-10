package albuquerquelima.DSlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import albuquerquelima.DSlist.DTO.GameDTO;
import albuquerquelima.DSlist.DTO.GameListDTO;
import albuquerquelima.DSlist.DTO.GameMinDTO;
import albuquerquelima.DSlist.services.GameListService;
import albuquerquelima.DSlist.services.GameService;

@RestController
@RequestMapping (value = "/lists")

public class GameListController {


    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
 
}

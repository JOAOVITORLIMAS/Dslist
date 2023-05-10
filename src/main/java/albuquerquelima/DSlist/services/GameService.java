package albuquerquelima.DSlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import albuquerquelima.DSlist.DTO.GameDTO;
import albuquerquelima.DSlist.DTO.GameMinDTO;
import albuquerquelima.DSlist.entities.Game;
import albuquerquelima.DSlist.repositories.GameRepository;



// Anotacao para registrar um componetente no programa - injetenado dependencias de componentes
@Service
public class GameService {
   
    @Transactional(readOnly = true) // boas praticas , lib spring
    public GameDTO findByID(long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result); // converter o Game para GameDTO
    }
    // injetando uma instancia do Repository na classe sarvice
    @Autowired
    private GameRepository gameRepository;
    // findAll faz a busca e tras todos os dados 
    @Transactional(readOnly = true) // boas praticas , lib spring
    public List<GameMinDTO> findAll() {
       List<Game> result = gameRepository.findAll();
       return result.stream().map(x -> new GameMinDTO(x)).toList();
    

   }

}

   



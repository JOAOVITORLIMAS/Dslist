package albuquerquelima.DSlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import albuquerquelima.DSlist.DTO.GameListDTO;
import albuquerquelima.DSlist.entities.GameList;
import albuquerquelima.DSlist.repositories.GameListRepository;

// Anotacao para registrar um componetente no programa - injetenado dependencias de componentes
@Service
public class GameListService {
   
    // injetando uma instancia do Repository na classe sarvice
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true) // boas praticas , lib spring
    public List<GameListDTO> findAll() {
       List<GameList> result = gameListRepository.findAll();
       return result.stream().map(x -> new GameListDTO(x)).toList(); //  tras todos objetos da lista original e faz um new , virando um gamelistDTo
    

   }

}

   



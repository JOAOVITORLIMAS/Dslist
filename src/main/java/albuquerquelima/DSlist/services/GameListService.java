package albuquerquelima.DSlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import albuquerquelima.DSlist.DTO.GameListDTO;
import albuquerquelima.DSlist.entities.GameList;
import albuquerquelima.DSlist.projections.GameMinProjection;
import albuquerquelima.DSlist.repositories.GameListRepository;
import albuquerquelima.DSlist.repositories.GameRepository;

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
    @Autowired
    private GameRepository gameRepository;

    @Transactional // dado uma mudança na lista atualiza a posição do id na tabela belonging
    public void move(long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection  obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        var min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        var max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

        for ( int i = min; i <= max ; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(),i);
        }
        
    }
}

   



package albuquerquelima.DSlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import albuquerquelima.DSlist.entities.GameList;

// componente para consulta basicas ao banco de dados
public interface GameListRepository extends JpaRepository<GameList, Long> {
    
}

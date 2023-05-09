package albuquerquelima.DSlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import albuquerquelima.DSlist.entities.Game;

// componente para consulta basicas ao banco de dados
public interface GameRepository extends JpaRepository<Game, Long> {
    
}

package albuquerquelima.DSlist.DTO;

import org.springframework.beans.BeanUtils;

import albuquerquelima.DSlist.entities.Game;

public class GameDTO {
    
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String ShortDescription;
    private String longDescription;

    public GameDTO(){
    }

    public GameDTO( Game entity) {
        BeanUtils.copyProperties(entity, this);
    }
    

}

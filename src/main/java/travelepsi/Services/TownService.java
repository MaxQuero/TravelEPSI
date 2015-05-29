package travelepsi.Services;

import org.springframework.stereotype.Service;
import travelepsi.Entities.TownEntity;


@Service
public class TownService extends CoreDao<TownEntity> {

    public TownService() {
        super(TownEntity.class);
    }

}


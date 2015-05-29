package travelepsi.Services;

import org.springframework.stereotype.Service;
import travelepsi.Entities.ServiceEntity;

/**
 * Created by benjaminsenechal on 29/05/15.
 */
@Service
public class ServiceService extends CoreDao<ServiceEntity>{

    public ServiceService() {
        super(ServiceEntity.class);
    }

}


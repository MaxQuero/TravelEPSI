package travelepsi.Services;

import org.hibernate.criterion.Restrictions;
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

    public ServiceEntity getService(Integer idService){
        return (ServiceEntity)session.createCriteria(ServiceEntity.class).add(Restrictions.eq("id", idService)).uniqueResult();
    }
}


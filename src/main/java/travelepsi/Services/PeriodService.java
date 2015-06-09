package travelepsi.Services;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import travelepsi.Entities.PeriodEntity;
import travelepsi.Entities.UserEntity;

/**
 * Created by benjaminsenechal on 28/05/15.
 */
@Service
public class PeriodService extends CoreDao<PeriodEntity>{

    public PeriodService() {
        super(PeriodEntity.class);
    }

    public PeriodEntity getPeriod(Integer idPeriod){
        return (PeriodEntity)session.createCriteria(PeriodEntity.class).add(Restrictions.eq("id", idPeriod)).uniqueResult();
    }
}

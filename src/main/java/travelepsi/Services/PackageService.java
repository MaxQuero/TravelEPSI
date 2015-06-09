package travelepsi.Services;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import travelepsi.Entities.OrderEntity;
import travelepsi.Entities.PackageEntity;
import travelepsi.Entities.PeriodEntity;

import java.util.List;


@Service
public class PackageService extends CoreDao<PackageEntity>{

    public PackageService() {
        super(PackageEntity.class);
    }

    public List<OrderEntity> getOrders(int idPackage) {
        return (List<OrderEntity>) session.createCriteria(OrderEntity.class)
                .add(Restrictions.eq("package_id", idPackage))
                .list();
    }
}

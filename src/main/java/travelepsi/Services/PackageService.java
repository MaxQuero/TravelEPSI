package travelepsi.Services;

import org.springframework.stereotype.Service;
import travelepsi.Entities.PackageEntity;
import travelepsi.Entities.PeriodEntity;

/**
 * Created by benjaminsenechal on 29/05/15.
 */
@Service
public class PackageService extends CoreDao<PackageEntity>{

    public PackageService() {
        super(PackageEntity.class);
    }

}

package travelepsi.Services;

import org.springframework.stereotype.Service;
import travelepsi.Entities.OrderEntity;

/**
 * Created by benjaminsenechal on 06/06/15.
 */
@Service
public class OrderService  extends CoreDao<OrderEntity>{

    public OrderService() {
        super(OrderEntity.class);
    }
}


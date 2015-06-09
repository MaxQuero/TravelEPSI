package travelepsi.Services;

import org.springframework.stereotype.Service;
import travelepsi.Entities.OrderEntity;


@Service
public class OrderService  extends CoreDao<OrderEntity>{

    public OrderService() {
        super(OrderEntity.class);
    }
}


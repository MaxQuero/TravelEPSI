package travelepsi.Services;

import org.springframework.stereotype.Service;
import travelepsi.Entities.UserEntity;


@Service
public class UserService extends CoreDao<UserEntity> {

    public UserService() {
        super(UserEntity.class);
    }

}

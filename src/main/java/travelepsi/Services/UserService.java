package travelepsi.Services;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import travelepsi.Entities.UserEntity;


@Service
public class UserService extends CoreDao<UserEntity> {

    public UserService() {
        super(UserEntity.class);
    }

    public UserEntity getUserByLoginAndPassword(String login, String password) {
        return (UserEntity) session.createCriteria(UserEntity.class)
                .add(Restrictions.eq("login", login))
                .add(Restrictions.eq("password", password))
                .uniqueResult();
    }

}

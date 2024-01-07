package repository;

import exceptions.UserAlreadyExists;
import exceptions.UserDoesntExist;
import lombok.Data;
import lombok.Getter;
import models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data

public class UserRepository {
    @Getter
    private static Map<String, User> userIdsMap = new HashMap<>();

    public static void addUser(User user) throws UserAlreadyExists {
        if(!Objects.isNull(user) && userIdsMap.containsKey(user.getAccount().getUserName())){
           throw new UserAlreadyExists("User with username " +  user.getAccount().getUserName()  + "already exists " );
        }
        userIdsMap.put(user.getAccount().getUserName(),user);
    }

    public static void updateUserDetails(User user) throws UserDoesntExist {
        if(Objects.isNull(userIdsMap.get(user.getAccount().getUserName()))) {
            throw new UserDoesntExist("User with username " + user.getAccount().getUserName() + "doesn't exists");
        }
        userIdsMap.put(user.getAccount().getUserName(),user);
    }
}

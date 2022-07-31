import java.util.ArrayList;
import java.util.List;

public interface UserFilter {

    boolean userFiltering(UserData user);

     static List<UserData> userFiltering(List<UserData> usersData, UserFilter userFilter) {

        List<UserData> userList = new ArrayList<>();

        for(UserData userInfo : usersData) {
            if(userFilter.userFiltering(userInfo)) {
                userList.add(userInfo);
            }
        }
        return userList;
    }
}

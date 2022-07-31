
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestOrder {

    List<UserData> listUserData;

    @BeforeTest
    private void beforeTest() {
        UserData user1 = new UserData("Petya", 21, 30, true, "Elektrik");
        UserData user2 = new UserData("Tom", 22, 40, true, "Santehnik");
        UserData user3 = new UserData("Toma", 23, 50, true, "AQA");
        UserData user4 = new UserData("Grey", 34, 60, false, "Medic");
        UserData user5 = new UserData("Mumu", 45, 70, false, "AQA");
        UserData user6 = new UserData("Maks", 56, 80, false, "MQA");
        UserData user7 = new UserData("Tima", 67, 90, false, "Lid");

        listUserData = Arrays.asList (user1, user2, user3, user4, user5, user6, user7);
    }

    @Test
    public void getAgeByName() {
        List<UserData> result = UserFilter.userFiltering(listUserData, new UserFilter() {
            @Override
            public boolean userFiltering(UserData userData) {
                return userData.name.equals("Mumu");
            }
        });

        List<Integer> getAge = result.stream()
            .map(name -> name.age)
            .collect(Collectors.toList());
        System.out.println(getAge);
    }

    @Test
    public void getListOver30Age() {
        List<UserData> result = UserFilter.userFiltering(listUserData, new UserFilter() {
            @Override
            public boolean userFiltering(UserData userData) {
                return userData.name.equals(userData.name);
            }
        });

        List<Integer> getAge = result.stream()
                .map(element -> element.age)
                .filter(element -> element > 30)
                .collect(Collectors.toList());
        System.out.println(getAge);
    }

    @Test
    public void getListLess30Age() {
        List<UserData> result = UserFilter.userFiltering(listUserData, new UserFilter() {
            @Override
            public boolean userFiltering(UserData userData) {
                return userData.name.equals(userData.name);
            }
        });

        List<Integer> getAge = result.stream()
                .map(element -> element.age)
                .filter(element -> element < 30)
                .collect(Collectors.toList());
        System.out.println(getAge);
    }

    @Test
    public void getAmountMen() {
        List<UserData> result = UserFilter.userFiltering(listUserData, new UserFilter() {
            @Override
            public boolean userFiltering(UserData userData) {
                return userData.name.equals(userData.name);
            }
        });

        List<Boolean> getAmountMen = result.stream()
                .map(element -> element.sex)
                .filter(element -> element == true)
                .collect(Collectors.toList());
        System.out.println(getAmountMen.size() + " Men");
    }

    @Test
    public void getAmountWoman() {
        List<UserData> result = UserFilter.userFiltering(listUserData, new UserFilter() {
            @Override
            public boolean userFiltering(UserData userData) {
                return userData.name.equals(userData.name);
            }
        });

        List<Boolean> getAmountWoman = result.stream()
                .map(element -> element.sex)
                .filter(element -> element == false)
                .collect(Collectors.toList());
        System.out.println(getAmountWoman.size() + " Women");
    }

    @Test
    public void getMaxAge() {
        List<UserData> result = UserFilter.userFiltering(listUserData, new UserFilter() {
            @Override
            public boolean userFiltering(UserData userData) {
                return userData.name.equals(userData.name);
            }
        });

        int getMaxAge = result.stream()
                .map(element -> element.age)
                .max(Integer::compareTo).get();
        System.out.println(getMaxAge + " Max age");
    }

    @Test
    public void getMinAge() {
        List<UserData> result = UserFilter.userFiltering(listUserData, new UserFilter() {
            @Override
            public boolean userFiltering(UserData userData) {
                return userData.name.equals(userData.name);
            }
        });

        int getMinAge = result.stream()
                .map(element -> element.age)
                .min(Integer::compareTo).get();
        System.out.println(getMinAge + " Min age");
    }

    @Test
    public void getNameAllNames() {
        List<UserData> result = UserFilter.userFiltering(listUserData, new UserFilter() {
            @Override
            public boolean userFiltering(UserData userData) {
                return userData.name.equals(userData.name);
            }
        });

        List<String> getAllName = result.stream()
                .map(element -> element.name)
                .collect(Collectors.toList());
        System.out.println(getAllName + " All names");
    }

    @Test
    public void getNameAllSpeciality() {
        List<UserData> result = UserFilter.userFiltering(listUserData, new UserFilter() {
            @Override
            public boolean userFiltering(UserData userData) {
                return userData.name.equals(userData.name);
            }
        });

        List<String> getNameAllSpeciality = result.stream()
                .map(element -> element.speciality)
                .collect(Collectors.toList());
        System.out.println(getNameAllSpeciality + " - All speciality");
    }

    @Test
    public void getNameAllAQA() {
        List<UserData> result = UserFilter.userFiltering(listUserData, new UserFilter() {
            @Override
            public boolean userFiltering(UserData userData) {
                return userData.speciality.equals("AQA");
            }
        });

        List<String> getNameAllAQA = result.stream()
                .map(element -> element.name)
                .collect(Collectors.toList());
        System.out.println(getNameAllAQA + " - All AQA speciality");
    }
}

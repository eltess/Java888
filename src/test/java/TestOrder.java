
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestOrder {

    List<UserData> listUserData;

    @BeforeTest
    private void beforeTest() {
        UserData Petya = new UserData("Petya", 21, 30, true, "Elektrik");
        UserData Tom = new UserData("Tom", 22, 40, true, "Santehnik");
        UserData Toma = new UserData("Toma", 23, 50, true, "AQA");
        UserData Grey = new UserData("Grey", 34, 60, false, "Medic");
        UserData Mumu = new UserData("Mumu", 45, 70, false, "AQA");
        UserData Maks = new UserData("Maks", 56, 80, false, "MQA");
        UserData Tima = new UserData("Tima", 67, 90, false, "Lid");

        listUserData = Arrays.asList (Petya, Tom, Toma, Grey, Mumu, Maks, Tima);
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
        Assert.assertEquals(getAge, 45, "Actual age is different from expected age");
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
        Assert.assertEquals(getAge, 67, "Actual age is different from expected age");
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
        Assert.assertEquals(getAge, 21, "Actual age is different from expected age");
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
        Assert.assertEquals(getAmountMen, 45,
                "Actual amount of man is different from expected amount of man");
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
        Assert.assertEquals(getAmountWoman.size(), 4,
                "Actual amount of woman is different from expected amount of woman");
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
        Assert.assertEquals(getMaxAge, 67,
                "Actual maximum age is different from expected maximum age");
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
        Assert.assertEquals(getMinAge, 21,
                "Actual minimum age is different from expected minimum age");
    }

    @Test
    public void getNameAll() {
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
        Assert.assertTrue(getAllName.size() > 0, "Name list is empty");
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
        Assert.assertTrue(getNameAllSpeciality.size() > 0, "Speciality list is empty");
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
        Assert.assertTrue(getNameAllAQA.size() > 0, "QA list is empty");
    }
}

public class UserData {

    public String name;
    public int age;
    public int weight;
    public boolean sex;
    public String speciality;

    public UserData(String name, int age, int weight, boolean sex, String speciality) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.sex = sex;
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Customer " + name + "/ Age " + age + "/ Weight " + weight + "/ Sex " + sex + "/ Speciality " + speciality +" ;";
    }
}

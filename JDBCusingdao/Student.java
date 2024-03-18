package JDBCusingdao;

public class Student {
    int id ;
    String name;
    int age;
    Gender gender;
    String email;

    enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

}



package JDBCusingdao;

public class JDBC_Dao {

    public static void main(String[] args) throws Exception {
        StudentDao dao = new StudentDao();
//        fetchSingleStudent(dao);
        dao.addStudent("Rima Ajmera",19, Student.Gender.FEMALE,"rima.jha@gmail.com");
        fetchStudentList(dao);
    }

    private static void fetchSingleStudent(StudentDao dao) throws Exception {
        Student student = dao.getStudent(2);
        System.out.println("Roll No.-"+student.id+" Name-"+student.name);
    }

    private static void fetchStudentList(StudentDao dao) throws Exception {
        for(Student std: dao.getStudents()){
            System.out.println("Roll No.-"+std.id+" Name-"+std.name);
        }
    }
}

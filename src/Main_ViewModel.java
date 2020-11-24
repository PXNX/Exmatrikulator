public class Main_ViewModel {

    Repository repo = new Repository();

    public String getName(int matnr) {
        return repo.sqlString("select name from students where matnr = " + matnr);
    }

    public Student getStudent(int matnr) {
        return repo.sqlStudent(matnr);
    }
}

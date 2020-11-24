public class Main {

    public static void main(String[] args) {

        View view = new View();
        view.init();

        Repository repo = new Repository();
        repo.showAll();

        repo.sql("select * from students");
    }
}


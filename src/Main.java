public class Main {

    public static void main(String[] args) {

        //TODO Xampp holen!!

        View view = new View();
        view.init();

        Repository repo = new Repository();
        repo.showAll();

        repo.sql("select * from students");
    }
}


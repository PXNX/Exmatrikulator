import java.sql.*;

public class Repository {
    // noch kein Wert zugewiesen; nur deklariert
    Connection con;
    Statement stmt;
    ResultSet rs;

    public void showAll() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            // Wertzuweisung(Initialisieren)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exmatrikulator?user=root&password=root");

            // here sonoo is database name, root is username and password

            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from students");

            while (rs.next()) {
                // Anzeige von matnr, name, note, (nicht)/bestanden
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getDouble(3) + "  " + rs.getBoolean(4));
            }

            // Verbindung schlie�en, damit jeder zugreifen kann
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // query = Abfrage
    public void sql(String query) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            // Wertzuweisung(Initialisieren)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exmatrikulator?user=root&password=root");

            // here sonoo is database name, root is username and password

            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Anzeige von matnr, name, note, (nicht)/bestanden
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getDouble(3) + "  " + rs.getBoolean(4));
            }

            // Verbindung schlie�en, damit jeder zugreifen kann
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String sqlString(String query) {

        String result = "name not available";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            // Wertzuweisung(Initialisieren)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exmatrikulator?user=root&password=root");

            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Anzeige von matnr, name, note, (nicht)/bestanden
                result = rs.getString(1);
                System.out.println(result);
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);

        }
        return result;
    }

    public Student sqlStudent(int matnr) {

        Student result = new Student();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exmatrikulator?user=root&password=root");

            stmt = con.createStatement();
            rs = stmt.executeQuery("select name, grade, exmatriculated from students where matnr = " + matnr);

            while (rs.next()) {
                result.setMatnr(matnr);
                result.setName(rs.getString(1));
                result.setGrade(rs.getDouble(2));
                result.setExmat(rs.getBoolean(3));
                System.out.println(result);
            }
            con.close();

        } catch (Exception e) {
            System.err.println(e);

        }
        return result;
    }

}

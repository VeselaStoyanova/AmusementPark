package DataBaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnector {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void openConnection(){
        try {
            DriverManager.registerDriver(new com.ibm.db2.jcc.DB2Driver());
        } catch(Exception cnfex) {
            System.out.println("Problem in loading or registering IBM DB2 JDBC driver");
            cnfex.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:db2://62.44.108.24:50000/SAMPLE", "db2admin", "db2admin");
            statement = connection.createStatement();
        } catch(SQLException s){
            s.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            if (null != connection) {
                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public void select(String stmnt, int column) {
        try{
            resultSet = statement.executeQuery(stmnt);
            String result = "";
            while(resultSet.next()) {
                for (int i = 1; i <= column; i++) {
                    result += resultSet.getString(i);
                    if (i == column) result += " \n";
                    else             result += ", ";
                }
            }
            System.out.println("Executing query: " + stmnt + "\n");
            System.out.println("Result output \n");
            System.out.println("---------------------------------- \n");
            System.out.println(result);
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public void insert(String stmnt) {
        try{
            statement.executeUpdate(stmnt);
        } catch (SQLException s){
            s.printStackTrace();
        }
        System.out.println("Successfully inserted!");
    }

    public void delete(String stmnt) {
        try{
            statement.executeUpdate(stmnt);
        } catch (SQLException s){
            s.printStackTrace();
        }
        System.out.println("Successfully deleted!");
    }
}








package persistence;
import java.sql.*;
import java.util.Collections;
import java.util.List;

public abstract class DAO<T> {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "111111";

    protected String tableName; // для выборки из нужной таблицы
    protected String[] columns; // для получения полей

    public DAO() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver is ok!");
        } catch (Exception ex) {
            System.out.println("Driver is not ok!"
                    + ex.getMessage() + " "
                    + ex.getCause());
        }
    }

    public boolean add(T value){
        String query = createInsertQuery(value);
        return executeModifyQuery(query);
    }

    public List<T> findAll() {
        final String query = String.format("select * from %s", tableName);
        return executeSelectQuery(query);
    }

    public T findById(int id) {
        final String query = String.format("select * from %s where id = %d", tableName, id);
        List<T> result = executeSelectQuery(query);
        if (!result.isEmpty())
            return result.get(0);
        return null;
    }

    protected abstract String createInsertQuery(T entity);

    private boolean executeModifyQuery(String query){
        try (Connection connection =
                     DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(query)){
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getCause() + " " + ex.getMessage());
            return false;
        }
    }

    protected abstract List<T> convertFrom(ResultSet resultSet) throws SQLException; // перегонка значений

    private List<T> executeSelectQuery(String query){
        try (
                Connection connection = DriverManager.getConnection(
                        DATABASE_URL,
                        DATABASE_USER,
                        DATABASE_PASSWORD); // пытаемся сделать коннект к базе
                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)){ // сущность подготовленный запрос
            ResultSet resultSet = preparedStatement.executeQuery();
            return convertFrom(resultSet);
        } catch (SQLException ex) {
            System.out.println("Problem "
                    + ex.getMessage() + " "
                    + ex.getCause());
            return Collections.emptyList(); // пустой лист в случае ошибки
        }
    }
}

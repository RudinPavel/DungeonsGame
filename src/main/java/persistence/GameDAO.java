package persistence;

import game.Game;
import utils.Log;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO extends DAO<Game> {

    public GameDAO() {
        tableName = "games";
        columns = new String[] {"log"};
    }

    @Override
    protected List<Game> convertFrom(ResultSet resultSet) throws SQLException {
        List<Game> games = new ArrayList<>();
        while (resultSet.next()) {
            Game g = new Game();
            g.setLog(resultSet.getString("log"));
            games.add(g);
        }
        return games;
    }

    @Override
    protected String createInsertQuery(Game entity) {
        String fields = String.join(", ", columns);
        String values = "'" + entity.getLog() + "'";
        return String.format("insert into %s (%s)" +
                "values (%s)", tableName, fields, values);
    }
}
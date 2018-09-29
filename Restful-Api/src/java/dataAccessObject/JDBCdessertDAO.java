package dataAccessObject;

import entity.Dessert;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import storage.ConnectionFactory;
import storage.DbUtil;

/**
 *
 * @author ciccio
 */
public class JDBCdessertDAO implements AbstractDessertDAO {

    private Connection connection;
    private Statement statement;

    private final static String LISTA_DESSERT = "SELECT * FROM dessert";
    private final static String DESSERT_BY_ID = "SELECT * FROM dessert WHERE id=";

    @Override
    public Dessert getDessert(int pId) {

        int id = pId;
        Dessert dessert = null;

        try {
            //apertura connessione al database
            connection = ConnectionFactory.getConnection();
            //creazione di uno statement
            statement = connection.createStatement();
            //esecuzione della query
            ResultSet resultSet = statement.executeQuery(DESSERT_BY_ID + "'" + id + "'");

            if (resultSet.next()) {

                dessert = new Dessert();
                dessert.setId(Integer.parseInt(resultSet.getString("id")));
                dessert.setNome(resultSet.getString("nome"));
                dessert.setIngredienti(resultSet.getString("ingredienti"));
                dessert.setPrezzo(resultSet.getDouble("prezzo"));
            }

            DbUtil.close(resultSet);
            DbUtil.close(statement);
            DbUtil.close(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(dessert);

        return dessert;
    }

    @Override
    public List<Dessert> getListaDessert() {

        List<Dessert> listaDessert = new LinkedList<Dessert>();

        try {
            //apertura connessione al database
            connection = ConnectionFactory.getConnection();
            //creazione di uno statement
            statement = connection.createStatement();
            //esecuzione della query
            ResultSet resultSet = statement.executeQuery(LISTA_DESSERT);

            Dessert dessert = null;
            //scorre tutti i dessert trovati nel DB e li inserisce in una lista
            while (resultSet.next()) {
                dessert = new Dessert();
                dessert.setId(Integer.parseInt(resultSet.getString("id")));
                dessert.setNome(resultSet.getString("nome"));
                dessert.setIngredienti(resultSet.getString("ingredienti"));
                dessert.setPrezzo(resultSet.getDouble("prezzo"));

                listaDessert.add(dessert);
            }

            DbUtil.close(resultSet);
            DbUtil.close(statement);
            DbUtil.close(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println(listaDessert);
        
        return listaDessert;
    }

}

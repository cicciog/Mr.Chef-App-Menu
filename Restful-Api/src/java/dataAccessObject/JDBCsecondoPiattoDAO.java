package dataAccessObject;

import entity.SecondoPiatto;
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
public class JDBCsecondoPiattoDAO implements AbstractSecondoPiattoDAO {

    private Connection connection;
    private Statement statement;

    private final static String LISTA_SECONDI_PIATTI = "SELECT * FROM secondi";
    private final static String SECONDO_PIATTO_BY_ID = "SELECT * FROM secondi WHERE id=";

    @Override
    public SecondoPiatto getSecondoPiatto(int pId) {

        int id = pId;
        SecondoPiatto secondoPiatto = null;

        try {
            //apertura connessione al database
            connection = ConnectionFactory.getConnection();
            //creazione di uno statement
            statement = connection.createStatement();
            //esecuzione della query
            ResultSet resultSet = statement.executeQuery(SECONDO_PIATTO_BY_ID + "'" + id + "'");

            if (resultSet.next()) {

                secondoPiatto = new SecondoPiatto();
                secondoPiatto.setId(Integer.parseInt(resultSet.getString("id")));
                secondoPiatto.setNome(resultSet.getString("nome"));
                secondoPiatto.setIngredienti(resultSet.getString("ingredienti"));
                secondoPiatto.setPrezzo(resultSet.getDouble("prezzo"));
            }

            DbUtil.close(resultSet);
            DbUtil.close(statement);
            DbUtil.close(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(secondoPiatto);

        return secondoPiatto;
    }

    @Override
    public List<SecondoPiatto> getListaSecondiPiatti() {

        List<SecondoPiatto> listaSecondiPiatti = new LinkedList<SecondoPiatto>();

        try {
            //apertura connessione al database
            connection = ConnectionFactory.getConnection();
            //creazione di uno statement
            statement = connection.createStatement();
            //esecuzione della query
            ResultSet resultSet = statement.executeQuery(LISTA_SECONDI_PIATTI);

            SecondoPiatto secondoPiatto = null;
            //scorre tutti i secondi piatti trovati nel DB e li inserisce in una lista
            while (resultSet.next()) {

                secondoPiatto = new SecondoPiatto();
                secondoPiatto.setId(Integer.parseInt(resultSet.getString("id")));
                secondoPiatto.setNome(resultSet.getString("nome"));
                secondoPiatto.setIngredienti(resultSet.getString("ingredienti"));
                secondoPiatto.setPrezzo(resultSet.getDouble("prezzo"));

                listaSecondiPiatti.add(secondoPiatto);
            }

            DbUtil.close(resultSet);
            DbUtil.close(statement);
            DbUtil.close(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(listaSecondiPiatti);

        return listaSecondiPiatti;
    }

}

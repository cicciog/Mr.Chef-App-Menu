package dataAccessObject;

import entity.Dessert;
import entity.PrimoPiatto;
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
public class JDBCprimoPiattoDAO implements AbstractPrimoPiattoDAO{
    
    private Connection connection;
    private Statement statement;

    private final static String LISTA_PRIMI_PIATTI = "SELECT * FROM primi";
    private final static String PRIMO_PIATTO_BY_ID = "SELECT * FROM primi WHERE id=";

    @Override
    public PrimoPiatto getPrimoPiatto(int pId) {
                
        int id = pId;
        PrimoPiatto primoPiatto = null;

        try {
            //apertura connessione al database
            connection = ConnectionFactory.getConnection();
            //creazione di uno statement
            statement = connection.createStatement();
            //esecuzione della query
            ResultSet resultSet = statement.executeQuery(PRIMO_PIATTO_BY_ID + "'" + id + "'");

            if (resultSet.next()) {

                primoPiatto = new PrimoPiatto();
                primoPiatto.setId(Integer.parseInt(resultSet.getString("id")));
                primoPiatto.setNome(resultSet.getString("nome"));
                primoPiatto.setIngredienti(resultSet.getString("ingredienti"));
                primoPiatto.setPrezzo(resultSet.getDouble("prezzo"));
            }

            DbUtil.close(resultSet);
            DbUtil.close(statement);
            DbUtil.close(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(primoPiatto);

        return primoPiatto;
    }

    @Override
    public List<PrimoPiatto> getListaPrimiPiatti() {
        
        List<PrimoPiatto> listaPrimiPiatti = new LinkedList<PrimoPiatto>();

        try {
            //apertura connessione al database
            connection = ConnectionFactory.getConnection();
            //creazione di uno statement
            statement = connection.createStatement();
            //esecuzione della query
            ResultSet resultSet = statement.executeQuery(LISTA_PRIMI_PIATTI);

            PrimoPiatto primoPiatto = null;
            //scorre tutti i primi piatti trovati nel DB e li inserisce in una lista
            while (resultSet.next()) {
                primoPiatto = new PrimoPiatto();
                primoPiatto.setId(Integer.parseInt(resultSet.getString("id")));
                primoPiatto.setNome(resultSet.getString("nome"));
                primoPiatto.setIngredienti(resultSet.getString("ingredienti"));
                primoPiatto.setPrezzo(resultSet.getDouble("prezzo"));

                listaPrimiPiatti.add(primoPiatto);
            }

            DbUtil.close(resultSet);
            DbUtil.close(statement);
            DbUtil.close(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println(listaPrimiPiatti);
        
        return listaPrimiPiatti;
        
    }
    
}

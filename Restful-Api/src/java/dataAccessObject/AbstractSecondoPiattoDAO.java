package dataAccessObject;

import entity.SecondoPiatto;
import java.util.List;

/**
 *
 * @author ciccio
 */
public interface AbstractSecondoPiattoDAO {
    
    public SecondoPiatto  getSecondoPiatto(int pId);
    public List<SecondoPiatto> getListaSecondiPiatti();
    
}

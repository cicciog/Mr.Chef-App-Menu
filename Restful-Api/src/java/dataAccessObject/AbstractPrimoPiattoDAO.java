package dataAccessObject;

import entity.PrimoPiatto;
import java.util.List;

/**
 *
 * @author ciccio
 */
public interface AbstractPrimoPiattoDAO {
    
    public PrimoPiatto getPrimoPiatto(int pId);
    public List<PrimoPiatto> getListaPrimiPiatti();
    
}

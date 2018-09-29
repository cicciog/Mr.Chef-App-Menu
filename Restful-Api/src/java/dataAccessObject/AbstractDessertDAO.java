package dataAccessObject;

import entity.Dessert;
import java.util.List;

/**
 *
 * @author ciccio
 */
public interface AbstractDessertDAO {
    
    public Dessert getDessert(int pId);
    public List<Dessert> getListaDessert();
    
}

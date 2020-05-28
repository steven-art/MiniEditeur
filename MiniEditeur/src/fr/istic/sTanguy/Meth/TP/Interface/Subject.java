package fr.istic.sTanguy.Meth.TP.Interface;

import java.util.Collection;

public interface Subject {



/**
 * allow to record a new observer
 * @param o 
 * this parameter is an observer
 */
public void recordNewOberver(Observer o);
/**
 * remove observer record
 * @param o
 */
public void removeObserver(Observer o);

public boolean isRecord(Observer o);


}

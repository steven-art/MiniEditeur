package fr.istic.sTanguy.Meth.TP.Interface;
/**
 * 
 * @author: Tanguy
 *
 */
public interface Observer {
	
	/**
	 * Signals to this that s's value has been updated
	 *
	 * @param s the updated subject
	 */
	void doUpdate(Engine s);


}

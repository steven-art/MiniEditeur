package fr.istic.sTanguy.Meth.TP.Interface;

import fr.istic.sTanguy.Meth.TP.exception.VideException;

public interface Engine {
	
	/**
	 * copy the string or charactere selection in clipboard  and delete the selection
	 */
	public void cut();
	/**
	 * copy the selection on the clipboard
	 */
	public void copy();
	/**
	 * paste the buffer after the location of the cursor 
	 * if the clipboard isn't empty and you copy the selection of null, you doesn't erase the clipboard and you keep 
	 * your previous selection
	 */
	
	public void paste();
	/**
	 * insertion the charactere in the buffercontent in location of the cursor
	 * @param c
	 */
	public void insert(char c);
	/**
	 * delete the charactere selected or the area selected, you erased the selection 
	 * and near 2 parts around the selection
	 * 
	 */
	public void delete() throws VideException;
	/**
	 * return the selection
	 * @return object selection
	 */
	public Selection getSelection();
	/**
	 * return the buffer content
	 * @return buffer
	 */
	public String getBufferContents();
	/**
	 * Return the clipboard content
	 * @return a clipboard 
	 */
	public String getClipboardContents();

}

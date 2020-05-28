package fr.istic.sTanguy.Meth.TP.Interface;
public interface Selection {
	
	/**
	 * move a cursor at the position change the value
	 * and if the value is negative return previous position
	 * and if the value is positive the cursor going next position
	 * if the value is upper of the last position the cursor go in the last position
	 * and if the value is lower of the first position the cursor going in the first position
	 * @param n
	 */
	public void moveCursor(int n);
	/**
	 * place marker at the current position of cursor
	 * the position of is initialized position -1
	 */
	public void setMarker();
	/**
	 * 
	 * @return int position of cursor
	 */
	public int getCursorPosition();
	/**
	 * 
	 * @return int position of marker
	 */
	public int getMarkerPosition();
	/**
	 * move the marker in position 0
	 */
	public void movetofirst();
	/**
	 * move the marker after the last charactere of your page
	 */
	public void movetolast();
	/**
	 * return lenght of the selection
	 *
	 */
	public int getLenght();
}

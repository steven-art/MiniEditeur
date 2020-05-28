package fr.istic.sTanguy.Meth.TP.classe;

import fr.istic.sTanguy.Meth.TP.Interface.Selection;

public class SelectionImplementation implements Selection{

	private int cursor =0 ;
	private int marker=0;
	public StringBuffer page2;
	private int lenght=0 ;
	private boolean isActive = false;


	public SelectionImplementation (int cursor, int marker) {
		this.cursor = cursor ;
		this.marker = cursor;// initialisation du marker a la valeur du curseur

	}
	@Override
	public void moveCursor(int n) {
		// TODO Auto-generated method stub
		if((cursor+n)>=0 && (cursor+n)<=page2.length()+1) // si le curseur + n est compris entre la position 0 et la taille de la chain +1 
		{
			cursor =cursor+n;

		}else if((cursor+n)>page2.length()+1)//si la valeur depasse on vas a la fin de la chaine
		{
			cursor = page2.length();

		}else if((cursor+n)<0) //si la valeur est en dessous le curseur vas en position 0
		{
			cursor=0;
		}
	}

	/**
	 * put selection active
	 */
	public void activeSelection() {//boolean pour indiquer que la selection est active
		isActive =true;
	}
	/**
	 * put selection inactive
	 */
	public void desactiveSelection() {//desactive la selection
		isActive =false;
	}
	/**
	 * retourne la valeur du boolean qui indique si la selection est active ou non
	 * @return isActive 
	 */
	public boolean getactive() {
		return isActive;
	}



	@Override
	public void setMarker() {
		// TODO Auto-generated method stub
		marker =cursor;
		activeSelection();//active la selection quand un marker pose
	}

	@Override
	public int getCursorPosition() {
		// TODO Auto-generated method stub
		return cursor;
	}

	@Override
	public int getMarkerPosition() {
		// TODO Auto-generated method stub
		return marker;
	}

	@Override
	public void movetofirst() {
		// TODO Auto-generated method stub
		cursor =0;
	}

	@Override
	public void movetolast() {
		// TODO Auto-generated method stub
		cursor = page2.length();
	}
	/**
	 * retourne la taille de la selection
	 */
	public int getLenght() {

		return lenght;
	}

	/**
	 * modify the lenght of the selection with lenght is positive 
	 * 
	 * @param longueur
	 */
	public void setLenght(int x, int y) {

		this.lenght = Math.abs(x-y);


	}
}

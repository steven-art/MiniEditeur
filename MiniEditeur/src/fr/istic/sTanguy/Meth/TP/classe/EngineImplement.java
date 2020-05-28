package fr.istic.sTanguy.Meth.TP.classe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.istic.sTanguy.Meth.TP.Interface.Engine;
import fr.istic.sTanguy.Meth.TP.Interface.Observer;
import fr.istic.sTanguy.Meth.TP.Interface.Selection;
import fr.istic.sTanguy.Meth.TP.Interface.Subject;

public class EngineImplement implements Engine,Subject {

	private StringBuffer page;
	private SelectionImplementation selector;
	private String clipboard="";
	private List<Observer> listObserver;

	public EngineImplement () {
		this.page = new StringBuffer();
		this.clipboard= new String();
		this.selector = new  SelectionImplementation(0,0);
		listObserver = new ArrayList<>();
		selector.page2=this.page;//premet de faire le lien entre la selection et Engine
	}
	@Override
	public void cut() {
		// TODO Auto-generated method stub
		this.copy();//reutilisation de la methode copy 
		page.delete(min(),max());
		selector.moveCursor(Math.abs(selector.getCursorPosition()-selector.getMarkerPosition()));
	}

	@Override
	public void copy() {
		// TODO Auto-generated method stub

		if( selector.getactive() ) //si la selection est active alors copy de la selection dans le clipboard
		{
			clipboard = page.substring(min(), max());// utilisation de substring() qui est une methode de API StringBuffer
			selector.desactiveSelection();

		}//fin if
	}

	@Override
	public void paste() {
		// TODO Auto-generated method stub

		if(selector.getactive()) {

			page.delete(min(), max());
		}//fin if
		page.insert(selector.getCursorPosition(),clipboard);//insert() est une methode de API StringBuffer permet de coller une chaine de caracteres
		selector.moveCursor(max());//on met le curseur a la fin de la chaine colle
	}



	@Override
	public void insert(char c) {
		// TODO Auto-generated method stub

		page.insert(selector.getCursorPosition(),c);//insert() est une methode de API StringBuffer permet de coller une chaine de caracteres

		selector.moveCursor(1);

	}
	/**
	 * 
	 * @return la valeur minium entre le cursor et le marker
	 */
	public int min() {

		return Math.min(selector.getCursorPosition(), selector.getMarkerPosition());
	}
	/**
	 * 
	 * @return la valeur maximum entre le cursor et le marker
	 */
	public int max() {

		return Math.max(selector.getCursorPosition(), selector.getMarkerPosition());
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub

		if(selector.getactive()) {
			page.delete(min(), max());//methode de API StringBuffer qui suprimer les caractere entre les deux valeurs
			selector.setLenght(0,0);//taille de la selection remise à zero
			selector.moveCursor(Math.abs(selector.getCursorPosition()-selector.getMarkerPosition()));
		}
		else {
			if(selector.getCursorPosition()==0) {

			}else {
				page.deleteCharAt(getSelection().getCursorPosition()-1);

				selector.moveCursor(-1) ;
			}

		}

	}


	@Override
	public Selection getSelection() {
		// TODO Auto-generated method stub

		return selector;
	}


	@Override
	public String getBufferContents() {
		// TODO Auto-generated method stub
		return page.toString();
	}

	@Override
	public String getClipboardContents() {
		// TODO Auto-generated method stub
		return clipboard;
	}
	//Methode pour le pattern observer

	@Override
	public void recordNewOberver(Observer o) {
		// TODO Auto-generated method stub
		Objects.requireNonNull(o, "o cannot be null");
		if (listObserver.contains(o)) {
			throw new IllegalArgumentException("o is registered already");
		}
		listObserver.add(o);
	}
	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		Objects.requireNonNull(o, "o cannot be null");
		if (!listObserver.contains(o)) {
			throw new IllegalArgumentException("o is not registered");
		}
		listObserver.remove(o);
	}
	@Override
	public boolean isRecord(Observer o) {
		// TODO Auto-generated method stub
		Objects.requireNonNull(o, "o cannot be null");

		return listObserver.contains(o);
	}
	public void notifyListObservers() {
		for (Observer o : listObserver) {
			o.doUpdate(this);
		}
	}
	


}

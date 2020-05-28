package fr.istic.sTanguy.Meth.TP.classe;

import fr.istic.sTanguy.Meth.TP.Interface.Command;
import fr.istic.sTanguy.Meth.TP.Interface.Engine;

public class PasteCmd implements Command{
	private final EngineImplement receiver ;
	public PasteCmd(EngineImplement receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.receiver.paste();
		System.out.println("paste ok");
		receiver.notifyListObservers();
	}

}

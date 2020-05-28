package fr.istic.sTanguy.Meth.TP.classe;

import fr.istic.sTanguy.Meth.TP.Interface.Command;
import fr.istic.sTanguy.Meth.TP.Interface.Engine;

public class CopyCmd implements Command {

	private final EngineImplement receiver ;
	
	public CopyCmd(EngineImplement receiver) {
		this.receiver = receiver;
	}

@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.receiver.copy();
		System.out.println("copy ok");
	receiver.notifyListObservers();
	}

}

package fr.istic.sTanguy.Meth.TP.classe;

import fr.istic.sTanguy.Meth.TP.Interface.Command;
import fr.istic.sTanguy.Meth.TP.Interface.Engine;
import fr.istic.sTanguy.Meth.TP.exception.VideException;

public class DeleteCmd implements Command {
private final EngineImplement receiver ;
	public DeleteCmd(EngineImplement receiver) {
		this.receiver = receiver;
	}

@Override
	public void execute() {
		this.receiver.delete();
		System.out.println("delete ok");
		receiver.notifyListObservers();
	}

}

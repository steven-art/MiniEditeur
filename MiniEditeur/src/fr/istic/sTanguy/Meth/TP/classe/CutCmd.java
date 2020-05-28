package fr.istic.sTanguy.Meth.TP.classe;

import fr.istic.sTanguy.Meth.TP.Interface.Command;
import fr.istic.sTanguy.Meth.TP.Interface.Engine;

public class CutCmd implements Command {
	private final EngineImplement receiver ;
	public CutCmd(EngineImplement receiver) {
		this.receiver = receiver;
	}

@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.receiver.cut();
		System.out.println("cut ok");
		receiver.notifyListObservers();
	}

}

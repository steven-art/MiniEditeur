package fr.istic.sTanguy.Meth.TP.classe;

import fr.istic.sTanguy.Meth.TP.Interface.Command;

public class SetMarkerCmd implements Command{
	private final EngineImplement receiver ;
	public SetMarkerCmd(EngineImplement receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.receiver.getSelection().setMarker();
		System.out.println("marker en position");
		receiver.notifyListObservers();
	}

}

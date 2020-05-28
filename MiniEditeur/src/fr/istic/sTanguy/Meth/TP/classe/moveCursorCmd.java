package fr.istic.sTanguy.Meth.TP.classe;

import java.util.Scanner;

import fr.istic.sTanguy.Meth.TP.Interface.Command;

public class moveCursorCmd implements Command {
	  int deplacement ;//permet le deplacemment en prenant la valeur du int pour moveCursor
	
	private final EngineImplement receiver ;
	public moveCursorCmd(EngineImplement receiver,int i) {
		this.receiver = receiver;
		
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("entrer un chiffre sans virgule : ");
		Scanner var = new Scanner(System.in);
		 deplacement = Integer.parseInt(var.nextLine());//permet de transformer la string de nextLine en int
		this.receiver.getSelection().moveCursor(deplacement);
		
		receiver.notifyListObservers();
	}

}

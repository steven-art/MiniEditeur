package fr.istic.sTanguy.Meth.TP.classe;

import java.io.BufferedReader;
import java.util.Scanner;

import fr.istic.sTanguy.Meth.TP.Interface.Command;
import fr.istic.sTanguy.Meth.TP.Interface.Engine;
import fr.istic.sTanguy.Meth.TP.exception.NoCharException;

public class InsertCmd implements Command{
	  char caractere;
	   
	private final EngineImplement receiver ;
	public InsertCmd(EngineImplement receiver,char c) {
		this.receiver = receiver;
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("caractere :");
		Scanner sc = new Scanner(System.in);//premet que le insert prennent un caractère
		String str = sc.nextLine();
	    if (str.toString().length()>=1) {
	        caractere = str.toString().charAt(0);
	        this.receiver.insert(caractere);
	        receiver.notifyListObservers();//notifier lors d'un changement
	        
	    }
	    
	    else { new NoCharException();}
		
		System.out.println("inser ok");
	}

}

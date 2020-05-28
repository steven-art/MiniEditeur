package fr.istic.sTanguy.Meth.TP.classe;

import fr.istic.sTanguy.Meth.TP.Interface.Engine;

/**
 * A simple demo application for the Greetings Command design pattern example
 */
public class Configurateur {
	private char c;
	private int i;
	private IHM invoker;
	private EngineImplement engine;

	public static void main(String lineArgs[]) {
		
		Configurateur client = new Configurateur();
		client.run();

	}

	private void run() {
		invoker = new IHM();
		engine = new EngineImplement();
		engine.recordNewOberver(invoker);
		invoker.setReadStream(System.in);
		configureCommands();
		invoker.runInvokerLoop();
		
	}
	private void configureCommands() {

		invoker.addCommand("Quit", new QuitCmd(invoker));
		invoker.addCommand("cut", new CutCmd(engine));
		invoker.addCommand("copy", new CopyCmd(engine));
		invoker.addCommand("del", new DeleteCmd(engine));
		invoker.addCommand("ins", new InsertCmd(engine,c));
		invoker.addCommand("pas", new PasteCmd(engine));
		invoker.addCommand("Mcursor", new moveCursorCmd(engine, i));
		invoker.addCommand("Smarker", new SetMarkerCmd(engine));
		// An example of Java 8 lambdas
		invoker.addCommand("Test", () -> System.err.println("Test : "+this.toString()));
	}



}
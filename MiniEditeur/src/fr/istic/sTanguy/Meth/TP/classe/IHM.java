package fr.istic.sTanguy.Meth.TP.classe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import fr.istic.sTanguy.Meth.TP.Interface.Command;
import fr.istic.sTanguy.Meth.TP.Interface.Engine;
import fr.istic.sTanguy.Meth.TP.Interface.Invoker;
import fr.istic.sTanguy.Meth.TP.Interface.Observer;
import fr.istic.sTanguy.Meth.TP.Interface.Subject;

/**
 * A simple example of invoker for the Command design pattern.
 */
public class IHM implements Invoker,Observer{
    private HashMap<String, Command> commands = new HashMap<>();
    private boolean stopLoop = false;
    private InputStream inputStream;
    private BufferedReader bufferedReader;

   
    @Override
    public void runInvokerLoop() {
        while (!stopLoop) {
            String userInput = null;
            try {
                userInput = readUserInput();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(userInput == null) {
                stopLoop = true;
                break;
            }
            Command cmdToExecute = commands.get(userInput);
            if (cmdToExecute != null) {
                cmdToExecute.execute();
            }
        }
    }

    @Override
    public void stopLoop() {
        stopLoop = true;
    }

    private String readUserInput() throws IOException {
        return bufferedReader.readLine();
    }

    /**
     * Registers a new keyword/command pair
     *
     * @param keyword a non-null String
     * @param cmd     a non-null Command reference
     * @throws java.lang.IllegalArgumentException for null parameters
     */
    @Override
    public void addCommand(String keyword, Command cmd) {
        if ((keyword == null) || (cmd == null)) {
            throw new IllegalArgumentException("null parameter");
        }
        commands.put(keyword,cmd);
    }

    @Override
    public void setReadStream(InputStream inputStream) {
        if(inputStream == null) {
            throw new IllegalArgumentException("null inputStream");
        }
        this.inputStream = inputStream;
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

	@Override
	public void doUpdate(Engine subject) {
		// TODO Auto-generated method stub
		System.out.println("le contenu du buffer " +subject.getBufferContents());
		System.out.println("le contenu du clipboard " +subject.getClipboardContents());
		System.out.println("position du cursor : "+ subject.getSelection().getCursorPosition());
		System.out.println("position du marker : "+ subject.getSelection().getMarkerPosition());
	}

	


}
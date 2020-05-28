package fr.istic.sTanguy.Meth.TP.Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import fr.istic.sTanguy.Meth.TP.Interface.Command;
import fr.istic.sTanguy.Meth.TP.Interface.Observer;
import fr.istic.sTanguy.Meth.TP.Interface.Subject;
import fr.istic.sTanguy.Meth.TP.classe.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Logger;



@RunWith(MockitoJUnitRunner.class)
class TestObserver {
	
	
	
//	private Observer obs1;
//	private CopyCmd copy;
//	private CutCmd cut;
//	private DeleteCmd del;
//	private InsertCmd ins;
//	private moveCursorCmd Mcursor;
//	private PasteCmd pas;
//	private SetMarkerCmd Smarker;
//	
//	@Test
//	@DisplayName("test QuitCmd")
//	public void testQuit() throws Exception {
//	    IHM ihm = new IHM(); 
//	    Command com = Mockito.mock(Command.class);
//	    
//	     // Setup a mock input stream
//	    String mockInput = "Quit\nQuit\n";
//	    InputStream mockReadStream = new ByteArrayInputStream(mockInput.getBytes());
//	    ihm.setReadStream(mockReadStream);
//
//	    ihm.addCommand("Quit", com);
//
//	    // Install a command to stop the invoker's loop
//	    {
//	        Command quitCmd;
//
//	        quitCmd = new Command() {
//
//	            @Override
//	            public void execute() {
//	                ihm.stopLoop();
//	                Logger.getGlobal().info("Invoker stopped by test case");
//	            }
//	        };
//	        ihm.addCommand("Quit", quitCmd);
//	    }
//
//	    ihm.runInvokerLoop();
//	    Mockito.verify(com).execute();
//	    
//	}
	@Test
	@DisplayName("test de la methode doUpdate")
	public void testdoUpdate() {
			
			EngineImplement subject = new EngineImplement();
			IHM ihm = new IHM(); 
		    Command com = Mockito.mock(Command.class);
		    String mockInput = "ins\nins\n";
		    InputStream mockReadStream = new ByteArrayInputStream(mockInput.getBytes());
		    ihm.setReadStream(mockReadStream);
		    char c = 'c';
		    ihm.addCommand("ins", new InsertCmd(subject,c));
		    assertEquals("c",subject.getBufferContents());
	}
}

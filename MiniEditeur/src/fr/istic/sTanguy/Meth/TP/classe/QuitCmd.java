package fr.istic.sTanguy.Meth.TP.classe;

import fr.istic.sTanguy.Meth.TP.Interface.Command;

public class QuitCmd implements Command {
    private final IHM receiver;

    public QuitCmd(IHM receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        this.receiver.stopLoop();
        
    }
}
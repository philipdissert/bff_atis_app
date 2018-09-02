package edu.kit.cm.BffAtisApp;

import edu.kit.cm.BffAtisApp.Thread.UtilisationThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadManager {
    @Autowired
    public ThreadManager() {
        UtilisationThread ut = new UtilisationThread();
        ut.start();
    }
}

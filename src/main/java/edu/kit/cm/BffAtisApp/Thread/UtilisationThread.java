package edu.kit.cm.BffAtisApp.Thread;

import edu.kit.cm.BffAtisApp.Service.UtilisationAdapter;

public class UtilisationThread extends Thread {

    @Override
    public void run() {
        UtilisationAdapter utilisationAdapter = UtilisationAdapter.getInstance();
        while(true){
            try {
                utilisationAdapter.update();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

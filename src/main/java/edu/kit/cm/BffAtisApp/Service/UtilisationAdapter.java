package edu.kit.cm.BffAtisApp.Service;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class UtilisationAdapter {

    private static UtilisationAdapter instance;
    private UtilisationAdapter(){}

    public static UtilisationAdapter getInstance() {
        if(instance!=null) {
            return instance;
        } return instance = new UtilisationAdapter();
    }

    public void update() {
        RestTemplate rt = new RestTemplate();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("poolElements",rt.getForEntity("https://workspace.cm.tm.kit.edu/layout/poolElements", String.class).getBody());
        jsonObject.put("computersWithState",rt.getForEntity("https://workspace.cm.tm.kit.edu/getComputersWithState", String.class).getBody());
        ResponseEntity<Map> responseEntity = new ResponseEntity(jsonObject.toMap(), HttpStatus.OK);
        rt.put("https://utilization.cm.tm.kit.edu/update", responseEntity);
    }
}

package edu.kit.cm.BffAtisApp.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ATISAdapter {

    private static ATISAdapter atisAdapter;
    public static ATISAdapter getInstance() {
        if(atisAdapter!=null) {
            return atisAdapter;
        } return atisAdapter=new ATISAdapter();
    }
    private ATISAdapter(){}

    private HashMap<LocalDateTime,Integer> getHistoryEntryMap(LocalDateTime localDateTime) {
        HashMap<LocalDateTime,Integer> map = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd_HH:mm");
        String[] array = getSeatsStringArray();
        for(int i = array.length-1; i >= 0; i--) {
            String[] string = array[i].split(" ");
            int seats = Integer.parseInt(string[1]);
            LocalDateTime date = LocalDateTime.parse(string[0], formatter);
            if(!date.isAfter(localDateTime)){
                break;
            }
            map.put(date,seats);
        }
        return map;
    }


    private String[] getSeatsStringArray() {
        RestTemplate rt = new RestTemplate();
        String in = rt.getForEntity("https://webadmin.informatik.kit.edu/pool/html/freeseats.txt",String.class).getBody();
        String[] stringArray = in.split("\\r?\\n");
        return  stringArray;
    }

    public HashMap<LocalDateTime,Integer> getSeatsMap(LocalDateTime localDateTime) {
        return getHistoryEntryMap(localDateTime);
    }

    /*
    @GetMapping("/test")
    public List<HistoryEntry> getHistoryEntryList() {
        List<HistoryEntry> list = new ArrayList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd_HH:mm");
        String[] array = getSeatsStringArray();
        for(int i = array.length-1; i >= 0; i--) {
            String[] string = array[i].split(" ");
            int seats = Integer.parseInt(string[1]);
            LocalDateTime date = LocalDateTime.parse(string[0], formatter);
            if(!date.isAfter(LocalDateTime.now().minusDays(1))){
                break;
            }
            list.add(new HistoryEntry(date, seats));
        }
        return list;
    }

    @GetMapping("/test2")
    public HistoryEntry getLastHistoryEntry() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd_HH:mm");
        String[] array = getSeatsStringArray();
        String[] string = array[array.length-1].split(" ");
        LocalDateTime date = LocalDateTime.parse(string[0], formatter);
        int seats = Integer.parseInt(string[1]);
        return new HistoryEntry(date,seats);
    }

    private String[] getSeatsStringArray() {
        RestTemplate rt = new RestTemplate();
        String in = rt.getForEntity("https://webadmin.informatik.kit.edu/pool/html/freeseats.txt",String.class).getBody();
        String[] stringArray = in.split("\\r?\\n");
        return stringArray;
    }*/
}


package edu.kit.cm.BffAtisApp.Domain;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

import java.time.LocalDateTime;

@Getter@Setter@ToString
public class HistoryEntry {
    public HistoryEntry(LocalDateTime dateTime, int freePlaces) {
        this.dateTime = dateTime;
        this.freePlaces = freePlaces;
    }
    private LocalDateTime dateTime;
    private int freePlaces;

}

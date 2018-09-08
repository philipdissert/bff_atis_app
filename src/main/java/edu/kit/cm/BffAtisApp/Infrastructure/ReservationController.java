package edu.kit.cm.BffAtisApp.Infrastructure;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class ReservationController {

    private RestTemplate restTemplate = new RestTemplate();
    private String url = "https://reservation.cm.tm.kit.edu/reservation";
    private String urlPlWs = url+"/workspace/";
    //private String url = "http://localhost:8080";

    @GetMapping("/reservation")
    public ResponseEntity<String> getReservations() {
        return restTemplate.getForEntity(url,String.class);
    }

    @PostMapping("/reservation")
    public ResponseEntity<String> setReservations(@RequestBody String body) {
        return restTemplate.postForEntity(url,body,String.class);
    }

    @GetMapping("/reservation/name/{name}")
    public ResponseEntity<String> getReservationsByName(@PathVariable String name){
        return restTemplate.getForEntity(url+"/name/"+name,String.class);
    }

    @GetMapping("/reservation/workspace/{workspace}")
    public ResponseEntity<String> getReservationsByWorkspace(@PathVariable String workspace) {
        return restTemplate.getForEntity(urlPlWs+workspace, String.class);
    }

    @DeleteMapping("/reservation/workspace/{workspace}")
    public void deleteReservationsByWorkspace(@PathVariable String workspace) {
        restTemplate.delete(urlPlWs+workspace);
    }

    @GetMapping("/reservation/workspace/{workspace}/id/{id}")
    public ResponseEntity<String> getReservationsByWorkspaceAndId(@PathVariable String workspace, @PathVariable String id) {
        return restTemplate.getForEntity(urlPlWs+workspace+"/id/"+id, String.class);
    }

    @DeleteMapping("/reservation/workspace/{workspace}/id/{id}/type/{type}")
    public void deleteReservationsByWorkspaceIdAndType(@PathVariable String workspace, @PathVariable String id,@PathVariable String type) {
        restTemplate.delete(urlPlWs+workspace+"/id/"+id+"/type/"+type);
    }

    @GetMapping("/reservation/workspace/{workspace}/day/{day}")
    public ResponseEntity<String> getReservationsFromWorkspaceAtDay(@PathVariable String workspace, @PathVariable String day) {
        return restTemplate.getForEntity(urlPlWs+workspace+"/day/"+day, String.class);
    }

    @GetMapping("/reservation/workspace/{workspace}/start/{start}/end/{end}")
    public ResponseEntity<String> getAllReservationsBetween(@PathVariable String workspace, @PathVariable String start,@PathVariable String end) {
        return restTemplate.getForEntity(urlPlWs+workspace+"/start/"+start+"/end/"+end, String.class);
    }
}

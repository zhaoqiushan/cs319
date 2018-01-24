package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.time.Instant;
import java.util.Date;

public class Container
    private Integer volumeId;
    private String number;
    private String title;
    private String consignmentCode;
    private Instant createdAt;
    private Instant updatedAt;

    public Container(Integer volumeId, String number, String title, String consignmentCode){
        this.volumeId = volumeId;
        this.number = number;
        this.title = title;
        this.consignmentCode = consignmentCode;
        this.createdAt = Instant.now();
        this.updatedAt = createdAt;
    }
}

package lv.sh.models;

import java.util.List;

public class Device {

    private String id;
    private String deviceName;
    private String room;
    private String status;
    private boolean on;
    private double percentage;
    private List<Device> relatedDevices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public List<Device> getRelatedDevices() {
        return relatedDevices;
    }

    public void setRelatedDevices(List<Device> relatedDevices) {
        this.relatedDevices = relatedDevices;
    }
}

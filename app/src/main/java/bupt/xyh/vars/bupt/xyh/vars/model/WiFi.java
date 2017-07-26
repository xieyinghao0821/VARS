package bupt.xyh.vars.bupt.xyh.vars.model;

/**
 * Created by Administrator on 2017/7/25.
 */

public class WiFi {
    private String macAddress;
    private String ssid;
    private Integer signalStrength;

    public WiFi(String macAddress, String ssid, Integer signalStrength) {
        this.macAddress = macAddress;
        this.ssid = ssid;
        this.signalStrength = signalStrength;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public Integer getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(Integer signalStrength) {
        this.signalStrength = signalStrength;
    }

    @Override
    public String toString() {
        return "macAddress='" + macAddress + '\'' + "\n" +
                "ssid='" + ssid + '\'' + "\n" +
                "signalStrength=" + signalStrength + '\'';
    }
}

package rechard.learn.web.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
//@PropertySource(value = "classpath:SupportedOperations.yml", factory = YamlConfigFactory.class)
@RefreshScope
@ConfigurationProperties(prefix = "idealx")
public class SupportedOperations {

    private boolean ocpSwitch;
    private Map<String, String> ocpOperations = new HashMap<String, String>();
    private Map<String, String> i3Operations = new HashMap<String, String>();
    //key=service name  ,  value=host
    private Map<String, String> ocpUrls;

    private String i3EntryUrl;

    private String i3SecEntryUrl;

    public void setOcpUrls(Map<String, String> ocpUrls) {
        this.ocpUrls = ocpUrls;
    }

    public Map<String, String> getOcpUrls() {
        return ocpUrls;
    }

    public void setI3EntryUrl(String i3EntryUrl) {
        this.i3EntryUrl = i3EntryUrl;
    }

    private String getI3EntryUrl() {
        return i3EntryUrl;
    }

    public void setI3SecEntryUrl(String i3SecEntryUrl) {
        this.i3SecEntryUrl = i3SecEntryUrl;
    }

    private String getI3SecEntryUrl() {
        return i3SecEntryUrl;
    }

    public void setI3Operations(Map<String, String> operations) {
        this.i3Operations = operations;
    }

    public Map<String, String> getI3Operations() {
        return i3Operations;
    }


    public void setOcpOperations(Map<String, String> operations) {
        this.ocpOperations = operations;
    }

    public Map<String, String> getOcpOperations() {
        return ocpOperations;
    }

    public String getOperation(String key) {
        return ocpSwitch? ocpOperations.get(key) : i3Operations.get(key);
    }

    public boolean isOcpSwitch() {
        return ocpSwitch;
    }

    public void setOcpSwitch(boolean ocpSwitch) {
        this.ocpSwitch = ocpSwitch;
    }

    private String getOcpUrl(String operation) {
        String serviceName = operation.substring(0, operation.indexOf("/")+1);
        return ocpUrls.get(serviceName);
    }

    public String getSecEntryUrl(String operation){
        return ocpSwitch?getOcpUrl(operation) : i3SecEntryUrl;
    }

    public String getEntryUrl(String operation){
        return ocpSwitch?getOcpUrl(operation) : i3EntryUrl;
    }


}
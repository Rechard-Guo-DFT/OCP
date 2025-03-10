package rechard.learn.web.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import rechard.learn.web.config.SupportedOperations;


@RestController
@RefreshScope
public class TestController {

    @Autowired
    private SupportedOperations supportedOperations;



    @GetMapping("/ocpStatus")
    public boolean ocpSwitch (){
        return supportedOperations.isOcpSwitch();
    }

    @GetMapping("/i3size")
    public int i3size (){
        return supportedOperations.getI3Operations().size();
    }
}

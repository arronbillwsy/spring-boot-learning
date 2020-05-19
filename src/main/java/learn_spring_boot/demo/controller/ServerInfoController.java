package learn_spring_boot.demo.controller;

import learn_spring_boot.demo.response.ResponseEntity;
import learn_spring_boot.demo.util.ServerUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/5/9 10:14
 **/

@RestController
@RequestMapping("/api/server")
public class ServerInfoController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity testLock() throws UnknownHostException {
        Map<String, Object> res = new HashMap<>();
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();
        ServerUtil serverUtil = new ServerUtil();
        Map<String, Object> cpu = serverUtil.getCpuInfo(hardwareAbstractionLayer.getProcessor());
        Map<String, Object> mem = serverUtil.getMemInfo(hardwareAbstractionLayer.getMemory());
        Map<String, Object> sys = serverUtil.getSysInfo();
        Map<String, Object> jvm = serverUtil.getJvmInfo();
        Map<String, Object> sysFiles = serverUtil.getSysFilesInfo(systemInfo.getOperatingSystem());
        res.put("CPU", cpu);
        res.put("Mem", mem);
        res.put("Sys", sys);
        res.put("JVM", jvm);
        res.put("Sys Files", sysFiles);
        return new ResponseEntity(res);
    }

}

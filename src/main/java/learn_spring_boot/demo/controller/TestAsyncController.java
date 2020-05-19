package learn_spring_boot.demo.controller;

import learn_spring_boot.demo.response.ResponseEntity;
import learn_spring_boot.demo.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/5/11 14:24
 **/
@RestController
@RequestMapping(value = "/api/async")
public class TestAsyncController {
    @Autowired
    private AsyncService asyncService;


    @RequestMapping(value = "/test")
    public ResponseEntity testAsyncNoReturn() {
        long start = System.currentTimeMillis();
        asyncService.doNoReturn();
        String res = String.format("任务执行成功,耗时{%s}", System.currentTimeMillis() - start);
        return new ResponseEntity(res);
    }

    @RequestMapping(value = "/return")
    public ResponseEntity testAsyncReturn() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<Future<String>> futures = new ArrayList<>();
        for (int i=0; i<1; i++) {
            Future<String> future = asyncService.doReturn(i);
            futures.add(future);
        }
        List<String> response = new ArrayList<>();
        for (Future future: futures) {
            String string = (String) future.get();
            response.add(string);
        }
        return new ResponseEntity();
    }
}

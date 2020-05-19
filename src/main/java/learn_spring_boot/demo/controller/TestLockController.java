package learn_spring_boot.demo.controller;

import learn_spring_boot.demo.response.ResponseEntity;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/5/6 17:16
 **/
@RestController
@RequestMapping("/api/lock")
public class TestLockController {
//    private final CuratorFramework client;
//    private static final String ZK_LOCK_PATH = "/zktest/lock0";
//
//    @Autowired
//    public testLock(CuratorFramework client) {
//        this.client = client;
//    }
//
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity testLock() throws InterruptedException {
//        final InterProcessMutex mutex = new InterProcessMutex(client, ZK_LOCK_PATH);
//        for (int i=0; i<3; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    doWithLock(client, mutex);
//                }
//            };
//            Thread thread = new Thread(runnable, "Thread-"+i);
//            thread.start();
//        }
//        return new ResponseEntity();
//    }
//
//    private void doWithLock(CuratorFramework client, InterProcessMutex mutex) {
//        try {
//            String name = Thread.currentThread().getName();
//            if (mutex.acquire(1, TimeUnit.SECONDS)) {
//                System.out.println(name+" hold lock");
//                System.out.println(client.getChildren().forPath(ZK_LOCK_PATH));
//                Thread.sleep(5000L);
//                System.out.println(name+" release lock");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                mutex.release();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}

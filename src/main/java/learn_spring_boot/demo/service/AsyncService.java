package learn_spring_boot.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Future;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/5/11 14:22
 **/
@Service
public class AsyncService {

    @Async
    public void doNoReturn() {
        try {
            Thread.sleep(3000);
            System.out.println("执行结束"+ new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public Future<String> doReturn(int i) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(String.format("这是第{%s}个异步调用的", i));
    }
}

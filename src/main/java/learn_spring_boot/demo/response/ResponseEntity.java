package learn_spring_boot.demo.response;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/4/27 15:05
 **/
public class ResponseEntity<T> {
    private boolean success = true;
    private String msg;
    private T data;
    public ResponseEntity() {}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseEntity(T data){
        this.data = data;
    }

    public ResponseEntity(boolean success, String msg) {
        this.msg = msg;
        this.success = success;
    }


}

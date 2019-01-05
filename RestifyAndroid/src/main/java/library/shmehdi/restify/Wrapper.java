package library.shmehdi.restify;

import java.util.List;

/**
 * Created By Syed Hussain Medhi
 * email : shmehdi01@gmail.com
 * youtube : youtube.com/shmehdi5
 * */

@SuppressWarnings("unchecked")
@Deprecated
public class Wrapper<Model> {


    private Wrapper.Status status;
    private List<Model> data;

    public Status getStatus() {
        return status;
    }

    public List<Model> getData() {
        return data;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setData(List<Model> data) {
        this.data = data;
    }


    @Deprecated
    public class Status {
        private boolean success;
        private String msg;

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
    }
}

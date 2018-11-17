package library.shmehdi.restify;

/**
 * Created By Syed Hussain Medhi
 * email : shmehdi01@gmail.com
 * youtube : youtube.com/shmehdi5
 * */

public interface Response<Model> {

    /**
     * @Override this method where your are using {@link Service}
     * This method will return a response of your request
     * model is a model class you passing in generic {@link Service} and {@link Parser}
     * json is your response json
     * url is your request url
     * You need to null check if you are passing {@link Parser} as null in {@link Service} model will be null.
     * */
    public void onServerResponse(Model model, String json, String url);
}

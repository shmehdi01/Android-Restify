package library.shmehdi.restify;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created By Syed Hussain Medhi
 * email : shmehdi01@gmail.com
 * youtube : youtube.com/shmehdi5
 * */

public abstract class Parser<T>{

   protected Gson gson;

   public Parser(){
       gson = new Gson();
   }


    /**
     * This method is actually parsing the json using {@link Gson}
     */

    protected T parse(String s){
        if(parseJson() != null) return gson.fromJson(s,parseJson().getType()); return null;
    }

    /**
     * This method will parse your json request {@link Response}
     * The return type of this method is TypeToken with your model class
     * This method will be implemented and you have to return new TypeToke
     *
     * e.g return new TypeToken<YourModel>(){};
     * */

    protected abstract TypeToken<T> parseJson();

}

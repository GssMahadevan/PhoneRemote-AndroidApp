package gssm.org.tvremote;

import com.google.gson.annotations.SerializedName;

// not that much used
public class CmdResponse {
    @SerializedName("code")
    private String code;

    @SerializedName("model")
    private String model;


    public String getCode(){
        return code;
    }

    public String getModel(){
        return model;
    }
}
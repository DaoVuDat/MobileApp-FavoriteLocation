package daovudat.demoproject;

import java.io.Serializable;

/**
 * Created by Dao Vu Dat on 7/2/2016.
 */
public class OptionView implements Serializable {
    private String name;
    private String des;

    public OptionView(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }
}

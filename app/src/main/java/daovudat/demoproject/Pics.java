package daovudat.demoproject;

import android.graphics.Bitmap;

/**
 * Created by Dao Vu Dat on 7/4/2016.
 */
public class Pics {

    private Bitmap image;

    public Pics(  Bitmap image) {


        this.image = image;
    }


    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}

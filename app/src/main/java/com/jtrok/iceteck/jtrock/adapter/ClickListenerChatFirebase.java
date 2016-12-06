package com.jtrok.iceteck.jtrock.adapter;

/**
 * Created by dhmxl on 12/2/16.
 */

/* public class ClickListenerChatFirebase {
} */
import android.view.View;


public interface ClickListenerChatFirebase {

    /**
     * Quando houver click na imagem do chat
     * @param view
     * @param position
     */
    void clickImageChat(View view, int position,String nameUser,String urlPhotoUser,String urlPhotoClick);

    /**
     * Quando houver click na imagem de mapa
     * @param view
     * @param position
     */
    void clickImageMapChat(View view, int position,String latitude,String longitude);

}

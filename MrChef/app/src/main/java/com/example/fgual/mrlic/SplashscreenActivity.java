package com.example.fgual.mrlic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.f.mrlic.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashscreenActivity extends Activity {
    private ImageView image;
    private Animation animation;
    private Animation animation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        //assegno ad image l'immagine definita nel layout della splash activity avente come ID imageSpalsh
        image = (ImageView) findViewById(R.id.imageSplah);
        //assegno ad animation l'animazione definita nel file rotate.xml presente nella cartella animator
        animation = AnimationUtils.loadAnimation(getBaseContext(), R.animator.rotate);
        //assegno ad animation2 l'animazione definita nel file fade.xml presente nella cartella animator
        animation2 = AnimationUtils.loadAnimation(getBaseContext(), R.animator.fade);
        //mando in esecuzione l'animazione per effettuare la rotazione dell'immagine
        image.startAnimation(animation);
        //imposta un evento generato dalla rotazione dell'imagine
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            //al termine della rotazione eseguo questo metodo
            @Override
            public void onAnimationEnd(Animation animation) {
                //avvia l'animazione di dissolvenza
                image.startAnimation(animation2);
                finish();
                //al termine dell'evento di dissolvenza avvio l'intent per effettuare lo switch delle activities
                Intent intent = new Intent(SplashscreenActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}

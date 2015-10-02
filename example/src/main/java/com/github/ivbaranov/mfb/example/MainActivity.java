package com.github.ivbaranov.mfb.example;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;

public class MainActivity extends AppCompatActivity {
  private TextView niceCounter;
  private int niceCounterValue = 37;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    //in the toolbar
    MaterialFavoriteButton toolbarFavorite = new MaterialFavoriteButton.Builder(this) //
        .favorite(true)
        .color(MaterialFavoriteButton.STYLE_WHITE)
        .type(MaterialFavoriteButton.STYLE_HEART)
        .rotationDuration(400)
        .create();
    toolbar.addView(toolbarFavorite);
    toolbarFavorite.setOnFavoriteChangeListener(
        new MaterialFavoriteButton.OnFavoriteChangeListener() {
          @Override
          public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
            Snackbar.make(buttonView, getString(R.string.toolbar_favorite_snack) + favorite,
                Snackbar.LENGTH_SHORT).show();
          }
        });

    //nice cardview
    niceCounter = (TextView) findViewById(R.id.counter_value);
    niceCounter.setText(String.valueOf(niceCounterValue));
    MaterialFavoriteButton materialFavoriteButtonNice =
        (MaterialFavoriteButton) findViewById(R.id.favorite_nice);
    materialFavoriteButtonNice.setFavorite(true, false);
    materialFavoriteButtonNice.setOnFavoriteChangeListener(
        new MaterialFavoriteButton.OnFavoriteChangeListener() {
          @Override
          public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
            if (favorite) {
              niceCounterValue++;
            } else {
              niceCounterValue--;
            }
          }
        });
    materialFavoriteButtonNice.setOnFavoriteAnimationEndListener(
        new MaterialFavoriteButton.OnFavoriteAnimationEndListener() {
          @Override
          public void onAnimationEnd(MaterialFavoriteButton buttonView, boolean favorite) {
            niceCounter.setText(String.valueOf(niceCounterValue));
          }
        });
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}

package com.danielme.android.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setupToolbar();
    setupSpinnerWithResourceArray(R.id.spinner_basic, android.R.layout.simple_spinner_dropdown_item, android.R.layout.simple_spinner_item);
    setupSpinnerWithResourceArray(R.id.spinner_prompt, android.R.layout.simple_spinner_dropdown_item, android.R.layout.simple_spinner_item);
    setupSpinnerWithResourceArray(R.id.spinner_background, android.R.layout.simple_spinner_dropdown_item, android.R.layout.simple_spinner_item);
    setupSpinnerWithResourceArray(R.id.spinner_custom_layout, R.layout.textview_dropdown_spinner, R.layout.textview_spinner_selected);
    setupSpinnerCustomAdapter();
  }

  private void setupSpinnerCustomAdapter() {
    Spinner spinner = findViewById(R.id.spinner_custom_adapter);
    spinner.setAdapter(new SocialNetworkSpinnerAdapter(this, buildSocialNetworksList()));
  }

  private List<SocialNetwork> buildSocialNetworksList() {
    return List.of(new SocialNetwork(getString(R.string.none), R.drawable.none),
            new SocialNetwork(getString(R.string.facebook), R.drawable.facebook),
            new SocialNetwork(getString(R.string.reddit), R.drawable.reddit),
            new SocialNetwork(getString(R.string.twitter), R.drawable.twitter),
            new SocialNetwork(getString(R.string.youtube), R.drawable.youtube)
    );
  }

  private void setupSpinnerWithResourceArray(@IdRes int id, int layoutDropDown, int layoutSpinner) {
    Spinner spinner = findViewById(id);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.social_networks_array, layoutSpinner);
    spinner.setAdapter(adapter);
    adapter.setDropDownViewResource(layoutDropDown);

    /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected = (String) spinner.getItemAtPosition(position);
        Toast.makeText(MainActivity.this, selected, Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {
      }
    });*/
  }

  private void setupToolbar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

}

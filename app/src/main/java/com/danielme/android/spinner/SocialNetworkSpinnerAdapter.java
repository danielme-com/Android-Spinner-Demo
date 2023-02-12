package com.danielme.android.spinner;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class SocialNetworkSpinnerAdapter extends ArrayAdapter<SocialNetwork> {
  private Context context;

  private final List<SocialNetwork> items;

  public SocialNetworkSpinnerAdapter(Context context, List<SocialNetwork> items) {
    super(context, R.layout.social_network_selected_item, items);
    this.context = context;
    this.items = items;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    return getView(position, convertView, parent, R.layout.social_network_selected_item);
  }

  @Override
  public View getDropDownView(int position, View convertView, ViewGroup parent) {
    return getView(position, convertView, parent, R.layout.social_network_item);
  }

  private View getView(int position, View convertView, ViewGroup parent, int layout) {
    View row = convertView;
    if (row == null) {
      row = inflate(parent, layout);
      createViewHolder(row);
    }
    setData(position, row);
    return row;
  }

  private View inflate(ViewGroup parent, int layout) {
    LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    return layoutInflater.inflate(layout, parent, false);
  }

  private void setData(int position, View row) {
    SocialNetwork redSocial = items.get(position);
    ((SocialNetworkViewHolder) row.getTag()).icon.setImageResource(redSocial.getIcon());
    ((SocialNetworkViewHolder) row.getTag()).label.setText(redSocial.getName());
  }

  private void createViewHolder(View row) {
    SocialNetworkViewHolder redSocialHolder = new SocialNetworkViewHolder();
    redSocialHolder.icon = (row.findViewById(R.id.imageViewIcon));
    redSocialHolder.label = (row.findViewById(R.id.textViewLabel));
    row.setTag(redSocialHolder);
  }

  private static class SocialNetworkViewHolder {

    ImageView icon;

    TextView label;

  }

}

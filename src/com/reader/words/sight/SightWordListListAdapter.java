package com.reader.words.sight;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.reader.words.sight.model.SightWordList;

public class SightWordListListAdapter 
extends ArrayAdapter<SightWordList>
{

	private Context context;
	private List<SightWordList> sightWordLists;

	public SightWordListListAdapter(Context context, List<SightWordList> sightWordLists) {
		super(context, R.layout.sightword_lists_layout, sightWordLists);
		this.context = context;
		this.sightWordLists = sightWordLists;
	}
	
	public int getCount() {
		return sightWordLists.size();
	}

	public SightWordList getItem(int position) {
		return sightWordLists.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View view, ViewGroup group) {

		SightWordList sightWordList = getItem(position);

		if (view == null) {

			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			view = inflater.inflate(R.layout.sightword_lists_list_row, null);
		}

		TextView sightWordListTextView 
			= (TextView)view.findViewById(R.id.sightword_list_text_view);
		
		sightWordListTextView.setText(sightWordList.getName());
		view.setBackgroundColor(Color.BLACK);
		
		ImageView imageView 
			= (ImageView) view.findViewById(R.id.selected_image_view);
		
		if (sightWordList.isCurrent()) {
			imageView.setVisibility(View.VISIBLE);
		} else {
			imageView.setVisibility(View.INVISIBLE);
		}

		if (view.isSelected()) {
			view.setBackgroundColor(Color.BLUE);
		}
		
		return view;
	}
}

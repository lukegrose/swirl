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

import com.reader.words.sight.model.SightWord;

public class AllSightWordsAdapter extends ArrayAdapter<SightWord> {

	private Context context;
	private List<SightWord> sightWords;

	public AllSightWordsAdapter(Context context, List<SightWord> sightWords) {
		
		super(context, R.layout.all_sightwords_row, sightWords);
		this.context = context;
		this.sightWords = sightWords;
		
	}

	public int getCount() {
		return sightWords.size();
	}

	public SightWord getItem(int position) {
		return sightWords.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View view, ViewGroup group) {

		SightWord sightWord = getItem(position);

		if (view == null) {

			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			view = inflater.inflate(R.layout.all_sightwords_row, null);
		}

		ImageView imgView = (ImageView) view.findViewById(R.id.all_sightword_image_view);
		
		TextView sightWordTextView 
			= (TextView)view.findViewById(R.id.all_sightword_text_view);
		
		sightWordTextView.setText(sightWord.getValue().toLowerCase());
		
		if (! sightWord.isHighlighted()) {
			view.setBackgroundColor(Color.BLUE);
			imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_input_add));
		} else {
			view.setBackgroundColor(Color.BLACK);
			imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_delete));
		}

		return view;
	}
}

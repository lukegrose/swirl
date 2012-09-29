package com.reader.words.sight;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.reader.words.sight.model.SightWord;
import com.reader.words.sight.model.SightWordList;

public class SelectedSightWordsAdapter extends ArrayAdapter<SightWord> {

	private Context context;
	private List<SightWord> sightWords;

	public SelectedSightWordsAdapter(Context context, List<SightWord> sightWords) {
		
		super(context, R.layout.selected_sightwords_row, sightWords);
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

			view = inflater.inflate(R.layout.selected_sightwords_row, null);
		}

		TextView sightWordTextView 
			= (TextView)view.findViewById(R.id.selected_sightword_text_view);
		
		sightWordTextView.setText(sightWord.getValue().toLowerCase());

		return view;
	}
}

package com.reader.words.sight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.reader.words.sight.model.SightWord;
import com.reader.words.sight.model.SightWordList;
import com.reader.words.sight.model.SightWordsReaderDb;

public class ReaderActivity extends Activity {

	private static final int WORDS_PER_LINE = 8;
	
	private String[] paragraphs;
	private int currentParagraph;
	private LinearLayout textLayout;
	private RelativeLayout navButtonsLayout;
	private boolean firstPage = true;
	private List<String> imageMap = new ArrayList<String>();
	private Map<String, SightWord> sightWords = new HashMap<String, SightWord>();

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.reader_layout);
		
		fillImageMap();

		Resources res = getResources();
		paragraphs = res.getStringArray(R.array.humpty_dumpty_paragraphs);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setCurrentParagraph(true);
	}
	
	
    
    @Override
	protected void onResume() {
		super.onResume();
		populateSightWords();
	    refreshView(true);
	}

	private void populateSightWords() {
		
    	SightWordsReaderDb db = SightWordsReaderDb.getInstance(this);
		SightWordList sightWordList = db.getCurrentlyActiveList();
		
		for (SightWord word : sightWordList.getSightWords()) {
			sightWords.put(word.getValue(), word);
		}
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.reader_items, menu);
        return super.onCreateOptionsMenu(menu);
    }

	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
 
        super.onOptionsItemSelected(item);
 
        switch(item.getItemId()){
            
        
	        case android.R.id.home: 
				onBackPressed();
				break;
			
            case R.id.copyright:
            	startActivity(new Intent(this, CopyrightActivity.class));
                break;
 
            case R.id.help:
            	startActivity(new Intent(this, HelpActivity.class));
                break;    
                
            case R.id.about:
            	startActivity(new Intent(this, AboutActivity.class));
                break;
                
            case R.id.bookshelf:
            	startActivity(new Intent(this, BookshelfActivity.class));
                break;    
        }       
 
        return true;
    }
	
	private void refreshView(boolean forward) {

		if (textLayout == null) {
			textLayout = (LinearLayout) findViewById(R.id.reader_text_layout);
		}

		textLayout.removeAllViews();
		populateSightWords();
		flip(forward);

		if (navButtonsLayout == null) {
			
			navButtonsLayout 
				= (RelativeLayout) findViewById(R.id.reader_nav_button_layout);
			
		}
		
//		addBookshelfButton();
		addBackButton();
		addNextButton();
		setBackgroundImage();

	}

	private void setBackgroundImage() {
		// nothing for now
	}

	private void addBookshelfButton() {
		
		Button homeButton = new Button(this);
		homeButton.setText("bookshelf");
		
		RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		relativeParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		relativeParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		homeButton.setLayoutParams(relativeParams);
		
		homeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});

		navButtonsLayout.addView(homeButton);
	}

	private void addNextButton() {
		
		Button nextButton = new Button(this);
		nextButton.setText("next");

		RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		relativeParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		relativeParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		nextButton.setLayoutParams(relativeParams);

		nextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setCurrentParagraph(true);
				refreshView(true);
			}
		});

		navButtonsLayout.addView(nextButton);
	}

	private void addBackButton() {
		
		Button backButton = new Button(this);
		backButton.setText("back");

		RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		relativeParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		backButton.setLayoutParams(relativeParams);

		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setCurrentParagraph(false);
				refreshView(false);
			}
		});

		navButtonsLayout.addView(backButton);
	}

	private void flip(boolean forward) {

//		setCurrentParagraph(forward);
				
		if (currentParagraph < paragraphs.length) {
			
			setCurrentImage();
			String[] words = paragraphs[currentParagraph].split(" ");
			LinearLayout lineLayout = new LinearLayout(this);
			lineLayout.setOrientation(LinearLayout.HORIZONTAL);
			
//			orientSelfToPageNumbers(lineLayout);
			
			textLayout.addView(lineLayout);
			int count = 1;

			for (String wd : words) {
				
				if (count % WORDS_PER_LINE == 0) {
					lineLayout = new LinearLayout(this);
					lineLayout.setOrientation(LinearLayout.HORIZONTAL);
					textLayout.addView(lineLayout);
				}

				TextView tv = new TextView(this);
				tv.setText(wd + " ");
				
				SightWord sightWord 
					= sightWords.get(wd.trim().split("\\W")[0].toUpperCase());
				
				styleTextView(tv, sightWord);
				lineLayout.addView(tv);
				count++;
			}
		} else {
			onBackPressed();
		}
	}
	
	private void orientSelfToPageNumbers(LinearLayout layout) {
		TextView orientation = new TextView(this);
		orientation.setText("[" + currentParagraph + "]");
		layout.addView(orientation);
	}
	
	private void styleTextView(TextView tv, SightWord sightWord) {
		if (sightWord != null && sightWord.isHighlighted()) {
			tv.setTextColor(Color.BLUE);
		} else {
			tv.setTextColor(Color.BLACK);
		}
	}
	
	private void setCurrentImage() {
		
		ImageView imageView 
			= (ImageView) findViewById(R.id.reader_image_view);
	
		int id 
			= getResources().getIdentifier(
					"drawable/" + imageMap.get(currentParagraph), 
					"drawable", 
					getPackageName());
	
		imageView.setImageResource(id);
	}
	
	private void setCurrentParagraph(boolean forward) {
		if (forward) {
			if (firstPage) {
				firstPage = false;
			} else {
				currentParagraph++;
			}
		} else {
			if (currentParagraph == 0) {
				onBackPressed();
			} else {
				currentParagraph--;
			}
		}
	}
	
	private void fillImageMap() {
		
		imageMap.add(0, "dancing");
		imageMap.add(1, "dancing");
		imageMap.add(2, "hen2");
		imageMap.add(3, "hen2");
		imageMap.add(4, "king2");
		imageMap.add(5, "king2");
		imageMap.add(6, "king2");
		imageMap.add(7, "hen2");
		imageMap.add(8, "hen2");
		imageMap.add(9, "farmerswife");
		imageMap.add(10, "farmerswife");
		imageMap.add(11, "potdrop");
		imageMap.add(12, "potdrop");
		imageMap.add(13, "potjump");
		imageMap.add(14, "potjump");
		imageMap.add(15, "diving");
		imageMap.add(16, "tightrope");
		imageMap.add(17, "banjo1");
		imageMap.add(18, "banjo2");
		imageMap.add(19, "oldman");
		imageMap.add(20, "bowing");
	}
}

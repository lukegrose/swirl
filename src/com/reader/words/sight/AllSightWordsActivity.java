package com.reader.words.sight;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.reader.words.sight.model.SightWord;
import com.reader.words.sight.model.SightWordsReaderDb;

public class AllSightWordsActivity extends ListActivity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_sightwords_layout);
        
        populateAllSightWords();
        //Show the dolce words by level
        //each word has a check box next to it
    }
    
    private void populateAllSightWords() {
		SightWordsReaderDb db = SightWordsReaderDb.getInstance(this);
		List<SightWord> sightWords = db.allWords();
		setListAdapter(new AllSightWordsAdapter(this, sightWords));
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.all_sightwords_items, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
 
        super.onOptionsItemSelected(item);
 
        switch(item.getItemId()){
        
        	case R.id.show_selected_sightwords:
        		startActivity(new Intent(this, SelectedSightWordsActivity.class));
        		break;
        		
        	case R.id.create_new_word:
        		startActivity(new Intent(this, NewWordActivity.class));
                break;
 
            case R.id.copyright:
                Toast.makeText(getBaseContext(), "You selected 'Copyright'", Toast.LENGTH_SHORT).show();
                break;
 
//            case R.id.highlight:
//                Toast.makeText(getBaseContext(), "You selected 'Highlight'", Toast.LENGTH_SHORT).show();
//                break;     
                
            case R.id.help:
                Toast.makeText(getBaseContext(), "You selected 'Help'", Toast.LENGTH_SHORT).show();
                break;    
                
            case R.id.about:
                Toast.makeText(getBaseContext(), "You selected 'About'", Toast.LENGTH_SHORT).show();
                break;
        }       
 
        return true;
    }
    
    public void handleShowEditWord(View view) {
    	startActivity(new Intent(this, AboutActivity.class));
    }
}

package com.reader.words.sight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.reader.words.sight.model.SightWord;
import com.reader.words.sight.model.SightWordList;
import com.reader.words.sight.model.SightWordsReaderDb;

public class SelectedSightWordsELVActivity extends ExpandableListActivity { 
	
	private SightWordList sightWordList;
	private SightWordsReaderDb db;
	
	private List<String> alphabet = Arrays.asList(new String[] {
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", 
			"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" 
		});
	
	public void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.selected_elv_main);
 
            db = SightWordsReaderDb.getInstance(this);
//            sightWordList = db.getSightWordList("Dolch - All");
//            sightWordList = db.getSightWordList("Dolch - PrePrimer");
            sightWordList = db.getSightWordList("Dolch - Nouns");
            
	        ExpandableAppAdapter expListAdapter =
	            new ExpandableAppAdapter(
	                    this,
	                    createGroupList(),              
	                    createChildListWithLetters()     
	                );
        
            setListAdapter( expListAdapter );
 
        }catch(Exception e){
            System.out.println("Errrr +++ " + e.getMessage());
            throw new RuntimeException("Hello, McFly...look in the logs!");
        }
    }
	
	private List<Alphabet> createGroupList() {
    	return Arrays.asList(Alphabet.values());
    }
 
    private List<List<Map<String, SightWord>>> createChildListWithLetters() {
    	 
    	List<List<Map<String, SightWord>>> result 
    		= new ArrayList<List<Map<String, SightWord>>>();
        
        for (String letter : alphabet) {
        	result.add(getWordsStartingWith(letter));
        }
        
        return result;
    }
    
    private List<Map<String, SightWord>> getWordsStartingWith(String letter) {
    	
    	List<Map<String, SightWord>> secList = new ArrayList<Map<String, SightWord>>();
    	
    	for (SightWord sightWord : sightWordList.getSightWords()) {
    		
    		if (sightWord.getValue().toLowerCase().startsWith(letter.toLowerCase())) {
    			Map<String, SightWord> child = new HashMap<String, SightWord>();
    			child.put( "word", sightWord );
    			secList.add(child);
    		}
    	}
    	
    	return secList;
    }
    
    public void  onContentChanged  () {
        System.out.println("onContentChanged");
        super.onContentChanged();
    }
    
    public boolean onChildClick( ExpandableListView parent, View v, int groupPosition,int childPosition,long id) {
        System.out.println("Inside onChildClick at groupPosition = " + groupPosition +" Child clicked at position " + childPosition);
        return true;
    }
 
    /* This function is called on expansion of the group */
    public void  onGroupExpand  (int groupPosition) {
        try{
             System.out.println("Group exapanding Listener => groupPosition = " + groupPosition);
        }catch(Exception e){
            System.out.println(" groupPosition Errrr +++ " + e.getMessage());
        }
    }
    
    public void handleCancelButton(View view) {
    	onBackPressed();
    }
    
    public void handleSaveButton(View view) {
    	db.updateSelectedWords(sightWordList);
    	onBackPressed();
    }
}
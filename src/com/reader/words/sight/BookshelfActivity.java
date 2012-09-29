package com.reader.words.sight;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.reader.words.sight.model.GenUtil;
import com.reader.words.sight.model.SightWordList;

public class BookshelfActivity extends Activity implements TabListener {

	private static final int DIALOG_COPYRIGHT_ID = 0;
	private static final int DIALOG_HELP_ID = 1;
	private static final int DIALOG_ABOUT_ID = 2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookshelf_layout);
        
        List<SightWordList> lists = new ArrayList<SightWordList>();
        GenUtil.fillSightWordListDeep(lists);
        
        
//        ActionBar actionBar = getActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//        actionBar.setNavigationMode(ActionBar.DISPLAY_HOME_AS_UP);
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        
        
        /*ActionBar.Tab wineTab = actionBar.newTab().setText("Wine");
        ActionBar.Tab cheeseTab = actionBar.newTab().setText("Cheese");
        
        wineTab.setTabListener(this);
        cheeseTab.setTabListener(this);
        
        actionBar.addTab(wineTab);
        actionBar.addTab(cheeseTab);*/
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bookshelf_items, menu);
        return super.onCreateOptionsMenu(menu);
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
 
        super.onOptionsItemSelected(item);
 
        switch(item.getItemId()){
        
            case R.id.bookshelf_sightword_lists:
            	startActivity(new Intent(this, SightWordListsActivity.class));
                break;
 
//            case R.id.highlight:
//                Toast.makeText(getBaseContext(), "You selected 'Highlight'", Toast.LENGTH_SHORT).show();
//                break;     
                
            case R.id.copyright:
            	startActivity(new Intent(this, CopyrightActivity.class));
                break;
 
            case R.id.help:
            	startActivity(new Intent(this, HelpActivity.class));
                break;    
                
            case R.id.about:
            	startActivity(new Intent(this, AboutActivity.class));
                break;
        }       
 
        return true;
    }
    
    public void handleStartReader(View view) {
    	
    	Toast.makeText(
    			getBaseContext(), 
    			"Loading...", 
    			Toast.LENGTH_SHORT).show();
    	
    	startActivity(new Intent(this, ReaderActivity.class));
    }
    
    public void handleGotoWordList(View view) {
    	startActivity(new Intent(this, SelectedSightWordsActivity.class));
    }
    
    @Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}
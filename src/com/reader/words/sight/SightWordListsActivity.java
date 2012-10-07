package com.reader.words.sight;

import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.reader.words.sight.model.SightWordList;
import com.reader.words.sight.model.SightWordsReaderDb;

public class SightWordListsActivity extends ListActivity {

	private ActionMode mActionMode;

	private SightWordListListAdapter mAdapter;
	private SightWordList mSelected;
	private SightWordsReaderDb mDb;
	private List<SightWordList> mAllSightWordLists;

	private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			MenuInflater inflater = mode.getMenuInflater();
			inflater.inflate(R.menu.context_sightword_lists, menu);
			return true;
		}

		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			return false;
		}

		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

			switch (item.getItemId()) {

			case R.id.edit_list:
				startActivity(new Intent(SightWordListsActivity.this,
						SelectedSightWordsELVActivity.class));
				mode.finish();
				return true;

			case R.id.make_active_list:

				if (SightWordListsActivity.this.mSelected != null) {
					
					Toast.makeText(
							getBaseContext(),
							"\"" + mSelected.getName()
									+ "\" is now the active list",
							Toast.LENGTH_SHORT).show();

					mDb.setCurrentlyActiveList(SightWordListsActivity.this.mSelected);
					mSelected = null;
					mAllSightWordLists = mDb.allListsDeep();
					mAdapter.notifyDataSetChanged();

				}
				mode.finish();
				return true;

			case R.id.delete_list:
				//this method is deprecated, it needs to be replaced with fragments
				showDialog(0);
				mode.finish();
				return true;

			default:
				return false;
			}
		}

		@Override
		public void onDestroyActionMode(ActionMode mode) {
			mSelected = null;
			mAllSightWordLists = mDb.allListsDeep();
			mAdapter.notifyDataSetChanged();
			mActionMode = null;
		}
	};

	protected Dialog onCreateDialog(int id) {

		AlertDialog.Builder builder = new AlertDialog.Builder(this,
				AlertDialog.THEME_TRADITIONAL);

		builder.setTitle("Warning!")
				.setMessage(
						"Delete the \"" + mSelected.getName()
								+ "\" list?")
				.setCancelable(false)
				.setPositiveButton("Delete",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Toast.makeText(
										getBaseContext(),
										"\"" + mSelected.getName()
												+ "\" has been deleted",
										Toast.LENGTH_SHORT).show();
								mDb.deleteList(mSelected);
								mSelected = null;
								mAllSightWordLists = mDb.allListsDeep();
								mAdapter.notifyDataSetChanged();
								dialog.cancel();
							}
						})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

		AlertDialog alert = builder.create();
		return alert;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sightword_lists_layout);
	}

	@Override
	protected void onResume() {
		initView();
		super.onResume();
	}

	private void initView() {

		if (mDb == null) {
			mDb = SightWordsReaderDb.getInstance(this);
		}

		mAllSightWordLists = mDb.allListsDeep();
		mAdapter = new SightWordListListAdapter(this, mAllSightWordLists);
		setListAdapter(mAdapter);
		ListView listView = getListView();
		listView.setClickable(true);
		listView.setItemsCanFocus(false);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.sightword_lists_items, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		super.onOptionsItemSelected(item);

		switch (item.getItemId()) {

//			case R.id.add_new_list:
//				startActivity(new Intent(this, AllSightWordsActivity.class));
//				break;
	
		
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

	@Override
	protected void onListItemClick(ListView listView, View linearLayout,
			int position, long id) {

		mSelected = mAdapter.getItem(position);
		mActionMode = startActionMode(mActionModeCallback);
		linearLayout.setSelected(true);
		return;
	}
}

package com.reader.words.sight.model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * 
 * This db is too simple to complicate it with anything too fancy.
 * 
 * @author Luke
 *
 */
public class SightWordsReaderDb  extends DataAccessObject {
	
	private List<SightWordList> dummyDeepLists;
	private List<SightWord> dummyWords;
	
	private static SightWordsReaderDb instance; 
	
	private String[] sightWordListCols = { "list_name" };
	private String[] sightWordCols = { "word" };
	private String[] sightWordListAssocCols = { "list_name", "word", "highlighted" };
	
	private SightWordsReaderDb(Context context) {
		
		super(context);
		
		dummyDeepLists = new ArrayList<SightWordList>();
		GenUtil.fillSightWordListDeep(dummyDeepLists);
		
		dummyWords = new ArrayList<SightWord>();
		GenUtil.fillAllWords(dummyWords);
		
	}
	
	public static SightWordsReaderDb getInstance(Context ctx) {
		
		if(instance == null) {
			instance = new SightWordsReaderDb(ctx);
		}
		
		return instance;
	}
	
//	CREATE
//  createList
	public SightWordList createSightWordList(SightWordList sightWordList) {
		
//		if successful, return the list with the id
//		if not successful return null
		
		return null;
	}

//	createWord
	public SightWord createSightWord(SightWord sightWord) {
		
//		if successful, return the word with the id
//		if not successful return null
		
		return null;
	}
	
//	READ
//	allListsDeep
	public List<SightWordList> allListsDeep() {
		return dummyDeepLists;
	}
	
//	allListsShallow
//	does not contain SightWords
	public List<SightWordList> allListsShallow() {
		return null;
	}
	
//	allWords
//	does not contain SightWords
	public List<SightWord> allWords() {
		return dummyWords;
	}
	
	public List<SightWord> allSelectedWords() {
		
		List<SightWord> selectedWords = new ArrayList<SightWord>();
		
		for(SightWord sightWord : dummyWords) {
			
			if (sightWord.isHighlighted()) {
				selectedWords.add(sightWord);
			}
		}
		
		return selectedWords;
	}
//	findListDeep
	public SightWordList findListDeep(int id) {
		return null;
	}
	
//	findListShallow
//	does not contain SightWords
	public SightWordList findListShallow(int id) {
		return null;
	}
	
//	findWord
//	does not contain SightWords
	public SightWordList findWord(int id) {
		return null;
	}
	
//	UPDATE
//	updateList
	public void updateList(SightWordList sightWordList) {
		
	}
	
//	updateWord
	public void updateWord(SightWord word) {
		
	}
	
	public List<SightWord> getSightWords(String wordListName) {
		
		List<SightWord> sightWords = new ArrayList<SightWord>();
		
		open();
		Cursor cursor = null;
		try {
	
			String where = "list_name" + " = '" + wordListName + "'";
			cursor = getDb().query(
					"sight_word_list_assoc", 
					sightWordListAssocCols, 
					where, 
					null, null, null, null
				);
	
			
			if (cursor != null) {
	
				boolean cursorMoveResult = cursor.moveToFirst();
				
				if (cursorMoveResult) {
	
					while (!cursor.isAfterLast()) {
					
						SightWord sightWord = new SightWord(
								0, 
								cursor.getString(1), 
								dbIntToBool(cursor.getInt(2))
							);
						
						sightWords.add(sightWord);
						
						cursor.moveToNext();
					}
				}
			}
	
			return sightWords;
			
		} finally {
			if (cursor != null) {
				cursor.close(); // close the cursor
				close(); // close the db
			}
		}
	}
	
	public SightWordList getSightWordList(String wordListName) {
		
		open();
		Cursor cursor = null;
		try {
	
			String where = "list_name" + " = '" + wordListName + "'";
			cursor = getDb().query(
					"sight_word_list", 
					sightWordListCols, 
					where, 
					null, null, null, null);
	
			SightWordList sightWordList = null;
	
			if (cursor != null) {
	
				boolean cursorMoveResult = cursor.moveToFirst();
	
				if (cursorMoveResult) {
	
					sightWordList = new SightWordList(
							0,
							cursor.getString(0),
							true,
							this.getSightWords(wordListName));
				}
			}
	
			return sightWordList;
			
		} finally {
			if (cursor != null) {
				cursor.close(); // close the cursor
				close(); // close the db
			}
		}
	}
	
	public boolean updateSelectedWords(SightWordList wordList) {
		
		List<SightWord> dbSightWords = getSightWords(wordList.getName());
		
		open();
		
		for(SightWord inmemorySightWord : wordList.getSightWords()) {
			
			for (SightWord dbSightWord : dbSightWords) {
				
				if ( hasChanged(dbSightWord, inmemorySightWord) ) {
					
					ContentValues args = new ContentValues();
					args.put("highlighted", boolToDbInt(inmemorySightWord.isHighlighted()));
					
					boolean updateResult = getDb().update("sight_word_list_assoc", 
							args,
							"list_name" + " = '" + wordList.getName() + "' and "
							+ "word" + " = '" + inmemorySightWord.getValue() + "'"
							, null) > 0;
				
					if (!updateResult) {
						return false;
					}		
				}
			}
		}
		
		close();
				
		return true;
	}
	
	private boolean hasChanged(SightWord dbWord, SightWord inlineWord) {
		
		return (dbWord.getValue().equals(inlineWord.getValue()) 
				&& dbWord.isHighlighted() != inlineWord.isHighlighted());
		
	}
	
	
//	DELETE
//	deleteList
//	cascade the delete through the junction table i.e. delete all List / Word relationships
	public boolean deleteList(SightWordList sightWordList) {
		
		return dummyDeepLists.remove(sightWordList);
		
	}
	
//	deleteWord
//	cascade the delete through the junction table i.e. delete all Word / List relationships
	public void deleteWord(SightWord sightWord) {
		
	}
	
	public void setCurrentlyActiveList(SightWordList currentSightWordList) {
		
		for (SightWordList sightWordList : dummyDeepLists) {
			if (currentSightWordList.equals(sightWordList)) {
				sightWordList.setCurrent(true);
			} else {
				sightWordList.setCurrent(false);
			}
		}
	}
	
	public SightWordList getCurrentlyActiveList() {
		
		for (SightWordList sightWordList : dummyDeepLists) {
			
			if (sightWordList.isCurrent()) {
				return sightWordList;
			}
		}
		return null;
	}
	
	private static void pt(String s) {
		System.out.println(s);
	}
}

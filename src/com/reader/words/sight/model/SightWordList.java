package com.reader.words.sight.model;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class SightWordList implements Parcelable {

	private String name;
	private boolean current;
	private List<SightWord> words;
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		 
        @Override
        public SightWordList createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new SightWordList(source);
        }
 
        @Override
        public SightWord[] newArray(int size) {
            return new SightWord[size];
        }
    };


    public SightWordList(Parcel parcel) {
    	
    	this(parcel.readString(), parcel.readByte() == 1);
    	List<SightWord> words = new ArrayList<SightWord>();
    	parcel.readTypedList(words, SightWord.CREATOR);
    	setSightWords(words);
    	
    }
    
	public SightWordList(String name, boolean current, List<SightWord> words) {
		
		this(name, current);
		setSightWords(words);
		
	}
	
//	TODO: not sure how I am going to use this, I may not want a 'deep' retrieve of the whole
//	...object graph
	public SightWordList(String name, boolean current) {
		
		super();
		setName(name);
		setCurrent(current);
		
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public boolean isCurrent() {
		return current;
	}
	
	public void setCurrent(boolean current) {
		this.current = current;
	}
	
	public List<SightWord> getSightWords() {
		return words;
	}
	
	private void setSightWords(List<SightWord> words) {
		this.words = words;
	}

	@Override
	public String toString() {
		return "SightWordList [name=" + name + ", current="
				+ current + ", words=" + words + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (current ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((words == null) ? 0 : words.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SightWordList other = (SightWordList) obj;
		if (current != other.current)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (words == null) {
			if (other.words != null)
				return false;
		} else if (!words.equals(other.words))
			return false;
		return true;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		dest.writeString(name);
		dest.writeByte((byte) (current ? 1 : 0));
		dest.writeTypedList(words);
		
	}
}

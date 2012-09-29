package com.reader.words.sight.model;

import java.util.List;

public class SightWordList {

	private int id;
	private String name;
	private boolean current;
	private List<SightWord> words;
	
	public SightWordList(int id, String name, boolean current, List<SightWord> words) {
		
		this(id, name, current);
		setSightWords(words);
		
	}
	
//	TODO: not sure how I am going to use this, I may not want a 'deep' retrieve of the whole
//	...object graph
	public SightWordList(int id, String name, boolean current) {
		
		super();
		setId(id);
		setName(name);
		setCurrent(current);
		
	}
	
	private int getId() {
		return id;
	}
	
	private void setId(int id) {
		this.id = id;
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
		return "SightWordList [id=" + id + ", name=" + name + ", current="
				+ current + ", words=" + words + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (current ? 1231 : 1237);
		result = prime * result + id;
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
		if (id != other.id)
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
}

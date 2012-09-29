package com.reader.words.sight.model;

public class SightWord {
	
	private int id;
	private String value;
	private boolean highlight;
	
	public SightWord(int id, String value, boolean highlight) {
		
		super();
		setId(id);
		setValue(value);
		setHighlight(highlight); //stored in junction table 
		
	}

	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	private void setValue(String value) {
		this.value = value;
	}
	
	public boolean isHighlighted() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

	@Override
	public String toString() {
		return "SightWord [id=" + id + ", value=" + value + ", highlight="
				+ highlight + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (highlight ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		SightWord other = (SightWord) obj;
		if (highlight != other.highlight)
			return false;
		if (id != other.id)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
}

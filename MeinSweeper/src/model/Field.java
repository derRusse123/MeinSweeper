package model;

public class Field {
	
	private int value;
	private boolean clicked;
	
	public Field(int value_) {
		value = value_;
		clicked = false;
	}
	
	public void setField(int value_, boolean clicked_) {
		value = value_;
		clicked = clicked_;
	}
	
	public Field getField() {
		return this;
	}
	
	
	// Alles hier darunter braucht man evtl. garnicht wenn das darüber geht
	public void setValue(int value_) {
		value = value_;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setClicked(boolean clicked_) {
		clicked = clicked_;
	}
	
	public boolean getClicked() {
		return clicked;
	}

	public void incrementValue() {
		value++;
	}
}
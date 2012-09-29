package com.reader.words.sight.model;

import java.util.ArrayList;
import java.util.List;

public class GenUtil {

	public static void main(String[] args) {
		
		List<SightWordList> list = new ArrayList<SightWordList>();
		fillSightWordListDeep(list);
		pt("bp");
	}
	
	public static void fillSightWords(List<SightWord> dummyWords) {
		
		dummyWords.addAll(fillPrePrimerWords(0));
		
	}
	
	public static void fillSightWordListDeep(List<SightWordList> sightWordLists) {
		
		sightWordLists.add(new SightWordList(0, "Dolch - PrePrimer", false, fillPrePrimerWords(0)));
		sightWordLists.add(new SightWordList(1, "Dolch - Primer", false, fillPrimerWords(0)));
		sightWordLists.add(new SightWordList(1, "Dolch - Grade 1", false, fillGradeOneWords(0)));
		sightWordLists.add(new SightWordList(1, "Dolch - Grade 2", false, fillGradeTwoWords(0)));
		sightWordLists.add(new SightWordList(1, "Dolch - Grade 3", false, fillGradeThreeWords(0)));
		sightWordLists.add(new SightWordList(1, "Dolch - Nouns", false, fillNounWords(0)));
		sightWordLists.add(new SightWordList(1, "Dolch - Non Nouns", false, fillNonNounWords()));
		sightWordLists.add(new SightWordList(1, "Dolch - All", true, fillAllWords()));
		pt("bp");
	}
	
	private static List<SightWord> fillPrePrimerWords(int nextId) {
		
		List<SightWord> words = new ArrayList<SightWord>();
		
		words.add(new SightWord(nextId++, "FUNNY", true));
		words.add(new SightWord(nextId++, "LOOK", false));
		words.add(new SightWord(nextId++, "NOT", true));
		words.add(new SightWord(nextId++, "UP", false));
		words.add(new SightWord(nextId++, "YELLOW", true));
		words.add(new SightWord(nextId++, "HERE", false));
		words.add(new SightWord(nextId++, "YOU", false));
		words.add(new SightWord(nextId++, "A", true));
		words.add(new SightWord(nextId++, "I", false));
		words.add(new SightWord(nextId++, "GO", true));
		words.add(new SightWord(nextId++, "WE", false));
		words.add(new SightWord(nextId++, "PLAY", true));
		words.add(new SightWord(nextId++, "HELP", false));
		words.add(new SightWord(nextId++, "THE", true));
		words.add(new SightWord(nextId++, "FIND", false));
		words.add(new SightWord(nextId++, "SEE", true));
		words.add(new SightWord(nextId++, "TO", false));
		words.add(new SightWord(nextId++, "TWO", true));
		words.add(new SightWord(nextId++, "THREE", false));
		words.add(new SightWord(nextId++, "BIG", true));
		words.add(new SightWord(nextId++, "AWAY", false));
		words.add(new SightWord(nextId++, "ME", true));
		words.add(new SightWord(nextId++, "ONE", false));
		words.add(new SightWord(nextId++, "LITTLE", true));
		words.add(new SightWord(nextId++, "MY", false));
		words.add(new SightWord(nextId++, "JUMP", true));
		words.add(new SightWord(nextId++, "BLUE", false));
		words.add(new SightWord(nextId++, "DOWN", true));
		words.add(new SightWord(nextId++, "WHERE", false));
		words.add(new SightWord(nextId++, "FOR", true));
		words.add(new SightWord(nextId++, "AND", false));
		words.add(new SightWord(nextId++, "CAN", true));
		words.add(new SightWord(nextId++, "IN", false));
		words.add(new SightWord(nextId++, "IS", true));
		words.add(new SightWord(nextId++, "IT", false));
		words.add(new SightWord(nextId++, "SAID", true));
		words.add(new SightWord(nextId++, "MAKE", false));
		words.add(new SightWord(nextId++, "RED", true));
		words.add(new SightWord(nextId++, "COME", false));
		words.add(new SightWord(nextId++, "RUN", true));


		return words;
	}
	
	private static List<SightWord> fillPrimerWords(int nextId) {
		
		List<SightWord> words = new ArrayList<SightWord>();
		
		words.add(new SightWord(nextId++, "SHE", true));
		words.add(new SightWord(nextId++, "DO", false));
		words.add(new SightWord(nextId++, "NOW", true));
		words.add(new SightWord(nextId++, "ARE", false));
		words.add(new SightWord(nextId++, "RAN", true));
		words.add(new SightWord(nextId++, "THIS", false));
		words.add(new SightWord(nextId++, "GET", true));
		words.add(new SightWord(nextId++, "WILL", false));
		words.add(new SightWord(nextId++, "BUT", true));
		words.add(new SightWord(nextId++, "BLACK", false));
		words.add(new SightWord(nextId++, "SAW", true));
		words.add(new SightWord(nextId++, "SAY", false));
		words.add(new SightWord(nextId++, "MUST", true));
		words.add(new SightWord(nextId++, "CAME", false));
		words.add(new SightWord(nextId++, "WHITE", true));
		words.add(new SightWord(nextId++, "HE", false));
		words.add(new SightWord(nextId++, "ATE", true));
		words.add(new SightWord(nextId++, "OUT", false));
		words.add(new SightWord(nextId++, "OUR", true));
		words.add(new SightWord(nextId++, "RIDE", false));
		words.add(new SightWord(nextId++, "SOON", true));
		words.add(new SightWord(nextId++, "THEY", false));
		words.add(new SightWord(nextId++, "AT", true));
		words.add(new SightWord(nextId++, "WAS", false));
		words.add(new SightWord(nextId++, "PRETTY", true));
		words.add(new SightWord(nextId++, "LIKE", false));
		words.add(new SightWord(nextId++, "AM", true));
		words.add(new SightWord(nextId++, "WELL", false));
		words.add(new SightWord(nextId++, "BE", true));
		words.add(new SightWord(nextId++, "DID", false));
		words.add(new SightWord(nextId++, "SO", true));
		words.add(new SightWord(nextId++, "WANT", false));
		words.add(new SightWord(nextId++, "WHAT", true));
		words.add(new SightWord(nextId++, "NEW", false));
		words.add(new SightWord(nextId++, "WENT", true));
		words.add(new SightWord(nextId++, "YES", false));
		words.add(new SightWord(nextId++, "THAT", true));
		words.add(new SightWord(nextId++, "INTO", false));
		words.add(new SightWord(nextId++, "FOUR", true));
		words.add(new SightWord(nextId++, "NO", false));
		words.add(new SightWord(nextId++, "ON", true));
		words.add(new SightWord(nextId++, "THERE", false));
		words.add(new SightWord(nextId++, "EAT", true));
		words.add(new SightWord(nextId++, "BROWN", false));
		words.add(new SightWord(nextId++, "UNDER", true));
		words.add(new SightWord(nextId++, "ALL", false));
		words.add(new SightWord(nextId++, "HAVE", true));
		words.add(new SightWord(nextId++, "PLEASE", false));
		words.add(new SightWord(nextId++, "WITH", true));
		words.add(new SightWord(nextId++, "WHO", true));
		words.add(new SightWord(nextId++, "GOOD", false));
		words.add(new SightWord(nextId++, "TOO", true));

		return words;
	}
	
	private static List<SightWord> fillGradeOneWords(int nextId) {
		
		List<SightWord> words = new ArrayList<SightWord>();
		
		words.add(new SightWord(nextId++, "HIM", true));
		words.add(new SightWord(nextId++, "HIS", true));
		words.add(new SightWord(nextId++, "TAKE", true));
		words.add(new SightWord(nextId++, "ASK", true));
		words.add(new SightWord(nextId++, "STOP", true));
		words.add(new SightWord(nextId++, "KNOW", true));
		words.add(new SightWord(nextId++, "AS", true));
		words.add(new SightWord(nextId++, "THEM", true));
		words.add(new SightWord(nextId++, "THEN", true));
		words.add(new SightWord(nextId++, "AN", true));
		words.add(new SightWord(nextId++, "BY", true));
		words.add(new SightWord(nextId++, "WALK", true));
		words.add(new SightWord(nextId++, "WHEN", true));
		words.add(new SightWord(nextId++, "THANK", true));
		words.add(new SightWord(nextId++, "THINK", true));
		words.add(new SightWord(nextId++, "HAS", true));
		words.add(new SightWord(nextId++, "LIVE", true));
		words.add(new SightWord(nextId++, "HAD", true));
		words.add(new SightWord(nextId++, "EVERY", true));
		words.add(new SightWord(nextId++, "OLD", true));
		words.add(new SightWord(nextId++, "OF", true));
		words.add(new SightWord(nextId++, "COULD", true));
		words.add(new SightWord(nextId++, "FLY", true));
		words.add(new SightWord(nextId++, "ROUND", true));
		words.add(new SightWord(nextId++, "FROM", true));
		words.add(new SightWord(nextId++, "OVER", true));
		words.add(new SightWord(nextId++, "WERE", true));
		words.add(new SightWord(nextId++, "MAY", true));
		words.add(new SightWord(nextId++, "HOW", true));
		words.add(new SightWord(nextId++, "HER", true));
		words.add(new SightWord(nextId++, "SOME", true));
		words.add(new SightWord(nextId++, "ONCE", true));
		words.add(new SightWord(nextId++, "AFTER", true));
		words.add(new SightWord(nextId++, "GIVE", true));
		words.add(new SightWord(nextId++, "GIVING", true));
		words.add(new SightWord(nextId++, "OPEN", true));
		words.add(new SightWord(nextId++, "ANY", true));
		words.add(new SightWord(nextId++, "JUST", true));
		words.add(new SightWord(nextId++, "LET", true));
		words.add(new SightWord(nextId++, "PUT", true));
		
		return words;
	}
	
	private static List<SightWord> fillGradeTwoWords(int nextId) {
		
		List<SightWord> words = new ArrayList<SightWord>();
		
		words.add(new SightWord(nextId++, "GREEN", true));
		words.add(new SightWord(nextId++, "SING", true));
		words.add(new SightWord(nextId++, "THEIR", true));
		words.add(new SightWord(nextId++, "COLD", true));
		words.add(new SightWord(nextId++, "SIT", true));
		words.add(new SightWord(nextId++, "US", true));
		words.add(new SightWord(nextId++, "OFF", true));
		words.add(new SightWord(nextId++, "TELL", true));
		words.add(new SightWord(nextId++, "GOES", true));
		words.add(new SightWord(nextId++, "DONT", true));
		words.add(new SightWord(nextId++, "BUY", true));
		words.add(new SightWord(nextId++, "MANY", true));
		words.add(new SightWord(nextId++, "READ", true));
		words.add(new SightWord(nextId++, "CALL", true));
		words.add(new SightWord(nextId++, "SLEEP", true));
		words.add(new SightWord(nextId++, "THOSE", true));
		words.add(new SightWord(nextId++, "AROUND", true));
		words.add(new SightWord(nextId++, "WOULD", true));
		words.add(new SightWord(nextId++, "BEST", true));
		words.add(new SightWord(nextId++, "FAST", true));
		words.add(new SightWord(nextId++, "RIGHT", true));
		words.add(new SightWord(nextId++, "BECAUSE", true));
		words.add(new SightWord(nextId++, "FIRST", true));
		words.add(new SightWord(nextId++, "PULL", true));
		words.add(new SightWord(nextId++, "BEEN", true));
		words.add(new SightWord(nextId++, "MADE", true));
		words.add(new SightWord(nextId++, "ALWAYS", true));
		words.add(new SightWord(nextId++, "BOTH", true));
		words.add(new SightWord(nextId++, "WORK", true));
		words.add(new SightWord(nextId++, "YOUR", true));
		words.add(new SightWord(nextId++, "ITS", true));
		words.add(new SightWord(nextId++, "OR", true));
		words.add(new SightWord(nextId++, "USE", true));
		words.add(new SightWord(nextId++, "THESE", true));
		words.add(new SightWord(nextId++, "VERY", true));
		words.add(new SightWord(nextId++, "WASH", true));
		words.add(new SightWord(nextId++, "FIVE", true));
		words.add(new SightWord(nextId++, "WHICH", true));
		words.add(new SightWord(nextId++, "DOES", true));
		words.add(new SightWord(nextId++, "UPON", true));
		words.add(new SightWord(nextId++, "BEFORE", true));
		words.add(new SightWord(nextId++, "WHY", true));
		words.add(new SightWord(nextId++, "WISH", true));
		words.add(new SightWord(nextId++, "WRITE", true));
		words.add(new SightWord(nextId++, "GAVE", true));
		words.add(new SightWord(nextId++, "FOUND", true));
		
		return words;
	}
	
	private static List<SightWord> fillGradeThreeWords(int nextId) {

		List<SightWord> words = new ArrayList<SightWord>();
		
		words.add(new SightWord(nextId++, "FAR", true));
		words.add(new SightWord(nextId++, "CLEAN", true));
		words.add(new SightWord(nextId++, "OWN", true));
		words.add(new SightWord(nextId++, "DONE", true));
		words.add(new SightWord(nextId++, "FALL", true));
		words.add(new SightWord(nextId++, "SHOW", true));
		words.add(new SightWord(nextId++, "TODAY", true));
		words.add(new SightWord(nextId++, "HURT", true));
		words.add(new SightWord(nextId++, "SEVEN", true));
		words.add(new SightWord(nextId++, "SIX", true));
		words.add(new SightWord(nextId++, "CUT", true));
		words.add(new SightWord(nextId++, "MUCH", true));
		words.add(new SightWord(nextId++, "TOGETHER", true));
		words.add(new SightWord(nextId++, "ONLY", true));
		words.add(new SightWord(nextId++, "BETTER", true));
		words.add(new SightWord(nextId++, "LIGHT", true));
		words.add(new SightWord(nextId++, "DRINK", true));
		words.add(new SightWord(nextId++, "KIND", true));
		words.add(new SightWord(nextId++, "START", true));
		words.add(new SightWord(nextId++, "NEVER", true));
		words.add(new SightWord(nextId++, "LONG", true));
		words.add(new SightWord(nextId++, "GOT", true));
		words.add(new SightWord(nextId++, "MYSELF", true));
		words.add(new SightWord(nextId++, "FULL", true));
		words.add(new SightWord(nextId++, "SMALL", true));
		words.add(new SightWord(nextId++, "PICK", true));
		words.add(new SightWord(nextId++, "ABOUT", true));
		words.add(new SightWord(nextId++, "LAUGH", true));
		words.add(new SightWord(nextId++, "TEN", true));
		words.add(new SightWord(nextId++, "TRY", true));
		words.add(new SightWord(nextId++, "GROW", true));
		words.add(new SightWord(nextId++, "CARRY", true));
		words.add(new SightWord(nextId++, "DRAW", true));
		words.add(new SightWord(nextId++, "SHALL", true));
		words.add(new SightWord(nextId++, "BRING", true));
		words.add(new SightWord(nextId++, "HOT", true));
		words.add(new SightWord(nextId++, "HOLD", true));
		words.add(new SightWord(nextId++, "IF", true));
		words.add(new SightWord(nextId++, "EIGHT", true));
		words.add(new SightWord(nextId++, "WARM", true));
		words.add(new SightWord(nextId++, "KEEP", true));

		
		return words;
	}
	
	private static List<SightWord> fillNounWords(int nextId) {
		
		List<SightWord> words = new ArrayList<SightWord>();
		
		words.add(new SightWord(nextId++, "DOOR", true));
		words.add(new SightWord(nextId++, "LETTER", true));
		words.add(new SightWord(nextId++, "GROUND", true));
		words.add(new SightWord(nextId++, "HEAD", true));
		words.add(new SightWord(nextId++, "CAKE", true));
		words.add(new SightWord(nextId++, "BELL", true));
		words.add(new SightWord(nextId++, "BALL", true));
		words.add(new SightWord(nextId++, "SHOE", true));
		words.add(new SightWord(nextId++, "PIG", true));
		words.add(new SightWord(nextId++, "GIRL", true));
		words.add(new SightWord(nextId++, "SONG", true));
		words.add(new SightWord(nextId++, "MORNING", true));
		words.add(new SightWord(nextId++, "SQUIRREL", true));
		words.add(new SightWord(nextId++, "BED", true));
		words.add(new SightWord(nextId++, "CHAIR", true));
		words.add(new SightWord(nextId++, "ROBIN", true));
		words.add(new SightWord(nextId++, "SNOW", true));
		words.add(new SightWord(nextId++, "CHILDREN", true));
		words.add(new SightWord(nextId++, "TABLE", true));
		words.add(new SightWord(nextId++, "RING", true));
		words.add(new SightWord(nextId++, "SCHOOL", true));
		words.add(new SightWord(nextId++, "PARTY", true));
		words.add(new SightWord(nextId++, "WOOD", true));
		words.add(new SightWord(nextId++, "SUN", true));
		words.add(new SightWord(nextId++, "TIME", true));
		words.add(new SightWord(nextId++, "HAND", true));
		words.add(new SightWord(nextId++, "BIRD", true));
		words.add(new SightWord(nextId++, "WAY", true));
		words.add(new SightWord(nextId++, "HILL", true));
		words.add(new SightWord(nextId++, "GRASS", true));
		words.add(new SightWord(nextId++, "FARM", true));
		words.add(new SightWord(nextId++, "STICK", true));
		words.add(new SightWord(nextId++, "SANTACLAUSE", true));
		words.add(new SightWord(nextId++, "KITTY", true));
		words.add(new SightWord(nextId++, "MOTHER", true));
		words.add(new SightWord(nextId++, "BIRTHDAY", true));
		words.add(new SightWord(nextId++, "DOLL", true));
		words.add(new SightWord(nextId++, "APPLE", true));
		words.add(new SightWord(nextId++, "PAPER", true));
		words.add(new SightWord(nextId++, "MONEY", true));
		words.add(new SightWord(nextId++, "BEAR", true));
		words.add(new SightWord(nextId++, "EYE", true));
		words.add(new SightWord(nextId++, "SHEEP", true));
		words.add(new SightWord(nextId++, "HOUSE", true));
		words.add(new SightWord(nextId++, "BABY", true));
		words.add(new SightWord(nextId++, "WATER", true));
		words.add(new SightWord(nextId++, "THING", true));
		words.add(new SightWord(nextId++, "NEST", true));
		words.add(new SightWord(nextId++, "DAY", true));
		words.add(new SightWord(nextId++, "BREAD", true));
		words.add(new SightWord(nextId++, "FIRE", true));
		words.add(new SightWord(nextId++, "NAME", true));
		words.add(new SightWord(nextId++, "BACK", true));
		words.add(new SightWord(nextId++, "COW", true));
		words.add(new SightWord(nextId++, "FARMER", true));
		words.add(new SightWord(nextId++, "FISH", true));
		words.add(new SightWord(nextId++, "WATCH", true));
		words.add(new SightWord(nextId++, "FATHER", true));
		words.add(new SightWord(nextId++, "RABBIT", true));
		words.add(new SightWord(nextId++, "CHRISTMAS", true));
		words.add(new SightWord(nextId++, "FLOOR", true));
		words.add(new SightWord(nextId++, "EGG", true));
		words.add(new SightWord(nextId++, "HORSE", true));
		words.add(new SightWord(nextId++, "FLOWER", true));
		words.add(new SightWord(nextId++, "COAT", true));
		words.add(new SightWord(nextId++, "MEN", true));
		words.add(new SightWord(nextId++, "RAIN", true));
		words.add(new SightWord(nextId++, "GAME", true));
		words.add(new SightWord(nextId++, "CORN", true));
		words.add(new SightWord(nextId++, "WIND", true));
		words.add(new SightWord(nextId++, "MILK", true));
		words.add(new SightWord(nextId++, "DOG", true));
		words.add(new SightWord(nextId++, "CAR", true));
		words.add(new SightWord(nextId++, "CAT", true));
		words.add(new SightWord(nextId++, "BOX", true));
		words.add(new SightWord(nextId++, "BOY", true));
		words.add(new SightWord(nextId++, "TREE", true));
		words.add(new SightWord(nextId++, "SISTER", true));
		words.add(new SightWord(nextId++, "GARDEN", true));
		words.add(new SightWord(nextId++, "STREET", true));
		words.add(new SightWord(nextId++, "SEED", true));
		words.add(new SightWord(nextId++, "CHICKEN", true));
		words.add(new SightWord(nextId++, "BOAT", true));
		words.add(new SightWord(nextId++, "PICTURE", true));
		words.add(new SightWord(nextId++, "BROTHER", true));
		words.add(new SightWord(nextId++, "NIGHT", true));
		words.add(new SightWord(nextId++, "FEET", true));
		words.add(new SightWord(nextId++, "MAN", true));
		words.add(new SightWord(nextId++, "LEG", true));
		words.add(new SightWord(nextId++, "TOY", true));
		words.add(new SightWord(nextId++, "HOME", true));
		words.add(new SightWord(nextId++, "WINDOW", true));
		words.add(new SightWord(nextId++, "GOODBYE", true));
		words.add(new SightWord(nextId++, "DUCK", true));
		words.add(new SightWord(nextId++, "TOP", true));

		
		return words;
	}
	
	private static List<SightWord> fillNonNounWords() {
		
		List<SightWord> words = new ArrayList<SightWord>();
		
		words.addAll(fillPrePrimerWords(words.size()));
		words.addAll(fillPrimerWords(words.size()));
		words.addAll(fillGradeOneWords(words.size()));
		words.addAll(fillGradeTwoWords(words.size()));
		words.addAll(fillGradeThreeWords(words.size()));
		
		return words;
	}
	
	public static List<SightWord> fillAllWords() {
			
		List<SightWord> words = new ArrayList<SightWord>();
		
		words.addAll(fillNonNounWords());
		words.addAll(fillNounWords(words.size()));
		
		return words;
	}
	
	public static void fillAllWords(List<SightWord> words) {
		if (words != null) {
			words.addAll(fillNonNounWords());
			words.addAll(fillNounWords(words.size()));	
		}
	}
	
	private static void pt(String s) {
		System.out.println(s);
	}
}

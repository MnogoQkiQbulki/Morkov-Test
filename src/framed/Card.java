package framed;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Card {
	Map<Integer,String> Deck = new HashMap<Integer,String>();
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	public Card () {				
		Deck.put(1, "TwoC"); Deck.put(2, "ThreeC"); Deck.put(3, "FourC"); Deck.put(4, "FiveC");
		Deck.put(5, "SixC"); Deck.put(6, "SevenC"); Deck.put(7, "EightC"); Deck.put(8, "NineC");
		Deck.put(9, "TenC"); Deck.put(10, "JC"); Deck.put(11, "QC"); Deck.put(12, "KC"); Deck.put(13, "AC");
		Deck.put(14, "TwoD"); Deck.put(15, "ThreeD"); Deck.put(16, "FourD"); Deck.put(17, "FiveD");
		Deck.put(18, "SixD"); Deck.put(19, "SevenD"); Deck.put(20, "EightD"); Deck.put(21, "NineD");
		Deck.put(22, "TenD"); Deck.put(23, "JD"); Deck.put(24, "QD"); Deck.put(25, "KD"); Deck.put(26, "AD");
		Deck.put(27, "TwoH"); Deck.put(28, "ThreeH"); Deck.put(29, "FourH"); Deck.put(30, "FiveH");
		Deck.put(31, "SixH"); Deck.put(32, "SevenH"); Deck.put(33, "EightH"); Deck.put(34, "NineH");
		Deck.put(35, "TenH"); Deck.put(36, "JH"); Deck.put(37, "QH"); Deck.put(38, "KH"); Deck.put(39, "AH");
		Deck.put(40, "TwoS"); Deck.put(41, "ThreeS"); Deck.put(42, "FourS"); Deck.put(43, "FiveS");
		Deck.put(44, "SixS"); Deck.put(45, "SevenS"); Deck.put(46, "EightS"); Deck.put(47, "NineS");
		Deck.put(48, "TenS"); Deck.put(49, "JS"); Deck.put(50, "QS"); Deck.put(51, "KS"); Deck.put(52, "AS");
		
		Refill();
	}
	
	public void Refill () {
		list.clear();
	    for (int i = 1; i <= 52; i++) {
	        list.add(i);
	    }
	}
	
	public int Pull() {
	    if (list.isEmpty()) Refill();
	    int idx = ThreadLocalRandom.current().nextInt(0, list.size());
	    return list.remove(idx);
	}
}

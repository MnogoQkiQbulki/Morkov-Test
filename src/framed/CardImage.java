package framed;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Map;
import java.util.HashMap;

public class CardImage{
	
	Map<String,ImageIcon> images = new HashMap<>();
	public CardImage() {
		
		images.put("TwoC", Scales(new ImageIcon("2C.png").getImage()));
		images.put("ThreeC", Scales(new ImageIcon("3C.png").getImage()));
		images.put("FourC", Scales(new ImageIcon("4C.png").getImage()));
		images.put("FiveC", Scales(new ImageIcon("5C.png").getImage()));
		images.put("SixC", Scales(new ImageIcon("6C.png").getImage()));
		images.put("SevenC", Scales(new ImageIcon("7C.png").getImage()));
		images.put("EightC", Scales(new ImageIcon("8C.png").getImage()));
		images.put("NineC", Scales(new ImageIcon("9C.png").getImage()));
		images.put("TenC", Scales(new ImageIcon("TC.png").getImage()));
		images.put("JC", Scales(new ImageIcon("JC.png").getImage()));
		images.put("QC", Scales(new ImageIcon("QC.png").getImage()));
		images.put("KC", Scales(new ImageIcon("KC.png").getImage()));
		images.put("AC", Scales(new ImageIcon("AC.png").getImage()));
	
		images.put("TwoD", Scales(new ImageIcon("2D.png").getImage()));
		images.put("ThreeD", Scales(new ImageIcon("3D.png").getImage()));
		images.put("FourD", Scales(new ImageIcon("4D.png").getImage()));
		images.put("FiveD", Scales(new ImageIcon("5D.png").getImage()));
		images.put("SixD", Scales(new ImageIcon("6D.png").getImage()));
		images.put("SevenD", Scales(new ImageIcon("7D.png").getImage()));
		images.put("EightD", Scales(new ImageIcon("8D.png").getImage()));
		images.put("NineD", Scales(new ImageIcon("9D.png").getImage()));
		images.put("TenD", Scales(new ImageIcon("TD.png").getImage()));
		images.put("JD", Scales(new ImageIcon("JD.png").getImage()));
		images.put("QD", Scales(new ImageIcon("QD.png").getImage()));
		images.put("KD", Scales(new ImageIcon("KD.png").getImage()));
		images.put("AD", Scales(new ImageIcon("AD.png").getImage()));
	
		images.put("TwoH", Scales(new ImageIcon("2H.png").getImage()));
		images.put("ThreeH", Scales(new ImageIcon("3H.png").getImage()));
		images.put("FourH", Scales(new ImageIcon("4H.png").getImage()));
		images.put("FiveH", Scales(new ImageIcon("5H.png").getImage()));
		images.put("SixH", Scales(new ImageIcon("6H.png").getImage()));
		images.put("SevenH", Scales(new ImageIcon("7H.png").getImage()));
		images.put("EightH", Scales(new ImageIcon("8H.png").getImage()));
		images.put("NineH", Scales(new ImageIcon("9H.png").getImage()));
		images.put("TenH", Scales(new ImageIcon("TH.png").getImage()));
		images.put("JH", Scales(new ImageIcon("JH.png").getImage()));
		images.put("QH", Scales(new ImageIcon("QH.png").getImage()));
		images.put("KH", Scales(new ImageIcon("KH.png").getImage()));
		images.put("AH", Scales(new ImageIcon("AH.png").getImage()));
		
		images.put("TwoS", Scales(new ImageIcon("2S.png").getImage()));
		images.put("ThreeS", Scales(new ImageIcon("3S.png").getImage()));
		images.put("FourS", Scales(new ImageIcon("4S.png").getImage()));
		images.put("FiveS", Scales(new ImageIcon("5S.png").getImage()));
		images.put("SixS", Scales(new ImageIcon("6S.png").getImage()));
		images.put("SevenS", Scales(new ImageIcon("7S.png").getImage()));
		images.put("EightS", Scales(new ImageIcon("8S.png").getImage()));
		images.put("NineS", Scales(new ImageIcon("9S.png").getImage()));
		images.put("TenS", Scales(new ImageIcon("TS.png").getImage()));
		images.put("JS", Scales(new ImageIcon("JS.png").getImage()));
		images.put("QS", Scales(new ImageIcon("QS.png").getImage()));
		images.put("KS", Scales(new ImageIcon("KS.png").getImage()));
		images.put("AS", Scales(new ImageIcon("AS.png").getImage()));
	}
	
	public ImageIcon Scales(Image playcard) {
		Image img = playcard.getScaledInstance(140, 150, Image.SCALE_SMOOTH);
		ImageIcon scaled = new ImageIcon(img);
		return scaled;
	}
}

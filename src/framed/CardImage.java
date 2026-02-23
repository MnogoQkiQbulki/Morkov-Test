package framed;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Map;
import java.util.HashMap;

public class CardImage{
	
	Map<String,ImageIcon> images = new HashMap<>();
	public CardImage() {
		
		images.put("TwoC", Scales(new ImageIcon("cards/2C.png").getImage()));
		images.put("ThreeC", Scales(new ImageIcon("cards/3C.png").getImage()));
		images.put("FourC", Scales(new ImageIcon("cards/4C.png").getImage()));
		images.put("FiveC", Scales(new ImageIcon("cards/5C.png").getImage()));
		images.put("SixC", Scales(new ImageIcon("cards/6C.png").getImage()));
		images.put("SevenC", Scales(new ImageIcon("cards/7C.png").getImage()));
		images.put("EightC", Scales(new ImageIcon("cards/8C.png").getImage()));
		images.put("NineC", Scales(new ImageIcon("cards/9C.png").getImage()));
		images.put("TenC", Scales(new ImageIcon("cards/TC.png").getImage()));
		images.put("JC", Scales(new ImageIcon("cards/JC.png").getImage()));
		images.put("QC", Scales(new ImageIcon("cards/QC.png").getImage()));
		images.put("KC", Scales(new ImageIcon("cards/KC.png").getImage()));
		images.put("AC", Scales(new ImageIcon("cards/AC.png").getImage()));

		images.put("TwoD", Scales(new ImageIcon("cards/2D.png").getImage()));
		images.put("ThreeD", Scales(new ImageIcon("cards/3D.png").getImage()));
		images.put("FourD", Scales(new ImageIcon("cards/4D.png").getImage()));
		images.put("FiveD", Scales(new ImageIcon("cards/5D.png").getImage()));
		images.put("SixD", Scales(new ImageIcon("cards/6D.png").getImage()));
		images.put("SevenD", Scales(new ImageIcon("cards/7D.png").getImage()));
		images.put("EightD", Scales(new ImageIcon("cards/8D.png").getImage()));
		images.put("NineD", Scales(new ImageIcon("cards/9D.png").getImage()));
		images.put("TenD", Scales(new ImageIcon("cards/TD.png").getImage()));
		images.put("JD", Scales(new ImageIcon("cards/JD.png").getImage()));
		images.put("QD", Scales(new ImageIcon("cards/QD.png").getImage()));
		images.put("KD", Scales(new ImageIcon("cards/KD.png").getImage()));
		images.put("AD", Scales(new ImageIcon("cards/AD.png").getImage()));

		images.put("TwoH", Scales(new ImageIcon("cards/2H.png").getImage()));
		images.put("ThreeH", Scales(new ImageIcon("cards/3H.png").getImage()));
		images.put("FourH", Scales(new ImageIcon("cards/4H.png").getImage()));
		images.put("FiveH", Scales(new ImageIcon("cards/5H.png").getImage()));
		images.put("SixH", Scales(new ImageIcon("cards/6H.png").getImage()));
		images.put("SevenH", Scales(new ImageIcon("cards/7H.png").getImage()));
		images.put("EightH", Scales(new ImageIcon("cards/8H.png").getImage()));
		images.put("NineH", Scales(new ImageIcon("cards/9H.png").getImage()));
		images.put("TenH", Scales(new ImageIcon("cards/TH.png").getImage()));
		images.put("JH", Scales(new ImageIcon("cards/JH.png").getImage()));
		images.put("QH", Scales(new ImageIcon("cards/QH.png").getImage()));
		images.put("KH", Scales(new ImageIcon("cards/KH.png").getImage()));
		images.put("AH", Scales(new ImageIcon("cards/AH.png").getImage()));

		images.put("TwoS", Scales(new ImageIcon("cards/2S.png").getImage()));
		images.put("ThreeS", Scales(new ImageIcon("cards/3S.png").getImage()));
		images.put("FourS", Scales(new ImageIcon("cards/4S.png").getImage()));
		images.put("FiveS", Scales(new ImageIcon("cards/5S.png").getImage()));
		images.put("SixS", Scales(new ImageIcon("cards/6S.png").getImage()));
		images.put("SevenS", Scales(new ImageIcon("cards/7S.png").getImage()));
		images.put("EightS", Scales(new ImageIcon("cards/8S.png").getImage()));
		images.put("NineS", Scales(new ImageIcon("cards/9S.png").getImage()));
		images.put("TenS", Scales(new ImageIcon("cards/TS.png").getImage()));
		images.put("JS", Scales(new ImageIcon("cards/JS.png").getImage()));
		images.put("QS", Scales(new ImageIcon("cards/QS.png").getImage()));
		images.put("KS", Scales(new ImageIcon("cards/KS.png").getImage()));
		images.put("AS", Scales(new ImageIcon("cards/AS.png").getImage()));
		}
	
	public ImageIcon Scales(Image playcard) {
		Image img = playcard.getScaledInstance(140, 150, Image.SCALE_SMOOTH);
		ImageIcon scaled = new ImageIcon(img);
		return scaled;
	}
}

package com.ahstu;

import java.awt.image.BufferedImage;

public class Bao extends NexonObject{
	private BufferedImage[] images;
	
	public Bao() {
		this.image = NexonPanel.down;
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
		this.row = 0;
		this.col = 13;
		
		this.images = new BufferedImage[] {
				NexonPanel.up,
				NexonPanel.down,
				NexonPanel.left,
				NexonPanel.right
		};
	}
}

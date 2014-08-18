package com.clearlyspam23.GLE.GUI.level;

import com.clearlyspam23.GLE.Layer;

public interface LayerContainer {
	
	public void changeLayer(int index);
	
	public Iterable<Layer> getLayers();

}
package com.clearlyspam23.GLE.basic.layers;

import java.util.List;

import com.clearlyspam23.GLE.LayerDefinition;
import com.clearlyspam23.GLE.LayerTemplate;
import com.clearlyspam23.GLE.basic.gui.TileLayerGUIOptions;
import com.clearlyspam23.GLE.util.Vector2f;

public class TileLayerDefinition extends LayerDefinition<TileLayerGUIOptions> {
	
	private Vector2f gridDimensions;
	private List<TileConstraint> constraints;

	@Override
	public String getTypeName() {
		return "Tile";
	}

	@Override
	public LayerTemplate buildFromGUI(TileLayerGUIOptions gui) {
		return null;
	}

	@Override
	public TileLayerGUIOptions getLayerComponent() {
		return new TileLayerGUIOptions();
	}

}

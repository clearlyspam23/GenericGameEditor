package com.clearlyspam23.GLE.basic.layers.tile.commands;

import java.util.ArrayList;
import java.util.List;

import org.piccolo2d.PCamera;
import org.piccolo2d.event.PInputEvent;

import com.clearlyspam23.GLE.basic.layers.tile.Tile;
import com.clearlyspam23.GLE.basic.layers.tile.commands.EditActions.PlaceTileAction;
import com.clearlyspam23.GLE.basic.layers.tile.gui.TilePNode;
import com.clearlyspam23.GLE.basic.layers.tile.gui.TilesetEditorData;
import com.clearlyspam23.GLE.util.Pair;

public class PlaceTileCommand extends TileDragCommand {
	
	protected List<Pair<TilePNode, Tile>> replacedList;
	
	
	public PlaceTileCommand(TilesetEditorData data){
		super(data);
	}
	
	protected void setTile(TilePNode tile, PCamera cam){
		if(data.getSelectedTile()==null)
			return;
		replacedList.add(new Pair<TilePNode, Tile>(tile, tile.getTile()));
		tile.setTileset(data.getCurrentTileset(), data.getSelectedX(), data.getSelectedY());
	}
	
	private boolean aChangeExists(){
		for(Pair<TilePNode, Tile> p : replacedList){
			if(!p.second.equals(data.getCurrentTileset(), data.getSelectedX(), data.getSelectedY()))
				return true;
		}
		return false;
	}

	@Override
	protected void onFinish(PInputEvent event) {
		if(aChangeExists()){
			PlaceTileAction action = new PlaceTileAction(replacedList, new Tile(data.getCurrentTileset(), data.getSelectedX(), data.getSelectedY()));
			data.registerEditAction(action);
		}
	}

	@Override
	protected void onStart(PInputEvent event) {
		replacedList = new ArrayList<Pair<TilePNode, Tile>>();
	}

}

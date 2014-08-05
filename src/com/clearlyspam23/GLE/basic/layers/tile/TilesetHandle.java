package com.clearlyspam23.GLE.basic.layers.tile;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.clearlyspam23.GLE.Nameable;
import com.clearlyspam23.GLE.basic.layers.tile.resources.Tileset;
import com.clearlyspam23.GLE.resources.ResourceLoader;
import com.clearlyspam23.GLE.resources.ResourceManager;

public class TilesetHandle implements ResourceLoader<Tileset>, Nameable{
	
	private int tileWidth;
	private int tileHeight;
	private String name;
	private String filename;
	
	public TilesetHandle(){
		
	}
	
	public Image[][] getTileset() {
		return ResourceManager.get().getResource(filename, Tileset.class, this).getTileset();
	}
	
	public TilesetHandle(String name, String filename, int tileWidth, int tileHeight){
		this.name = name;
		this.filename = filename;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}

	@Override
	public Tileset loadResource(File file) throws IOException {
		Image[][] tiles = null;
		try {
			BufferedImage temp  = ImageIO.read(file);
			tiles = new Image[temp.getWidth()/tileWidth][temp.getHeight()/tileHeight];
			for(int i = 0; i < tiles.length; i++)
			{
				for(int j = 0; j < tiles[i].length; j++)
				{
					tiles[i][j] = temp.getSubimage(tileWidth*i, tileHeight*j, tileWidth, tileHeight);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Tileset(tiles);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public Image getTileAt(int x, int y){
		return ResourceManager.get().getResource(filename, Tileset.class, this).getTileAt(x, y);
	}
	
	public Image getTileByIndex(int index){
		return ResourceManager.get().getResource(filename, Tileset.class, this).getTileByIndex(index);
	}
	
	public int getXFromIndex(int index){
		return ResourceManager.get().getResource(filename, Tileset.class, this).getXFromIndex(index);
	}
	
	public int getYFromIndex(int index){
		return ResourceManager.get().getResource(filename, Tileset.class, this).getYFromIndex(index);
	}
	
	public boolean isValidLocation(int x, int y){
		return ResourceManager.get().getResource(filename, Tileset.class, this).isValidLocation(x, y);
	}
	
	public int getIndex(int x, int y){
		return ResourceManager.get().getResource(filename, Tileset.class, this).getIndex(x, y);
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}
	
	public int getWidth(){
		return ResourceManager.get().getResource(filename, Tileset.class, this).getWidth();
	}
	
	public int getHeight(){
		return ResourceManager.get().getResource(filename, Tileset.class, this).getHeight();
	}

}

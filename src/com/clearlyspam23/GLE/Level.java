package com.clearlyspam23.GLE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
	
	private Template template;
	private List<Layer> layers = new ArrayList<Layer>();
	private double width;
	private double height;
	
	public Level(Template template)
	{
		this.template = template;
	}
	
	public void setDimensions(double width, double height){
		this.width = width;
		this.height = height;
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}
	
	public void addLayer(Layer l)
	{
		layers.add(l);
	}
	
	public List<Layer> getLayers()
	{
		return Collections.unmodifiableList(layers);
	}

}

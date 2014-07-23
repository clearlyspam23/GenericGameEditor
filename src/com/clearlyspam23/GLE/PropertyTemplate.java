package com.clearlyspam23.GLE;

import java.awt.Component;
import java.util.List;

public abstract class PropertyTemplate<T extends Component, E> implements Nameable{
	
	private String name;
	@SuppressWarnings("rawtypes")
	private final PropertyDefinition definition;
	
	@SuppressWarnings("rawtypes")
	public PropertyTemplate(String name, PropertyDefinition def){
		this.name = name;
		this.definition = def;
	}
	
	public final String getName(){
		return name;
	}
	
	@SuppressWarnings("rawtypes")
	public final PropertyDefinition getDefinition(){
		return definition;
	}
	
	public abstract T getEditorComponent();
	
	public abstract void setToValue(T component, E value);
	
	public abstract E getValueFrom(T component);
	
	public List<String> checkValidity(){
		return null;
	}

}

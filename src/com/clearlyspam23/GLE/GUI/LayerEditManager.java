package com.clearlyspam23.GLE.GUI;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PInputEventListener;

import com.clearlyspam23.GLE.Nameable;
import com.clearlyspam23.GLE.level.EditAction;
import com.clearlyspam23.GLE.level.Layer;

@SuppressWarnings("rawtypes")
public abstract class LayerEditManager <T extends Layer> implements PInputEventListener, Nameable{
	
	private ComponentData mainComponent;
	
	private List<ComponentData> subComponents = new ArrayList<ComponentData>();
	private List<PInputEventListener> eventListeners = new ArrayList<PInputEventListener>();
	private final List<EditActionListener> editListeners = new ArrayList<EditActionListener>();

	public List<PInputEventListener> getEventListeners() {
		return eventListeners;
	}

	public void setEventListeners(List<PInputEventListener> eventListeners) {
		this.eventListeners = eventListeners;
	}

	@Override
	public void processEvent(PInputEvent arg0, int arg1) {
		for(PInputEventListener l : eventListeners){
			l.processEvent(arg0, arg1);
		}
	}
	
	public ComponentData getMainComponent(){
		return mainComponent;
	}

	public void setMainComponent(Component mainComponent, String name) {
		this.mainComponent = new ComponentData(mainComponent, name);
	}
	
	public void setMainComponent(Component mainComponent, String name, Icon icon) {
		this.mainComponent = new ComponentData(mainComponent, name, icon);
	}

	public List<ComponentData> getSubComponents() {
		return subComponents;
	}

	public void addSubComponents(Component subComponent, String name) {
		subComponents.add(new ComponentData(subComponent, name));
	}
	
	public void addSubComponents(Component subComponent, String name, Icon icon) {
		subComponents.add(new ComponentData(subComponent, name, icon));
	}
	
	public final void addEditListener(EditActionListener listener){
		editListeners.add(listener);
	}
	
	public final void removeEditListener(EditActionListener listener){
		editListeners.remove(listener);
	}
	
	public void registerEditAction(EditAction event){
		for(EditActionListener l : editListeners){
			l.actionMade(event);
		}
	}
	
	public void onActive(T layer){
		
	}
	
	public void onInActive(T layer){
		
	}

}

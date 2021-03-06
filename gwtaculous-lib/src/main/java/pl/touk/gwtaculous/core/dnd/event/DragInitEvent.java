package pl.touk.gwtaculous.core.dnd.event;

import pl.touk.gwtaculous.core.dnd.DragObject;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Represents drag initialization event. This event is fired before actual drag begins (just after mouse is moved with mouse down button on draggable object).
 * This event contains only partially initialized {@link DragObject}, no DOM changes occurred yet.
 */
public class DragInitEvent extends DragEvent<DragInitHandler> {
	
	public static final GwtEvent.Type<DragInitHandler> TYPE = new GwtEvent.Type<DragInitHandler>();
	
	public DragInitEvent(DragObject dragObject, NativeEvent nativeEvent){
		super(dragObject, nativeEvent);
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<DragInitHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DragInitHandler handler) {
		handler.onDragInit(this);
	}
	
    public static HandlerRegistration register(EventBus e, DragInitHandler handler) {
        return e.addHandler(TYPE, handler);
    }
  
    public static HandlerRegistration register(EventBus e, DragInitHandler handler, Object source) {
      return e.addHandlerToSource(TYPE, source, handler);
    }
	
}

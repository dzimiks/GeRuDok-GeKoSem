package state;

import java.awt.Color;

import gekosem.Gekosem;
import gui.view.SlotView;

public class StateManager {

	private State currentState;

	private LinkState linkState;
	private SelectState selectState;
	private LassoState lassoState;
	private LassoZoomState lassoZoomState;
	private AndState andState;
	private OrState orState;
	private NotState notState;
	private MoveState moveState;
	private ResizeState resizeState;
	private Color color;
	


	public StateManager(Gekosem med) {

		this.linkState = new LinkState(med);
		this.selectState = new SelectState(med);
		this.lassoState = new LassoState(med);
		this.lassoZoomState = new LassoZoomState(med);
		this.andState = new AndState(med);
		this.orState = new OrState(med);
		this.notState = new NotState(med);
		this.moveState = new MoveState(med);
		this.resizeState = new ResizeState(med);
		this.currentState = selectState;
		this.color = Color.WHITE;
	}

	private void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public void setLinkState() {
		setCurrentState(linkState);
	}

	public void setSelectState() {
		setCurrentState(selectState);
		selectState.setColor(color);
	}

	public void setLassoState() {
		setCurrentState(lassoState);
	}
	
	public void setResizeState() {
		setCurrentState(resizeState);
		resizeState.startState();
	}

	public void setLassoZoomState() {
		setCurrentState(lassoZoomState);
	}

	public void setAndState() {
		setCurrentState(andState);
		andState.setColor(color);
	}

	public void setOrState() {
		setCurrentState(orState);
		orState.setColor(color);
	}

	public void setNotState() {
		setCurrentState(notState);
		notState.setColor(color);
	}
	
	public void setMoveState(){
		setCurrentState(moveState);
	}

	public State getCurrentState() {
		return currentState;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}

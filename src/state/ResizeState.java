package state;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import gekosem.Gekosem;
import gekosem.Gekosem.Handle;
import gekosem.GraphicElement;
import gekosem.GraphicShape;
import gekosem.commands.ResizeCommand;
import gui.model.Element;
import gui.observer.NotificationObserver;
import gui.view.MainView;

public class ResizeState extends State {

	private Handle handleInMotion = null;
	private GraphicShape inMotion = null;
	private Gekosem med;

	private double scalable;

	private ArrayList<Point2D> newPositions = new ArrayList<>();
	private ArrayList<Point2D> oldPositions = new ArrayList<>();
	private ArrayList<Double> newScale = new ArrayList<>();
	private ArrayList<Double> oldScale = new ArrayList<>();
	private ArrayList<Dimension> newDimensions = new ArrayList<>();
	private ArrayList<Dimension> oldDimensions = new ArrayList<>();

	public ResizeState(Gekosem med) {
		super();
		this.med = med;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	private double max(double a, double b) {
		return (a > b) ? b : a;
	}

//	private double daljina(double x1, double y1, double x2, double y2) {
//		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
//	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Point2D position = e.getPoint();
		med.transformToUserSpace(position);
		if (handleInMotion == null) {
			handleInMotion = med.getDeviceAndHandleForPoint(position);
			inMotion = med.getDeviceForHandlePoint(position);
		}
		if (handleInMotion != null) {
			// double bestX= 100000000;
			// double bestY= 100000000;
			// for (Element e1 :
			// med.getSlot().getSelectionModels().getSelectionList()){
			// double tmpBestX = min(bestX,
			// Math.abs(e.getX()-((GraphicShape)e1).getPosition().getX() +
			// ((GraphicShape)e1).getSize().getWidth()));
			// double tmpBestY = min(bestY,
			// Math.abs(e.getY()-((GraphicShape)e1).getPosition().getY() +
			// ((GraphicShape)e1).getSize().getHeight()));
			//
			// if(daljina(bestX, bestY, e.getX(), e.getY()) > daljina(tmpBestX,
			// tmpBestY, e.getX(), e.getY())){
			// bestX = tmpBestX;
			// bestY = tmpBestY;
			// }
			//
			//
			// }
			double razlikaX = 0;
			double razlikaY = 0;
			GraphicShape shape = this.inMotion;
			switch (handleInMotion.ordinal()) {
			// southeast
			case 4: {
				razlikaX = position.getX() - (shape.getPosition().getX() + shape.getSize().getWidth());
				razlikaY = position.getY() - (shape.getPosition().getY() + shape.getSize().getHeight());
				double newWidth = shape.getSize().getWidth() + razlikaX;
				double newHeight = shape.getSize().getHeight() + razlikaY;
				shape.setSize(new Dimension((int) newWidth, (int) newHeight));
				double scaleX = newWidth / shape.getInitSize().getWidth();
				double scaleY = newHeight / shape.getInitSize().getHeight();
				double newScale = 1;
				if (scaleX < scaleY)
					newScale = scaleX;
				else
					newScale = scaleY;

				double tempWidth = shape.getSize().getWidth();
				this.scalable = newScale - shape.getScale();

				if (newScale < 0.2)
					shape.setScale(0.2);
				else if (newScale > 3)
					shape.setScale(3);
				else
					shape.setScale(newScale);
				((Point) shape.getPosition()).translate((int) (tempWidth - shape.getSize().getWidth()), 0);
				med.getSlot().notifyObservers(NotificationObserver.ADD, null);
				break;
			}
//			// southwest
//			case 5:{
//				razlikaX=position.getX()-(shape.getPosition().getX());
//				razlikaY=position.getY()-(shape.getPosition().getY()+shape.getSize().getHeight());					
//				double newWidth = shape.getSize().getWidth()-razlikaX;
//				double newHeight = shape.getSize().getHeight()+razlikaY;
//				double scaleX=newWidth/shape.getInitSize().getWidth();
//				double scaleY=newHeight/shape.getInitSize().getHeight();
//				double newScale = 1;
//				if (scaleX < scaleY)
//					newScale = scaleX;
//				else
//					newScale = scaleY;
//				double tempWidth=shape.getSize().getWidth();
//				this.scalable = newScale - shape.getScale();
//					
//				if(newScale<0.2)
//					shape.setScale(0.2);
//				else if(newScale>3)
//					shape.setScale(3);
//				else
//					shape.setScale(newScale);
//				shape.setSize(new Dimension((int) newWidth, (int) newHeight));
//				((Point) shape.getPosition()).translate((int)(tempWidth-shape.getSize().getWidth()),0);
//				med.getSlot().notifyObservers(NotificationObserver.ADD, null);
//				break;
//				
//			}
//			//NorthEast
//			case 6: {
//				razlikaX=position.getX()-(shape.getPosition().getX()+shape.getSize().getWidth());
//				razlikaY=position.getY()-(shape.getPosition().getY());					
//				double newWidth = shape.getSize().getWidth()+razlikaX;
//				double newHeight = shape.getSize().getHeight()-razlikaY;
//				double scaleX=newWidth/shape.getInitSize().getWidth();
//				double scaleY=newHeight/shape.getInitSize().getHeight();
//				double newScale = 1;
//				if (scaleX < scaleY)
//					newScale = scaleX;
//				else
//					newScale = scaleY;
//				double tempHeight=shape.getSize().getHeight();
//				this.scalable = newScale - shape.getScale();
//					
//				if(newScale<0.2)
//					shape.setScale(0.2);
//				else if(newScale>3)
//					shape.setScale(3);
//				else
//					shape.setScale(newScale);
//				shape.setSize(new Dimension((int) newWidth, (int) newHeight));
//				((Point) shape.getPosition()).translate(0, (int)(tempHeight-shape.getSize().getHeight()));
//				med.getSlot().notifyObservers(NotificationObserver.ADD, null);
//				break;
//			}
//			//NorthWest
//			case 7:{
//				razlikaX=position.getX()-(shape.getPosition().getX());
//				razlikaY=position.getY()-(shape.getPosition().getY());					
//				double newWidth = shape.getSize().getWidth()-razlikaX;
//				double newHeight = shape.getSize().getHeight()-razlikaY;
//				double scaleX=newWidth/shape.getInitSize().getWidth();
//				double scaleY=newHeight/shape.getInitSize().getHeight();
//				double newScale = 1;
//				if (scaleX < scaleY)
//					newScale = scaleX;
//				else
//					newScale = scaleY;
//				double tempHeight=shape.getSize().getHeight();
//				double tempWidth=shape.getSize().getWidth();
//				this.scalable = newScale - shape.getScale();
//					
//				if(newScale<0.2)
//					shape.setScale(0.2);
//				else if(newScale>3)
//					shape.setScale(3);
//				else
//					shape.setScale(newScale);
//				shape.setSize(new Dimension((int) tempWidth, (int) tempHeight));
//				((Point) shape.getPosition()).translate((int)(tempWidth-shape.getSize().getWidth()), (int)(tempHeight-shape.getSize().getHeight()));
//				med.getSlot().notifyObservers(NotificationObserver.ADD, null);
//				break;}
			}
			med.getSlot().notifyObservers(NotificationObserver.ADD, null);

			for (Element e1 : med.getSlot().getSelectionModels().getSelectionList()) {
				GraphicElement element = (GraphicElement) e1;
				if (element instanceof GraphicShape) {
					shape = (GraphicShape) element;
					if(shape == inMotion) continue;
					switch (handleInMotion.ordinal()) {
					// southeast
					case 4: {
						double newWidth = shape.getSize().getWidth() + razlikaX;
						double newHeight = shape.getSize().getHeight() + razlikaY;
						shape.setSize(new Dimension((int) newWidth, (int) newHeight));
						double newScale = shape.getScale() + this.scalable;

						double tempWidth = shape.getSize().getWidth();
						
						if (newScale < 0.2)
							shape.setScale(0.2);
						else if (newScale > 3)
							shape.setScale(3);
						else
							shape.setScale(newScale);
						((Point) shape.getPosition()).translate((int) (tempWidth - shape.getSize().getWidth()), 0);
						med.getSlot().notifyObservers(NotificationObserver.ADD, null);
						break;
					}
//					// southwest
//					case 5:{
//						double newWidth = shape.getSize().getWidth()-razlikaX;
//						double newHeight = shape.getSize().getHeight()+razlikaY;
//						double newScale = shape.getScale() + this.scalable;
//						shape.setSize(new Dimension((int) newWidth, (int) newHeight));
//						double tempHeight=shape.getSize().getHeight();
//							
//						if(newScale<0.2)
//							shape.setScale(0.2);
//						else if(newScale>3)
//							shape.setScale(3);
//						else
//							shape.setScale(newScale);
//						((Point) shape.getPosition()).translate(0, (int)(tempHeight-shape.getSize().getHeight()));
//						med.getSlot().notifyObservers(NotificationObserver.ADD, null);
//						break;
//						
//					}
//					//NorthEast
//					case 6: {
//						double newWidth = shape.getSize().getWidth() + razlikaX;
//						double newHeight = shape.getSize().getHeight() - razlikaY;
//						shape.setSize(new Dimension((int) newWidth, (int) newHeight));
//						double newScale = shape.getScale() + this.scalable;
//
//						double tempWidth = shape.getSize().getWidth();
//						
//						if (newScale < 0.2)
//							shape.setScale(0.2);
//						else if (newScale > 3)
//							shape.setScale(3);
//						else
//							shape.setScale(newScale);
//						((Point) shape.getPosition()).translate((int) (tempWidth - shape.getSize().getWidth()), 0);
//						med.getSlot().notifyObservers(NotificationObserver.ADD, null);
//						break;
//					}
//					//NorthWest
//					case 7:{
//						double newWidth = shape.getSize().getWidth() - razlikaX;
//						double newHeight = shape.getSize().getHeight() - razlikaY;
//						shape.setSize(new Dimension((int) newWidth, (int) newHeight));
//						double newScale = shape.getScale() + this.scalable;
//
//						double tempWidth = shape.getSize().getWidth();
//						
//						if (newScale < 0.2)
//							shape.setScale(0.2);
//						else if (newScale > 3)
//							shape.setScale(3);
//						else
//							shape.setScale(newScale);
//						((Point) shape.getPosition()).translate((int) (tempWidth - shape.getSize().getWidth()), 0);
//						med.getSlot().notifyObservers(NotificationObserver.ADD, null);
//						break;
//					}
					}
				}
				med.getSlot().notifyObservers(NotificationObserver.ADD, null);

			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		for(Element element : med.getSlot().getSelectionModels().getSelectionList()){
			if(element instanceof GraphicShape){
				newPositions.add(((GraphicShape) element).getPosition());
				newScale.add(((GraphicShape) element).getScale());
				newDimensions.add(((GraphicShape) element).getSize());
			}
		}
		handleInMotion = null;
		med.getGkm().addCommand(new ResizeCommand(med.getSlot(), oldPositions, newPositions, oldScale, newScale, oldDimensions, newDimensions));
		med.startSelectState();
		
		newPositions.clear();
		oldPositions.clear();
		newScale.clear();
		oldScale.clear();
		oldDimensions.clear();
		newDimensions.clear();

	}
	
	public void startState() {
		for(Element element : med.getSlot().getSelectionModels().getSelectionList()){
			if(element instanceof GraphicShape){
				oldPositions.add((Point2D) ((GraphicShape) element).getPosition().clone());
				oldScale.add(((GraphicShape) element).getScale());
				oldDimensions.add(((GraphicShape) element).getSize());
			}
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

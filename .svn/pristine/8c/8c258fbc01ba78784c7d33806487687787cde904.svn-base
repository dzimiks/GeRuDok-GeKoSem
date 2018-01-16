package gekosem.painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import gekosem.GraphicElement;
import gekosem.LinkElement;

@SuppressWarnings("serial")
public class LinkPainter extends ElementPainter {

	public LinkPainter(GraphicElement element) {
		super(element);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void paint(Graphics2D g2, GraphicElement element) {
		// TODO Auto-generated method stub
		g2.setPaint(element.getPaint());
		g2.setStroke(element.getStroke());

		LinkElement link = (LinkElement) element;

		Point2D last = (Point2D) link.getOut().getPosition().clone();

		last.setLocation(last.getX(), last.getY());

		for (Point2D curr : link.getPoints()) {
			g2.drawLine((int) last.getX(), (int) last.getY(), (int) curr.getX(), (int) curr.getY());
			last = curr;
			g2.drawRect((int) last.getX() - 2, (int) last.getY() - 2, 4, 4);

		}

		if (link.getIn() != null) {
			g2.drawLine((int) last.getX(), (int) last.getY(), (int) link.getIn().getPosition().getX(),
					(int) link.getIn().getPosition().getY());
		}

	}

	@Override
	public boolean isElementAt(Point pos) {
		// TODO Auto-generated method stub
		LinkElement link = (LinkElement) getElement();
		if (link.getIn() == null)
			return false;

		Point2D s = link.getOut().getPosition();
		Point2D d = link.getOut().getPosition();

		Rectangle rect = new Rectangle();
		rect.setRect(s.getX() - 2, s.getY() - 2, 4, 4);
		if (rect.contains(pos))
			return true;

		rect.setRect(d.getX() - 2, d.getY() - 2, 4, 4);
		if (rect.contains(pos))
			return true;

		for (Point2D p : link.getPoints()) {
			rect.setRect(p.getX() - 2, p.getY() - 2, 4, 4);
			if (rect.contains(pos))
				return true;
		}
		return false;
	}

	public static Rectangle findRectangle(LinkElement link) {
		double minX = link.getOut().getPosition().getX();
		double minY = link.getOut().getPosition().getY();
		double maxX = link.getOut().getPosition().getX() + 5;
		double maxY = link.getOut().getPosition().getY() + 5;
		for(Point2D point : link.getPoints()){
			if(point.getX()<minX)
				minX = point.getX();
			if(point.getX()>maxX)
				maxX = point.getX();
			if(point.getY()<minY)
				minY = point.getY();
			if(point.getY()>maxY)
				maxY = point.getY();
		}
		Point2D point = link.getIn().getPosition();
		if(point.getX()<minX)
			minX = point.getX();
		if(point.getX()>maxX)
			maxX = point.getX();
		if(point.getY()<minY)
			minY = point.getY();
		if(point.getY()>maxY)
			maxY = point.getY();

		
		Rectangle rect=new Rectangle((int)minX-5,(int)minY-5,(int)(maxX-minX+10),(int)(maxY-minY+10));
		return rect;

	}

}

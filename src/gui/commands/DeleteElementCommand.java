package gui.commands;

import java.util.ArrayList;
 
import gekosem.GraphicShape;
import gekosem.LinkElement;
import gui.commands.Command;
import gui.commands.Invoker;
import gui.commands.TreeSelectCommand;
import gui.model.Element;
import gui.model.MainModel;
import gui.model.Project;
import gui.model.Slot;
import gui.model.Workspace;
import gui.model.tree.Node;
import gui.observer.NotificationObserver;
 
public class DeleteElementCommand extends Command {
 
    private ArrayList<Element> nodes = new ArrayList<>();
    private MainModel model = MainModel.getInstance();
    
    public DeleteElementCommand(Node node){
    	this.nodes.add((Element)node);
    }
    
    public DeleteElementCommand(ArrayList<Element> nodes) {
        for(Node node: nodes){
        	this.nodes.add((Element)node);
        }
    }
    
    @Override
    public void doCommand() {
    	
       for(Node node: nodes){
    	   Node parent = (Node) node.getParent();
    	   Slot slot = (Slot) node.getParent();
    	   
           if (node instanceof GraphicShape) {
               
               ArrayList<Element> linkoviZaBrisanje = new ArrayList<>();
               for (Node n : parent.getChildren()){
                   if(n instanceof LinkElement && (((LinkElement)n).getStart().equals(node)
                           || ((LinkElement)n).getEnd().equals(node))){
                       linkoviZaBrisanje.add((Element)n);
                   }
               } 
                   Invoker.getInstance().executeCommand(new DeleteElementCommand(linkoviZaBrisanje));
           }
           
           slot.getSelectionModels().removeAllFromSelectionList();
           slot.notifyObservers(NotificationObserver.DELETE, null);
           node.removeFromParent();
           model.getTreeModel().reload();
           Invoker.getInstance().executeCommand(new TreeSelectCommand(model, parent));
       }
    }
}
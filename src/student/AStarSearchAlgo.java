package student;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		Set<Node> visited = new HashSet<Node>();
		root.setH(0);
		root.setG(0);
		frontier.add(root);
		visited.add(root);
		Node current;
		while (frontier != null) {
			current = frontier.poll();
			for (Edge e : current.getChildren()) {
				Node child = e.getEnd();
				double cost = e.getWeight();
				child.setG(current.getH() + cost);
				child.setG(current.getG()+child.getG());
				if (!visited.contains(child) && !frontier.contains(child)) {
					child.setParent(current);
					frontier.add(child);
				} else if ((frontier.contains(child)) && (child.getG() > current.getG())) {
					child.setParent(current);

					frontier.remove(child);
					frontier.add(child);
				}
			}
			if (current.getLabel().equalsIgnoreCase(goal)) {
				return current;
			}
			visited.add(current);
		}
		return null;	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		Set<Node> visited = new HashSet<Node>();
		root.setH(0);
		root.setG(0);
		frontier.add(root);
		visited.add(root);
		Node current;
		while (frontier != null) {
			current = frontier.poll();
			for (Edge e : current.getChildren()) {
				Node child = e.getEnd();
				double cost = e.getWeight();
				child.setG(current.getH() + cost);
				child.setG(current.getG()+child.getG());
				if (!visited.contains(child) && !frontier.contains(child)) {
					child.setParent(current);
					frontier.add(child);
				} else if ((frontier.contains(child)) && (child.getG() > current.getG())) {
					child.setParent(current);

					frontier.remove(child);
					frontier.add(child);
				}
			}
			if (current.getLabel().equalsIgnoreCase(goal)) {
				return current;
			}
			visited.add(current);
		}
		return null;	
	}
	public boolean isAdmissibleH(Node root, String goal) {
		AStarSearchAlgo as = new AStarSearchAlgo();
		GreedyBestFirstSearchAlgo g = new GreedyBestFirstSearchAlgo();
		if(g.execute(root, goal).getH()<=as.execute(root, goal).getH()) {
			return true;
		}
		return false;
		
	}
}

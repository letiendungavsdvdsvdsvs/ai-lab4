package student;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;



public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		Set<Node> visited = new HashSet<Node>();
		root.setH(0);
		frontier.add(root);
		visited.add(root);
		Node current;
		while (frontier != null) {
			current = frontier.poll();
			for (Edge e : current.getChildren()) {
				Node child = e.getEnd();
				child.setH(current.getH() + child.getH());
				if (!visited.contains(child) && !frontier.contains(child)) {
					child.setParent(current);
					frontier.add(child);
				} else if ((frontier.contains(child)) && (child.getH() > current.getH())) {
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

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		Set<Node> visited = new HashSet<Node>();
		root.setH(0);
		frontier.add(root);
		visited.add(root);
		Node current;
		while (frontier != null) {
			current = frontier.poll();
			for (Edge e : current.getChildren()) {
				Node child = e.getEnd();
				child.setH(current.getH() + child.getH());
				if (!visited.contains(child) && !frontier.contains(child)) {
					child.setParent(current);
					frontier.add(child);
				} else if ((frontier.contains(child)) && (child.getH() > current.getH())) {
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
	

}

package data;

import java.util.LinkedList;
import java.util.List;

public class ListfinPath {

	private ListfinPath() {

	}

	private static List<finPath> finPathList;

	public static List<finPath> getInstance() {
		if (finPathList == null) {
			finPathList = new LinkedList<finPath>();
		}
		return finPathList;
	}
}

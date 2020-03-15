import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/*
 * https://www.lavivienpost.com/autocomplete-with-trie-code/
 */

class TrieNode {
	char value;
	// each element in the LL is a TrieNode
	LinkedList<TrieNode> children;
	TrieNode parent;
	boolean isEnd;

	public TrieNode(char c) {
		value = c;
		children = new LinkedList();
		isEnd = false;
	}

	// used to access leaf node
	public TrieNode getChild(char c) {
		if (children != null)
			for (TrieNode eachChild : children)
				if (eachChild.value == c)
					return eachChild;
		return null;
	}

	// returns the entire list of words
	public List getWords() {
		List list = new ArrayList();
		if (isEnd) list.add(toString());

		if (children != null) {
			for (int i = 0; i < children.size(); i++) {
				if (children.get(i) != null) list.addAll(children.get(i).getWords());
			}
		}
		return list;
	}

	public String toString() {
		if (parent==null) {
			return ""; // return blank string if null
		} else {
			return parent.toString() + new String(new char[] { value });
		}
	}
}
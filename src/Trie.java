import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/*
 * https://www.lavivienpost.com/autocomplete-with-trie-code/
 */

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode(' ');
	}

	public void add(String word) {
		if (search(word) == true)
			return;

		TrieNode current = root;
		TrieNode pre;
		for (char ch : word.toCharArray()) {
			pre = current;
			TrieNode child = current.getChild(ch);
			if (child != null) {
				current = child;
				child.parent = pre;
			} else {
				current.children.add(new TrieNode(ch));
				current = current.getChild(ch);
				current.parent = pre;
			}
		}
		current.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			if (current.getChild(ch) == null)
				return false;
			else {
				current = current.getChild(ch);
			}
		}
		if (current.isEnd == true) {
			return true;
		}
		return false;
	}

	public List autocomplete(String prefix) {
		TrieNode lastNode = root;
		for (int i = 0; i < prefix.length(); i++) {
			lastNode = lastNode.getChild(prefix.charAt(i));
			if (lastNode == null)
				return new ArrayList();
		}

		return lastNode.getWords();
	}
}
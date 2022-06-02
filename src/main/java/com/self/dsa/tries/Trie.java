package com.self.dsa.tries;

import java.util.ArrayList;
import java.util.List;

class TrieNode{

	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}


public class Trie {

	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
	}

	public boolean search(String word){
		TrieNode curr = root;
        
        int n = word.length();
        for(int i = 0; i < n; i++) {
            char c = word.charAt(i);
            int childIndex = c - 'a';
            
            if(curr == null)
                break;
            
            curr = curr.children[childIndex];
        }
        return curr != null && curr.isTerminating;
	}


	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));

	}

	private List<String> getSuffixes(String word) {
		List<String> suffixes = new ArrayList<>();
		suffixes.add(word);

		for(int i = 1; i < word.length(); i++) {
			suffixes.add(word.substring(i));
		}
		return suffixes;
	}

	public boolean patternMatching(ArrayList<String> vect, String pattern) {

		for(String word : vect) {
			List<String> suffixes = getSuffixes(word);
			for(String suffix : suffixes) {
				add(suffix);
			}
		}

		TrieNode curr = root;
		for(int i = 0; i < pattern.length() ; i++) {
			char c = pattern.charAt(i);
			int childIndex = c - 'a';

			TrieNode child = curr.children[childIndex];
			if(child == null) {
				return false;
			}
			curr = child;
		}
		return true;
	}

	private boolean searchReverse(String word) {

		TrieNode curr = root;
		for(int i = word.length() - 1; i >=0; i--) {
			char c = word.charAt(i);
			int childIndex = c - 'a';

			TrieNode child = curr.children[childIndex];
			if(child == null)
				return false;

			curr = child;
		}
		return curr != null && curr.isTerminating;
	}


	public boolean isPalindromePair(ArrayList<String> words) {
		List<String> pairs = getPairedWords(words);
		for(String word : words) {
			add(word);
		}

		for(String word : words) {
			boolean found = searchReverse(word);
			if(found)
				return true;
		}
		for(String pair: pairs) {
			add(pair);
		}
		for(String pair: pairs) {
			boolean found = searchReverse(pair);
			if(found)
				return true;
		}

		return false;
	}

	private List<String> getPairedWords(ArrayList<String> words) {

		List<String> pairs = new ArrayList<>();
		for(int i = 0; i < words.size(); i++) {
			for(int j = i+1; j < words.size(); j++) {
				pairs.add(words.get(i) + words.get(j));
			}
		}
		return pairs;
	}

	public void add(String word){
		add(root, word);
	}

	public void autoComplete(ArrayList<String> input, String word) {


		for(String eachWord : input) {
			add(eachWord);
		}

		TrieNode wordNode = root;

		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int childIndex = c - 'a';

			TrieNode childNode = wordNode.children[childIndex];
			if(childNode == null)
				return;

			wordNode = childNode;
		}

		print(word, wordNode);
	}

	private void print(String prefix, TrieNode node) {

		if(node == null)
			return;

		if(node != null && node.isTerminating) {
			System.out.println(prefix);
		}

		for(TrieNode childNode : node.children) {
			if(childNode != null) {
				print(prefix + childNode.data, childNode);
			}
		}
	}
}
package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;

import structures.Queue;

/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 */
public class LevelOrderIterator extends FileIterator<File> {
	
	private File node;
	private  Queue<File> files;
	
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
        	// TODO 1
	    files = new Queue<File>();
	  
		if(!rootNode.exists()){
			throw new FileNotFoundException();
		}
		else{
			node = rootNode;
			files.enqueue(node);
		}
				
			
			//bfs algorhythm
			
		
	}
	
	@Override
	public boolean hasNext() {
        	// TODO 2
	    
            return (files.size() > 0);
	}

	@Override
	public File next() throws NoSuchElementException {
        	// TODO 3
		if(!hasNext()){
			throw new NoSuchElementException();
		}
		else{
			if(files.peek().isDirectory()){
				File[] directories = files.peek().listFiles();
				Arrays.sort(directories);
				for(int i = 0; i < directories.length; i++){
					files.enqueue(directories[i]);
				}
			}
			return files.dequeue();	
		}	
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}

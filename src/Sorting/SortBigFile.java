package Sorting;

/**
 * @author Nagaraju Budigam
 *
 */
public class SortBigFile {
	/*
	 * Imagine you have a 20GB file with one string per line. Explain how you
	 * sort the file.
	 * 
	 * Solution: Divide the file into chunks, which are x megabytes each, where
	 * x is the amount of memory available. Each chunk is sorted separately and
	 * then saved back to the file system. Once all the chunks are sorted, we
	 * merge the chunks one by one. At the end we have fully sorted file. 
	 * This algorithm is known as External Sort.
	 */

}

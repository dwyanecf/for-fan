package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinuxFindOOD {

	public interface EntryInterface {
		String getName();

		int getSize();

		void setName(String name);

		boolean isDirectory();

	}

	public abstract class Entry implements EntryInterface {
		String name;

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return this.name;
		}

		@Override
		public void setName(String name) {
			// TODO Auto-generated method stub
			this.name = name;
		}
	}

	public class File extends Entry {
		private byte[] content;

		public byte[] getContent() {
			return this.content;
		}

		public void setContent(byte[] content) {
			this.content = content;
		}

		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			return content.length;
		}

		@Override
		public boolean isDirectory() {
			// TODO Auto-generated method stub
			return false;
		}

		public String getExtension() {
			return this.name.substring(this.name.indexOf(".") + 1);
		}

	}

	public class Directory extends Entry {
		List<Entry> entries = new ArrayList<>();

		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			int size = 0;
			for (Entry e : entries) {
				size += e.getSize();
			}
			return size;
		}

		@Override
		public boolean isDirectory() {
			// TODO Auto-generated method stub
			return true;
		}

		public void addEntry(Entry e) {
			this.entries.add(e);
		}

		public List<Entry> getEntry() {
			return this.entries;
		}

	}

	public class SearchParams {
		String extension;
		Integer minSize;
		Integer maxSize;
		String name;
	}

	public interface FilterInterface {
		public boolean isValid(SearchParams para, File file);
	}

	public class ExtensionFilter implements FilterInterface {

		@Override
		public boolean isValid(SearchParams params, File file) {
			if (params.extension == null) {
				return true;
			}

			return file.getExtension().equals(params.extension);
		}

	}

	public class MinSizeFilter implements FilterInterface {

		@Override
		public boolean isValid(SearchParams params, File file) {
			if (params.minSize == null) {
				return true;
			}

			return file.getSize() >= params.minSize;
		}

	}

	public class MaxSizeFilter implements FilterInterface {

		@Override
		public boolean isValid(SearchParams params, File file) {
			if (params.maxSize == null) {
				return true;
			}

			return file.getSize() <= params.maxSize;
		}

	}

	public class NameFilter implements FilterInterface {

		@Override
		public boolean isValid(SearchParams params, File file) {
			if (params.name == null) {
				return true;
			}

			return file.getName().equals(params.name);
		}

	}

	public class FileFilter {
		List<FilterInterface> filters = new ArrayList<>();

		public FileFilter() {
			filters.add(new NameFilter());
			filters.add(new MaxSizeFilter());
			filters.add(new MinSizeFilter());
			filters.add(new ExtensionFilter());
		}

		public boolean isValid(SearchParams params, File file) {
			for (FilterInterface filter : filters) {
				if (!filter.isValid(params, file)) {
					return false;
				}
			}

			return true;
		}
	}

	public class FileSearcher {
		FileFilter filter = new FileFilter();

		public List<File> search(Directory dir, SearchParams params) {
			List<File> res = new ArrayList<>();
			Queue<Directory> q = new LinkedList<>();
			q.offer(dir);
			while (!q.isEmpty()) {
				Directory cur = q.poll();

				for (Entry e : cur.entries) {
					if (e.isDirectory()) {
						q.offer((Directory) e);
					} else {
						File file = (File) e;
						if (filter.isValid(params, file)) {
							res.add((File) e);
						}
					}
				}
			}

			return res;
		}
	}

}

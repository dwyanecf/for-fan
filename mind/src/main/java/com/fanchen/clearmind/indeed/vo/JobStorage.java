package com.fanchen.clearmind.indeed.vo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JobStorage {
	Map<Long, Boolean> record = new HashMap<>();
	
	Set<Long> set = new HashSet<>();

	public JobStorage(List<Long> jobids) {
		for (Long id : jobids) {
			record.put(id, true);
		}
	}

	public void expire(long jobid) {
		if (record.containsKey(jobid)) {
			record.put(jobid, false);
		}
	}

	public boolean isexpired(long jobid) {
		return record.get(jobid);
	}
	
	
	
	/**
	 * 全放进map里面空间就不够了，面试中不让用map。
		long是64个bit。
		64bit的操作系统里面，16GB的内存如何存下4 Billion个jobid。
		还有用16MB怎么存下一大堆jobid。
		（意思是怎么存比较节约内存）。
		expire的job id比较多，可以考虑如何压缩去存expire job id。
		
		可能用bitSet，还有就是讨论job id的范围。还有trie可以用。
		job id
		（这里用4位表示long，前面的0省略）
		0001
		0010
		0100
		1000
		
		开一个四个长度的bit数组（好像没有bit数组），这样的话如果4个job id都expire，只需要保存1111即可
		检查某个job id是否expire，只需要检查某一位上是不是1就可以。
		这样的话，存储空间从16位降到了4位。
		这里面的hash function就是 id & 1111
	 */
}

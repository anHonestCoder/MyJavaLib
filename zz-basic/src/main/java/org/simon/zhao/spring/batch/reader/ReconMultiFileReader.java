package org.simon.zhao.spring.batch.reader;

import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * @author Zhaozhou
 * @date 2017/6/21
 */
public class ReconMultiFileReader extends MultiResourceItemReader implements InitializingBean{
	private String filePaths;

	public void setFilePaths(String filePaths) {
		this.filePaths = filePaths;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (StringUtils.isBlank(filePaths)) {
			return;
		}

		System.out.println("ReconMultiFileReader#afterPropertiesSet----  " + filePaths);
		String[] paths = filePaths.split(";");
		Resource[] resources = new Resource[paths.length];
		for (int i = 0; i < paths.length; i++) {
			resources[i] = new FileSystemResource(paths[i]);
		}

		this.setResources(resources);

	}
}

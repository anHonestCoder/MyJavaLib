package org.simon.zhao.spring.batch.writer;

import org.simon.zhao.spring.batch.record.VpalRecondItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.FlatFileItemWriter;

import java.util.List;

/**
 * @author jason.gao
 * @date 2017/6/6
 */
public class SPDBItemWriter extends FlatFileItemWriter<VpalRecondItem> {
	private static final Logger logger = LoggerFactory.getLogger(SPDBItemWriter.class);


	@Override
	public void write(List<? extends VpalRecondItem> items) throws Exception {

		//写入Vpal对账文件
		super.write( items );

	}


}

package org.simon.zhao.spring.batch.aggregator;


import org.simon.zhao.spring.batch.record.VpalRecondItem;
import org.springframework.batch.item.file.transform.LineAggregator;

/**
 * @author Zhaozhou
 * @date 2017/5/23
 */
public class ReconLineAggregator implements LineAggregator<VpalRecondItem> {
	
	
	@Override
	public String aggregate(VpalRecondItem item) {
		if (item == null) {
			return "";
		}

		String newLine = System.getProperty("line.separator").toString();

		StringBuilder sb = new StringBuilder("");
		sb.append(item.getTransType()).append("|");
		sb.append(item.getTransDate()).append("|");
		sb.append(item.getTransTime()).append("|");
		sb.append(item.getBankOrdNo()).append("|");
		sb.append(item.getTransAmount()).append("|");
		sb.append(item.getTransNo()).append("|");
		sb.append(item.getUasNo()).append("|");
		sb.append(item.getUsaOriginNo()).append(newLine);



		return sb.toString();
	}
}

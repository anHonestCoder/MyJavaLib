package org.simon.zhao.spring.batch.field.mapping;

import org.simon.zhao.spring.batch.record.SPDBReconItem;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * @author Jason.gao
 * @date 2017/6/1
 */
public class SPDBRecondItemFieldSetMapper implements FieldSetMapper<SPDBReconItem> {
	@Override
	public SPDBReconItem mapFieldSet(FieldSet fieldSet) throws BindException {
		SPDBReconItem item = new SPDBReconItem();
		item.setMerchantId( fieldSet.readString(0) );
		item.setMerchantName( fieldSet.readString(1) );
		item.setSecondMerchantId( fieldSet.readString(2) );
		item.setSecondMerchantName( fieldSet.readString(3) );
		item.setTxType( fieldSet.readString(4) );
		item.setTxDate( fieldSet.readString(5) );
		item.setMerchantReqNo( fieldSet.readString(6) );
		item.setBankRespNo( fieldSet.readString(7) );
		item.setTxAccount( fieldSet.readString(8) );
		item.setTxAccountName( fieldSet.readString(9) );
		item.setTxAccountLineNo( fieldSet.readString(10) );
		item.setTxAccountLineName( fieldSet.readString(11) );
		item.setAccountedDate( fieldSet.readString(12) );
		item.setAccountedTime( fieldSet.readString(13) );
		item.setTxAmount( fieldSet.readString(14) );
		item.setFee( fieldSet.readString(15) );
		return item;
	}
}
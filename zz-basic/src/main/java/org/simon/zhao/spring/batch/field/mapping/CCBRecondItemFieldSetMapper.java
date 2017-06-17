package org.simon.zhao.spring.batch.field.mapping;

import org.simon.zhao.spring.batch.record.CCBReconItem;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * @author Zhaozhou
 * @date 2017/5/22
 */
public class CCBRecondItemFieldSetMapper implements FieldSetMapper<CCBReconItem> {
	@Override
	public CCBReconItem mapFieldSet(FieldSet fieldSet) throws BindException {
		CCBReconItem item = new CCBReconItem();
		item.setShopNo( fieldSet.readString(0) );
		item.setPosRefNo( fieldSet.readString(1) );
		item.setTxDate( fieldSet.readString(2) );
		item.setTxTime( fieldSet.readString(3) );
		item.setOrderNo( fieldSet.readString(4) );
		item.setPosTxSqNo( fieldSet.readString(5) );
		item.setAcctNo( fieldSet.readString(6) );
		item.setTxAmt( fieldSet.readString(7) );
		item.setDecAmt( fieldSet.readString(8) );
		item.setEntrDate( fieldSet.readString(9) );
		item.setAuthNo( fieldSet.readString(10) );
		item.setPayType( fieldSet.readString(11) );
		item.setAcctType( fieldSet.readString(12) );
		item.setTradNo( fieldSet.readString(13) );
		item.setTradNoOrg( fieldSet.readString(14) );
		return item;
	}
}

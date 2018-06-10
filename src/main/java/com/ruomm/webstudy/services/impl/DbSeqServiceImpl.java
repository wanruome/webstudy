/**
 *	@copyright wanruome-2018
 * 	@author wanruome
 * 	@create 2018年6月10日 下午11:30:41
 */
package com.ruomm.webstudy.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ruomm.webstudy.dal.mapper.DbSequenceMapper;
import com.ruomm.webstudy.dal.model.DbSequence;
import com.ruomm.webstudy.services.DbSeqService;

import tk.mybatis.mapper.entity.Example;

@Service
public class DbSeqServiceImpl implements DbSeqService {
	@Autowired
	DbSequenceMapper dbSequenceMapper;

	@Override
	public int getSeqByName(String name) {
		// TODO Auto-generated method stub
		String seqName = StringUtils.isEmpty(name) ? "default_seq_key" : name;
		DbSequence querySeq = new DbSequence();
		querySeq.setSeqName(seqName);
		DbSequence resultDbSeq = dbSequenceMapper.selectByPrimaryKey(querySeq);
		int dbResult = 0;
		DbSequence updateDbSeq = new DbSequence();
		if (null == resultDbSeq) {
			updateDbSeq.setSeqName(seqName);
			updateDbSeq.setSeqValue(1);
			dbResult = dbSequenceMapper.insertSelective(updateDbSeq);
		}
		else {

			updateDbSeq.setSeqName(resultDbSeq.getSeqName());
			updateDbSeq.setSeqValue(resultDbSeq.getSeqValue() + 1);
			Example example = new Example(DbSequence.class);
			Example.Criteria criteria = example.createCriteria();
			criteria.andEqualTo(resultDbSeq);
			dbResult = dbSequenceMapper.updateByExampleSelective(updateDbSeq, example);
		}
		return dbResult > 0 ? updateDbSeq.getSeqValue() : -9999;
	}

}

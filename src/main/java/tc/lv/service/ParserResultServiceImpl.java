package tc.lv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.SourceDao;
import tc.lv.utils.ParserResults;

@Service
public class ParserResultServiceImpl implements ParserResultService {
    @Autowired
    //�� ���� Download DAO
    private SourceDao sourceDao;

    //Update source in DataBAse
    
    @Transactional
    @Override
    public void save(ParserResults result) {
	//sourceDao.updateFeed(result);
    }
    
    @Transactional
    @Override
    public void saveAllSources(List<ParserResults> resultList) {
	for(ParserResults result: resultList){
	    this.save(result);
	}
    }
}


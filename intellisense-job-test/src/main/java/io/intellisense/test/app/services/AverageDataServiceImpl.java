package io.intellisense.test.app.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.intellisense.test.app.entities.AveragePeriod;
import io.intellisense.test.app.entities.DataProvider;
import io.intellisense.test.app.exception.NotDataFoundException;
import io.intellisense.test.app.services.clients.DataProviderService;

@Service
public class AverageDataServiceImpl implements AverageDataService {
	
	private static final Logger log = LoggerFactory.getLogger(AverageDataServiceImpl.class);

	@Autowired
	private DataProviderService dataProvider;
	
//	@Autowired
//	private DataProviderRestClient dataProvider;
	
	@Override
	public DataProvider obtainAverageValueForPeriod(AveragePeriod period) throws Exception  {
		
		DataProvider averageDataProvider = new DataProvider();
		DataProvider findAll = dataProvider.findAll();
		
		if (findAll == null) {
			throw new NotDataFoundException("No data received from external json.");
		}
	
		averageDataProvider.getThe660().setThe3000(getAverageMetricPeriod(findAll.getThe660().getThe3000(), period.getPeriod()));
		averageDataProvider.getThe660().setThe3001(getAverageMetricPeriod(findAll.getThe660().getThe3001(), period.getPeriod()));
		averageDataProvider.getThe660().setThe3002(getAverageMetricPeriod(findAll.getThe660().getThe3002(), period.getPeriod()));
		averageDataProvider.getThe660().setThe3003(getAverageMetricPeriod(findAll.getThe660().getThe3003(), period.getPeriod()));
		averageDataProvider.getThe660().setThe3004(getAverageMetricPeriod(findAll.getThe660().getThe3004(), period.getPeriod()));
		averageDataProvider.getThe660().setThe3005(getAverageMetricPeriod(findAll.getThe660().getThe3005(), period.getPeriod()));
		
		
		return averageDataProvider;
	}

	private List<Double> getAverageMetricPeriod(List<Double> metrics, int periodAvg) {
		
		Iterator<Double> metricIt = metrics.iterator();
		List<Double> averageMetrics = new ArrayList<Double>();
		Double sumValues = 0.0;
		int currentIteration = 0;
		int valueIt = 0;
		while (metricIt.hasNext()) {
			if (currentIteration == periodAvg) {
				Double avg = sumValues/currentIteration;
				log.info("Insert values "+ valueIt +" to ArrayList " + sumValues + "/" + currentIteration + "=" + avg);
				averageMetrics.add(avg);
				currentIteration = 0;
				sumValues = 0.0;
			}
			Double next = metricIt.next();
			if(next != null) {
				sumValues += next;	
			}
			currentIteration ++;
			valueIt ++;
			
		}
		
		if(currentIteration < periodAvg && sumValues > 0.0) {
			log.info("Last values "+ valueIt +" to insert in ArrayList " + sumValues + "," + currentIteration + "=" + sumValues/currentIteration);
			averageMetrics.add(sumValues/currentIteration);
		}
		
		return averageMetrics;
	}

}

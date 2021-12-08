package io.intellisense.test.app.services;

import io.intellisense.test.app.entities.AveragePeriod;
import io.intellisense.test.app.entities.DataProvider;

public interface AverageDataService {
	DataProvider obtainAverageValueForPeriod(AveragePeriod period ) throws Exception;
}

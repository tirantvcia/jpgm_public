package io.intellisense.test.app.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.intellisense.test.app.entities.AveragePeriod;
import io.intellisense.test.app.entities.DataProvider;
import io.intellisense.test.app.services.AverageDataService;

@RestController
public class AverageDataController {
	
	@Autowired
	private AverageDataService avgDataService;
	
	@GetMapping("/listAvg")
	public ResponseEntity<?> getAverageMetrics (@RequestBody AveragePeriod period) {
		
		if(period.getPeriod() < 1 || period.getPeriod() > 180) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Period must be between 1 and 180");
		}
		try {
			DataProvider obtainAverageValueForPeriod = avgDataService.obtainAverageValueForPeriod(period);
			return ResponseEntity.ok().body(obtainAverageValueForPeriod);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}

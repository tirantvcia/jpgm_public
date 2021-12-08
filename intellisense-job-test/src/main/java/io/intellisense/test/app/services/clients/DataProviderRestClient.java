package io.intellisense.test.app.services.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import io.intellisense.test.app.entities.DataProvider;

@FeignClient(name="dataprovider", url = "https://reference.intellisense.io/test.dataprovider")
public interface DataProviderRestClient {
	
	@GetMapping
	public DataProvider findAll();
}

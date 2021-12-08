package io.intellisense.test.app.services.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.intellisense.test.app.entities.DataProvider;

@Service
public class DataProvicerServiceImp implements DataProviderService {

	private static final String URL_PROVIDER = "https://reference.intellisense.io/test.dataprovider";
	@Autowired
	@Qualifier("restClient")
	private RestTemplate restClient;
	
//	@Autowired
//	@Qualifier("objMapper")
//	public ObjectMapper objMapper; 
	
	@Override
	public DataProvider findAll() {
		DataProvider body = null;
	    ResponseEntity<DataProvider> responseEntity = restClient.getForEntity(URL_PROVIDER, DataProvider.class);
	    if(responseEntity != null && responseEntity.getBody() != null) {
	    	body = responseEntity.getBody();	
	    }
	    
	    return body;
		
//		DataProvider data = objMapper.readValue(new URL("https://reference.intellisense.io/test.dataprovider"), DataProvider.class);
//		return data;
	}

}

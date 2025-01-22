package com.example.beansfortype;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import com.example.beansfortype.data.CharlieRequest;
import com.example.beansfortype.data.CharlieResponse;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
/**
 * 
 * BeansfortypeApplicationTests2 tests for two generics
 *
 */
class BeansfortypeApplicationTests2 {

	@Autowired
	ApplicationContext context;
	
	@Test
	void retrieveCharlieReqResProcessorsUsingBeanFactoryUtils() {		
		String[] beanNames = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(context, ResolvableType.forClassWithGenerics(ReqResProcessor.class, CharlieRequest.class, CharlieResponse.class));		
		
		log.info("[retrieveCharlieRequestProcessorsUsingBeanFactoryUtils] {}beanNames = {}", "", beanNames);
		
		assertThat(beanNames)
			.contains("charlieReqResProcessor", "charlieGenericReqResProcessor") // generics strictly match CharlieRequest
			.doesNotContain("charlieSubGenericReqResProcessor"); // charlieSubGenericProcessor generics do not strictly match CharlieRequest
	}
	
	@Test
	void retrieveCharlieReqResProcessorsContext() {		
		String[] beanNames = context.getBeanNamesForType(ResolvableType.forClassWithGenerics(ReqResProcessor.class, CharlieRequest.class, CharlieResponse.class));		
		
		log.info("[retrieveCharlieRequestProcessorsContext] {}beanNames = {}", "", beanNames);
		
		assertThat(beanNames)
			.contains("charlieReqResProcessor", "charlieGenericReqResProcessor") // generics strictly match CharlieRequest
			.doesNotContain("charlieSubGenericReqResProcessor"); // charlieSubGenericProcessor generics do not strictly match CharlieRequest 
	}
	
	@Test
	void assignCharlieReqResProcessorsUsingBeanFactoryUtils() {		
		String[] beanNames = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(context, ResolvableType.forClassWithGenerics(ReqResProcessor.class, CharlieRequest.class, CharlieResponse.class));		
		
		List<ReqResProcessor<CharlieRequest, CharlieResponse>> list = new ArrayList<ReqResProcessor<CharlieRequest, CharlieResponse>>();
        assertDoesNotThrow(() -> {
    		for (String beanName : beanNames) {
    			@SuppressWarnings("unchecked")
    			ReqResProcessor<CharlieRequest, CharlieResponse> processor = context.getBean(beanName, ReqResProcessor.class);	
    			list.add(processor);
    		}
        });
		Collections.sort(list, AnnotationAwareOrderComparator.INSTANCE);
		log.info("[assignCharlieRequestProcessorsUsingBeanFactoryUtils] {}list = {}", "", list);
		
		CharlieRequest request = new CharlieRequest();
		CharlieResponse response = new CharlieResponse();
        assertDoesNotThrow(() -> {
    		for (ReqResProcessor<CharlieRequest, CharlieResponse> processor : list) {
    			processor.process(request, response);    		
    		}
        });
        assertThat(request.charlie).isEqualTo("Set by CharlieReqResProcessor");
        assertThat(response.charlie).isEqualTo("Set by CharlieReqResProcessor");
	}

}

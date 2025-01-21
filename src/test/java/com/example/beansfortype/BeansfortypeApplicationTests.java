package com.example.beansfortype;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;

import com.example.beansfortype.data.CharlieRequest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BeansfortypeApplicationTests {

	@Autowired
	ApplicationContext context;
	
	@Test
	void retrieveCharlieRequestProcessorsUsingBeanFactoryUtils() {		
		String[] beanNames = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(context, ResolvableType.forClassWithGenerics(Processor.class, CharlieRequest.class));		
		
		log.info("[retrieveCharlieRequestProcessorsUsingBeanFactoryUtils] {}beanNames = {}", "", beanNames);
		
		assertThat(beanNames)
			.contains("charlieProcessor", "charlieGenericProcessor") // generics strictly match CharlieRequest
			.doesNotContain("charlieSubGenericProcessor"); // charlieSubGenericProcessor generics do not strictly match CharlieRequest
	}
	
	@Test
	void retrieveCharlieRequestProcessorsContext() {		
		String[] beanNames = context.getBeanNamesForType(ResolvableType.forClassWithGenerics(Processor.class, CharlieRequest.class));		
		
		log.info("[retrieveCharlieRequestProcessorsContext] {}beanNames = {}", "", beanNames);
		
		assertThat(beanNames)
			.contains("charlieProcessor", "charlieGenericProcessor") // generics strictly match CharlieRequest
			.doesNotContain("charlieSubGenericProcessor"); // charlieSubGenericProcessor generics do not strictly match CharlieRequest 
	}

}

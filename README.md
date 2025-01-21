# beans-for-type
`BeanFactoryUtils.getBeanNamesForType(ResolvableType)` change in behavior from Spring Boot 3.3.x (and earlier) top 3.4.x.

## Code 

### Class Definitions

1. AlphaRequest/BravoRequest/CharlieRequest extends Request
1. CharlieSubRequest extends CharlieRequest
1. AlphaProcessor implements Processor<AlphaRequest>
1. BravoProcessor implements Processor<BravoRequest>
1. CharlieProcessor implements Processor<CharlieRequest>
1. CharlieSubProcessor implements Processor<CharlieSubRequest>
1. CharlieGenericProcessor<REQ extends CharlieRequest> implements Processor<REQ>
1. CharlieSubGenericProcessor<REQ extends CharlieSubRequest> implements Processor<REQ>

### Retrieving Beans of a Given Type with a Specific Generics Type

```
String[] beanNames = context.getBeanNamesForType(ResolvableType.forClassWithGenerics(Processor.class, CharlieRequest.class));
```

Translation: Give me all `Processors` implementations for `CharlieRequest` type.

## 3.3.x or Earlier Behavior 

```
beanNames = [charlieGenericProcessor, charlieProcessor]
``` 

> This is our expected behavior which our functionality is based on.


## 3.4.x Behavior 

```
beanNames = [charlieGenericProcessor, charlieProcessor, charlieSubGenericProcessor]
```

It is now including `CharlieSubGenericProcessor`. `CharlieRequest` does not meet the `extends CharlieSubRequest` criteria. For some reason, it is matching super types as well.

> This is actual behavior after upgrading and causing unexpected processors to run.
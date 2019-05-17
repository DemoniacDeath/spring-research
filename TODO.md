to Learn:
- RequestDispatcher (forward and include, does error dispatch go through forward? how to work with AsyncContext)
- Content Negotiating subsystem
- How does Spring (\w & \wo Boot) serve static content?
- ULTIMATE GOAL: recreate configuration of Spring Boot without Spring Boot (for simple REST controller, with thymeleaf, with Security, with Data and so on...)

classes and interfaces to Learn (\w Spring Boot):

- MultipartResolver:
  - StandardServletMultipartResolver
- LocaleResolver:
  - AcceptHeaderLocaleResolver
- ThemeResolver:
  - FixedThemeResolver
- RequestToViewNameTranslator:
  - DefaultRequestToViewNameTranslator
- FlashMapManager:
  - SessionFlashMapManager
- HandlerMapping:
  - SimpleUrlHandlerMapping
  - RequestMappingHandlerMapping
  - BeanNameUrlHandlerMapping
  - SimpleUrlHandlerMapping
  - WelcomePageHandlerMapping
- HandlerAdapter:
  - RequestMappingHandlerAdapter
  - HttpRequestHandlerAdapter
  - SimpleControllerHandlerAdapter
- HandlerExceptionResolver:
  - DefaultErrorAttributes
  - HandlerExceptionResolverComposite
- ViewResolver:
  - ContentNegotiatingViewResolver
  - BeanNameViewResolver
  - ViewResolverComposite
  - InternalResourceViewResolver
  
 
defaults (\wo Spring Boot, i guess?): 
- LocaleResolver:
  - AcceptHeaderLocaleResolver
- ThemeResolver:
  - FixedThemeResolver
- RequestToViewNameTranslator:
  - DefaultRequestToViewNameTranslator
- FlashMapManager:
  - SessionFlashMapManager
- HandlerMapping:
  - BeanNameUrlHandlerMapping
  - RequestMappingHandlerMapping
- HandlerAdapter:
  - HttpRequestHandlerAdapter
  - SimpleControllerHandlerAdapter
  - RequestMappingHandlerAdapter
- HandlerExceptionResolver:
  - ExceptionHandlerExceptionResolver
  - ResponseStatusExceptionResolver
  - DefaultHandlerExceptionResolver
- ViewResolver:
  - InternalResourceViewResolver

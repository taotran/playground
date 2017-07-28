package eu.codix.tvtran.config.resolver;

import eu.codix.tvtran.config.MyLang;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  7/20/2017
 */
public class MyLangArgumentResolver implements HandlerMethodArgumentResolver
{
  public boolean supportsParameter(MethodParameter parameter)
  {
    return parameter.hasParameterAnnotation(MyLang.class);
  }

  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception
  {
    String acceptLang = webRequest.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
    return acceptLang.toUpperCase();
  }
}

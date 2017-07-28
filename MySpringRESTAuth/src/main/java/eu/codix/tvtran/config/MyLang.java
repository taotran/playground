package eu.codix.tvtran.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  7/20/2017
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface MyLang
{
}

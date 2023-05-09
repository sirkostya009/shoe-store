package ua.sirkostya009.shoeservice.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used for extracting current user's username.
 *
 * @see ua.sirkostya009.shoeservice.resolver.UsernameResolver UsernameResolver
 */
@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Username {
}

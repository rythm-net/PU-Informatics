package com.customorm.labels;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.customorm.enums.DatabaseType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CustomEntityColumn {

	String colum() default "";
	DatabaseType type();
}

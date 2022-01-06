package br.com.geoged.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import br.com.geoged.exceptions.GeoGedException;


@Aspect
@Component
public class BeforeSaveAspect
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	//
	@Around("@annotation(BeforeSaveAnnotation)")
	public Class<?> beforeSave(JoinPoint joinPoint) throws GeoGedException
	{
		try
		{
			final Object result = joinPoint.getArgs();
			Class<?> classe = result.getClass();
			if(classe.getComponentType().isInstance("ArrayList"))
			{
				logger.info(classe.getTypeName());
			}
			logger.info(classe.getTypeName());
			return classe;
		}
		catch (Throwable e)
		{
			throw new GeoGedException(e.getMessage());
		}
	}

	@Around("@annotation(AfterSaveAnnotation)")
	public Object afterSave(ProceedingJoinPoint joinPoint) throws GeoGedException
	{
		try
		{
			final Object result = joinPoint.proceed();
			Class<?> classe = result.getClass();
			logger.info(classe.getTypeName());
			return result;
		}
		catch (Throwable e)
		{
			throw new GeoGedException(e.getMessage());
		}
	}
}

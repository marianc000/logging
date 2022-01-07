package tracing.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TracingAspect extends AbstractTracingAspect {

    @Pointcut("execution(public * *.*(..))")
    public void publicMethods() {
    }

    @Pointcut("execution(* (@org.springframework.web.bind.annotation.RestController *).*(..))")
    public void methodInRestResource() {
    }

    @Pointcut("execution(* (@tracing.annotations.Traced *).*(..))")
    public void methodInAnnotatedClass() {
    }

    @Pointcut("execution(* (folder.LoggedRepository+ && !folder.LoggedRepository).*(..))")
    public void methodInDbSubclass() {
    }
    
    @Pointcut("methodInRestResource()||methodInAnnotatedClass()||methodInDbSubclass()")
    public void monitoredClasses() {
    }

    @Pointcut("monitoredClasses()&&publicMethods()")
    @Override
    public void monitored() {
    }
}

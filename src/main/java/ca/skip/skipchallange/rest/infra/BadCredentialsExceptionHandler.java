package ca.skip.skipchallange.rest.infra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

@Component
public class BadCredentialsExceptionHandler extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) {
        if (ex instanceof ca.skip.skipchallange.exception.BadCredentialsException) {
            ModelAndView mv = new ModelAndView().addObject("Error", ex.getMessage());
            mv.setStatus(HttpStatus.BAD_REQUEST);
            return mv;
        }
        return null;
    }
}
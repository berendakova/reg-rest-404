package ru.kpfu.springcontrollers.config;


import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ErrorResolver extends AbstractTemplateViewResolver implements ViewResolver {

    private Map<Integer, String> PAGES = new HashMap<>();


    public ErrorResolver()   {
        setViewClass(requiredViewClass());
    }

    public ErrorResolver(String prefix, String suffix){
        this();
        setPrefix(prefix);
        setSuffix(suffix);
    }

    protected Class<?> requiredViewClass(){
        return AbstractTemplateView.class;
    }


    @Override
    protected View createView(String viewName, Locale locale) throws Exception {
        // If this resolver is not supposed to handle the given view,
        // return null to pass on to the next resolver in the chain.
        PAGES.put(404, "404");
        if (!canHandle(viewName, locale)) {
            return null;
        }
        // Check for special "error:" prefix
        if (viewName.startsWith("error: ")){
            String errorCode = viewName.substring(("error: ".length())).trim();
            try{
                int integerErrorCode = Integer.parseInt(errorCode);
                if (PAGES.containsKey(integerErrorCode)){
                    InternalResourceView view = new InternalResourceView(PAGES.get(integerErrorCode));
                    return applyLifecycleMethods(PAGES.get(integerErrorCode), view);
                }
            }catch (NumberFormatException ex){
                return null;
            }
        }


        // Check for special "redirect:" prefix.
        if (viewName.startsWith(REDIRECT_URL_PREFIX)) {
            String redirectUrl = viewName.substring(REDIRECT_URL_PREFIX.length());
            RedirectView view = new RedirectView(redirectUrl,
                    isRedirectContextRelative(), isRedirectHttp10Compatible());
            String[] hosts = getRedirectHosts();
            if (hosts != null) {
                view.setHosts(hosts);
            }
            return applyLifecycleMethods(REDIRECT_URL_PREFIX, view);
        }

        // Check for special "forward:" prefix.
        if (viewName.startsWith(FORWARD_URL_PREFIX)) {
            String forwardUrl = viewName.substring(FORWARD_URL_PREFIX.length());
            InternalResourceView view = new InternalResourceView(forwardUrl);
            return applyLifecycleMethods(FORWARD_URL_PREFIX, view);
        }

//        ?? return new InternalResourceView(this.getPrefix() + viewName + this.getSuffix());
        return null;
    }



    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        InternalResourceView view = (InternalResourceView) super.buildView(viewName);
        return view;
    }

}
package org.oregami.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

import org.oregami.stripes.ext.MyLocalePicker;

public abstract class BaseActionBean implements ActionBean {

	private ActionBeanContext context = null;
	
	@Override
	public final ActionBeanContext getContext() {
		return context;
	}

	@Override
	public final void setContext(ActionBeanContext arg0) {
		this.context = arg0;
	}
	
	
    @SuppressWarnings("unchecked")
    public String getLastUrl() {
        HttpServletRequest req = getContext().getRequest();
        StringBuilder sb = new StringBuilder();

        // Start with the URI and the path
        String uri = (String)
            req.getAttribute("javax.servlet.forward.request_uri");
        String path = (String)
            req.getAttribute("javax.servlet.forward.path_info");
        if (uri == null) {
            uri = req.getRequestURI(); 
            path = req.getPathInfo(); 
        }
        sb.append(uri);
        if (path != null) { sb.append(path); }

        // Now the request parameters
        sb.append('?');
        Map<String,String[]> map =
            new HashMap<String,String[]>(req.getParameterMap());

        // Remove previous locale parameter, if present.
        map.remove(MyLocalePicker.LOCALE);

        // Append the parameters to the URL
        for (String key : map.keySet()) {
            String[] values = map.get(key);
            for (String value : values) {
                sb.append(key).append('=').append(value).append('&');
            }
        }
        // Remove the last '&'
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
	
	
}

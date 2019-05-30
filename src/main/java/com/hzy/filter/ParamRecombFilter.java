package com.hzy.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

@WebFilter(urlPatterns = "/*",filterName = "/ParamRecombFilter")
public class ParamRecombFilter implements Filter{
	
	private final static Log log = LogFactory.getLog(ParamRecombFilter.class);
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		ServletRequest requestWrapper = null;   
        if (request instanceof HttpServletRequest) {    
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;    
            if ("POST".equals(httpServletRequest.getMethod().toUpperCase())
            		||"PUT".equals(httpServletRequest.getMethod().toUpperCase())
            		||"GET".equals(httpServletRequest.getMethod().toUpperCase())) {    
                requestWrapper = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request);    
                String body = "";
                ServletInputStream is;  
                try {  
                    is = requestWrapper.getInputStream();  
                    int nRead = 1;  
                    int nTotalRead = 0;  
                    byte[] bytes = new byte[10240];  
                    while (nRead > 0) {  
                        nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);  
                        if (nRead > 0)  
                            nTotalRead = nTotalRead + nRead;  
                    }  
                    body = new String(bytes, 0, nTotalRead, "utf-8");  
                } catch (IOException e) {  
                	log.error("ConfigFilter read param failed", e);
                } 
                
                try {
                	JSONObject jsonObject  = new JSONObject();
                	if(StringUtils.isNotBlank(body)){
                		jsonObject  = JSONObject.parseObject(body);
                		requestWrapper.setAttribute("params", jsonObject.toString());
                	}
				} catch (Exception e) {
					log.error("ConfigFilter_ERROR", e);
				}
            }    
        }    
        
        if (requestWrapper == null) {    
            chain.doFilter(request, response);    
        } else {    
            chain.doFilter(requestWrapper, response);     
        }    
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper{
		 private final byte[] body;    
		    
		    @SuppressWarnings({ "rawtypes", "unused" })
			public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) throws IOException {    
		        super(request);    
		        Enumeration e = request.getHeaderNames();      
		         while(e.hasMoreElements()){      
		             String name = (String) e.nextElement();  
		             String value = request.getHeader(name); 
		         }      
		        body = HttpHelper.getBodyString(request).getBytes(Charset.forName("UTF-8"));    
		    }    
		    
		    @Override    
		    public BufferedReader getReader() throws IOException {    
		        return new BufferedReader(new InputStreamReader(getInputStream()));    
		    }    
		    
		    @Override    
		    public ServletInputStream getInputStream() throws IOException {    
		    
		        final ByteArrayInputStream bais = new ByteArrayInputStream(body);    
		    
		        return new ServletInputStream() {    
		            @Override    
		            public int read() throws IOException {    
		                return bais.read();    
		            }

					@Override
					public boolean isFinished() {
						return false;
					}

					@Override
					public boolean isReady() {
						return false;
					}

					@Override
					public void setReadListener(ReadListener readListener) {
						
					}    
		        };    
		    }    
		    
		    @Override    
		    public String getHeader(String name) {    
		        return super.getHeader(name);    
		    }    
		    
			@Override    
		    public Enumeration<String> getHeaderNames() {    
		        return super.getHeaderNames();    
		    }    
		    
			@Override    
		    public Enumeration<String> getHeaders(String name) {    
		        return super.getHeaders(name);    
		    } 
	}

	
	public static class HttpHelper {
		 public static String getBodyString(ServletRequest request) {    
		        StringBuilder sb = new StringBuilder();    
		        InputStream inputStream = null;    
		        BufferedReader reader = null;    
		        try {    
		            inputStream = request.getInputStream();    
		            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));    
		            String line = "";    
		            while ((line = reader.readLine()) != null) {    
		                sb.append(line);    
		            }    
		        } catch (IOException e) {    
		        	log.error("HttpHelper_ERROR", e);  
		        } finally {    
		            if (inputStream != null) {    
		                try {    
		                    inputStream.close();    
		                } catch (IOException e) {    
		                	log.error("HttpHelper_ERROR", e);  
		                }    
		            }    
		            if (reader != null) {    
		                try {    
		                    reader.close();    
		                } catch (IOException e) {    
		                	log.error("HttpHelper_ERROR", e);  
		                }    
		            }    
		        }    
		        return sb.toString();    
		    }
	}
}

package com.coface.corp.autonomy.gateway.filters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HeaderMapRequestWrapper extends HttpServletRequestWrapper {

  private Map<String, String> headerMap = new HashMap<>();

  /**
   * construct a wrapper for this request
   * 
   * @param request
   */
  public HeaderMapRequestWrapper(HttpServletRequest request) {
    super(request);
  }

  @Override
  public String getHeader(String name) {
    String headerValue = super.getHeader(name);
    if (headerMap.containsKey(name)) {
      headerValue = headerMap.get(name);
    }
    return headerValue;
  }

  @Override
  public Enumeration<String> getHeaders(String name) {
    List<String> values = Collections.list(super.getHeaders(name));
    if (headerMap.containsKey(name)) {
      values.add(headerMap.get(name));
    }
    return Collections.enumeration(values);
  }

  /**
   * add a header with given name and value
   * 
   * @param name
   * @param value
   */
  public void addHeader(String name, String value) {
    headerMap.put(name, value);
  }

  /**
   * get the Header names
   */
  @Override
  public Enumeration<String> getHeaderNames() {
    List<String> names = Collections.list(super.getHeaderNames());
    for (String name : headerMap.keySet()) {
      names.add(name);
    }
    return Collections.enumeration(names);
  }


}

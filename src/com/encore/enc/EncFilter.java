

package com.encore.enc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncFilter  implements Filter{

	private String encType;
	
	@Override
	public void init(FilterConfig config) throws ServletException {		
		encType = config.getInitParameter("encType");
	}
	
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, 
			             ServletResponse resp, 
			             FilterChain chain)
			throws IOException, ServletException {
	  if(encType != null) {//web.xml�� encType�� ���ǵǾ��ٸ�
		  req.setCharacterEncoding(encType);
	  }else {
	   req.setCharacterEncoding("UTF-8");//�⺻��
	  }
	   chain.doFilter(req, resp);//�ٸ� ���� Ȥ�� ��û���������� ���� ����
	}//doFilter

    
}

package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{

	public void destroy() {
		//�ͷ���Դ
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ִ��ģ��
		//System.out.println("���������....");
		//�����������Ӧ���ַ�����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//�������û�����⣬������һ������������servlet��������
		chain.doFilter(request, response);
		//System.out.println("��Ӧ������....");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// ���ݳ�ʼ��
		//System.out.println("filter��ʼ");
	}

}

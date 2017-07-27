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
		//释放资源
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 执行模块
		//System.out.println("请求过滤器....");
		//设置请求和响应的字符编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//如果过滤没有问题，进到下一个过滤器或者servlet继续处理
		chain.doFilter(request, response);
		//System.out.println("响应过滤器....");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// 数据初始化
		//System.out.println("filter开始");
	}

}

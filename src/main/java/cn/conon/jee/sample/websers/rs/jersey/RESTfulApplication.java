package cn.conon.jee.sample.websers.rs.jersey;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import cn.conon.jee.sample.websers.rs.jersey.resource.BookResource;
import cn.conon.jee.sample.websers.rs.jersey.resource.MyResource;

@ApplicationPath("/restfulapi/*")
public class RESTfulApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(MyResource.class);
		classes.add(BookResource.class);
		return classes;
	}
}
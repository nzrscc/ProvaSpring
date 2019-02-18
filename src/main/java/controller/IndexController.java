package controller;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "HowToDoInJava Reader !!");
		return "index";
	}
	
	@RequestMapping("/next")
	public String next(Map<String, Object> model) {
		model.put("message", "You are in new page !!");
		return "next";
	}

	@RequestMapping(value="hello",method= RequestMethod.GET)
	public String sayHello(@PathVariable("name") String name){
		Map<String, Object> model = new Map<String, Object>() {
			@Override
			public int size() {
				return 0;
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public boolean containsKey(Object key) {
				return false;
			}

			@Override
			public boolean containsValue(Object value) {
				return false;
			}

			@Override
			public Object get(Object key) {
				return null;
			}

			@Override
			public Object put(String key, Object value) {
				return null;
			}

			@Override
			public Object remove(Object key) {
				return null;
			}

			@Override
			public void putAll(Map<? extends String, ?> m) {

			}

			@Override
			public void clear() {

			}

			@Override
			public Set<String> keySet() {
				return null;
			}

			@Override
			public Collection<Object> values() {
				return null;
			}

			@Override
			public Set<Entry<String, Object>> entrySet() {
				return null;
			}
		};
		model.put("name", name);
		return "hello";
	}

}
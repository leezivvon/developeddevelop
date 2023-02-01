package springweb.a04_di_last;

import org.springframework.stereotype.Service;

@Service //이거선언하면 메모리에 올라감
public class A04_Service {
	public String getGreet() {
		return "네. (의존)주입완.";
	}
}

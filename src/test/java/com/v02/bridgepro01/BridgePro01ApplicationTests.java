package com.v02.bridgepro01;

import com.v02.bridgepro01.bridge.common.status.TraceStatus;
import com.v02.bridgepro01.bridge.common.status.TraceV1;
import com.v02.bridgepro01.bridge.common.status.TraceV2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BridgePro01ApplicationTests {

	@Test
	void contextLoads() {

	}
	@Test
	void begin_end(){
		TraceV1 trace = new TraceV1();
		TraceStatus status = trace.begin("hello");
		trace.end(status);
	}
	@Test
	void begin_exception(){
		TraceV1 trace = new TraceV1();
		TraceStatus status = trace.begin("hello");
		trace.exception(status,new IllegalStateException());
	}
	@Test
	void begin_end_level2(){
		TraceV2 trace = new TraceV2();
		TraceStatus status1 = trace.begin("hello1");
		TraceStatus status2 = trace.beginSync(status1.getTraceId(),"hello2");
		trace.end(status2);
		trace.end(status1);
	}

	@Test
	void begin_exception_level2(){
		TraceV2 trace = new TraceV2();
		TraceStatus status1 = trace.begin("hello");
		TraceStatus status2 = trace.beginSync(status1.getTraceId(),"hello2");
		trace.exception(status2,new IllegalStateException());
		trace.exception(status1,new IllegalStateException());
	}



}

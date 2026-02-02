package com.bridgelabz.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import jar.Performance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceTest {
	@Test
    @Timeout(2)  //test will be failed if execution takes more than 2 seconds
    void testLongRunningTaskTimeout() {
        String result =Performance.longRunningTask();
        assertEquals("Task Completed", result);
    }
}
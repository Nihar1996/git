package com.autoiinnovations.Interfaces;

import java.util.HashMap;

public interface MetricsAndDataWorker {
	public HashMap<String,String> getMetrics(HashMap<String,String> inputDetails) throws Exception;
}

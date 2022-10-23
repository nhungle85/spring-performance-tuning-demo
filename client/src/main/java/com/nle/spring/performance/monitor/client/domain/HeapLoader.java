package com.nle.spring.performance.monitor.client.domain;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class HeapLoader {
	
	//static will stay in heap memory forever even after object is set to null -> do not use static in this case -> out of memory error
	//public static final List<Double> doubleLeakerList = new ArrayList<>();
	public final List<Double> doubleLeakerList = new ArrayList<>();


    private List<Double> doubleInstanceList = new ArrayList<>();

    public void initStaticDoubleList() {
        for (int i = 0; i < 1000000; i++) {
            doubleLeakerList.add(Math.random());
        }
    }

    public int getStaticListLength() {
        return doubleLeakerList.size();
    }

    public void initInstanceDoubleList() {
        for (int i = 0; i < 1000000; i++) {
            doubleInstanceList.add(Math.random());
        }
    }

    public void initOpenConnection() {
        try {
            URL url = new URL("http://spring.io");
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

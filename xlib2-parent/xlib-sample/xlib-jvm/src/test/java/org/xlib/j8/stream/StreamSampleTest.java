package org.xlib.j8.stream;

import org.junit.Before;
import org.junit.Test;

public class StreamSampleTest {

    public static StreamSample streamSample;

    @Before
    public void startUp(){
        streamSample = new StreamSample();
    }

    @Test
    public void testSort() {
        streamSample.sort();
    }


    @Test
    public void testFilter() {
        streamSample.filter();
    }
}
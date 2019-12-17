package org.xlib.j8.stream;

import org.junit.Test;

public class StuStreamSampleTest {
    public static StuStreamSample sample = new StuStreamSample();

    @Test
    public void filter(){
        sample.filter();
    }

    @Test
    public void sort() {
        sample.sort();
    }

    @Test
    public void limitSkip() {
        sample.limitSkip();
    }

    @Test
    public void map(){
        sample.map();
    }

    @Test
    public void mapToInt(){
        sample.mapToInt();
    }

    @Test
    public void flatMap() {
        sample.flatMap();
    }

    @Test
    public void anyMatch(){
        sample.anyMatch();
    }

    @Test
    public void reduce(){
        sample.reduce();
    }

    @Test
    public void counting() {
        sample.counting();
    }

    @Test
    public void groupBy(){
        sample.groupBy();
    }
}
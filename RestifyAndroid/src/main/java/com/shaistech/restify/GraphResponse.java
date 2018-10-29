package com.shaistech.restify;

/**
 * Created By Syed Hussain Medhi
 * email : shmehdi01@gmail.com
 * youtube : youtube.com/shmehdi5
 * */

public class GraphResponse<Model> {

    private Wrapper<Model> graph;

    public Wrapper<Model> getGraph() {
        return graph;
    }

    public void setGraph(Wrapper<Model> graph) {
        this.graph = graph;
    }
}

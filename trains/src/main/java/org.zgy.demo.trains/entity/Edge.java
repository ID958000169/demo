package org.zgy.demo.trains.entity;

public class Edge
{
    private Vertex start;
    private Vertex end;
    private int weight;

    public Vertex getStart()
    {
        return start;
    }

    public void setStart(Vertex start)
    {
        this.start = start;
    }

    public Vertex getEnd()
    {
        return end;
    }

    public void setEnd(Vertex end)
    {
        this.end = end;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }
}

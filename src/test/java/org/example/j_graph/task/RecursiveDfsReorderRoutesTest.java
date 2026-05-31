package org.example.j_graph.task;

class RecursiveDfsReorderRoutesTest extends ReorderRoutesTest {

    @Override
    protected ReorderRoutes createSolution() {
        return new RecursiveDfsReorderRoutes();
    }
}

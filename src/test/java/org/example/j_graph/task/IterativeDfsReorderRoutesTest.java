package org.example.j_graph.task;

class IterativeDfsReorderRoutesTest extends ReorderRoutesTest {

    @Override
    protected ReorderRoutes createSolution() {
        return new IterativeDfsReorderRoutes();
    }
}

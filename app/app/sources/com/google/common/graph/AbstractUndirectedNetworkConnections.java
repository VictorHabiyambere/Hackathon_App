package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> incidentEdgeMap;

    AbstractUndirectedNetworkConnections(Map<E, N> incidentEdgeMap2) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(incidentEdgeMap2);
    }

    public Set<N> predecessors() {
        return adjacentNodes();
    }

    public Set<N> successors() {
        return adjacentNodes();
    }

    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    public Set<E> inEdges() {
        return incidentEdges();
    }

    public Set<E> outEdges() {
        return incidentEdges();
    }

    public N adjacentNode(E edge) {
        return Objects.requireNonNull(this.incidentEdgeMap.get(edge));
    }

    @CheckForNull
    public N removeInEdge(E edge, boolean isSelfLoop) {
        if (!isSelfLoop) {
            return removeOutEdge(edge);
        }
        return null;
    }

    public N removeOutEdge(E edge) {
        return Objects.requireNonNull(this.incidentEdgeMap.remove(edge));
    }

    public void addInEdge(E edge, N node, boolean isSelfLoop) {
        if (!isSelfLoop) {
            addOutEdge(edge, node);
        }
    }

    public void addOutEdge(E edge, N node) {
        Preconditions.checkState(this.incidentEdgeMap.put(edge, node) == null);
    }
}

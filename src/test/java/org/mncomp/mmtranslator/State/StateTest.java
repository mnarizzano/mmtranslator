package org.mncomp.mmtranslator.State;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {
    @Test
    void getStateName() {
        State state = new State("TestState", 1);
        String result = state.getStateName();
        assertEquals("TestState", result);
    }
    @Test
    void getId() {
        State state = new State("TestState", 1);
        int result = state.getId();
        assertEquals(1, result);
    }

    @Test
    void getStateNo() {
        State state = new State("TestState", 1);
        int result = state.getStateNo();
        assertEquals(0, result);
    }

    @Test
    void setName() {
        State state = new State("OldName", 1);
        state.setName("NewName");
        assertEquals("NewName", state.getStateName());
    }

    @Test
    void isInit() {
        State initialState = new State("InitialState", 1);
        initialState.setInit();
        State nonInitialState = new State("NonInitialState", 2);
        assertTrue(initialState.isInit());
        assertFalse(nonInitialState.isInit());
    }

    @Test
    void setInit() {
        State state = new State("TestState", 1);
        state.setInit();
        assertTrue(state.isInit());
    }

    @Test
    void unsetInit() {
        State initialState = new State("InitialState", 1);
        initialState.setInit();
        initialState.unsetInit();
        assertFalse(initialState.isInit());
    }
}

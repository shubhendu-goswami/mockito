/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockitousage.matchers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockitousage.IMethods;
import org.mockitoutil.TestBase;

@SuppressWarnings("unchecked")
public class NewMatchersTest extends TestBase {

    private IMethods mock;

    @Before
    public void setUp() {
        mock = Mockito.mock(IMethods.class);
    }

    @Test
    public void shouldAllowAnyList() {
        when(mock.forList(anyListOf(String.class))).thenReturn("matched");

        assertEquals("matched", mock.forList(Arrays.asList("x", "y")));
        assertEquals(null, mock.forList(null));

        verify(mock, once()).forList(anyListOf(String.class));
    }

    @Test
    public void shouldAllowAnyCollection() {
        when(mock.forCollection(anyCollectionOf(String.class))).thenReturn("matched");

        assertEquals("matched", mock.forCollection(Arrays.asList("x", "y")));
        assertEquals(null, mock.forCollection(null));

        verify(mock, once()).forCollection(anyCollectionOf(String.class));
    }

    @Test
    public void shouldAllowAnyMap() {
        when(mock.forMap(anyMapOf(String.class, String.class))).thenReturn("matched");

        assertEquals("matched", mock.forMap(new HashMap<String, String>()));
        assertEquals(null, mock.forMap(null));

        verify(mock, once()).forMap(anyMapOf(String.class, String.class));
    }

    @Test
    public void shouldAllowAnySet() {
        when(mock.forSet(anySetOf(String.class))).thenReturn("matched");

        assertEquals("matched", mock.forSet(new HashSet<String>()));
        assertEquals(null, mock.forSet(null));

        verify(mock, once()).forSet(anySetOf(String.class));
    }

    @Test
    public void shouldAllowAnyIterable() {
        when(mock.forIterable(anyIterableOf(String.class))).thenReturn("matched");

        assertEquals("matched", mock.forIterable(new HashSet<String>()));
        assertEquals(null, mock.forIterable(null));

        verify(mock, once()).forIterable(anyIterableOf(String.class));
    }
}
